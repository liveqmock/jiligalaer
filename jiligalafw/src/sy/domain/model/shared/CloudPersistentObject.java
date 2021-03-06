package sy.domain.model.shared;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author lidongbo
 * 
 */
@MappedSuperclass
public abstract class CloudPersistentObject implements PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7693012137294463893L;
	private String id;
	/**
	 * 接口ID
	 */
	private String interfaceId;

	/**
	 * 同步时间
	 */
	private Date syncTime;

	/**
	 * 状态
	 */
	private Integer dataState;
	
	private Date syncCreatedTime;

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

	@Column(name = "IF_ID")
	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
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
	
	@Column(name = "SYNC_CREATED_TIME")
	public Date getSyncCreatedTime() {
		return syncCreatedTime;
	}

	public void setSyncCreatedTime(Date syncCreatedTime) {
		this.syncCreatedTime = syncCreatedTime;
	}
	
	
}
