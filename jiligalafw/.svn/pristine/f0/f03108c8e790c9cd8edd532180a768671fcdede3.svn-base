package sy.domain.model.promotion;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.base.BasicDictItem;
import sy.domain.model.shared.PersistentObject;

@Entity
@Table(name = "CLOUD_PROMOTION_INFO")
public class CloudPromotionInfo implements PersistentObject {

	private static final long serialVersionUID = 345132L;
	
	private String promotionId;
	private BasicDictItem basicPromotionType;
	private String activityName;
	private Integer rebateFlag;
	private BigDecimal rebateAmount;
	private BigDecimal rebateThresholdValue;
	private Date startDate;
	private Date endDate;
	private Integer state;
	private String remark;
	private String createdBy;
	private Date created;
	private String updatedBy;
	private Date updated;
	private BigDecimal rebatePercentage;

	@Id
	@Column(name="PROMOTION_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	
	@ManyToOne()  
    @JoinColumn(name = "PROMOTION_TYPE_ID") 
	public BasicDictItem getBasicPromotionType() {
		return basicPromotionType;
	}

	public void setBasicPromotionType(BasicDictItem basicPromotionType) {
		this.basicPromotionType = basicPromotionType;
	}
	
	@Column(name="ACTIVITY_NAME")
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	@Column(name="REBATE_FLAG")
	public Integer getRebateFlag() {
		return rebateFlag;
	}
	
	public void setRebateFlag(Integer rebateFlag) {
		this.rebateFlag = rebateFlag;
	}
	
	@Column(name="REBATE_AMOUNT")
	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}
	
	@Column(name="REBATE_THRESHOLD_VALUE")
	public BigDecimal getRebateThresholdValue() {
		return rebateThresholdValue;
	}

	public void setRebateThresholdValue(BigDecimal rebateThresholdValue) {
		this.rebateThresholdValue = rebateThresholdValue;
	}
	
	@Column(name="REBATE_PERCENTAGE")
	public BigDecimal getRebatePercentage() {
		return rebatePercentage;
	}

	public void setRebatePercentage(BigDecimal rebatePercentage) {
		this.rebatePercentage = rebatePercentage;
	}

	@Column(name="START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name="END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	@Column(name = "STATE")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
