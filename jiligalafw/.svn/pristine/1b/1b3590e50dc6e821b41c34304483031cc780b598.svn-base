package sy.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.ProviderContext;
import sy.common.util.cloudstack.SecurityGroupRepository;
import sy.common.util.cloudstack.entity.Egressrule;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudEgressrule;
import sy.domain.vo.product.CloudEgressruleVo;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("cloudEgressruleService")
public class CloudEgressruleService extends
		SynchronizeDataService<CloudEgressrule, CloudEgressruleVo> implements
		CloudEgressruleServiceI {

	public void sync(List<CloudEgressruleVo> vos) throws ValidatorException{
		super.sync(vos);
	}
	
	
	public void create(String securitygroupid,
			String cidrlist, String protocol, String startport, String endport,String icmptype,String icmpcode) throws ValidatorException,CloudException {

		ProviderContext context = new ProviderContext();
		SecurityGroupRepository service = new SecurityGroupRepository(context);

		Egressrule egressrule = new Egressrule();
		egressrule.setSecuritygroupid(securitygroupid);
		egressrule.setCidrlist(cidrlist);
		egressrule.setProtocol(protocol);
		egressrule.setStartport(startport);
		egressrule.setEndport(endport);
		egressrule.setIcmpcode(icmpcode);
		egressrule.setIcmptype(icmptype);
		Egressrule result = service.createEgressrule(egressrule);
		CloudEgressruleVo vo = createVo(result);
		save(vo);
	}
	
	public void delete(String egressruleId) throws ValidatorException,CloudException {
		ProviderContext context = new ProviderContext();
		SecurityGroupRepository service = new SecurityGroupRepository(context);
		service.deleteEgressrule(egressruleId);
		update("Update CloudEgressrule Set dataState = 0 Where interfaceId = ?",
				egressruleId);
	}
	
}
