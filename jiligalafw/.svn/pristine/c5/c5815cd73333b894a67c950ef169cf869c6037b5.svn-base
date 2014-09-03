package sy.service.promotion;

import sy.domain.vo.promotion.CloudPromotionProductVo;
import sy.domain.vo.promotion.CloudPromotionValue;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author xhchen
 *
 */
public interface CloudPromotionProductServiceI extends BasicServiceI<CloudPromotionProductVo> {
	
	public String getProdIdsByPromId(String promotionId);
	
	public int deleteByPromId(String promotionId) ;

	public void save(String promotionId, String prodIds);

	/**
	 * 根据当前日期所在的首次充值返利活动中，获取最优的、有效的首次返利金额
	 * @return
	 */
	public Double getFirstRebateAmount();
	/**
	 * 查找符合条件的充值返利活动：根据充值的金额，计算出获取充值返利金额
	 * @param promType 促销活动类型
	 * @param amount 充值金额、产品价格
	 * @return
	 */
	public Double getRebateAmount(String promType, Double amount);
	
	/**
	 * 查找符合条件的产品促销活动：根据产品的价格，计算出折扣后的价格
	 * @param promType 促销活动类型
	 * @param prodId 产品ID（组合、单一）
	 * @param amount 产品价格
	 * @return
	 */
	public CloudPromotionValue getDiscountAmountByProdId( String prodId, Double amount);
		
	
}
