package sy.service.promotion;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import sy.common.util.Constants;
import sy.common.util.StringUtils;
import sy.domain.model.product.CloudMdmProduct;
import sy.domain.model.promotion.CloudPromotionInfo;
import sy.domain.model.promotion.CloudPromotionProduct;
import sy.domain.vo.product.CloudMdmProductVo;
import sy.domain.vo.promotion.CloudPromotionProductVo;
import sy.domain.vo.promotion.CloudPromotionValue;
import sy.service.shared.BaseServiceTemplate;


@Service("cloudPromotionProductService")
public class CloudPromotionProductService extends BaseServiceTemplate<CloudPromotionProduct, CloudPromotionProductVo>
		implements CloudPromotionProductServiceI {

	@Override
	public String getProdIdsByPromId(String promotionId) {
		List<CloudMdmProductVo> prodList = find(
				CloudMdmProductVo.class,
				"select a.cloudMdmProduct from CloudPromotionProduct a where a.cloudPromotionInfo.promotionId=?",
				promotionId);
		String resId = "";
		for (CloudMdmProductVo prod : prodList) {
			if (!resId.equals("")) {
				resId += ",";
			}
			resId += prod.getId();
		}
		return resId;
	}

	@Override
	public int deleteByPromId(String promotionId) {
		return update("delete from CloudPromotionProduct where cloudPromotionInfo.promotionId=?", promotionId);
	}

	@Override
	public void save(String promotionId, String prodIds) {
		deleteByPromId(promotionId);
		
		if (StringUtils.isNotBlank(prodIds)) {
			String[] prodIdArr = prodIds.split(",");
			for (String id : prodIdArr) {
				CloudPromotionProduct promotionProduct = new CloudPromotionProduct();
				
				CloudPromotionInfo promotionInfo = new CloudPromotionInfo();
				promotionInfo.setPromotionId(promotionId);
				promotionProduct.setCloudPromotionInfo(promotionInfo);
				
				CloudMdmProduct mdmProduct = new CloudMdmProduct();
				mdmProduct.setId(id);
				promotionProduct.setCloudMdmProduct(mdmProduct);
				getBaseDao().save(promotionProduct);
			}
		}
	}

	
	@Override
	public Double getFirstRebateAmount(){
		String sql = "select  ifnull(max(REBATE_AMOUNT),0) " +
				"	from 	cloud_promotion_info cp " +
				"			inner join basic_dict_item di on cp.PROMOTION_TYPE_ID = di.DICT_ITEM_ID " +
				"	where	cp.START_DATE<=now() and cp.END_DATE>=now() " +
				"			and di.ITEM_CODE='"+Constants.PROMOTIONTYPE_FIRST+"' ";
		
		List<Object[]> list = super.getBaseDao().findBySQL(sql);
		if(list != null){
			return Double.valueOf(String.valueOf(list.get(0)));
		}else{
			return 0d;
		}
	}
	
	/**
	 * 根据活动类型，在活动有效时间内获取最优的活动
	 * obj[0]：按照返利条件统一换算成的%
	 * obj[1]：返利条件（每满xxx）
	 * @param promType
	 * @return
	 */
	private Object[] getOptimalPromotion(String promType){
		String sql = "select  ifnull(REBATE_PERCENTAGE,0), ifnull(REBATE_THRESHOLD_VALUE,0) " +
				"	from 	cloud_promotion_info cp " +
				"			inner join basic_dict_item di on cp.PROMOTION_TYPE_ID = di.DICT_ITEM_ID " +
				"	where	cp.START_DATE<=now() and cp.END_DATE>=now() " +
				"			and di.ITEM_CODE='" + promType + "' " +
				"	order by REBATE_PERCENTAGE desc " +
				"	limit 0,1 ";
		
		List<Object[]> list = super.getBaseDao().findBySQL(sql);
		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	
	@Override
	public Double getRebateAmount(String promType, Double amount){
		Object[] objArr = this.getOptimalPromotion(promType);
		if(objArr != null){
			int num = (int) (amount/Double.parseDouble(objArr[1].toString()));
			return num*Double.parseDouble(objArr[0].toString())*Double.parseDouble(objArr[1].toString());
		}else{
			return null;
		}
	}
	
	/**
	 * 根据促销产品活动类型，在活动有效时间内获取最优的活动
	 * obj[0]：按照返利条件统一换算成的%
	 * obj[1]：返利条件（每满xxx）
	 * @param promType
	 * @return
	 */
	@SuppressWarnings("unused")
	private Object[] getOptimalProd(String promType, String prodId, Double Amount){
		String sql = "select  ifnull(REBATE_PERCENTAGE,0), ifnull(REBATE_THRESHOLD_VALUE,0) " +
				"	from 	cloud_promotion_info cp " +
				"			inner join basic_dict_item di on cp.PROMOTION_TYPE_ID = di.DICT_ITEM_ID " +
				"			inner join cloud_promotion_product p on p.PROMOTION_ID=cp.PROMOTION_ID " +
				"	where	cp.START_DATE<=now() and cp.END_DATE>=now() " +
				"			and di.ITEM_CODE='" + promType + "' and p.PROD_ID='" + prodId + "' " +
				"	order by REBATE_PERCENTAGE asc " +
				"	limit 0,1 ";
		
		List<Object[]> list = super.getBaseDao().findBySQL(sql);
		if(list != null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public CloudPromotionValue getDiscountAmountByProdId(String prodId, Double amount){
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select p.promotion_id,p.activity_name,p.rebate_flag,p.rebate_amount,p.start_date,p.end_date ");
		sqlBuilder.append("from cloud_promotion_info p ");
		sqlBuilder.append("inner join cloud_promotion_product pp on pp.promotion_id=p.promotion_id ");
		sqlBuilder.append("where p.state ='1' and  curdate() between p.start_date and p.end_date and pp.prod_id='" + prodId +"'");
		
		CloudPromotionValue cloudPromotionValue = new CloudPromotionValue();
		cloudPromotionValue.setDiscountAmount(Double.MAX_VALUE);
		
		List<Object[]> promolist = super.getBaseDao().findBySQL(sqlBuilder.toString());
		if(promolist != null && promolist.size()>0){
			for(Object[] objArray : promolist) {
				
				//促销后金额
				Double discountAmount = 0D;
				
				//1:比例;2:金额
				if ((Integer)objArray[2]==1){
					discountAmount =amount- (amount * (((BigDecimal)objArray[3]).doubleValue()/100));
				} else {
					discountAmount = amount - ((BigDecimal)objArray[3]).doubleValue();
				}
				
				if (discountAmount < cloudPromotionValue.getDiscountAmount()) {
					cloudPromotionValue.setPromotionId((String)objArray[0]);
					cloudPromotionValue.setActivityName((String)objArray[1]);
					cloudPromotionValue.setStartDate((Date)objArray[4]);
					cloudPromotionValue.setEndDate((Date)objArray[5]);
					cloudPromotionValue.setRebateFlag((Integer)objArray[2]);
					cloudPromotionValue.setRebateAmount(((BigDecimal)objArray[3]).doubleValue()/100);
					cloudPromotionValue.setOriginalAmount(amount);
					cloudPromotionValue.setDiscountAmount(discountAmount);
				}
			}
		} else {
			return cloudPromotionValue = null;
		}
		
		if (cloudPromotionValue.getDiscountAmount() < 0) {
			cloudPromotionValue.setDiscountAmount(0D);
		}
		return cloudPromotionValue;
	}

}
