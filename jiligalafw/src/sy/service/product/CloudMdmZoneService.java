package sy.service.product;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudMdmZone;
import sy.domain.vo.product.CloudMdmZoneVo;


/**
 * 数据中心表
 * @author cs
 *
 */
@Service("cloudMdmZoneService")
public class CloudMdmZoneService extends
		SynchronizeDataService<CloudMdmZone, CloudMdmZoneVo> implements
		CloudMdmZoneServiceI {

	@Override
	public List<CloudMdmZoneVo> getCloudMdmZoneListByItemId(String itemId,
			QueryContext context) throws ValidatorException {
		// TODO Auto-generated method stub
		String sql ="SELECT mz.id as id ,mz.NAME as name,mz.DISPLAYTEXT as displayText,mz.DESCRIPTION as description ,mz.NETWORK_TYPE as networkType "
				   +" FROM cloud_mdm_zone mz where mz.data_state=1 ";
		return this.listBySql(context, sql);
	}
	
	@Override
	public List<CloudMdmZoneVo> getAllMdmZoneList()
			throws Exception {
		// TODO Auto-generated method stub
		List<CloudMdmZoneVo> cloudMdmZoneList = null;
		try {
			cloudMdmZoneList = this.find(
					"from CloudMdmZone where dataState = 1");
		} catch (Exception e) {
			throw new Exception("获取数据中心列表时出错：" + e.getMessage());
		}
		return cloudMdmZoneList;
	}

	@Override
	public CloudMdmZoneVo findZone(String zoneInterfaceId) {
		return findUnique("From CloudMdmZone Where dataState = 1 And interfaceId = ?", zoneInterfaceId);
	}

}
