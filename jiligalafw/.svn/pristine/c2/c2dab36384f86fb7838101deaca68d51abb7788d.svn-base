package sy.domain.vo.base;

import sy.common.util.validator.annotations.ValidateNotEmpty;
import sy.common.util.validator.annotations.ValidateSize;
import sy.domain.vo.shared.BaseVo;


public class BasicDictVo extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6055034876649161162L;
	/**
	 * 字典ID
	 */
	 private String dictId;
	 /**
	  * 字典名称
	  */
	 @ValidateNotEmpty(description="字典名称")
	 @ValidateSize(description="字典名称",max=50)
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
	 @ValidateSize(description="备注",max=500)
	 private String remark;
	 
	 
	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	 
}
