package sy.service.product;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudRemoteaccessVpnVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface CloudRemoteaccessVpnServiceI extends
		BasicServiceI<CloudRemoteaccessVpnVo>, SynchronizeDataServiceI {

	public List<CloudRemoteaccessVpnVo> listByIP(QueryContext context,
			String ipid) throws ValidatorException;
	
	public void create(String accountName,String publicipid) throws ValidatorException,CloudException;

	public void delete(String publicipid) throws ValidatorException,CloudException;
	
}
