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
 * 账户充值PO
 * @author luobin
 *
 */
@Entity
@Table(name = "CLOUD_USER_PAY")
public class AccountPay implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624971534758545616L;

	private String payId;
	/**
	 * 充值账户
	 */
	private BasicUser basicUser;
	/**
	 * 充值日期
	 */
	private Date payDate;
	/**
	 * 充值金额
	 */
	private Double payAmount;
	/**
	 * 充值后余额（充值后那一刻的账户余额）
	 */
	private Double remainingAmount;
	/**
	 * 充值类型：银联、支付宝、现金、转账、赠送、首次充值、充值返利、推荐返利
	 */
	private Integer payType;
	/**
	 * 充值卡号
	 */
	private String payCardNo;
	/**
	 * 充值备注
	 */
	private String remark;
	/**
	 * 充值操作人员
	 */
	private String createdBy;
	

	@Id
	@Column(name="PAY_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	@ManyToOne()  
    @JoinColumn(name = "USER_ID") 
	public BasicUser getBasicUser() {
		return basicUser;
	}

	public void setBasicUser(BasicUser basicUser) {
		this.basicUser = basicUser;
	}
	
	@Column(name="PAY_DATE")
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	@Column(name="PAY_AMOUNT")
	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	
	@Column(name="REMAINING_AMOUNT")
	public Double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(Double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	@Column(name="PAY_TYPE")
	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	@Column(name="PAY_CARD_NO",length = 20)
	public String getPayCardNo() {
		return payCardNo;
	}

	public void setPayCardNo(String payCardNo) {
		this.payCardNo = payCardNo;
	}
	
	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


}
