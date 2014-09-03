package sy.domain.model.product;

import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * 
 * @author lidongbo
 * 
 */

@Entity
@Table(name = "CLOUD_MDM_FIREWALL_RULE")
public class CloudMdmFirewallrule extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3203428904695031129L;
	private String protocol;
	private String startport;
	private String endport;
	private String ipaddressid;
	private String ipaddress;
	private String state;
	private String cidrlist;
	private String networkid;
	private String icmpcode;
	private String icmptype;

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

	public String getIpaddressid() {
		return ipaddressid;
	}

	public void setIpaddressid(String ipaddressid) {
		this.ipaddressid = ipaddressid;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCidrlist() {
		return cidrlist;
	}

	public void setCidrlist(String cidrlist) {
		this.cidrlist = cidrlist;
	}

	public String getNetworkid() {
		return networkid;
	}

	public void setNetworkid(String networkid) {
		this.networkid = networkid;
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
