package sy.domain.vo.base;

import java.util.Date;

import sy.common.util.validator.annotations.ValidateSize;
import sy.common.util.valuesetter.Create;
import sy.common.util.valuesetter.Update;
import sy.domain.vo.shared.BaseVo;

/**
 * 用户数量、信用额度设置VO
 * @author luobin
 *
 */
public class BasicUserQuotaVo extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643130688211913881L;

	private String quotaId;
	
	@ValidateSize(description="测试用户个数",max=4)
	private Integer testUserNum;
	
	@ValidateSize(description="测试账户额度",max=10)
	private Double testCredit;
	
	@ValidateSize(description="正式账户信用额度",max=10)
	private Double formalCredit;
	
	/**
	 * 全局信用停机天数
	 */
	@ValidateSize(description="信用停机天数",max=2)
	private Integer stopRunDay;

	/**
	 * 全局信用停机天数
	 */
	@ValidateSize(description="信用删机天数",max=2)
	private Integer delVmDay;
	
	private Integer state;
	
	@Create
	private String createdBy;
	
	@Create
	private Date created;
	
	@Update
	private String updatedBy;
	
	@Update
	private Date updated;


	public String getQuotaId() {
		return quotaId;
	}

	public void setQuotaId(String quotaId) {
		this.quotaId = quotaId;
	}

	public Integer getTestUserNum() {
		return testUserNum;
	}

	public void setTestUserNum(Integer testUserNum) {
		this.testUserNum = testUserNum;
	}

	public Double getTestCredit() {
		return testCredit;
	}

	public void setTestCredit(Double testCredit) {
		this.testCredit = testCredit;
	}

	public Double getFormalCredit() {
		return formalCredit;
	}

	public void setFormalCredit(Double formalCredit) {
		this.formalCredit = formalCredit;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Integer getStopRunDay() {
		return stopRunDay;
	}

	public void setStopRunDay(Integer stopRunDay) {
		this.stopRunDay = stopRunDay;
	}

	public Integer getDelVmDay() {
		return delVmDay;
	}

	public void setDelVmDay(Integer delVmDay) {
		this.delVmDay = delVmDay;
	}

}
