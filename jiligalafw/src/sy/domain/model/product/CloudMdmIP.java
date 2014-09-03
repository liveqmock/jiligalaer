package sy.domain.model.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * IP表
 * 
 * @author CS
 * 
 */
@Entity
@Table(name = "CLOUD_MDM_IP")
public class CloudMdmIP extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624974548758505616L;

	/**
	 * 显示的数据中心信息.
	 */
	private String ipAddress;
	/**
	 * 虚拟机ID.
	 */
	private String virtualMachineId;

	private Date allocated;
	private String zoneid;
	private String zonename;
	private String issourcenat;
	private String account;
	private String domainid;
	private String domain;
	private String forvirtualnetwork;
	private String vlanid;
	private String vlanname;
	private String isstaticnat;
	private String issystem;
	private String virtualmachinename;
	private String virtualmachinedisplayname;
	private String associatednetworkid;
	private String associatednetworkname;
	private String networkid;
	private String state;
	private String physicalnetworkid;

	private String vpcid;
	private String project;
	private String projectid;
	private String purpose;
	
	@Column(name = "IPADDRESS")
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "VIRTUALMACHINEID")
	public String getVirtualMachineId() {
		return virtualMachineId;
	}

	public void setVirtualMachineId(String virtualMachineId) {
		this.virtualMachineId = virtualMachineId;
	}

	@Column
	public Date getAllocated() {
		return allocated;
	}

	public void setAllocated(Date allocated) {
		this.allocated = allocated;
	}

	@Column
	public String getZoneid() {
		return zoneid;
	}

	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

	@Column
	public String getZonename() {
		return zonename;
	}

	public void setZonename(String zonename) {
		this.zonename = zonename;
	}

	@Column
	public String getIssourcenat() {
		return issourcenat;
	}

	public void setIssourcenat(String issourcenat) {
		this.issourcenat = issourcenat;
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
	public String getForvirtualnetwork() {
		return forvirtualnetwork;
	}

	public void setForvirtualnetwork(String forvirtualnetwork) {
		this.forvirtualnetwork = forvirtualnetwork;
	}

	@Column
	public String getVlanid() {
		return vlanid;
	}

	public void setVlanid(String vlanid) {
		this.vlanid = vlanid;
	}

	@Column
	public String getVlanname() {
		return vlanname;
	}

	public void setVlanname(String vlanname) {
		this.vlanname = vlanname;
	}

	@Column
	public String getIsstaticnat() {
		return isstaticnat;
	}

	public void setIsstaticnat(String isstaticnat) {
		this.isstaticnat = isstaticnat;
	}

	@Column
	public String getIssystem() {
		return issystem;
	}

	public void setIssystem(String issystem) {
		this.issystem = issystem;
	}

	@Column
	public String getVirtualmachinename() {
		return virtualmachinename;
	}

	public void setVirtualmachinename(String virtualmachinename) {
		this.virtualmachinename = virtualmachinename;
	}

	@Column
	public String getVirtualmachinedisplayname() {
		return virtualmachinedisplayname;
	}

	public void setVirtualmachinedisplayname(String virtualmachinedisplayname) {
		this.virtualmachinedisplayname = virtualmachinedisplayname;
	}

	@Column
	public String getAssociatednetworkid() {
		return associatednetworkid;
	}

	public void setAssociatednetworkid(String associatednetworkid) {
		this.associatednetworkid = associatednetworkid;
	}

	@Column
	public String getAssociatednetworkname() {
		return associatednetworkname;
	}

	public void setAssociatednetworkname(String associatednetworkname) {
		this.associatednetworkname = associatednetworkname;
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
	public String getPhysicalnetworkid() {
		return physicalnetworkid;
	}

	public void setPhysicalnetworkid(String physicalnetworkid) {
		this.physicalnetworkid = physicalnetworkid;
	}

	@Column
	public String getVpcid() {
		return vpcid;
	}

	public void setVpcid(String vpcid) {
		this.vpcid = vpcid;
	}

	@Column
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Column
	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	@Column
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	

}
