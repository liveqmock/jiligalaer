package sy.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.FirewallruleRepository;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.PublicipaddressRepository;
import sy.common.util.cloudstack.entity.Firewallrule;
import sy.common.util.cloudstack.entity.Publicipaddress;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudMdmFirewallrule;
import sy.domain.vo.product.CloudMdmFirewallruleVo;

/**
 * 防火墙规则
 * @author lidongbo
 * 
 */
@Service("cloudMdmFirewallruleService")
public class CloudMdmFirewallruleService extends
		SynchronizeDataService<CloudMdmFirewallrule, CloudMdmFirewallruleVo>
		implements CloudMdmFirewallruleServiceI {

	protected void sync(List<CloudMdmFirewallruleVo> vos) throws ValidatorException{
		ProviderContext context = new ProviderContext();
		PublicipaddressRepository ipService = new PublicipaddressRepository(context);
		for (CloudMdmFirewallruleVo vo : vos) {
			Publicipaddress ip = ipService.get(vo.getIpaddressid());
			vo.setIpaddressid(ip.getId());
		}
		super.sync(vos);
	}
	
	public void create(String ipaddressid, String cidrlist, String startport,
			String endport,String icmpcode,String icmptype, String protocol) throws ValidatorException,CloudException {

		ProviderContext context = new ProviderContext();
		FirewallruleRepository service = new FirewallruleRepository(context);

		Firewallrule obj = new Firewallrule();
		obj.setIpaddressid(ipaddressid);
		obj.setProtocol(protocol);
		obj.setCidrlist(cidrlist);
		obj.setStartport(startport);
		obj.setEndport(endport);
		obj.setIcmpcode(icmpcode);
		obj.setIcmptype(icmptype);

		Firewallrule result = service.create(obj);

		CloudMdmFirewallruleVo vo = createVo(result);

		PublicipaddressRepository ipService = new PublicipaddressRepository(context);
		Publicipaddress ip = ipService.get(vo.getIpaddressid());
		vo.setIpaddressid(ip.getId());
		
		save(vo);
	}

	public void delete(String firewallRuleId) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		FirewallruleRepository service = new FirewallruleRepository(context);
		service.delete(firewallRuleId);
		update("Update CloudMdmFirewallrule Set dataState = 0 Where interfaceId = ?",
				firewallRuleId);
	}

}
