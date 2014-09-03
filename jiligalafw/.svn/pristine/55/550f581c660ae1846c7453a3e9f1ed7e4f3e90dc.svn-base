package sy.service.product;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudPortForwardingRuleVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface CloudPortForwardingRuleServiceI extends
		BasicServiceI<CloudPortForwardingRuleVo>, SynchronizeDataServiceI {

	public void create(String ipaddressid, String privateStartport,
			String protocol, String publicStartport, String virtualmachineid,
			String privateEndport, String publicEndport)
			throws ValidatorException, CloudException;

	public void delete(String ruleid) throws ValidatorException, CloudException;
	
	public List<CloudPortForwardingRuleVo> listByPortForward(QueryContext context) throws ValidatorException;

}
