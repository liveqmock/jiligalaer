package sy.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * 数据中心表
 * 
 * @author CS
 * 
 */
@Entity
@Table(name = "CLOUD_MDM_ZONE")
public class CloudMdmZone extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624974544758545616L;

	/**
	 * 显示的数据中心信息
	 */
	private String displayText;
	/**
	 * 简述.
	 */
	private String description;
	/**
	 * 网络带宽类型.
	 */
	private String networkType;

	private String name;

	@Column(name = "DISPLAYTEXT")
	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "NETWORK_TYPE")
	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
