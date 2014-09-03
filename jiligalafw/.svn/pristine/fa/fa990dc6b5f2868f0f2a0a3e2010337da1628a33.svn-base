package sy.domain.vo.base;

import java.util.Date;

import sy.common.util.validator.annotations.ValidateNotEmpty;
import sy.common.util.validator.annotations.ValidateNotNull;
import sy.common.util.validator.annotations.ValidatePattern;
import sy.common.util.validator.annotations.ValidateSize;
import sy.common.util.validator.pattern.CommonJavaPattern;
import sy.common.util.valuesetter.Create;
import sy.common.util.valuesetter.Update;
import sy.domain.vo.shared.BaseVo;

/**
 *
 * @author lidongbo
 *
 */
public class BasicResourceVo  extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8412077891547198324L;

	private String resId;
	
	@ValidateNotEmpty(description="资源名称")
	@ValidateSize(description="资源名称",max=50)
	private String resName;
	
	@ValidateSize(description="资源地址",max=200)
	private String resUrl;
	
	@ValidateNotNull(description="资源分类")
	private BasicDictItemVo resType;
	
	private Integer state;
	
	@Create
	private String createdBy;
	
	@Create
	private Date created;
	
	@Update
	private String updatedBy;
	
	@Update
	private Date updated;
	
	private BasicResourceVo parentRes;
	
	private String subCode;
	
	private Integer levelCode;
	
	@ValidateNotEmpty(description="序号")
	@ValidatePattern(
			description="序号",
			regexpName="正整数",
			flags=ValidatePattern.Flag.CASE_INSENSITIVE,
			regexp=CommonJavaPattern.POSITIVE_INTEGER)
	@ValidateSize(description="序号",max=5)
	private String sort;
	
	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
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
	
	public BasicDictItemVo getResType() {
		return resType;
	}

	public void setResType(BasicDictItemVo resType) {
		this.resType = resType;
	}

	public BasicResourceVo getParentRes() {
		return parentRes;
	}

	public void setParentRes(BasicResourceVo parentRes) {
		this.parentRes = parentRes;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public Integer getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(Integer levelCode) {
		this.levelCode = levelCode;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
}
