package sy.service.cloud;

import sy.common.util.validator.ValidatorException;
import sy.domain.vo.cloud.CloudMdmAccountVo;
import sy.service.product.SynchronizeDataServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface CloudMdmAccountServiceI extends
		BasicServiceI<CloudMdmAccountVo>, SynchronizeDataServiceI {

	public void create(String userName, String email) throws ValidatorException;

	public void disable(String interfaceAccountId) throws ValidatorException;

	public void enable(String interfaceAccountId) throws ValidatorException;

	public CloudMdmAccountVo findAccountByName(String name) throws ValidatorException;
}
