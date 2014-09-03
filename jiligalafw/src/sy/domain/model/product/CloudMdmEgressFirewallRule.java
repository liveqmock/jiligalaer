package sy.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * 
 * @author lidongbo
 * 
 */
@Entity
@Table(name = "CLOUD_MDM_EGRESS_FIREWALL_RULE")
public class CloudMdmEgressFirewallRule extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4753244372644766300L;
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

	@Column
	public String getCidrlist() {
		return cidrlist;
	}

	public void setCidrlist(String cidrlist) {
		this.cidrlist = cidrlist;
	}

	@Column
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Column
	public String getStartport() {
		return startport;
	}

	public void setStartport(String startport) {
		this.startport = startport;
	}

	@Column
	public String getEndport() {
		return endport;
	}

	public void setEndport(String endport) {
		this.endport = endport;
	}

	@Column
	public String getNetworkid() {
		return networkid;
	}

	public void setNetworkid(String networkid) {
		this.networkid = networkid;
	}

	@Column
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column
	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Column
	public String getIpaddressid() {
		return ipaddressid;
	}

	public void setIpaddressid(String ipaddressid) {
		this.ipaddressid = ipaddressid;
	}

	@Column
	public String getIcmpcode() {
		return icmpcode;
	}

	public void setIcmpcode(String icmpcode) {
		this.icmpcode = icmpcode;
	}

	@Column
	public String getIcmptype() {
		return icmptype;
	}

	public void setIcmptype(String icmptype) {
		this.icmptype = icmptype;
	}

}
