package sy.domain.model.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.shared.PersistentObject;

/**
 * 用户订单子表.
 * @author cs
 *
 */
@Entity
@Table(name = "CLOUD_USER_ORDER_ITEM")
public class CloudUserOrderItem implements PersistentObject  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3624971544758545616L;
	
	/**
	 * 订单子ID
	 */
	private String orderItemId;
	/**
	 * 订单主表ID
	 */
	private CloudUserOrder cloudUserOrder;
	/**
	 * 产品主表ID.
	 */
	private CloudMdmProduct cloudMdmProduct;
	/**
	 * 产品子表ID.
	 */
	private CloudMdmProductItem cloudMdmProductItem;	
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

	
	@Id
	@Column(name="ORDER_ITEM_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	@ManyToOne()  
    @JoinColumn(name = "ORDER_ID") 
	public CloudUserOrder getCloudUserOrder() {
		return cloudUserOrder;
	}
	public void setCloudUserOrder(CloudUserOrder cloudUserOrder) {
		this.cloudUserOrder = cloudUserOrder;
	}
	
	@ManyToOne()  
    @JoinColumn(name = "PRODUCT_ID") 
	public CloudMdmProduct getCloudMdmProduct() {
		return cloudMdmProduct;
	}
	public void setCloudMdmProduct(CloudMdmProduct cloudMdmProduct) {
		this.cloudMdmProduct = cloudMdmProduct;
	}
	@Column(name="PROD_TYPE")
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	
	@Column(name="BILLING_TYPE")
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	
	@Column(name="DISK_SIZE")
	public Double getDiskSize() {
		return diskSize;
	}
	public void setDiskSize(Double diskSize) {
		this.diskSize = diskSize;
	}
	@Column(name="PROMOTION_ID")
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	@Column(name="REBATE_FLAG")
	public Integer getRebateFlag() {
		return rebateFlag;
	}
	public void setRebateFlag(Integer rebateFlag) {
		this.rebateFlag = rebateFlag;
	}

	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name="ONETIME_BILLING_FLAG")
	public Integer getOneTimeBillingFlag() {
		return oneTimeBillingFlag;
	}
	public void setOneTimeBillingFlag(Integer oneTimeBillingFlag) {
		this.oneTimeBillingFlag = oneTimeBillingFlag;
	}
	
	@Column(name="BILLING_FLAG")
	public Integer getBillingFlag() {
		return billingFlag;
	}
	public void setBillingFlag(Integer billingFlag) {
		this.billingFlag = billingFlag;
	}
	
	@Column(name="BEGIN_BILLING_TIME")
	public Date getBeginBillingTime() {
		return beginBillingTime;
	}
	public void setBeginBillingTime(Date beginBillingTime) {
		this.beginBillingTime = beginBillingTime;
	}
	
	@Column(name="NEXT_BILLING_TIME")
	public Date getNextBillingTime() {
		return nextBillingTime;
	}
	public void setNextBillingTime(Date nextBillingTime) {
		this.nextBillingTime = nextBillingTime;
	}
	
	@Column(name="RES_DESTROY_TIME")
	public Date getResDestroyTime() {
		return resDestroyTime;
	}
	public void setResDestroyTime(Date resDestroyTime) {
		this.resDestroyTime = resDestroyTime;
	}
	
	@Column(name="REBATE_AMOUNT")
	public Double getRebateAmount() {
		return rebateAmount;
	}
	public void setRebateAmount(Double rebateAmount) {
		this.rebateAmount = rebateAmount;
	}
	
	@ManyToOne()  
    @JoinColumn(name = "PRODUCT_ITEM_ID") 
	public CloudMdmProductItem getCloudMdmProductItem() {
		return cloudMdmProductItem;
	}
	public void setCloudMdmProductItem(CloudMdmProductItem cloudMdmProductItem) {
		this.cloudMdmProductItem = cloudMdmProductItem;
	}
	
	
}
