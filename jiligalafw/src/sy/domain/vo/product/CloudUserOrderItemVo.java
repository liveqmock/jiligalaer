package sy.domain.vo.product;

import java.util.Date;

import sy.common.util.Constants;
import sy.domain.vo.shared.BaseVo;

/**
 * 用户订单子表.
 * @author cs
 *
 */
public class CloudUserOrderItemVo extends BaseVo {
	
	private static final long serialVersionUID = -3624971544758545616L;
	
	/**
	 * 订单子ID
	 */
	private String orderItemId;
	/**
	 * 订单主表ID
	 */

	private CloudUserOrderVo cloudUserOrder;
	/**
	 * 产品主表ID.
	 */
	private CloudMdmProductVo cloudMdmProduct;
	/**
	 * 产品子表ID.
	 */
	private CloudMdmProductItemVo cloudMdmProductItem;
	/**
	 * 产品类型（单一  or 组合）.
	 */
	private String prodType;
	
	
	/**
	 *一次性计费是否已发生.ONETIME_BILLING_FLAG
	 */
	private Integer oneTimeBillingFlag;
	/**
	 *  0 未开始计费 ，1 开始计费 .
	 */
	private Integer billingFlag;
	/**
	 *开始计费时间. BEGIN_BILLING_TIME
	 */
	private Date beginBillingTime;
	
	/**
	 *下次计费时间. NEXT_BILLING_TIME
	 */
	private Date nextBillingTime;
	/**
	 * 资源销毁时间
	 */
	private Date resDestroyTime;
	/**
	 * BILLING_TYPE计费类型（一次性、周期性）.
	 */
	private String billingType;
	/**
	 * 自定义磁盘大小
	 */
	private Double diskSize;
	
//	/**
//	 * PROD_DETAIL_AMOUNT产品明细实际价格.
//	 */
//	private Double prodDetailPrice;
//	/**
//	 * PROD_DETAIL_PRICE产品明细促销价格
//	 */
//	private Double prodRebatePrice;

	/**
	 * PROMOTION_ID 促销活动ID
	 */
	private String promotionId;
	/**
	 * 促销方式
	 */
	private Integer rebateFlag;
	/**
	 * 返利额度或者金额
	 */
	private Double rebateAmount;
	
//	/**
//	 * ACTIVITY_NAME促销活动名称
//	 */
//	private String activityName;	
//	/**
//	 * PROMOTION_START_DATE促销开始时间
//	 */
//	private Date promotionStartDate;
//	/**
//	 * PROMOTION_END_DATE促销结束时间
//	 */
//	private Date promotionEndDate;
	
	/**
	 * 备注
	 */
	private String remark;
	
	private String buyName;
	
	private String billingTypeName;
	
	private CloudProductPriceVo cloudProductPrice;
	
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public CloudUserOrderVo getCloudUserOrder() {
		return cloudUserOrder;
	}
	public void setCloudUserOrder(CloudUserOrderVo cloudUserOrder) {
		this.cloudUserOrder = cloudUserOrder;
	}
	public CloudMdmProductVo getCloudMdmProduct() {
		return cloudMdmProduct;
	}
	public void setCloudMdmProduct(CloudMdmProductVo cloudMdmProduct) {
		this.cloudMdmProduct = cloudMdmProduct;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public Integer getOneTimeBillingFlag() {
		return oneTimeBillingFlag;
	}
	public void setOneTimeBillingFlag(Integer oneTimeBillingFlag) {
		this.oneTimeBillingFlag = oneTimeBillingFlag;
	}
	public Integer getBillingFlag() {
		return billingFlag;
	}
	public void setBillingFlag(Integer billingFlag) {
		this.billingFlag = billingFlag;
	}
	public Date getBeginBillingTime() {
		return beginBillingTime;
	}
	public void setBeginBillingTime(Date beginBillingTime) {
		this.beginBillingTime = beginBillingTime;
	}
	public Date getNextBillingTime() {
		return nextBillingTime;
	}
	public void setNextBillingTime(Date nextBillingTime) {
		this.nextBillingTime = nextBillingTime;
	}
	public Date getResDestroyTime() {
		return resDestroyTime;
	}
	public void setResDestroyTime(Date resDestroyTime) {
		this.resDestroyTime = resDestroyTime;
	}
	public Double getDiskSize() {
		return diskSize;
	}
	public void setDiskSize(Double diskSize) {
		this.diskSize = diskSize;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	public Integer getRebateFlag() {
		return rebateFlag;
	}
	public void setRebateFlag(Integer rebateFlag) {
		this.rebateFlag = rebateFlag;
	}
	public Double getRebateAmount() {
		return rebateAmount;
	}
	public void setRebateAmount(Double rebateAmount) {
		this.rebateAmount = rebateAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public CloudMdmProductItemVo getCloudMdmProductItem() {
		return cloudMdmProductItem;
	}
	public void setCloudMdmProductItem(CloudMdmProductItemVo cloudMdmProductItem) {
		this.cloudMdmProductItem = cloudMdmProductItem;
	}
	public String getBuyName() {
		if(Constants.PROD_TYPE_IP.equals(prodType)){
			if(this.getCloudUserOrder().getCloudMdmIP() != null){
				buyName = "IP：" + this.getCloudUserOrder().getCloudMdmIP().getIpAddress();
			}else{
				buyName = "IP：";
			}
			
		}else if(Constants.PROD_TYPE_NETWORK_SOLN.equals(prodType)){
			buyName = "网络：" + this.getCloudUserOrder().getCloudMdmNetwork().getName();
		}else {
			buyName = "VM：" + this.getCloudUserOrder().getVmName();
		}
		return buyName;
	}
	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}
	public String getBillingTypeName() {
		if(Constants.BILLING_TYPE_SINGLE.equals(billingType)){
			billingTypeName = "一次性";
		}else{
			billingTypeName = "周期性";
		}
		return billingTypeName;
	}
	public void setBillingTypeName(String billingTypeName) {
		this.billingTypeName = billingTypeName;
	}
	
	public CloudProductPriceVo getCloudProductPrice() {
		return cloudProductPrice;
	}
	public void setCloudProductPrice(CloudProductPriceVo cloudProductPrice) {
		this.cloudProductPrice = cloudProductPrice;
	}

	
}
