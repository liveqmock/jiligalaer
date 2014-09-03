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
@Table(name = "CLOUD_LOAD_BALANCER_RULE")
public class CloudLoadbalancerrule extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1958756139263837566L;
	private String name;
	private String description;
	private String publicipid;
	private String publicip;
	private String publicport;
	private String privateport;
	private String algorithm;
	private String cidrlist;
	private String account;
	private String domainid;
	private String domain;
	private String state;
	private String zoneid;

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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
	public String getPublicport() {
		return publicport;
	}

	public void setPublicport(String publicport) {
		this.publicport = publicport;
	}

	@Column
	public String getPrivateport() {
		return privateport;
	}

	public void setPrivateport(String privateport) {
		this.privateport = privateport;
	}

	@Column
	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	@Column
	public String getCidrlist() {
		return cidrlist;
	}

	public void setCidrlist(String cidrlist) {
		this.cidrlist = cidrlist;
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

	@Column
	public String getZoneid() {
		return zoneid;
	}

	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

}
