package sy.domain.vo.finance;

import java.util.Date;

import sy.common.util.valuesetter.Create;
import sy.domain.vo.base.BasicUserVo;
import sy.domain.vo.shared.BaseVo;

/**
 * 账户充值VO
 * @author luobin
 *
 */
public class AccountPayVo extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643130688211913881L;

	private String payId;
	/**
	 * 充值账户
	 */
	private BasicUserVo basicUser;
	/**
	 * 充值日期
	 */
	@Create
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
	@Create
	private String createdBy;
	
	private String payTypeName;
	
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public BasicUserVo getBasicUser() {
		return basicUser;
	}
	public void setBasicUser(BasicUserVo basicUser) {
		this.basicUser = basicUser;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	public Double getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(Double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public String getPayCardNo() {
		return payCardNo;
	}
	public void setPayCardNo(String payCardNo) {
		this.payCardNo = payCardNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getPayTypeName() {
		if(this.payType == 1){
			payTypeName="现金";
		}else if(this.payType == 2){
			payTypeName="转账";
		}else if(this.payType == 3){
			payTypeName="试用账户赠送";
		}else if(this.payType == 4){
			payTypeName="银联";
		}else if(this.payType == 5){
			payTypeName="支付宝";
		}else if(this.payType == 6){
			payTypeName="首次充值返利活动";
		}else if(this.payType == 7){
			payTypeName="充值返利活动";
		}else if(this.payType == 8){
			payTypeName="推荐返利活动";
		}
			
		return payTypeName;
	}
	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}
	
	
}
