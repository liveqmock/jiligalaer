package sy.domain.vo.base;

import java.util.Date;

import sy.common.util.validator.annotations.ValidateNotEmpty;
import sy.common.util.validator.annotations.ValidateSize;
import sy.common.util.valuesetter.Create;
import sy.common.util.valuesetter.Update;
import sy.domain.vo.shared.BaseVo;


public class BasicDictItemVo extends BaseVo{
	
	private static final long serialVersionUID = 3452342343234232L;

	private String dictItemId;
	
	@ValidateNotEmpty(description="字典明细名称")
	@ValidateSize(description="字典明细名称",max=50)
	private String itemCode;
	
	private String extCode;
	
	private String subCode;
	
	private String levelCode;
	
	private String itemName;
	
	private String itemAlias;
	
	private String memo1;
	
	private String memo2;
	
	private String memo3;
	
	private String memo4;
	
	private String memo5;
	
	private String memo6;
	
	private String remark;
	
	private Integer state;
	
	private Integer sort;
	
	private String PI1;
	
	private String PI2;
	
	private String PI3;
	
	private String PI4;
	
	private String PI5;
	
	private String PI6;
	
	private String PI7;
	
	private String PN1;
	
	private String PN2;
	
	private String PN3;
	
	private String PN4;
	
	private String PN5;
	
	private String PN6;
	
	private String PN7;
	
	private String PNAll;
	
	@Create
	private String createdBy;
	
	@Create
	private Date created;
	
	@Update
	private String updatedBy;
	
	@Update
	private Date updated;
	
	private BasicDictVo basicDict;
	
	private BasicDictItemVo basicDictItem;
	

	public String getDictItemId() {
		return dictItemId;
	}

	public void setDictItemId(String dictItemId) {
		this.dictItemId = dictItemId;
	}
	

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	

	public String getExtCode() {
		return extCode;
	}

	public void setExtCode(String extCode) {
		this.extCode = extCode;
	}
	

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	
	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemAlias() {
		return itemAlias;
	}

	public void setItemAlias(String itemAlias) {
		this.itemAlias = itemAlias;
	}

	public String getMemo1() {
		return memo1;
	}

	
	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	public String getMemo2() {
		return memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	public String getMemo3() {
		return memo3;
	}

	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}

	public String getMemo4() {
		return memo4;
	}

	public void setMemo4(String memo4) {
		this.memo4 = memo4;
	}

	public String getMemo5() {
		return memo5;
	}

	public void setMemo5(String memo5) {
		this.memo5 = memo5;
	}

	public String getMemo6() {
		return memo6;
	}

	public void setMemo6(String memo6) {
		this.memo6 = memo6;
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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getPI1() {
		return PI1;
	}

	public void setPI1(String pI1) {
		PI1 = pI1;
	}

	public String getPI2() {
		return PI2;
	}

	public void setPI2(String pI2) {
		PI2 = pI2;
	}

	public String getPI3() {
		return PI3;
	}

	public void setPI3(String pI3) {
		PI3 = pI3;
	}

	public String getPI4() {
		return PI4;
	}

	public void setPI4(String pI4) {
		PI4 = pI4;
	}

	public String getPI5() {
		return PI5;
	}

	public void setPI5(String pI5) {
		PI5 = pI5;
	}

	public String getPI6() {
		return PI6;
	}

	public void setPI6(String pI6) {
		PI6 = pI6;
	}

	public String getPI7() {
		return PI7;
	}

	public void setPI7(String pI7) {
		PI7 = pI7;
	}

	public String getPN1() {
		return PN1;
	}

	public void setPN1(String pN1) {
		PN1 = pN1;
	}

	public String getPN2() {
		return PN2;
	}

	public void setPN2(String pN2) {
		PN2 = pN2;
	}

	public String getPN3() {
		return PN3;
	}

	public void setPN3(String pN3) {
		PN3 = pN3;
	}

	public String getPN4() {
		return PN4;
	}

	public void setPN4(String pN4) {
		PN4 = pN4;
	}

	public String getPN5() {
		return PN5;
	}

	public void setPN5(String pN5) {
		PN5 = pN5;
	}

	public String getPN6() {
		return PN6;
	}

	public void setPN6(String pN6) {
		PN6 = pN6;
	}

	public String getPN7() {
		return PN7;
	}

	public void setPN7(String pN7) {
		PN7 = pN7;
	}

	public String getPNAll() {
		return PNAll;
	}

	public void setPNAll(String pNAll) {
		PNAll = pNAll;
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
	
	public BasicDictVo getBasicDict() {
		return basicDict;
	}

	public void setBasicDict(BasicDictVo basicDict) {
		this.basicDict = basicDict;
	}

	public BasicDictItemVo getBasicDictItem() {
		return basicDictItem;
	}

	public void setBasicDictItem(BasicDictItemVo basicDictItem) {
		this.basicDictItem = basicDictItem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
