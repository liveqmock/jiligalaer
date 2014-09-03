package sy.service.product;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmCPUSolnVo;
import sy.domain.vo.product.CloudMdmDiskSolnVo;
import sy.domain.vo.product.CloudProductDetail;
import sy.service.shared.BasicServiceI;


/**
 * 磁盘方案表.
 * @author cs
 *
 */
public interface CloudMdmDiskSolnServiceI extends BasicServiceI<CloudMdmDiskSolnVo>, SynchronizeDataServiceI {

	 public  List<CloudProductDetail>  getCloudMdmDiskSolnListByItemId(String itemId,QueryContext context) throws ValidatorException ;
     public CloudProductDetail getCloudMdmDiskSolnByProdId(String prodId) throws ValidatorException;
     public CloudProductDetail getCloudMdmDiskSolnByCombProdId(String combProdId) throws ValidatorException;
     public CloudMdmDiskSolnVo getMdmDiskSolnByid(String id);
     public CloudMdmDiskSolnVo getMdmDiskSolnByInterfaceId(String interfaceId);
}
