package sy.service.product;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmTemplateVo;
import sy.domain.vo.product.CloudProductDetail;
import sy.service.shared.BasicServiceI;


/**
 * IP表
 * @author cs
 *
 */
public interface CloudMdmTemplateServiceI extends BasicServiceI<CloudMdmTemplateVo>, SynchronizeDataServiceI  {

	 public  List<CloudProductDetail>  getCloudMdmTemplateListByItemId(String itemId,String mdmZoneId,QueryContext context) throws ValidatorException ;

	 public CloudProductDetail getCloudMdmTemplateByProdId(String prodId) throws ValidatorException;
	 
	 public CloudProductDetail getCloudMdmTemplateByComnProdId(String combProdId) throws ValidatorException;
	 
	 public CloudMdmTemplateVo getMdmTemplateByid(String id);
	 public CloudMdmTemplateVo  getMdmTemplateByInterfaceId(String interfaceId);
}
