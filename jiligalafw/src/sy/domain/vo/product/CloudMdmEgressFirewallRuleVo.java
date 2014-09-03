package sy.domain.vo.product;

import sy.common.util.cloudstack.entity.EgressFirewallRule;

/**
 *
 * @author lidongbo
 *
 */
public class CloudMdmEgressFirewallRuleVo extends CloudDataSyncBuilder<EgressFirewallRule> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8853183231129256515L;
	private String cidrlist;
	private String protocol;
	private String startport;
	private String endport;
	private String networkid;
	private String state;
	private String ipaddress;
	private String ipaddressid;
	private String icmpcode;
	private String icmptype;
	
	public String getCidrlist() {
		return cidrlist;
	}
	public void setCidrlist(String cidrlist) {
		this.cidrlist = cidrlist;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getStartport() {
		return startport;
	}
	public void setStartport(String startport) {
		this.startport = startport;
	}
	public String getEndport() {
		return endport;
	}
	public void setEndport(String endport) {
		this.endport = endport;
	}
	public String getNetworkid() {
		return networkid;
	}
	public void setNetworkid(String networkid) {
		this.networkid = networkid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getIpaddressid() {
		return ipaddressid;
	}
	public void setIpaddressid(String ipaddressid) {
		this.ipaddressid = ipaddressid;
	}
	public String getIcmpcode() {
		return icmpcode;
	}
	public void setIcmpcode(String icmpcode) {
		this.icmpcode = icmpcode;
	}
	public String getIcmptype() {
		return icmptype;
	}
	public void setIcmptype(String icmptype) {
		this.icmptype = icmptype;
	}
}
