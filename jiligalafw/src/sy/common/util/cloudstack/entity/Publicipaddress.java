package sy.common.util.cloudstack.entity;

import java.util.Date;


/**
 * 
 * @author lidongbo
 * 
 */
public class Publicipaddress extends CloudBeanSupport {
	private String id;
	private String ipaddress;
	private Date allocated;
	@CreateUsing
	private String zoneid;
	private String zonename;
	private String issourcenat;
	@CreateUsing
	private String account;
	@CreateUsing
	private String domainid;
	private String domain;
	private String forvirtualnetwork;
	private String vlanid;
	private String vlanname;
	private String isstaticnat;
	private String issystem;
	private String virtualmachineid;
	private String virtualmachinename;
	private String virtualmachinedisplayname;
	private String associatednetworkid;	//the ID of the Network associated with the IP address
	private String associatednetworkname;
	@CreateUsing
	private String networkid;//the ID of the Network where ip belongs to
	private String state;
	private String physicalnetworkid;

	@CreateUsing
	private String vpcid;
	private String project;
	
	@CreateUsing
	private String projectid;
	private String purpose;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Date getAllocated() {
		return allocated;
	}

	public void setAllocated(Date allocated) {
		this.allocated = allocated;
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

	public String getIssourcenat() {
		return issourcenat;
	}

	public void setIssourcenat(String issourcenat) {
		this.issourcenat = issourcenat;
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

	public String getForvirtualnetwork() {
		return forvirtualnetwork;
	}

	public void setForvirtualnetwork(String forvirtualnetwork) {
		this.forvirtualnetwork = forvirtualnetwork;
	}

	public String getVlanid() {
		return vlanid;
	}

	public void setVlanid(String vlanid) {
		this.vlanid = vlanid;
	}

	public String getVlanname() {
		return vlanname;
	}

	public void setVlanname(String vlanname) {
		this.vlanname = vlanname;
	}

	public String getIsstaticnat() {
		return isstaticnat;
	}

	public void setIsstaticnat(String isstaticnat) {
		this.isstaticnat = isstaticnat;
	}

	public String getIssystem() {
		return issystem;
	}

	public void setIssystem(String issystem) {
		this.issystem = issystem;
	}

	public String getVirtualmachineid() {
		return virtualmachineid;
	}

	public void setVirtualmachineid(String virtualmachineid) {
		this.virtualmachineid = virtualmachineid;
	}

	public String getVirtualmachinename() {
		return virtualmachinename;
	}

	public void setVirtualmachinename(String virtualmachinename) {
		this.virtualmachinename = virtualmachinename;
	}

	public String getVirtualmachinedisplayname() {
		return virtualmachinedisplayname;
	}

	public void setVirtualmachinedisplayname(String virtualmachinedisplayname) {
		this.virtualmachinedisplayname = virtualmachinedisplayname;
	}

	public String getAssociatednetworkid() {
		return associatednetworkid;
	}

	public void setAssociatednetworkid(String associatednetworkid) {
		this.associatednetworkid = associatednetworkid;
	}

	public String getAssociatednetworkname() {
		return associatednetworkname;
	}

	public void setAssociatednetworkname(String associatednetworkname) {
		this.associatednetworkname = associatednetworkname;
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

	public String getPhysicalnetworkid() {
		return physicalnetworkid;
	}

	public void setPhysicalnetworkid(String physicalnetworkid) {
		this.physicalnetworkid = physicalnetworkid;
	}

	public String getVpcid() {
		return vpcid;
	}

	public void setVpcid(String vpcid) {
		this.vpcid = vpcid;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	
}
