package sy.service.product;

import java.util.List;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudLoadBalancerRuleInstanceVo;
import sy.service.shared.BasicServiceI;

/**
 * 负载均衡虚拟机
 * 
 * @author lidongbo
 */
public interface CloudLoadBalancerRuleInstanceServiceI extends
		BasicServiceI<CloudLoadBalancerRuleInstanceVo>, SynchronizeDataServiceI {

	
	/**添加虚拟机实例*/
	public void addInstance(String lbruleid, List<String> vmids)
			throws CloudException, ValidatorException ;
	
	/**移除虚拟机实例*/
	public void removeInstance(String lbruleid, List<String> vmids)
			throws CloudException, ValidatorException ;
	
}
