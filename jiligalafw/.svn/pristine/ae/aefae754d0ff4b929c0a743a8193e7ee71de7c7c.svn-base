package sy.domain.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.en.base.DataAuth;
import sy.domain.model.shared.PersistentObject;

/**
 *
 * @author lidongbo
 *
 */
@Entity
@Table(name = "BASIC_ROLE")
public class BasicRole implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624971534758545616L;

	private String roleId;
	
	private String roleName;
	
	private String description;
	
	private String remark;
	
	private Integer priority;
	
	private Integer state;
	
	private DataAuth dataAuth;
	
	private String createdBy;
	
	private Date created;
	
	private String updatedBy;
	
	private Date updated;
	/**
	 * 针对角色表增加标识来区分是账户角色还是用户角色，其中1表示账户2表示用户.
	 */
	private String roleFlag;

	@Id
	@Column(name="ROLE_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name="ROLE_NAME")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Column(name = "DATA_AUTH")
	@Enumerated(value = EnumType.STRING)
	public DataAuth getDataAuth() {
		return dataAuth;
	}

	public void setDataAuth(DataAuth dataAuth) {
		this.dataAuth = dataAuth;
	}

	@Column(name="ROLE_FLAG")
	public String getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(String roleFlag) {
		this.roleFlag = roleFlag;
	}

	
}
