package sy.domain.vo.product;

import sy.common.util.cloudstack.entity.Network;

/**
 * 
 * @author lidongbo
 * 
 */
public class CloudMdmNetworkVo extends CloudDataSyncBuilder<Network> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2452923951970278713L;
	private String name;
	private String displaytext;
	private String traffictype;
	private String gateway;
	private String netmask;
	private String cidr;
	private String zoneid;
	private String networkofferingid;
	private String issystem;
	private String state;
	private String related;
	private String broadcasturi;
	private String dns1;
	private String type;
	private String vlan;
	private String acltype;
	private String physicalnetworkid;
	private String restartrequired;
	private String specifyipranges;
	private String canusefordeploy;

	private String broadcastdomaintype;
	private String zonename;
	private String networkofferingname;
	private String networkofferingdisplaytext;
	private String networkofferingavailability;
	private String account;
	private String domainid;
	private String domain;
	private String networkdomain;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplaytext() {
		return displaytext;
	}

	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}

	public String getTraffictype() {
		return traffictype;
	}

	public void setTraffictype(String traffictype) {
		this.traffictype = traffictype;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	public String getCidr() {
		return cidr;
	}

	public void setCidr(String cidr) {
		this.cidr = cidr;
	}

	public String getZoneid() {
		return zoneid;
	}

	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

	public String getNetworkofferingid() {
		return networkofferingid;
	}

	public void setNetworkofferingid(String networkofferingid) {
		this.networkofferingid = networkofferingid;
	}

	public String getIssystem() {
		return issystem;
	}

	public void setIssystem(String issystem) {
		this.issystem = issystem;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRelated() {
		return related;
	}

	public void setRelated(String related) {
		this.related = related;
	}

	public String getBroadcasturi() {
		return broadcasturi;
	}

	public void setBroadcasturi(String broadcasturi) {
		this.broadcasturi = broadcasturi;
	}

	public String getDns1() {
		return dns1;
	}

	public void setDns1(String dns1) {
		this.dns1 = dns1;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVlan() {
		return vlan;
	}

	public void setVlan(String vlan) {
		this.vlan = vlan;
	}

	public String getAcltype() {
		return acltype;
	}

	public void setAcltype(String acltype) {
		this.acltype = acltype;
	}

	public String getPhysicalnetworkid() {
		return physicalnetworkid;
	}

	public void setPhysicalnetworkid(String physicalnetworkid) {
		this.physicalnetworkid = physicalnetworkid;
	}

	public String getRestartrequired() {
		return restartrequired;
	}

	public void setRestartrequired(String restartrequired) {
		this.restartrequired = restartrequired;
	}

	public String getSpecifyipranges() {
		return specifyipranges;
	}

	public void setSpecifyipranges(String specifyipranges) {
		this.specifyipranges = specifyipranges;
	}

	public String getCanusefordeploy() {
		return canusefordeploy;
	}

	public void setCanusefordeploy(String canusefordeploy) {
		this.canusefordeploy = canusefordeploy;
	}

	public String getBroadcastdomaintype() {
		return broadcastdomaintype;
	}

	public void setBroadcastdomaintype(String broadcastdomaintype) {
		this.broadcastdomaintype = broadcastdomaintype;
	}

	public String getZonename() {
		return zonename;
	}

	public void setZonename(String zonename) {
		this.zonename = zonename;
	}

	public String getNetworkofferingname() {
		return networkofferingname;
	}

	public void setNetworkofferingname(String networkofferingname) {
		this.networkofferingname = networkofferingname;
	}

	public String getNetworkofferingdisplaytext() {
		return networkofferingdisplaytext;
	}

	public void setNetworkofferingdisplaytext(String networkofferingdisplaytext) {
		this.networkofferingdisplaytext = networkofferingdisplaytext;
	}

	public String getNetworkofferingavailability() {
		return networkofferingavailability;
	}

	public void setNetworkofferingavailability(String networkofferingavailability) {
		this.networkofferingavailability = networkofferingavailability;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDomainid() {
		return domainid;
	}

	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getNetworkdomain() {
		return networkdomain;
	}

	public void setNetworkdomain(String networkdomain) {
		this.networkdomain = networkdomain;
	}

}
