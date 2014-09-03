package sy.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.SecurityGroupRepository;
import sy.common.util.cloudstack.entity.Ingressrule;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudIngressrule;
import sy.domain.vo.product.CloudIngressruleVo;

/**
 * 安全组入口规则
 * @author lidongbo
 * 
 */
@Service("cloudIngressruleService")
public class CloudIngressruleService extends
		SynchronizeDataService<CloudIngressrule, CloudIngressruleVo> implements
		CloudIngressruleServiceI {
	
	public void sync(List<CloudIngressruleVo> vos) throws ValidatorException {
		super.sync(vos);
	}
	
	
	public void create(String securitygroupid,
			String cidrlist, String protocol, String startport, String endport,String icmptype,String icmpcode) throws ValidatorException,CloudException {

		ProviderContext context = new ProviderContext();
		SecurityGroupRepository service = new SecurityGroupRepository(context);

		Ingressrule ingressrule = new Ingressrule();
		ingressrule.setSecuritygroupid(securitygroupid);
		ingressrule.setCidrlist(cidrlist);
		ingressrule.setProtocol(protocol);
		ingressrule.setStartport(startport);
		ingressrule.setEndport(endport);
		ingressrule.setIcmpcode(icmpcode);
		ingressrule.setIcmptype(icmptype);
		Ingressrule result = service.createIngressrule(ingressrule);
		CloudIngressruleVo vo = createVo(result);
		save(vo);
	}
	
	public void delete(String ingressruleId) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		SecurityGroupRepository service = new SecurityGroupRepository(context);
		service.deleteIngressrule(ingressruleId);
		update("Update CloudIngressrule Set dataState = 0 Where interfaceId = ?",
				ingressruleId);
	}
	
}
