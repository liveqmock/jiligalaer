package sy.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * 磁盘方案表.
 * @author CS
 *
 */
@Entity
@Table(name = "CLOUD_MDM_DISK_SOLN")
public class CloudMdmDiskSoln extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624974548758505716L;

	/**
	 * 磁盘大小.
	 */
	private String diskSize;
	/**
	 * 磁盘名称.
	 */
	private String name;
	/**
	 * 显示的数据中心信息.
	 */
	private String displayText;
	
	private String iscustomized;
	
	private String storagetype;
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="DISPLAYTEXT")
	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	
	@Column(name="DISKSIZE")
	public String getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(String diskSize) {
		this.diskSize = diskSize;
	}

	@Column(name="ISCUSTOMIZED")
	public String getIscustomized() {
		return iscustomized;
	}

	public void setIscustomized(String iscustomized) {
		this.iscustomized = iscustomized;
	}

	@Column(name="STORAGETYPE")
	public String getStoragetype() {
		return storagetype;
	}

	public void setStoragetype(String storagetype) {
		this.storagetype = storagetype;
	}

}
