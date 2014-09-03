package sy.service.product;

import java.util.List;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmNetworkVo;
import sy.domain.vo.product.CloudSecurityGroupVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface CloudSecurityGroupServiceI extends
		BasicServiceI<CloudSecurityGroupVo>, SynchronizeDataServiceI {
	public List<CloudSecurityGroupVo> getSecurityGroupListByAccount(String account)
			throws Exception;
	
	public void create(String accountName, String name,
			String description) throws ValidatorException,CloudException;
	
	public void delete(String securityGroupId) throws ValidatorException,CloudException;
	public CloudSecurityGroupVo getSecurityGroupByID(String id);
}
