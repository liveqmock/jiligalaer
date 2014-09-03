package sy.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.PortForwardingRuleRepository;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.entity.PortForwardingRule;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudPortForwardingRule;
import sy.domain.vo.product.CloudMdmVmVo;
import sy.domain.vo.product.CloudPortForwardingRuleVo;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudPortForwardingRuleService")
public class CloudPortForwardingRuleService extends
		SynchronizeDataService<CloudPortForwardingRule, CloudPortForwardingRuleVo> implements
		CloudPortForwardingRuleServiceI {

	@Autowired
	private CloudMdmVMServiceI cloudMdmVMService;
	
	public void create(String ipaddressid, String privateStartport,
			String protocol,String publicStartport,String virtualmachineid,String privateEndport,String publicEndport) throws ValidatorException, CloudException {

		ProviderContext context = new ProviderContext();
		PortForwardingRuleRepository service = new PortForwardingRuleRepository(context);

		PortForwardingRule rule = new PortForwardingRule();
		rule.setIpaddressid(ipaddressid);
		rule.setPrivateport(privateStartport);
		rule.setPublicport(publicStartport);
		rule.setProtocol(protocol);
		rule.setVirtualmachineid(virtualmachineid);
		rule.setPrivateendport(privateEndport);
		rule.setPublicendport(publicEndport);
		
		PortForwardingRule result = service.create(rule);

		CloudPortForwardingRuleVo vo = createVo(result);

		save(vo);
	}

	public void delete(String ruleid)
			throws ValidatorException, CloudException {

		ProviderContext context = new ProviderContext();
		PortForwardingRuleRepository service = new PortForwardingRuleRepository(context);
		service.delete(ruleid);
		update("Update CloudPortForwardingRule Set dataState = 0 Where interfaceId = ?",
				ruleid);
	}
	
	public List<CloudPortForwardingRuleVo> listByPortForward(QueryContext context) throws ValidatorException {
		List<CloudPortForwardingRuleVo> result = super.list(context);
		context.clearParmeters();
		for (CloudPortForwardingRuleVo vo : result) {
			CloudMdmVmVo vmVo = cloudMdmVMService.getVmByInterfaceId(vo.getVirtualmachineid());
			vo.setVmName(vmVo.getDisplayName());
		}
		return result;
	}

	
	public CloudMdmVMServiceI getCloudMdmVMService() {
		return cloudMdmVMService;
	}

	public void setCloudMdmVMService(CloudMdmVMServiceI cloudMdmVMService) {
		this.cloudMdmVMService = cloudMdmVMService;
	}
	
	
}
