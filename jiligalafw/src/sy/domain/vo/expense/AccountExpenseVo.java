package sy.domain.vo.expense;

import java.util.Date;

import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.shared.BaseVo;

/**
 * 账户费用汇总VO
 * @author luobin
 *
 */
public class AccountExpenseVo extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643130688211913881L;

	private String expId;
	/**
	 * 费用账户
	 */
	private BasicUserVo basicUser;
	/**
	 * 账户充值、退款后总金额
	 */
	private Double payTotalAmount;
	/**
	 * 充值、退款总额更新时间
	 */
	private Date payUpdated;
	/**
	 * 账号费用总额
	 */
	private Double expTotalAmount;
	/**
	 * 费用总额更新时间
	 */
	private Date expUpdated;	
	/**
	 * 账户信用额度
	 */
	private Double creditAmount;
	
	/**是否正在计费*/
	private Integer isBilling;
	
	/**已使用的信用开机天数*/
	private Integer usedStopRunDays;
	
	/**已使用的信用开机天数*/
	private Integer usedDelVmDays;
	
	/**信用开始天数上次提醒时间*/
	private Date stopRunDaysLastWarnDate;
	
	/**信用开始天数上次提醒时间*/
	private Date delVmDaysLastWarnDate;
	
	/**上次提醒日期*/
	private Date lastRemindDate;
	
	public String getExpId() {
		return expId;
	}
	public void setExpId(String expId) {
		this.expId = expId;
	}
	public BasicUserVo getBasicUser() {
		return basicUser;
	}
	public void setBasicUser(BasicUserVo basicUser) {
		this.basicUser = basicUser;
	}
	public Double getPayTotalAmount() {
		return payTotalAmount;
	}
	public void setPayTotalAmount(Double payTotalAmount) {
		this.payTotalAmount = payTotalAmount;
	}
	public Date getPayUpdated() {
		return payUpdated;
	}
	public void setPayUpdated(Date payUpdated) {
		this.payUpdated = payUpdated;
	}
	public Double getExpTotalAmount() {
		return expTotalAmount;
	}
	public void setExpTotalAmount(Double expTotalAmount) {
		this.expTotalAmount = expTotalAmount;
	}
	public Date getExpUpdated() {
		return expUpdated;
	}
	public void setExpUpdated(Date expUpdated) {
		this.expUpdated = expUpdated;
	}
	public Double getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}
	public Integer getIsBilling() {
		return isBilling;
	}
	public void setIsBilling(Integer isBilling) {
		this.isBilling = isBilling;
	}
	public Integer getUsedStopRunDays() {
		return usedStopRunDays;
	}
	public void setUsedStopRunDays(Integer usedStopRunDays) {
		this.usedStopRunDays = usedStopRunDays;
	}
	public Integer getUsedDelVmDays() {
		return usedDelVmDays;
	}
	public void setUsedDelVmDays(Integer usedDelVmDays) {
		this.usedDelVmDays = usedDelVmDays;
	}
	public Date getStopRunDaysLastWarnDate() {
		return stopRunDaysLastWarnDate;
	}
	public void setStopRunDaysLastWarnDate(Date stopRunDaysLastWarnDate) {
		this.stopRunDaysLastWarnDate = stopRunDaysLastWarnDate;
	}
	public Date getDelVmDaysLastWarnDate() {
		return delVmDaysLastWarnDate;
	}
	public void setDelVmDaysLastWarnDate(Date delVmDaysLastWarnDate) {
		this.delVmDaysLastWarnDate = delVmDaysLastWarnDate;
	}
	public Date getLastRemindDate() {
		return lastRemindDate;
	}
	public void setLastRemindDate(Date lastRemindDate) {
		this.lastRemindDate = lastRemindDate;
	}
	
}
