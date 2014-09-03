package sy.service.product;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmNetworkSolnVo;
import sy.domain.vo.product.CloudProductDetail;
import sy.service.shared.BasicServiceI;


/**
 * 计算方案表
 * @author cs
 *
 */
public interface CloudMdmNetworkSolnServiceI extends BasicServiceI<CloudMdmNetworkSolnVo>, SynchronizeDataServiceI {

	public List<CloudMdmNetworkSolnVo> list(QueryContext context, String zoneId) throws ValidatorException;
	
	public  List<CloudProductDetail>  getCloudMdmNetworkSolnListByItemId(String itemId,QueryContext context) throws ValidatorException ;
 
    public CloudProductDetail getCloudMdmNetworkSolnByProdId(String prodId) throws ValidatorException;
    
    public CloudProductDetail getCloudMdmNetworkSolnByCombProdId(String combProdId) throws ValidatorException;
}
