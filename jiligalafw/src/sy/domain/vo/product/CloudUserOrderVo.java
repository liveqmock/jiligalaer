package sy.domain.vo.product;

import java.util.Date;

import sy.common.util.Constants;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.shared.BaseVo;

/**
 * 产品订单信息
 * 
 * @author CS
 * 
 */
public class CloudUserOrderVo extends BaseVo {
	
	private static final long serialVersionUID = -3624971544758545616L;
	
	/**
	 * 订单ID
	 */
	private String orderId;
	/**
	 * 订单所属用户
	 */
	private BasicUserVo basicUser;
	/**
	 * 订单所属账户
	 */
	private BasicUserVo basicAccount;
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
	private CloudMdmVmVo cloudMdmVm;
	/**
	 * 主机名（表中无此字段，在高级网络模块用）
	 */
	private String vmName;
	
	/**网络、安全组ID*/
	private String netIds;
	/**
	 * 网络ID.
	 */
	private CloudMdmNetworkVo cloudMdmNetwork;
	/**
	 * 网络方案ID.
	 */
	private CloudMdmNetworkSolnVo cloudMdmNetworkSoln;
	/**
	 * IP地址
	 */
	private CloudMdmIPVo cloudMdmIP;
	
//	/**
//	 * 磁盘方案（更改配置时增加磁盘：卷ID）
//	 */
//	private CloudMdmDiskSolnVo cloudMdmDiskSoln;
	
	/**
	 * 购买类型：
	 * 快速购买（组合产品）：quickBuy，
	 * 自定义购买：customBuy，
	 * 单一产品购买：singleBuy（包含添加网络、申请IP、增加磁盘、变更计算方案）
	 */
	private String buyType;
	/**
	 * 计费周期（年、月、日、时）
	 * 一次性：0，(不用存值)
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
	
	private String cycleName;
	
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
	

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BasicUserVo getBasicUser() {
		return basicUser;
	}

	public void setBasicUser(BasicUserVo basicUser) {
		this.basicUser = basicUser;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public CloudMdmVmVo getCloudMdmVm() {
		return cloudMdmVm;
	}

	public void setCloudMdmVm(CloudMdmVmVo cloudMdmVm) {
		this.cloudMdmVm = cloudMdmVm;
	}

	public CloudMdmNetworkVo getCloudMdmNetwork() {
		return cloudMdmNetwork;
	}

	public void setCloudMdmNetwork(CloudMdmNetworkVo cloudMdmNetwork) {
		this.cloudMdmNetwork = cloudMdmNetwork;
	}

	public CloudMdmNetworkSolnVo getCloudMdmNetworkSoln() {
		return cloudMdmNetworkSoln;
	}

	public Integer getBillingFlag() {
		return billingFlag;
	}

	public void setBillingFlag(Integer billingFlag) {
		this.billingFlag = billingFlag;
	}

	public void setCloudMdmNetworkSoln(CloudMdmNetworkSolnVo cloudMdmNetworkSoln) {
		this.cloudMdmNetworkSoln = cloudMdmNetworkSoln;
	}

	public String getBuyType() {
		return buyType;
	}

	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}

	public String getBillingCycle() {
		return billingCycle;
	}

	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getNetIds() {
		return netIds;
	}

	public void setNetIds(String netIds) {
		this.netIds = netIds;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public CloudMdmIPVo getCloudMdmIP() {
		return cloudMdmIP;
	}

	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	public Double getOneTimeRebateAmount() {
		return oneTimeRebateAmount;
	}

	public void setOneTimeRebateAmount(Double oneTimeRebateAmount) {
		this.oneTimeRebateAmount = oneTimeRebateAmount;
	}

	public Double getOneTimeProdAmount() {
		return oneTimeProdAmount;
	}

	public void setOneTimeProdAmount(Double oneTimeProdAmount) {
		this.oneTimeProdAmount = oneTimeProdAmount;
	}

	public Double getCycleRebateAmount() {
		return cycleRebateAmount;
	}

	public void setCycleRebateAmount(Double cycleRebateAmount) {
		this.cycleRebateAmount = cycleRebateAmount;
	}

	public Double getCycleOrderAmount() {
		return cycleOrderAmount;
	}

	public void setCycleOrderAmount(Double cycleOrderAmount) {
		this.cycleOrderAmount = cycleOrderAmount;
	}

	public void setCloudMdmIP(CloudMdmIPVo cloudMdmIP) {
		this.cloudMdmIP = cloudMdmIP;
	}

	public BasicUserVo getBasicAccount() {
		return basicAccount;
	}

	public void setBasicAccount(BasicUserVo basicAccount) {
		this.basicAccount = basicAccount;
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

	/**订单类型,1：网络，2：IP，3：虚拟机，4：磁盘方案*/
	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getCycleName() {
		if(this.billingCycle == null){
			cycleName = "一次性收费";
		}else{
			if(this.billingCycle.equals(Constants.BILLING_CYCLE_YEAR)){
				cycleName = "每年收费";
			}else if(this.billingCycle.equals(Constants.BILLING_CYCLE_MONTH)){
				cycleName = "每月收费";
			}else if(this.billingCycle.equals(Constants.BILLING_CYCLE_DAY)){
				cycleName = "每天收费";
			}else if(this.billingCycle.equals(Constants.BILLING_CYCLE_HOUR)){
				cycleName = "每小时收费";
			}else{
				cycleName = "一次性收费";
			}
		}
		return cycleName;
	}

	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}

//	public CloudMdmDiskSolnVo getCloudMdmDiskSoln() {
//		return cloudMdmDiskSoln;
//	}
//
//	public void setCloudMdmDiskSoln(CloudMdmDiskSolnVo cloudMdmDiskSoln) {
//		this.cloudMdmDiskSoln = cloudMdmDiskSoln;
//	}
	

}
