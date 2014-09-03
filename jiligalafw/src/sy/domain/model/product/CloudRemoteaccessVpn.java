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
@Table(name = "CLOUD_VPN_REMOTEACCESS")
public class CloudRemoteaccessVpn extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6736758466968526690L;

	private String publicipid;
	private String publicip;
	private String iprange;
	private String presharedkey;
	private String account;
	private String domainid;
	private String domain;
	private String state;

	@Column
	public String getPublicipid() {
		return publicipid;
	}

	public void setPublicipid(String publicipid) {
		this.publicipid = publicipid;
	}

	@Column
	public String getPublicip() {
		return publicip;
	}

	public void setPublicip(String publicip) {
		this.publicip = publicip;
	}

	@Column
	public String getIprange() {
		return iprange;
	}

	public void setIprange(String iprange) {
		this.iprange = iprange;
	}

	@Column
	public String getPresharedkey() {
		return presharedkey;
	}

	public void setPresharedkey(String presharedkey) {
		this.presharedkey = presharedkey;
	}

	@Column
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column
	public String getDomainid() {
		return domainid;
	}

	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}

	@Column
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Column
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
