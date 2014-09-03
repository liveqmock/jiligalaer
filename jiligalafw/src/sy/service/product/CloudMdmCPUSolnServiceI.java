package sy.service.product;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmCPUSolnVo;
import sy.domain.vo.product.CloudProductDetail;
import sy.service.shared.BasicServiceI;

/**
 * 计算方案表
 * 
 * @author cs
 * 
 */
public interface CloudMdmCPUSolnServiceI extends
		BasicServiceI<CloudMdmCPUSolnVo>, SynchronizeDataServiceI {

	 public  List<CloudProductDetail>  getCloudMdmCPUSolnListByItemId(String itemId,QueryContext context) throws ValidatorException ;

	 public CloudProductDetail getCloudMdmCPUSolnDetailByProdId(String prodId) throws ValidatorException;
	 
	 public CloudProductDetail getCloudMdmCPUSolnDetailByCombProdId(String comnProdId) throws ValidatorException;
	 
	 public CloudMdmCPUSolnVo getMdmCPUSolnByid(String id);
	 
	 public CloudMdmCPUSolnVo getMdmCPUSolnByInterfaceId(String interfaceId);
}
