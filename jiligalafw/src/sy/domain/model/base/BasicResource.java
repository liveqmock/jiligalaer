package sy.domain.model.base;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import sy.common.util.valuesetter.Hierarchy;
import sy.domain.model.shared.PersistentObject;
import sy.service.shared.Hierarchical;

/**
 *
 * @author lidongbo
 *
 */
@Entity
@Table(name = "BASIC_RESOURCE")
public class BasicResource  implements PersistentObject,Hierarchical<BasicResource> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7526279707991792155L;

	private String resId;
	
	private String resName;
	
	private String resUrl;
	
	private BasicDictItem resType;
	
	private Integer state;
	
	private Integer sort;
	
	private String createdBy;
	
	private Date created;
	
	private String updatedBy;
	
	private Date updated;

//	@Parent
	private BasicResource parentRes;
	
	@Hierarchy
	private String subCode;
	
//	@HierarchyLevel
	private Integer levelCode;
	
//	@Children
	private Set<BasicResource> children = new HashSet<BasicResource>();
	
	@Id
	@Column(name = "RES_ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid", parameters = {
			@Parameter(name = "unsaved-value", value = "null")
	})
	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	@Column(name="RES_NAME")
	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	@Column(name="RES_URL")
	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
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

	@ManyToOne
	@JoinColumn(name = "RES_TYPE")
	public BasicDictItem getResType() {
		return resType;
	}

	public void setResType(BasicDictItem resType) {
		this.resType = resType;
	}

	@ManyToOne
	@JoinColumn(name = "PARENT_RES_ID")
	public BasicResource getParentRes() {
		return parentRes;
	}

	public void setParentRes(BasicResource parentRes) {
		this.parentRes = parentRes;
	}

	@Column(name="SUB_CODE")
	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	@Column(name="LEVEL_CODE")
	public Integer getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(Integer levelCode) {
		this.levelCode = levelCode;
	}

	@Override
	@OneToMany
	@JoinColumn(name = "PARENT_RES_ID")
	public Set<BasicResource> getChildren() {
		return children;
	}

	@Override
	@Transient
	public String getHierarchyCode() {
		return this.subCode;
	}

	@Override
	public void setHierarchyCode(String code) {
		this.subCode = code;
	}

	@Override
	@Transient
	public Integer getHierarchyLevel() {
		return this.levelCode;
	}

	@Override
	public void setHierarchyLevel(Integer code) {
		this.levelCode = code;
	}

	@Override
	@Transient
	public BasicResource getParent() {
		return parentRes;
	}

	public void setChildren(Set<BasicResource> children) {
		this.children = children;
	}

	@Column(name="SORT")
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
