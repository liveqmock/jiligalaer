package sy.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * 端口转发
 * @author lidongbo
 * 
 */
@Entity
@Table(name = "CLOUD_PORT_FORWARDING_RULE")
public class CloudPortForwardingRule extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3128017420330498920L;
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

	@Column
	public String getPrivateport() {
		return privateport;
	}

	public void setPrivateport(String privateport) {
		this.privateport = privateport;
	}

	@Column
	public String getPrivateendport() {
		return privateendport;
	}

	public void setPrivateendport(String privateendport) {
		this.privateendport = privateendport;
	}

	@Column
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Column
	public String getPublicport() {
		return publicport;
	}

	public void setPublicport(String publicport) {
		this.publicport = publicport;
	}
	
	@Column
	public String getPublicendport() {
		return publicendport;
	}

	public void setPublicendport(String publicendport) {
		this.publicendport = publicendport;
	}

	@Column
	public String getVirtualmachineid() {
		return virtualmachineid;
	}

	public void setVirtualmachineid(String virtualmachineid) {
		this.virtualmachineid = virtualmachineid;
	}

	@Column
	public String getIpaddressid() {
		return ipaddressid;
	}

	public void setIpaddressid(String ipaddressid) {
		this.ipaddressid = ipaddressid;
	}

	@Column
	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Column
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column
	public String getCidrlist() {
		return cidrlist;
	}

	public void setCidrlist(String cidrlist) {
		this.cidrlist = cidrlist;
	}
}
