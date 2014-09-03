package sy.common.util.cloudstack.entity;

/**
 * 
 * 来宾网络-出口规则
 * @author lidongbo
 * 
 */
public class EgressFirewallRule extends CloudBeanSupport {

	private String id;

	@CreateUsing
	private String cidrlist;
	@CreateUsing
	private String protocol;
	@CreateUsing
	private String startport;
	@CreateUsing
	private String endport;
	@CreateUsing
	private String networkid;
	private String state;

	private String ipaddress;
	private String ipaddressid;

	private String icmpcode;
	private String icmptype;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
