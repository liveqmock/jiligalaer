package sy.domain.model.expense;

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
 * 账户费用汇总PO
 * @author luobin
 *
 */
@Entity
@Table(name = "CLOUD_USER_EXPENSE")
public class AccountExpense implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624971534758545616L;

	private String expId;
	/**
	 * 费用账户
	 */
	private BasicUser basicUser;
	/**
	 * 账户充值总金额
	 */
	private Double payTotalAmount;
	/**
	 * 充值总额更新时间
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
	
	/**信用开始天数上次提醒时间*/
	private Date stopRunDaysLastWarnDate;
	
	/**已使用的信用开机天数*/
	private Integer usedDelVmDays;

	/**信用开始天数上次提醒时间*/
	private Date delVmDaysLastWarnDate;
	
	/**上次提醒日期*/
	private Date lastRemindDate;
	
	@Id
	@Column(name="EXP_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}

	@ManyToOne()  
    @JoinColumn(name = "USER_ID") 
	public BasicUser getBasicUser() {
		return basicUser;
	}

	public void setBasicUser(BasicUser basicUser) {
		this.basicUser = basicUser;
	}
	
	@Column(name="PAY_TOTAL_AMOUNT")
	public Double getPayTotalAmount() {
		return payTotalAmount;
	}

	public void setPayTotalAmount(Double payTotalAmount) {
		this.payTotalAmount = payTotalAmount;
	}
	
	@Column(name="PAY_UPDATED")
	public Date getPayUpdated() {
		return payUpdated;
	}

	public void setPayUpdated(Date payUpdated) {
		this.payUpdated = payUpdated;
	}


	@Column(name="EXP_TOTAL_AMOUNT")
	public Double getExpTotalAmount() {
		return expTotalAmount;
	}

	public void setExpTotalAmount(Double expTotalAmount) {
		this.expTotalAmount = expTotalAmount;
	}

	@Column(name="EXP_UPDATED")
	public Date getExpUpdated() {
		return expUpdated;
	}

	public void setExpUpdated(Date expUpdated) {
		this.expUpdated = expUpdated;
	}

	@Column(name="CREDIT_AMOUNT")
	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	@Column(name="IS_BILLING")
	public Integer getIsBilling() {
		return isBilling;
	}

	public void setIsBilling(Integer isBilling) {
		this.isBilling = isBilling;
	}

	@Column(name="USED_STOP_RUN_DAYS")
	public Integer getUsedStopRunDays() {
		return usedStopRunDays;
	}

	public void setUsedStopRunDays(Integer usedStopRunDays) {
		this.usedStopRunDays = usedStopRunDays;
	}

	@Column(name="USED_DEL_VM_DAYS")
	public Integer getUsedDelVmDays() {
		return usedDelVmDays;
	}

	public void setUsedDelVmDays(Integer usedDelVmDays) {
		this.usedDelVmDays = usedDelVmDays;
	}

	@Column(name="STOP_RUN_DAYS_LAST_WARN_DATE")
	public Date getStopRunDaysLastWarnDate() {
		return stopRunDaysLastWarnDate;
	}

	public void setStopRunDaysLastWarnDate(Date stopRunDaysLastWarnDate) {
		this.stopRunDaysLastWarnDate = stopRunDaysLastWarnDate;
	}

	@Column(name="DEL_VM_DAYS_LAST_WARN_DATE")
	public Date getDelVmDaysLastWarnDate() {
		return delVmDaysLastWarnDate;
	}

	public void setDelVmDaysLastWarnDate(Date delVmDaysLastWarnDate) {
		this.delVmDaysLastWarnDate = delVmDaysLastWarnDate;
	}

	@Column(name="LAST_REMIND_DATE")
	public Date getLastRemindDate() {
		return lastRemindDate;
	}

	public void setLastRemindDate(Date lastRemindDate) {
		this.lastRemindDate = lastRemindDate;
	}
}
