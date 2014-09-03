package sy.common.util.cloudstack.entity;

import java.util.Date;


/**
 * 
 * @author lidongbo
 * 
 */
public class Template extends CloudBeanSupport  {

	private String id;
	private String name;
	private String displaytext;
	private String ispublic;
	private Date created;
	private String isready;
	private String passwordenabled;
	private String format;
	private String isfeatured;
	private String crossZones;
	private String ostypeid;
	private String ostypename;
	private String account;
	private String zoneid;
	private String zonename;
	private String status;
	private String size;
	private String templatetype;
	private String hypervisor;
	private String domain;
	private String domainid;
	private String isextractable;
	private String checksum;
	private String sshkeyenabled;
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
	public String getDisplaytext() {
		return displaytext;
	}
	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}
	public String getIspublic() {
		return ispublic;
	}
	public void setIspublic(String ispublic) {
		this.ispublic = ispublic;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getIsready() {
		return isready;
	}
	public void setIsready(String isready) {
		this.isready = isready;
	}
	public String getPasswordenabled() {
		return passwordenabled;
	}
	public void setPasswordenabled(String passwordenabled) {
		this.passwordenabled = passwordenabled;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getIsfeatured() {
		return isfeatured;
	}
	public void setIsfeatured(String isfeatured) {
		this.isfeatured = isfeatured;
	}
	public String getCrossZones() {
		return crossZones;
	}
	public void setCrossZones(String crossZones) {
		this.crossZones = crossZones;
	}
	public String getOstypeid() {
		return ostypeid;
	}
	public void setOstypeid(String ostypeid) {
		this.ostypeid = ostypeid;
	}
	public String getOstypename() {
		return ostypename;
	}
	public void setOstypename(String ostypename) {
		this.ostypename = ostypename;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public String getZonename() {
		return zonename;
	}
	public void setZonename(String zonename) {
		this.zonename = zonename;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getTemplatetype() {
		return templatetype;
	}
	public void setTemplatetype(String templatetype) {
		this.templatetype = templatetype;
	}
	public String getHypervisor() {
		return hypervisor;
	}
	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getIsextractable() {
		return isextractable;
	}
	public void setIsextractable(String isextractable) {
		this.isextractable = isextractable;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getSshkeyenabled() {
		return sshkeyenabled;
	}
	public void setSshkeyenabled(String sshkeyenabled) {
		this.sshkeyenabled = sshkeyenabled;
	}

	
}
