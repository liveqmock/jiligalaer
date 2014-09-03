package sy.service.product;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmEgressFirewallRuleVo;
import sy.service.shared.BasicServiceI;

/**
 * 出口规则接口
 * @author lidongbo
 * 
 */
public interface CloudMdmEgressFirewallRuleServiceI extends
		BasicServiceI<CloudMdmEgressFirewallRuleVo>, SynchronizeDataServiceI {

	public void create(String networkid, String cidrlist, String startport,
			String endport, String protocol, String icmpcode, String icmptype) throws ValidatorException,CloudException;

	public void delete(String firewallRuleId) throws ValidatorException,CloudException;
}
