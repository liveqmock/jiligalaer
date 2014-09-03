package sy.service.product;

import java.util.List;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.vo.product.CloudMdmZoneVo;
import sy.service.shared.BasicServiceI;


/**
 * 用户订单
 * @author cs
 *
 */
public interface CloudMdmZoneServiceI extends BasicServiceI<CloudMdmZoneVo>, SynchronizeDataServiceI  {

	public  List<CloudMdmZoneVo>  getCloudMdmZoneListByItemId(String itemId,QueryContext context) throws ValidatorException ;
	public 	List<CloudMdmZoneVo>  getAllMdmZoneList() throws Exception ;
	
	public CloudMdmZoneVo findZone(String zoneInterfaceId);
}
