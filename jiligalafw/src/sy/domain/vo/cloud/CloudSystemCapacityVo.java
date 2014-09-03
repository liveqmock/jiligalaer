package sy.domain.vo.cloud;

import sy.common.util.cloudstack.entity.Capacity;
import sy.domain.vo.product.CloudDataSyncBuilder;
import sy.domain.vo.product.CloudMdmZoneVo;

/**
 * 
 * @author luobin
 * 
 */
public class CloudSystemCapacityVo extends CloudDataSyncBuilder<Capacity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3842945730284077318L;
	private String type;
	private String zoneid;
	private String zonename;
	private String capacityused;
	private String capacitytotal;
	private String percentused;
	
	private CloudMdmZoneVo cloudMdmZone;
	
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
	public CloudMdmZoneVo getCloudMdmZone() {
		return cloudMdmZone;
	}
	public void setCloudMdmZone(CloudMdmZoneVo cloudMdmZone) {
		this.cloudMdmZone = cloudMdmZone;
	}

	
}
