package sy.domain.vo.product;

import java.util.Date;

import sy.common.util.Constants;
import sy.common.util.valuesetter.Create;
import sy.domain.vo.shared.BaseVo;

/**
 * 产品管理-产品子表VO
 * 
 * @author luobin
 * 
 */
public class CloudMdmProductItemVo extends BaseVo {

	private static final long serialVersionUID = 6615363709143182939L;

	private String id;
	/**
	 * 产品主表
	 */
	private CloudMdmProductVo mdmProduct;
	/**
	 * 产品子表ID
	 */
	private String itemId;
	/**
	 * 产品类型
	 */
	private String itemType;
	/**
	 * 产品 - 数据中心
	 */
	private CloudMdmZoneVo mdmZone;
	/**
	 * 产品 - 计算方案
	 */
	private CloudMdmCPUSolnVo mdmCpuSoln;
	/**
	 * 产品 - 磁盘方案
	 */
	private CloudMdmDiskSolnVo mdmDiskSoln;
	/**
	 * 产品 - 模板方案
	 */
	private CloudMdmTemplateVo mdmTemplate;
	/***
	 * 产品 - 网络方案
	 */
	private CloudMdmNetworkSolnVo mdmNetworkSoln;
	/***
	 * 产品 - IP
	 */
	private CloudMdmIPVo mdmIp;
	
	@Create
	private Date created;
	
	private Integer state;

	private String itemTypeName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CloudMdmProductVo getMdmProduct() {
		return mdmProduct;
	}

	public void setMdmProduct(CloudMdmProductVo mdmProduct) {
		this.mdmProduct = mdmProduct;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public CloudMdmZoneVo getMdmZone() {
		return mdmZone;
	}

	public void setMdmZone(CloudMdmZoneVo mdmZone) {
		this.mdmZone = mdmZone;
	}

	public CloudMdmCPUSolnVo getMdmCpuSoln() {
		return mdmCpuSoln;
	}

	public void setMdmCpuSoln(CloudMdmCPUSolnVo mdmCpuSoln) {
		this.mdmCpuSoln = mdmCpuSoln;
	}

	public CloudMdmDiskSolnVo getMdmDiskSoln() {
		return mdmDiskSoln;
	}

	public void setMdmDiskSoln(CloudMdmDiskSolnVo mdmDiskSoln) {
		this.mdmDiskSoln = mdmDiskSoln;
	}

	public CloudMdmTemplateVo getMdmTemplate() {
		return mdmTemplate;
	}

	public void setMdmTemplate(CloudMdmTemplateVo mdmTemplate) {
		this.mdmTemplate = mdmTemplate;
	}

	public CloudMdmNetworkSolnVo getMdmNetworkSoln() {
		return mdmNetworkSoln;
	}

	public void setMdmNetworkSoln(CloudMdmNetworkSolnVo mdmNetworkSoln) {
		this.mdmNetworkSoln = mdmNetworkSoln;
	}

	public CloudMdmIPVo getMdmIp() {
		return mdmIp;
	}

	public void setMdmIp(CloudMdmIPVo mdmIp) {
		this.mdmIp = mdmIp;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getItemTypeName() {
		if(Constants.PROD_TYPE_CPU_SOLN.equals(itemType)){
			itemTypeName = "计算方案";
		}else if(Constants.PROD_TYPE_DISK_SOLN.equals(itemType)){
			itemTypeName = "磁盘方案";
		}else if(Constants.PROD_TYPE_NETWORK_SOLN.equals(itemType)){
			itemTypeName = "网络方案";
		}else if(Constants.PROD_TYPE_TEMPLATE.equals(itemType)){
			itemTypeName = "模板";
		}else if(Constants.PROD_TYPE_IP.equals(itemType)){
			itemTypeName = "IP";
		}else if(Constants.PROD_TYPE_COMP_PROD.equals(itemType)){
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
