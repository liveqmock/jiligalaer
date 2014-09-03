package sy.service.promotion;

import java.util.List;

import sy.domain.vo.promotion.CloudPromotionInfoVo;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author xhchen
 *
 */
public interface CloudPromotionInfoServiceI extends BasicServiceI<CloudPromotionInfoVo> {
	public List<Object[]> getSingleProdList(String promotionId,String prodName);
	public List<Object[]> getcombProdList(String promotionId,String prodName);
	public CloudPromotionInfoVo getUniqueRecommendRebateInfo(String currDate);
}
