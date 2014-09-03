package sy.common.util.cloudstack.entity;

/**
 * 
 * @author lidongbo
 * 
 */
public class Loadbalancerrule extends CloudBeanSupport {

	private String id;
	@CreateUsing
	private String name;
	private String description;
	@CreateUsing
	private String publicipid;
	private String publicip;
	@CreateUsing
	private String publicport;
	@CreateUsing
	private String privateport;
	@CreateUsing
	private String algorithm;
	private String cidrlist;
	@CreateUsing
	private String account;
	@CreateUsing
	private String domainid;
	private String domain;
	private String state;
	private String zoneid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublicipid() {
		return publicipid;
	}

	public void setPublicipid(String publicipid) {
		this.publicipid = publicipid;
	}

	public String getPublicip() {
		return publicip;
	}

	public void setPublicip(String publicip) {
		this.publicip = publicip;
	}

	public String getPublicport() {
		return publicport;
	}

	public void setPublicport(String publicport) {
		this.publicport = publicport;
	}

	public String getPrivateport() {
		return privateport;
	}

	public void setPrivateport(String privateport) {
		this.privateport = privateport;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getCidrlist() {
		return cidrlist;
	}

	public void setCidrlist(String cidrlist) {
		this.cidrlist = cidrlist;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZoneid() {
		return zoneid;
	}

	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
