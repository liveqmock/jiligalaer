package sy.service.product;

import java.util.List;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudIngressruleVo;
import sy.service.shared.BasicServiceI;

/**
 * 安全组入口规则
 * @author lidongbo
 * 
 */
public interface CloudIngressruleServiceI extends
		BasicServiceI<CloudIngressruleVo>, SynchronizeDataServiceI {
	
	void sync(List<CloudIngressruleVo> vos) throws ValidatorException;
	
	
	public void create(String securitygroupid, String cidrlist,
			String protocol, String startport, String endport, String icmptype,
			String icmpcode) throws ValidatorException, CloudException;

	public void delete(String ingressruleId) throws ValidatorException,
			CloudException;

}
