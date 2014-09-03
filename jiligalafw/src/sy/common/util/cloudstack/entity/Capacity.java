package sy.common.util.cloudstack.entity;


/**
 *
 * @author luobin
 *
 */
public class Capacity extends CloudBeanSupport  {

	private String type;
	private String zoneid;
	private String zonename;
	private String capacityused;
	private String capacitytotal;
	private String percentused;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public String getZonename() {
		return zonename;
	}
	public void setZonename(String zonename) {
		this.zonename = zonename;
	}
	public String getCapacityused() {
		return capacityused;
	}
	public void setCapacityused(String capacityused) {
		this.capacityused = capacityused;
	}
	public String getCapacitytotal() {
		return capacitytotal;
	}
	public void setCapacitytotal(String capacitytotal) {
		this.capacitytotal = capacitytotal;
	}
	public String getPercentused() {
		return percentused;
	}
	public void setPercentused(String percentused) {
		this.percentused = percentused;
	}
	
	
}
