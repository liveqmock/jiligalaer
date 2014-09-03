package sy.service.product;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmFirewallruleVo;
import sy.service.shared.BasicServiceI;

/**
 * 防火墙规则
 * @author lidongbo
 * 
 */
public interface CloudMdmFirewallruleServiceI extends
		BasicServiceI<CloudMdmFirewallruleVo>, SynchronizeDataServiceI {

	public void create(String ipaddressid, String cidrlist, String startport,
			String endport, String icmpcode, String icmptype, String protocol)
			throws ValidatorException,CloudException;

	public void delete(String firewallRuleId) throws ValidatorException,CloudException;

}
