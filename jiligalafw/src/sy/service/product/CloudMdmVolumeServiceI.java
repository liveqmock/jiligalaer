package sy.service.product;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmVolumeVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
public interface CloudMdmVolumeServiceI extends BasicServiceI<CloudMdmVolumeVo>,
		SynchronizeDataServiceI {

	/**创建卷.*/
	public CloudMdmVolumeVo create(String name, String zoneid,
			String accountName, String diskofferingid, Long disksize)
			throws ValidatorException, CloudException;

	/**移除卷.*/
	public void delete(String volumeid) throws ValidatorException,CloudException;
	
	public List<CloudMdmVolumeVo> list(QueryContext context) throws ValidatorException; 
}
