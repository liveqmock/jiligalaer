package sy.domain.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.shared.PersistentObject;

/**
 * 用户数量、信用额度设置PO
 * @author luobin
 *
 */
@Entity
@Table(name = "BASIC_USER_QUOTA")
public class BasicUserQuota implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624971534758545616L;

	private String quotaId;
	
	private Integer testUserNum;
	
	private Double testCredit;
	
	private Double formalCredit;
	
	private Integer stopRunDay;
	
	private Integer delVmDay;
	
	private Integer state;
	
	private String createdBy;
	
	private Date created;
	
	private String updatedBy;
	
	private Date updated;

	@Id
	@Column(name="QUOTA_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getQuotaId() {
		return quotaId;
	}

	public void setQuotaId(String quotaId) {
		this.quotaId = quotaId;
	}

	@Column(name="TEST_USER_NUM")
	public Integer getTestUserNum() {
		return testUserNum;
	}

	public void setTestUserNum(Integer testUserNum) {
		this.testUserNum = testUserNum;
	}

	@Column(name="TEST_CREDIT")
	public Double getTestCredit() {
		return testCredit;
	}

	public void setTestCredit(Double testCredit) {
		this.testCredit = testCredit;
	}
	
	@Column(name="FORMAL_CREDIT")
	public Double getFormalCredit() {
		return formalCredit;
	}

	public void setFormalCredit(Double formalCredit) {
		this.formalCredit = formalCredit;
	}

	@Column(name="STATE")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name="UPDATED")
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Column(name="STOP_RUN_DAY")
	public Integer getStopRunDay() {
		return stopRunDay;
	}

	public void setStopRunDay(Integer stopRunDay) {
		this.stopRunDay = stopRunDay;
	}
	
	@Column(name="DEL_VM_DAY")
	public Integer getDelVmDay() {
		return delVmDay;
	}

	public void setDelVmDay(Integer delVmDay) {
		this.delVmDay = delVmDay;
	}
}
