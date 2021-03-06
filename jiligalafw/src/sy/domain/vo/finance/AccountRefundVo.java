package sy.domain.vo.finance;

import java.util.Date;

import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.shared.BaseVo;

/**
 * 账户退款VO
 * @author luobin
 *
 */
public class AccountRefundVo extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643130688211913881L;

	private String refundId;
	
	/**
	 * 退款账户
	 */
	private BasicUserVo basicUser;
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
	private String refundDate;
	/**
	 * 处理退款金额
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

	private String stateName;
	
	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public BasicUserVo getBasicUser() {
		return basicUser;
	}
	
	public void setBasicUser(BasicUserVo basicUser) {
		this.basicUser = basicUser;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Double getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(Double applyAmount) {
		this.applyAmount = applyAmount;
	}

	public String getApplyRemark() {
		return applyRemark;
	}

	public void setApplyRemark(String applyRemark) {
		this.applyRemark = applyRemark;
	}

	public String getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
	}

	public Double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundRemark() {
		return refundRemark;
	}

	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRefundBy() {
		return refundBy;
	}

	public void setRefundBy(String refundBy) {
		this.refundBy = refundBy;
	}

	public String getStateName() {
		if(this.state == 0){
			stateName = "未退款";
		}else if(this.state == 1){
			stateName = "已退款";
		}else{
			stateName = "拒绝";
		}
		return stateName;
	}

}
