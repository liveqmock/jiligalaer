package sy.domain.vo.product;

import sy.common.util.cloudstack.entity.PortForwardingRule;

/**
 * 端口转发
 * @author lidongbo
 * 
 */
public class CloudPortForwardingRuleVo extends
		CloudDataSyncBuilder<PortForwardingRule> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9223354179537857067L;
	private String privateport;
	private String privateendport;
	private String protocol;
	private String publicport;
	private String publicendport;
	private String virtualmachineid;
	private String ipaddressid;
	private String ipaddress;
	private String state;
	private String cidrlist;
	
	private String vmName;

	public String getPrivateport() {
		return privateport;
	}

	public void setPrivateport(String privateport) {
		this.privateport = privateport;
	}

	public String getPrivateendport() {
		return privateendport;
	}

	public void setPrivateendport(String privateendport) {
		this.privateendport = privateendport;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getPublicport() {
		return publicport;
	}

	public void setPublicport(String publicport) {
		this.publicport = publicport;
	}

	public String getPublicendport() {
		return publicendport;
	}

	public void setPublicendport(String publicendport) {
		this.publicendport = publicendport;
	}

	public String getVirtualmachineid() {
		return virtualmachineid;
	}

	public void setVirtualmachineid(String virtualmachineid) {
		this.virtualmachineid = virtualmachineid;
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

	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

}
