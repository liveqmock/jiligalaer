package sy.domain.model.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sy.domain.model.shared.PersistentObject;

/**
 * 
 * @author lidongbo
 * 
 */
@Entity
@Table(name = "CLOUD_VM_SECURITYGROUP")
public class CloudVMSecuritygroup implements PersistentObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1590930336591346276L;

	private String id;
	
	private String virtualmachineid;

	private String securitygroupid;

	/**
	 * 同步时间
	 */
	private Date syncTime;

	/**
	 * 状态
	 */
	private Integer dataState;
	
	@Id
	@Column(name = "ID", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column
	public String getVirtualmachineid() {
		return virtualmachineid;
	}

	public void setVirtualmachineid(String virtualmachineid) {
		this.virtualmachineid = virtualmachineid;
	}

	@Column
	public String getSecuritygroupid() {
		return securitygroupid;
	}

	public void setSecuritygroupid(String securitygroupid) {
		this.securitygroupid = securitygroupid;
	}
	
	@Column(name = "SYNC_TIME")
	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	@Column(name = "DATA_STATE")
	public Integer getDataState() {
		return dataState;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}
}
