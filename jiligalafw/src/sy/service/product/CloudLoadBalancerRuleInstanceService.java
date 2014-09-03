package sy.service.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.util.cloudstack.CSQuqeyContext;
import sy.common.util.cloudstack.CloudBean;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.LoadBalancerRuleInstanceRepository;
import sy.common.util.cloudstack.Param;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.entity.LoadBalancerRuleInstance;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudLoadBalancerRuleInstance;
import sy.domain.vo.product.CloudLoadBalancerRuleInstanceVo;
import sy.domain.vo.product.CloudLoadbalancerruleVo;
import sy.service.shared.BaseServiceTemplate;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudLoadBalancerRuleInstanceService")
public class CloudLoadBalancerRuleInstanceService
		extends
		BaseServiceTemplate<CloudLoadBalancerRuleInstance, CloudLoadBalancerRuleInstanceVo>
		implements CloudLoadBalancerRuleInstanceServiceI {
	
	@Autowired
	private CloudLoadbalancerruleServiceI cloudLoadbalancerruleService;
	
	public <T extends CloudBean> List<CloudLoadBalancerRuleInstanceVo> getDatesFromInterface(String ruleid) throws ValidatorException {

		List<CloudLoadBalancerRuleInstanceVo> result = new ArrayList<CloudLoadBalancerRuleInstanceVo>();

		List<Param> paramters = new ArrayList<Param>();
		paramters.add(new Param("listall", "true"));
		paramters.add(new Param("id", ruleid));
		
		ProviderContext context = new ProviderContext();
		CSQuqeyContext qc = new CSQuqeyContext(paramters.toArray(new Param[] {}));

		LoadBalancerRuleInstanceRepository repository = new LoadBalancerRuleInstanceRepository(context);

		List<LoadBalancerRuleInstance> cloudBeans = repository.list(qc);
		
		for (LoadBalancerRuleInstance cloudBean : cloudBeans) {
			CloudLoadBalancerRuleInstanceVo vo = new CloudLoadBalancerRuleInstanceVo();
			vo.setLbruleid(ruleid);
			vo.setVirtualmachineid(cloudBean.getId());
			vo.setSyncTime(new Date());
			result.add(vo);
		}
		
		return result;
	}
	
	
	@Override
	public void sync() throws ValidatorException {

		List<CloudLoadBalancerRuleInstanceVo> result = new ArrayList<CloudLoadBalancerRuleInstanceVo>();
		
		List<CloudLoadbalancerruleVo> rules = cloudLoadbalancerruleService
				.getDatesFromInterface();
		
		for (CloudLoadbalancerruleVo rule : rules) {
			result.addAll(getDatesFromInterface(rule.getInterfaceId()));
			update("Delete From CloudLoadBalancerRuleInstance Where lbruleid = ?", rule.getInterfaceId());
		}
		
		for (CloudLoadBalancerRuleInstanceVo vo : result) {
			save(vo);
		}
	}
	
	
	public void addInstance(String lbruleid, List<String> vmids)
			throws CloudException, ValidatorException {
		
		ProviderContext context = new ProviderContext();
		LoadBalancerRuleInstanceRepository repository = new LoadBalancerRuleInstanceRepository(context);
		
		repository.addInstance(lbruleid, vmids);
		
		for (String vmid : vmids) {
			CloudLoadBalancerRuleInstanceVo vo = new CloudLoadBalancerRuleInstanceVo();
			vo.setLbruleid(lbruleid);
			vo.setVirtualmachineid(vmid);
			vo.setSyncTime(new Date());
			save(vo);
		}
		
	}
	
	public void removeInstance(String lbruleid, List<String> vmids)
			throws CloudException, ValidatorException {
		ProviderContext context = new ProviderContext();
		LoadBalancerRuleInstanceRepository repository = new LoadBalancerRuleInstanceRepository(context);
		
		repository.removeInstance(lbruleid, vmids);
		
		for (String vmid : vmids) {
			update("Delete From CloudLoadBalancerRuleInstance Where lbruleid = ? And virtualmachineid = ? ", lbruleid,vmid);
		}
	}

	public CloudLoadbalancerruleServiceI getCloudLoadbalancerruleService() {
		return cloudLoadbalancerruleService;
	}

	public void setCloudLoadbalancerruleService(
			CloudLoadbalancerruleServiceI cloudLoadbalancerruleService) {
		this.cloudLoadbalancerruleService = cloudLoadbalancerruleService;
	}

}
