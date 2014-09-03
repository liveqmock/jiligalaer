package sy.domain.vo.expense;

import java.util.Date;

import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.product.CloudUserOrderItemVo;
import sy.domain.vo.product.CloudUserOrderVo;
import sy.domain.vo.shared.BaseVo;

/**
 * 账户费用明细VO
 * @author luobin
 *
 */
public class AccountExpenseItemVo extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643130688211913881L;

	private String expItemId;
	/**
	 * 订单ID
	 */
	private CloudUserOrderVo cloudUserOrder;
	/**
	 * 订单子ID
	 */
	private CloudUserOrderItemVo cloudUserOrderItem;
	/**
	 * 费用账户
	 */
	private BasicUserVo basicUser;
	/**
	 * 计费日期
	 */
	private Date expDate;
	/**
	 * 计费金额
	 */
	private Double expAmount;
	/**
	 * 计费类型（一次性、周期性）
	 */
	private String billingType;
	
	public String getExpItemId() {
		return expItemId;
	}
	public void setExpItemId(String expItemId) {
		this.expItemId = expItemId;
	}
	public CloudUserOrderVo getCloudUserOrder() {
		return cloudUserOrder;
	}
	public void setCloudUserOrder(CloudUserOrderVo cloudUserOrder) {
		this.cloudUserOrder = cloudUserOrder;
	}
	public CloudUserOrderItemVo getCloudUserOrderItem() {
		return cloudUserOrderItem;
	}
	public void setCloudUserOrderItem(CloudUserOrderItemVo cloudUserOrderItem) {
		this.cloudUserOrderItem = cloudUserOrderItem;
	}
	public BasicUserVo getBasicUser() {
		return basicUser;
	}
	public void setBasicUser(BasicUserVo basicUser) {
		this.basicUser = basicUser;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public Double getExpAmount() {
		return expAmount;
	}
	public void setExpAmount(Double expAmount) {
		this.expAmount = expAmount;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
}
