package sy.domain.vo.product;

import sy.domain.vo.shared.BaseVo;

public class CloudProductCombinationPriceVo extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2643130688351913881L;
	
	private String id;
	 /**
     * 组合产品主表
     */
	 private CloudMdmProductVo cloudMdmProduct;
	 
	 /**
	  * 单一元素ID
	  */
	 private String cellId;
	 
	 /**
	  * 单一元素类型
	  */
	 private String cellType;
	 
	 /**
	  * 单一产品ID
	  */
	 private String singleProdId;
	 /**
	  * 单一产品价格
	  */
	 private String priceId;
	public CloudMdmProductVo getCloudMdmProduct() {
		return cloudMdmProduct;
	}
	public void setCloudMdmProduct(CloudMdmProductVo cloudMdmProduct) {
		this.cloudMdmProduct = cloudMdmProduct;
	}
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	public String getCellType() {
		return cellType;
	}
	public void setCellType(String cellType) {
		this.cellType = cellType;
	}
	public String getSingleProdId() {
		return singleProdId;
	}
	public void setSingleProdId(String singleProdId) {
		this.singleProdId = singleProdId;
	}
	public String getPriceId() {
		return priceId;
	}
	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	 
}
