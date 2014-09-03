package sy.service.product;

import java.util.List;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudEgressruleVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface CloudEgressruleServiceI extends BasicServiceI<CloudEgressruleVo>,
		SynchronizeDataServiceI {

	void sync(List<CloudEgressruleVo> vos) throws ValidatorException;

	public void create(String securitygroupid, String cidrlist,
			String protocol, String startport, String endport, String icmptype,
			String icmpcode) throws ValidatorException, CloudException;

	public void delete(String egressruleId) throws ValidatorException,
			CloudException;
}
