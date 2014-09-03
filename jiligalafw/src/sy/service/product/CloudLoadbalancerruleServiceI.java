package sy.service.product;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.CloudBean;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.Param;
import sy.common.util.cloudstack.entity.LoadBalancerAlgorithm;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudLoadRule;
import sy.domain.vo.product.CloudLoadbalancerruleVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface CloudLoadbalancerruleServiceI extends
		BasicServiceI<CloudLoadbalancerruleVo>, SynchronizeDataServiceI {

	public <T extends CloudBean> List<CloudLoadbalancerruleVo> getDatesFromInterface(Param ... params) throws ValidatorException ;
	
	/**创建负载均衡*/
	public CloudLoadbalancerruleVo create(String accountName
			,String name,String publicipid,String publicport,String privateport
			,LoadBalancerAlgorithm algorithm) throws ValidatorException,CloudException ;
	
	/**调整负载均衡*/
	public void update(String id, String name, String description,
			LoadBalancerAlgorithm algorithm) throws ValidatorException,CloudException ;
	
	/**移除负载均衡*/
	public void delete(String ruleid)  throws ValidatorException,CloudException ;
	
	public List<CloudLoadbalancerruleVo> loadList(QueryContext context)  throws ValidatorException ;
	
	public List<CloudLoadRule> getVmInstanceByRuleId(String ruleId,QueryContext context) throws ValidatorException ;
}
