package sy.domain.model.base;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import sy.domain.model.shared.PersistentObject;

@Entity
@Table(name = "BASIC_DICT")
public class BasicDict implements PersistentObject {

	private static final long serialVersionUID = 345232L;

	/**
	 * 字典ID
	 */
	private String dictId;
	/**
	 * 字典名称
	 */
	private String dictName;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 备注
	 */
	private String remark;

	private Set<BasicDictItem> baseDictItems = new HashSet<BasicDictItem>(0);
	
	@Id
	@Column(name = "DICT_ID", length = 50)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	@Column(name = "DICT_NAME")
	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	@Column(name = "STATE")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "SORT")
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@OneToMany
	@JoinColumn(name = "DICT_ID")
	@LazyCollection(LazyCollectionOption.TRUE)
	public Set<BasicDictItem> getBaseDictItems() {
		return baseDictItems;
	}

	public void setBaseDictItems(Set<BasicDictItem> baseDictItems) {
		this.baseDictItems = baseDictItems;
	}

	
}
