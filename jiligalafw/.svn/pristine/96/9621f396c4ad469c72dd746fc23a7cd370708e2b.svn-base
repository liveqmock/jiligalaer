package sy.domain.model.product;

import java.util.Date;

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
 * 产品管理-产品子表VO
 * @author luobin
 *
 */
@Entity
@Table(name = "CLOUD_MDM_PRODUCT_ITEM")
public class CloudMdmProductItem implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624971544758545616L;

	private String id;
	/**
	 * 产品主表
	 */
	private CloudMdmProduct mdmProduct;
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
	private CloudMdmZone mdmZone;
	/**
	 * 产品 - 计算方案
	 */
	private CloudMdmCPUSoln mdmCpuSoln;
	/**
	 * 产品 - 磁盘方案
	 */
	private CloudMdmDiskSoln mdmDiskSoln;
	/**
	 * 产品 - 模板方案
	 */
	private CloudMdmTemplate mdmTemplate;
	/***
	 * 产品 - 网络方案
	 */
	private CloudMdmNetworkSoln mdmNetworkSoln;
	/***
	 * 产品 - IP
	 */
	private CloudMdmIP mdmIp;
	
	private Date created;
	
	private Integer state;

	
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
	public CloudMdmProduct getMdmProduct() {
		return mdmProduct;
	}

	public void setMdmProduct(CloudMdmProduct mdmProduct) {
		this.mdmProduct = mdmProduct;
	}

	

	@Column(name="ITEM_ID",length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getItemId() {
		return itemId;
	}
	
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Column(name="ITEM_TYPE")
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@ManyToOne()  
    @JoinColumn(name = "ZONE_ID") 
	public CloudMdmZone getMdmZone() {
		return mdmZone;
	}

	public void setMdmZone(CloudMdmZone mdmZone) {
		this.mdmZone = mdmZone;
	}

	@ManyToOne()  
    @JoinColumn(name = "CPU_SOLN_ID") 
	public CloudMdmCPUSoln getMdmCpuSoln() {
		return mdmCpuSoln;
	}

	public void setMdmCpuSoln(CloudMdmCPUSoln mdmCpuSoln) {
		this.mdmCpuSoln = mdmCpuSoln;
	}

	@ManyToOne()  
    @JoinColumn(name = "DISK_SOLN_ID") 
	public CloudMdmDiskSoln getMdmDiskSoln() {
		return mdmDiskSoln;
	}

	public void setMdmDiskSoln(CloudMdmDiskSoln mdmDiskSoln) {
		this.mdmDiskSoln = mdmDiskSoln;
	}

	@ManyToOne()  
    @JoinColumn(name = "TEMPLATE_ID") 
	public CloudMdmTemplate getMdmTemplate() {
		return mdmTemplate;
	}

	public void setMdmTemplate(CloudMdmTemplate mdmTemplate) {
		this.mdmTemplate = mdmTemplate;
	}

	@ManyToOne()  
    @JoinColumn(name = "NETWORK_SOLN_ID") 
	public CloudMdmNetworkSoln getMdmNetworkSoln() {
		return mdmNetworkSoln;
	}

	public void setMdmNetworkSoln(CloudMdmNetworkSoln mdmNetworkSoln) {
		this.mdmNetworkSoln = mdmNetworkSoln;
	}

	@ManyToOne()  
    @JoinColumn(name = "IP_ID") 
	public CloudMdmIP getMdmIp() {
		return mdmIp;
	}

	public void setMdmIp(CloudMdmIP mdmIp) {
		this.mdmIp = mdmIp;
	}
	
	@Column(name="CREATED")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	@Column(name="STATE")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}
