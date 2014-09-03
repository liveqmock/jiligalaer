package sy.domain.model.finance;

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
 * 账户退款PO
 * @author luobin
 *
 */
@Entity
@Table(name = "CLOUD_USER_REFUND")
public class AccountRefund implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643130688211913881L;

	private String refundId;
	
	/**
	 * 退款账户
	 */
	private BasicUser basicUser;
	/**
	 * 退款申请日期
	 */
	private Date applyDate;
	/**
	 * 退款申请金额
	 */
	private Double applyAmount;
	/**
	 * 退款申请备注
	 */
	private String applyRemark;
	/**
	 * 处理退款日期
	 */
	private Date refundDate;
	/**
	 * 时间退款金额
	 */
	private Double refundAmount;
	/**
	 * 处理退款备注
	 */
	private String refundRemark;
	/**
	 * 退款状态
	 */
	private Integer state;
	/**
	 * 退款处理人员
	 */
	private String refundBy;

	@Id
	@Column(name="REFUND_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}
	
	@ManyToOne()  
    @JoinColumn(name = "USER_ID") 
	public BasicUser getBasicUser() {
		return basicUser;
	}

	public void setBasicUser(BasicUser basicUser) {
		this.basicUser = basicUser;
	}

	@Column(name="APPLY_DATE")
	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	@Column(name="APPLY_AMOUNT")
	public Double getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(Double applyAmount) {
		this.applyAmount = applyAmount;
	}

	@Column(name="APPLY_REMARK")
	public String getApplyRemark() {
		return applyRemark;
	}

	public void setApplyRemark(String applyRemark) {
		this.applyRemark = applyRemark;
	}

	@Column(name="REFUND_DATE")
	public Date getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	@Column(name="REFUND_AMOUNT")
	public Double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}

	@Column(name="REFUND_REMAKR")
	public String getRefundRemark() {
		return refundRemark;
	}

	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}

	@Column(name="REFUND_STATE")
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	@Column(name="REFUND_BY")
	public String getRefundBy() {
		return refundBy;
	}

	public void setRefundBy(String refundBy) {
		this.refundBy = refundBy;
	}
	
}
