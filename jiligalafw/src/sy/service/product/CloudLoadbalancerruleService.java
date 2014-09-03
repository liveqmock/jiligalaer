package sy.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.LoadbalancerruleRepository;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.entity.LoadBalancerAlgorithm;
import sy.common.util.cloudstack.entity.Loadbalancerrule;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudLoadbalancerrule;
import sy.domain.vo.cloud.CloudMdmAccountVo;
import sy.domain.vo.product.CloudLoadRule;
import sy.domain.vo.product.CloudLoadbalancerruleVo;
import sy.service.cloud.CloudMdmAccountServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudLoadbalancerruleService")
public class CloudLoadbalancerruleService extends
		SynchronizeDataService<CloudLoadbalancerrule, CloudLoadbalancerruleVo> implements
		CloudLoadbalancerruleServiceI {

	@Autowired
	private CloudMdmAccountServiceI cloudMdmAccountService;
	
	public CloudLoadbalancerruleVo create(String accountName
			,String name,String publicipid,String publicport,String privateport
			,LoadBalancerAlgorithm algorithm) throws ValidatorException,CloudException {
		
		CloudMdmAccountVo account = cloudMdmAccountService.findAccountByName(accountName);
		if(account == null){
			throw new ValidatorException("接口中不存在该账户."+accountName);
		}
		
		ProviderContext context = new ProviderContext();
		LoadbalancerruleRepository service = new LoadbalancerruleRepository(context);
		
		Loadbalancerrule bean = new Loadbalancerrule();
		bean.setAccount(accountName);
		bean.setDomainid(account.getDomainid());
		bean.setName(name);
		bean.setPublicipid(publicipid);
		bean.setPublicport(publicport);
		bean.setPrivateport(privateport);
		bean.setAlgorithm(algorithm.CODE);
		
		Loadbalancerrule result = service.create(bean);
		
		CloudLoadbalancerruleVo vo = createVo(result);

		save(vo);
		
		return vo;
	}
	
	
	public void update(String id, String name, String description,
			LoadBalancerAlgorithm algorithm) throws ValidatorException,CloudException {
		
		ProviderContext context = new ProviderContext();
		LoadbalancerruleRepository service = new LoadbalancerruleRepository(context);
		
		service.update(id, name, description, algorithm);

		update("Update CloudLoadbalancerrule Set name = ?,description=?,algorithm=? Where interfaceId = ?",
				name, description, algorithm.CODE, id);
	}
	
	public void delete(String ruleid) {
		ProviderContext context = new ProviderContext();
		LoadbalancerruleRepository service = new LoadbalancerruleRepository(context);
		service.delete(ruleid);
		update("Update CloudLoadbalancerrule Set dataState = 0 Where interfaceId = ?", ruleid);
	}

	public List<CloudLoadbalancerruleVo> loadList(QueryContext context)  throws ValidatorException{
		List<CloudLoadbalancerruleVo> list = this.list(context);
		for(CloudLoadbalancerruleVo vo : list){
			vo.setList(this.getVmInstanceByRuleId(vo.getInterfaceId(),context));
		}
		return list;
	}
	
	public List<CloudLoadRule> getVmInstanceByRuleId(String ruleId, QueryContext context){
		context.clearParmeters();
		String sql = "select i.ID as id, i.lbruleid as lbruleid, i.virtualmachineid as virtualmachineid, v.NAME as vmname " +
				"from 	cloud_load_balancer_rule_instance i " +
				"		inner join cloud_mdm_vm v on i.virtualmachineid=v.IF_ID " +
				"where	i.lbruleid='"+ruleId+"' ";
		
		return this.listBySql(CloudLoadRule.class, context, sql);
	}
	
	public CloudMdmAccountServiceI getCloudMdmAccountService() {
		return cloudMdmAccountService;
	}

	public void setCloudMdmAccountService(
			CloudMdmAccountServiceI cloudMdmAccountService) {
		this.cloudMdmAccountService = cloudMdmAccountService;
	}

}

