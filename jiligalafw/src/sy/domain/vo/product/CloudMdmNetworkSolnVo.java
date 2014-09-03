package sy.domain.vo.product;

import sy.common.util.cloudstack.entity.Networkoffering;

/**
 * 网络方案(带宽).
 * 
 * @author CS
 * 
 */
public class CloudMdmNetworkSolnVo extends CloudDataSyncBuilder<Networkoffering> {

	private static final long serialVersionUID = 6615366709143182939L;

	/**
	 * 带宽名称.
	 */
	private String name;
	/**
	 * 显示的数据中心信息
	 */
	private String displayText;
	/**
	 * 网络带宽.
	 */
	private String  networkRate;
	/**
	 * 选择状态标志
	 */
    private String selectFlag;

    
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
    
	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	
	public String getNetworkRate() {
		return networkRate;
	}

	public void setNetworkRate(String networkRate) {
		this.networkRate = networkRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String selectFlag) {
		this.selectFlag = selectFlag;
	}

	public String getTraffictype() {
		return traffictype;
	}

	public void setTraffictype(String traffictype) {
		this.traffictype = traffictype;
	}

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	public String getSpecifyvlan() {
		return specifyvlan;
	}

	public void setSpecifyvlan(String specifyvlan) {
		this.specifyvlan = specifyvlan;
	}

	public String getConservemode() {
		return conservemode;
	}

	public void setConservemode(String conservemode) {
		this.conservemode = conservemode;
	}

	public String getSpecifyipranges() {
		return specifyipranges;
	}

	public void setSpecifyipranges(String specifyipranges) {
		this.specifyipranges = specifyipranges;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGuestiptype() {
		return guestiptype;
	}

	public void setGuestiptype(String guestiptype) {
		this.guestiptype = guestiptype;
	}

	public String getServiceofferingid() {
		return serviceofferingid;
	}

	public void setServiceofferingid(String serviceofferingid) {
		this.serviceofferingid = serviceofferingid;
	}

	public String getForvpc() {
		return forvpc;
	}

	public void setForvpc(String forvpc) {
		this.forvpc = forvpc;
	}

	public String getZoneid() {
		return zoneid;
	}

	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	
}
