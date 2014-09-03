package sy.service.product;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudVpnUserVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface CloudVpnUserServiceI extends BasicServiceI<CloudVpnUserVo>,
		SynchronizeDataServiceI {

	public void create(String accountName, String username,
			String password) throws ValidatorException, CloudException;

	public void delete(String accountName, String username)
			throws ValidatorException, CloudException;
}
