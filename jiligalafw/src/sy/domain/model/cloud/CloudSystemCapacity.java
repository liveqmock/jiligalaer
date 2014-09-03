package sy.domain.model.cloud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * 
 * @author luobin
 * 
 */
@Entity
@Table(name = "CLOUD_SYSTEM_CAPACITY")
public class CloudSystemCapacity extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7245367163824937505L;

	
	private String type;
	private String zoneid;
	private String zonename;
	private String capacityused;
	private String capacitytotal;
	private String percentused;
	
	@Column(name = "type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "zoneid")
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	
	@Column(name = "zonename")
	public String getZonename() {
		return zonename;
	}
	public void setZonename(String zonename) {
		this.zonename = zonename;
	}
	
	@Column(name = "capacityused")
	public String getCapacityused() {
		return capacityused;
	}
	public void setCapacityused(String capacityused) {
		this.capacityused = capacityused;
	}
	
	@Column(name = "capacitytotal")
	public String getCapacitytotal() {
		return capacitytotal;
	}
	public void setCapacitytotal(String capacitytotal) {
		this.capacitytotal = capacitytotal;
	}
	
	@Column(name = "percentused")
	public String getPercentused() {
		return percentused;
	}
	public void setPercentused(String percentused) {
		this.percentused = percentused;
	}

	
}
