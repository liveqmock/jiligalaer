package sy.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.EgressFirewallRuleRepository;
import sy.common.util.cloudstack.NetworkRepository;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.entity.EgressFirewallRule;
import sy.common.util.cloudstack.entity.Network;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudMdmEgressFirewallRule;
import sy.domain.vo.product.CloudMdmEgressFirewallRuleVo;

/**
 * 网络出口规则
 * @author lidongbo
 * 
 */
@Service("cloudMdmEgressFirewallRuleService")
public class CloudMdmEgressFirewallRuleService extends
		SynchronizeDataService<CloudMdmEgressFirewallRule, CloudMdmEgressFirewallRuleVo> implements
		CloudMdmEgressFirewallRuleServiceI {

	protected void sync(List<CloudMdmEgressFirewallRuleVo> vos) throws ValidatorException{
		ProviderContext context = new ProviderContext();
		NetworkRepository networkService = new NetworkRepository(context);
		for (CloudMdmEgressFirewallRuleVo vo : vos) {
			Network nw = networkService.get(vo.getNetworkid());
			vo.setNetworkid(nw.getId());
		}
		super.sync(vos);
	}
	
	public void create(String networkid, String cidrlist, String startport,
			String endport, String protocol, String icmpcode, String icmptype)
			throws ValidatorException,CloudException {

		ProviderContext context = new ProviderContext();
		EgressFirewallRuleRepository service = new EgressFirewallRuleRepository(context);

		EgressFirewallRule obj = new EgressFirewallRule();
		obj.setCidrlist(cidrlist);
		obj.setNetworkid(networkid);
		obj.setStartport(startport);
		obj.setEndport(endport);
		obj.setProtocol(protocol);
		
		obj.setIcmpcode(icmpcode);
		obj.setIcmptype(icmptype);
		
		EgressFirewallRule result = service.create(obj);
		
		CloudMdmEgressFirewallRuleVo vo = createVo(result);

		NetworkRepository networkService = new NetworkRepository(context);
		Network nw = networkService.get(vo.getNetworkid());
		vo.setNetworkid(nw.getId());
		
		save(vo);
	}

	public void delete(String firewallRuleId) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		EgressFirewallRuleRepository service = new EgressFirewallRuleRepository(context);
		service.delete(firewallRuleId);
		update("Update CloudMdmEgressFirewallRule Set dataState = 0 Where interfaceId = ?", firewallRuleId);
	}
	
	
	
}
