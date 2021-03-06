package sy.service.product;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import sy.common.model.QueryContext;
import sy.common.util.validator.ValidatorException;
import sy.domain.model.product.CloudMdmNetworkSoln;
import sy.domain.vo.product.CloudMdmNetworkSolnVo;
import sy.domain.vo.product.CloudProductDetail;


/**
 * @author cs
 *
 */
@Service("cloudMdmNetworkSolnService")
public class CloudMdmNetworkSolnService extends
		SynchronizeDataService<CloudMdmNetworkSoln, CloudMdmNetworkSolnVo> implements
		CloudMdmNetworkSolnServiceI {

	public List<CloudMdmNetworkSolnVo> list(QueryContext context, String zoneId)
			throws ValidatorException {
		context.equals("specifyvlan", "false");
		context.equals("zoneid", zoneId);
		context.equals("dataState", "1");
		return super.list(context);
	}
	
	public List<CloudMdmNetworkSolnVo> list(QueryContext context)
			throws ValidatorException {
		context.equals("specifyvlan", "false");
		context.equals("dataState", "1");
		return super.list(context);
	}
	
	@Override
	public List<CloudProductDetail> getCloudMdmNetworkSolnListByItemId(
			String itemId, QueryContext context) throws ValidatorException {
		String sql ="SELECT mp.id as prodId,mp.PROD_NAME as prodName, mns.id as cellId,mns.DISPLAYTEXT as displayText,mns.NAME as cellName,mns.NETWORKRATE as networkRate,pp.id as priceId "
				   +" FROM cloud_mdm_product_item pi "
				   +"  inner join cloud_mdm_network_soln mns on mns.id=pi.item_id   "
				   +" inner join cloud_mdm_product mp on mp.ID=pi.PROD_ID "
				   +" inner join cloud_product_price pp on pp.PROD_ID=mp.ID "
				   +"   where pi.item_type='NETWORKSOLN' AND pi.state='1' and mns.DATA_STATE=1  and now()>=  pp.EFFECTIVE_DATE  and now() <=pp.INVALID_DATE ";
		if(StringUtils.isNotBlank(itemId)){
			sql =sql+" and pi.ITEM_ID='"+itemId+"'";
		}
		// TODO Auto-generated method stub
		return this.listBySql(CloudProductDetail.class,context, sql);
	}

	@Override
	public CloudProductDetail getCloudMdmNetworkSolnByProdId(String prodId)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String sql ="SELECT mp.id as prodId,mp.PROD_NAME as prodName, mns.id as cellId,mns.DISPLAYTEXT as displayText,mns.NAME as cellName,mns.NETWORKRATE as networkRate,pp.id as priceId,pp.price_mode as priceMode,mns.IF_ID as interfaceId  "
				   +" FROM cloud_mdm_product_item pi "
				   +"  inner join cloud_mdm_network_soln mns on mns.id=pi.item_id   "
				   +" inner join cloud_mdm_product mp on mp.ID=pi.PROD_ID "
				   +" inner join cloud_product_price pp on pp.PROD_ID=mp.ID "
				   +"   where pi.item_type='NETWORKSOLN' AND pi.state='1' and mns.DATA_STATE=1 and now()>=  pp.EFFECTIVE_DATE  and now() <=pp.INVALID_DATE  and mp.id='"+prodId+"'";
		
		
		return this.findUniqueBySql(CloudProductDetail.class,sql);
	}

	@Override
	public CloudProductDetail getCloudMdmNetworkSolnByCombProdId(
			String combProdId) throws ValidatorException {
		// TODO Auto-generated method stub
		String sql ="SELECT mp.id as prodId,mp.PROD_NAME as prodName, mns.id as cellId,mns.DISPLAYTEXT as displayText,mns.NAME as cellName,mns.NETWORKRATE as networkRate,pp.id as priceId,mns.IF_ID as interfaceId   "
				   +" FROM cloud_mdm_product_item pi "
				   +"  inner join cloud_mdm_network_soln mns on mns.id=pi.item_id   "
				   +" inner join cloud_mdm_product mp on mp.ID=pi.PROD_ID "
				   +" inner join cloud_product_combination_price cpcp on cpcp.SINGLE_PROD_ID=mp.id"
				   +" inner join cloud_product_price pp on pp.PROD_ID=mp.ID "
				   +"   where pi.item_type='NETWORKSOLN' AND pi.state='1' and mns.DATA_STATE=1 and now()>=  pp.EFFECTIVE_DATE  and now() <=pp.INVALID_DATE  and cpcp.prod_id='"+combProdId+"' and cpcp.cell_type='NETWORKSOLN'";
		
		
		return this.findUniqueBySql(CloudProductDetail.class,sql);
	}

}
