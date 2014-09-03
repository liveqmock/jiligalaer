package sy.service.product;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudLBStickinessPolicyVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface CloudLBStickinessPolicyServiceI extends
		BasicServiceI<CloudLBStickinessPolicyVo>, SynchronizeDataServiceI {

	/**粘性设置*/
	public void setStickinessPolicy(CloudLBStickinessPolicyVo voParam) throws ValidatorException,CloudException;
	public CloudLBStickinessPolicyVo getStickinessByRuleId(String ruleId) throws ValidatorException,CloudException;
}
