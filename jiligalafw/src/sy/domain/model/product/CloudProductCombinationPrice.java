package sy.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.shared.PersistentObject;

/**
 * 
 * @author CS
 * 组合产品中单一产品
 *
 */
@Entity
@Table(name = "CLOUD_PRODUCT_COMBINATION_PRICE")
public class CloudProductCombinationPrice implements PersistentObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3624955548758505616L;
	
	private String id;
    /**
     * 组合产品主表
     */
	 private CloudMdmProduct cloudMdmProduct;
	 
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
	 
	 
	@Id
	@Column(name="ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@ManyToOne()  
    @JoinColumn(name = "PROD_ID") 
	public CloudMdmProduct getCloudMdmProduct() {
		return cloudMdmProduct;
	}
	public void setCloudMdmProduct(CloudMdmProduct cloudMdmProduct) {
		this.cloudMdmProduct = cloudMdmProduct;
	}
	
	@Column(name="CELL_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	
	@Column(name="CELL_TYPE")
	public String getCellType() {
		return cellType;
	}
	public void setCellType(String cellType) {
		this.cellType = cellType;
	}
	@Column(name="SINGLE_PROD_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getSingleProdId() {
		return singleProdId;
	}
	public void setSingleProdId(String singleProdId) {
		this.singleProdId = singleProdId;
	}
	@Column(name="PRICE_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getPriceId() {
		return priceId;
	}
	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	 
}
