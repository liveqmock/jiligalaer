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

import sy.domain.model.base.BasicUser;
import sy.domain.model.shared.PersistentObject;

/**
 * 用户订单PO
 * @author CS
 *
 */
@Entity
@Table(name = "CLOUD_USER_ORDER")
public class CloudUserOrder implements PersistentObject {
	
	private static final long serialVersionUID = -3624971544758545616L;
	
	/**
	 * 订单ID
	 */
	private String orderId;
	/**
	 * 订单所属用户
	 */
	private BasicUser basicUser;
	/**
	 * 订单所属账户
	 */
	private BasicUser basicAccount;
	/**
	 * 订单日期
	 */
	private Date orderTime;
	/**
	 * 订单类型
	 * 1：网络，
	 * 2：IP，
	 * 3：虚拟机，
	 * 4：磁盘，
	 * 5：计算方案
	 */
	private Integer orderType;
	/**
	 *  0 未开始计费 
	 *  1 开始计费 
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
	 * 虚拟机ID.
	 */
	private CloudMdmVm cloudMdmVm;
	/**
	 * 主机名（表中无此字段，在高级网络模块用）
	 */
	private String vmName;
	
	/**网络、安全组ID*/
	private String netIds;
	/**
	 * 网络ID.
	 */
	private CloudMdmNetwork cloudMdmNetwork;
	/**
	 * 网络方案ID.
	 */
	private CloudMdmNetworkSoln cloudMdmNetworkSoln;
	/**
	 * IP地址
	 */
	private CloudMdmIP cloudMdmIP;
	
//	/**
//	 * 磁盘方案（更改配置时增加磁盘：卷ID）
//	 */
//	private CloudMdmDiskSoln cloudMdmDiskSoln;
	
	/**
	 * 购买类型：
	 * 快速购买（组合产品）：quickBuy，
	 * 自定义购买：customBuy，
	 * 单一产品购买：singleBuy（包含添加网络、申请IP、增加磁盘、变更计算方案）
	 */
	private String buyType;
	/**
	 * 计费周期（年、月、日、时）
	 * 一次性：0，
	 * 周期性，年：2，月：3，日：4，时：5
	 */
	private String billingCycle;
	/**
	 * 备注
	 */
	private String remark;
	 /**
	  * 状态
	  */
	private String state;
	
	
	private String createId;
	
	private String createdBy;
	
	private Date created;
	
	/**
	 * 一次性促销总价格.ONETIME_REBATE_AMOUNT
	 */
	private Double oneTimeRebateAmount;
	
	/**
	 * 一次性实际总价格.ONETIME_ORDER_AMOUNT
	 */
	private Double oneTimeProdAmount;
	
	/**
	 * 周期性促销总价格.CYCLE_REBATE_AMOUNT
	 */
	private Double cycleRebateAmount;
	
	/**
	 * 周期性实际总价格.CYCLE_ORDER_AMOUNT
	 */
	private Double cycleOrderAmount;
	

	@Id
	@Column(name="ORDER_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	@ManyToOne()  
    @JoinColumn(name = "USER_ID") 
	public BasicUser getBasicUser() {
		return basicUser;
	}
	public void setBasicUser(BasicUser basicUser) {
		this.basicUser = basicUser;
	}
	
	@Column(name="ORDER_TIME")
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	
	@ManyToOne()  
    @JoinColumn(name = "VM_ID") 
	public CloudMdmVm getCloudMdmVm() {
		return cloudMdmVm;
	}
	public void setCloudMdmVm(CloudMdmVm cloudMdmVm) {
		this.cloudMdmVm = cloudMdmVm;
	}
	
	@ManyToOne()  
    @JoinColumn(name = "NETWORK_ID") 
	public CloudMdmNetwork getCloudMdmNetwork() {
		return cloudMdmNetwork;
	}
	public void setCloudMdmNetwork(CloudMdmNetwork cloudMdmNetwork) {
		this.cloudMdmNetwork = cloudMdmNetwork;
	}
	
	@ManyToOne()  
    @JoinColumn(name = "NETWORK_SOLN_ID")
	public CloudMdmNetworkSoln getCloudMdmNetworkSoln() {
		return cloudMdmNetworkSoln;
	}
	public void setCloudMdmNetworkSoln(CloudMdmNetworkSoln cloudMdmNetworkSoln) {
		this.cloudMdmNetworkSoln = cloudMdmNetworkSoln;
	}
	
	@Column(name="BILLING_FLAG")
	public Integer getBillingFlag() {
		return billingFlag;
	}
	public void setBillingFlag(Integer billingFlag) {
		this.billingFlag = billingFlag;
	}
	@Column(name="NET_IDS")
	public String getNetIds() {
		return netIds;
	}
	public void setNetIds(String netIds) {
		this.netIds = netIds;
	}

	@Column(name="VM_Name")
	public String getVmName() {
		return vmName;
	}
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}
	
	@Column(name="BILLING_CYCLE")
	public String getBillingCycle() {
		return billingCycle;
	}
	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}
	
	@Column(name="ONETIME_REBATE_AMOUNT")
	public Double getOneTimeRebateAmount() {
		return oneTimeRebateAmount;
	}
	public void setOneTimeRebateAmount(Double oneTimeRebateAmount) {
		this.oneTimeRebateAmount = oneTimeRebateAmount;
	}
	
	@Column(name="ONETIME_ORDER_AMOUNT")
	public Double getOneTimeProdAmount() {
		return oneTimeProdAmount;
	}
	
	public void setOneTimeProdAmount(Double oneTimeProdAmount) {
		this.oneTimeProdAmount = oneTimeProdAmount;
	}
	
	@Column(name="CYCLE_REBATE_AMOUNT")
	public Double getCycleRebateAmount() {
		return cycleRebateAmount;
	}
	public void setCycleRebateAmount(Double cycleRebateAmount) {
		this.cycleRebateAmount = cycleRebateAmount;
	}
	@Column(name="CYCLE_ORDER_AMOUNT")
	public Double getCycleOrderAmount() {
		return cycleOrderAmount;
	}
	public void setCycleOrderAmount(Double cycleOrderAmount) {
		this.cycleOrderAmount = cycleOrderAmount;
	}
	
	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="STATE")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="CREATED_ID")
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name="CREATED")
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Column(name="BUY_TYPE")
	public String getBuyType() {
		return buyType;
	}
	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}
	@ManyToOne()  
    @JoinColumn(name="IP_ID") 
	public CloudMdmIP getCloudMdmIP() {
		return cloudMdmIP;
	}
	public void setCloudMdmIP(CloudMdmIP cloudMdmIP) {
		this.cloudMdmIP = cloudMdmIP;
	}
	
	@ManyToOne()  
    @JoinColumn(name="ACCOUNT_ID") 
	public BasicUser getBasicAccount() {
		return basicAccount;
	}
	public void setBasicAccount(BasicUser basicAccount) {
		this.basicAccount = basicAccount;
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
	
	/**订单类型,1：网络，2：IP，3：虚拟机，4：磁盘方案*/
	@Column(name="ORDER_TYPE")
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	
//	@ManyToOne()  
//    @JoinColumn(name="DISK_SOLN_ID") 
//	public CloudMdmDiskSoln getCloudMdmDiskSoln() {
//		return cloudMdmDiskSoln;
//	}
//	public void setCloudMdmDiskSoln(CloudMdmDiskSoln cloudMdmDiskSoln) {
//		this.cloudMdmDiskSoln = cloudMdmDiskSoln;
//	}
	
}
