package sy.domain.vo.product;

import java.util.Date;

import sy.common.util.Constants;
import sy.domain.vo.shared.BaseVo;

/**
 * 产品价格VO
 * 
 * @author luobin
 * 
 */
public class ProductPriceVo extends BaseVo {

	private static final long serialVersionUID = 6615363709143182939L;

	/**
	 * 价格ID
	 */
	private String priceId;
	
	/**
	 * 产品ID
	 */
	private String prodId;
	/**
	 * 产品名称
	 */
	private String prodName;
	/**
	 * 产品描述
	 */
	private String description;
	/**
	 * 产品子表ID
	 */
	private String prodItemId;
	/**
	 * 一次性收费
	 */
	private Double oneTimePrice;
	/**
	 * 年收费
	 */
	private Double yearPrice;
	/**
	 * 月收费
	 */
	private Double monthPrice;
	/**
	 * 天收费
	 */
	private Double dayPrice;
	/**
	 * 小时收费
	 */
	private Double hourPrice;
	
	/**
	 * 定价方式 （一次性、周期性）
	 */
	private String priceMode;
	/**
	 * 生效日期
	 */
	private Date effectiveDate;
	/**
	 * 失效日期
	 */
	private Date invalidDate;
	
	private String iscustomized;
	
	private String prodType;
	
	private String itemTypeName;
	
	public String getPriceId() {
		return priceId;
	}
	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdItemId() {
		return prodItemId;
	}
	public void setProdItemId(String prodItemId) {
		this.prodItemId = prodItemId;
	}
	public Double getOneTimePrice() {
		return oneTimePrice;
	}
	public void setOneTimePrice(Double oneTimePrice) {
		this.oneTimePrice = oneTimePrice;
	}
	public Double getYearPrice() {
		return yearPrice;
	}
	public void setYearPrice(Double yearPrice) {
		this.yearPrice = yearPrice;
	}
	public Double getMonthPrice() {
		return monthPrice;
	}
	public void setMonthPrice(Double monthPrice) {
		this.monthPrice = monthPrice;
	}
	public Double getDayPrice() {
		return dayPrice;
	}
	public void setDayPrice(Double dayPrice) {
		this.dayPrice = dayPrice;
	}
	public Double getHourPrice() {
		return hourPrice;
	}
	public void setHourPrice(Double hourPrice) {
		this.hourPrice = hourPrice;
	}
	public String getPriceMode() {
		return priceMode;
	}
	public void setPriceMode(String priceMode) {
		this.priceMode = priceMode;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getInvalidDate() {
		return invalidDate;
	}
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	public String getIscustomized() {
		return iscustomized;
	}
	public void setIscustomized(String iscustomized) {
		this.iscustomized = iscustomized;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	
	public String getItemTypeName() {
		if(Constants.PROD_TYPE_CPU_SOLN.equals(prodType)){
			itemTypeName = "计算方案";
		}else if(Constants.PROD_TYPE_DISK_SOLN.equals(prodType)){
			itemTypeName = "磁盘方案";
		}else if(Constants.PROD_TYPE_NETWORK_SOLN.equals(prodType)){
			itemTypeName = "网络方案";
		}else if(Constants.PROD_TYPE_TEMPLATE.equals(prodType)){
			itemTypeName = "模板";
		}else if(Constants.PROD_TYPE_IP.equals(prodType)){
			itemTypeName = "IP";
		}else if(Constants.PROD_TYPE_COMP_PROD.equals(prodType)){
			itemTypeName = "组合产品";
		}else{
			itemTypeName = "";
		}
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
}
