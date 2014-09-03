package sy.domain.vo.base;

import java.util.Date;

import sy.common.util.validator.annotations.ValidateNotEmpty;
import sy.common.util.validator.annotations.ValidatePattern;
import sy.common.util.validator.annotations.ValidateSize;
import sy.common.util.validator.pattern.CommonJavaPattern;
import sy.common.util.valuesetter.Create;
import sy.common.util.valuesetter.Update;
import sy.domain.en.base.DataAuth;
import sy.domain.vo.shared.BaseVo;

/**
 *
 * @author lidongbo
 *
 */
public class BasicRoleVo  extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643130688211913881L;

	private String roleId;
	
	@ValidateNotEmpty(description="角色名称")
	@ValidateSize(description="角色名称",max=10)
	private String roleName;
	
	@ValidateSize(description="角色描述",max=50)
	private String description;
	
	private String remark;
	
	@ValidateNotEmpty(description="优先级")
	@ValidatePattern(
			description="优先级",
			regexpName="正整数",
			flags=ValidatePattern.Flag.CASE_INSENSITIVE,
			regexp=CommonJavaPattern.POSITIVE_INTEGER)
	@ValidateSize(description="优先级",max=5)
	private String priority;
	
	@ValidateNotEmpty(description="数据权限")
	private String dataAuth;
	
	private Integer state;
	
	@ValidateNotEmpty(description="适用对象")
	@ValidateSize(description="适用对象",max=2)
	private String roleFlag;
	
	@Create
	private String createdBy;
	
	@Create
	private Date created;
	
	@Update
	private String updatedBy;
	
	@Update
	private Date updated;
	
	private String resIds;
	
	private String isUsed;
	

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDataAuth() {
		return dataAuth;
	}

	public void setDataAuth(String dataAuth) {
		this.dataAuth = dataAuth;
	}
	
	public String getDataAuthDisplayName() {
		DataAuth auth = DataAuth.valueOf(dataAuth);
		if(auth == null){
			return dataAuth;
		}else{
			return auth.getName();
		}
	}

	public String getResIds() {
		return resIds;
	}

	public void setResIds(String resIds) {
		this.resIds = resIds;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public String getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(String roleFlag) {
		this.roleFlag = roleFlag;
	}

	
	
}
