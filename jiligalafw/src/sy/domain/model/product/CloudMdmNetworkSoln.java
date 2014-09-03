package sy.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * 网络方案(带宽)
 * @author CS
 *
 */
@Entity
@Table(name = "CLOUD_MDM_NETWORK_SOLN")
public class CloudMdmNetworkSoln extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624974548758545616L;

	/**
	 * 带宽名称.
	 */
	private String name;
	/**
	 * 显示的数据中心信息.
	 */
	private String displayText;

	/**
	 * 网络带宽.
	 */
	private String  networkRate;

	
	private String traffictype;
	private String isdefault;
	private String specifyvlan;
	private String conservemode;
	private String specifyipranges;
	private String availability;
	private String state;
	private String guestiptype;
	private String serviceofferingid; //the ID of the service offering used by virtual router provider
	private String forvpc;
	
	private String zoneid;
	
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

	@Column(name="NETWORKRATE")
	public String getNetworkRate() {
		return networkRate;
	}

	public void setNetworkRate(String networkRate) {
		this.networkRate = networkRate;
	}

	@Column
	public String getTraffictype() {
		return traffictype;
	}

	public void setTraffictype(String traffictype) {
		this.traffictype = traffictype;
	}

	@Column
	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	@Column
	public String getSpecifyvlan() {
		return specifyvlan;
	}

	public void setSpecifyvlan(String specifyvlan) {
		this.specifyvlan = specifyvlan;
	}

	@Column
	public String getConservemode() {
		return conservemode;
	}

	public void setConservemode(String conservemode) {
		this.conservemode = conservemode;
	}

	@Column
	public String getSpecifyipranges() {
		return specifyipranges;
	}

	public void setSpecifyipranges(String specifyipranges) {
		this.specifyipranges = specifyipranges;
	}

	@Column
	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Column
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column
	public String getGuestiptype() {
		return guestiptype;
	}

	public void setGuestiptype(String guestiptype) {
		this.guestiptype = guestiptype;
	}

	@Column
	public String getServiceofferingid() {
		return serviceofferingid;
	}

	public void setServiceofferingid(String serviceofferingid) {
		this.serviceofferingid = serviceofferingid;
	}

	@Column
	public String getForvpc() {
		return forvpc;
	}

	public void setForvpc(String forvpc) {
		this.forvpc = forvpc;
	}

	@Column
	public String getZoneid() {
		return zoneid;
	}

	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	
	
}
