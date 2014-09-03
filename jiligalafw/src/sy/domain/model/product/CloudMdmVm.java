package sy.domain.model.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * 产品-虚拟机表PO
 * @author luobin
 *
 */
@Entity
@Table(name = "CLOUD_MDM_VM")
public class CloudMdmVm extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624971544758545616L;
	
	private String account;
	private String domainid;
	private String domain;

	private Date created;
	
	private String name;
	
	private String displayName;
	
	private String serviceOfferingId;
	
	private String cpuNumber;
	
	private String cpuSpeed;
	
	private String memory;
	
	private String cpuUsed;
	
	private String networkKbsRead;
	
	private String networkKbsWrite;
	
	private String publicIpId;
	
	private String publicIp;
	
	private String templateId;
	
	private String templateName;
	
	private String templateDisplayText;
	
	private String zoneName;
	
	private Date stoptime;
	
	private String state;
	
	private String zoneid;
	private String hostid;
	private String hypervisor;
	private String haenable;
	
	
	
	@Column(name="CREATED")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="DISPLAYNAME")
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	@Column(name="SERVICEOFFERINGID")
	public String getServiceOfferingId() {
		return serviceOfferingId;
	}

	public void setServiceOfferingId(String serviceOfferingId) {
		this.serviceOfferingId = serviceOfferingId;
	}
	
	@Column(name="CPUNUMBER")
	public String getCpuNumber() {
		return cpuNumber;
	}

	public void setCpuNumber(String cpuNumber) {
		this.cpuNumber = cpuNumber;
	}
	
	@Column(name="CPUSPEED")
	public String getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(String cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}
	
	@Column(name="MEMORY")
	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}
	
	@Column(name="CPUUSED")
	public String getCpuUsed() {
		return cpuUsed;
	}

	public void setCpuUsed(String cpuUsed) {
		this.cpuUsed = cpuUsed;
	}
	
	@Column(name="NETWORKKBSREAD")
	public String getNetworkKbsRead() {
		return networkKbsRead;
	}

	public void setNetworkKbsRead(String networkKbsRead) {
		this.networkKbsRead = networkKbsRead;
	}
	
	@Column(name="NETWORKKBSWRITE")
	public String getNetworkKbsWrite() {
		return networkKbsWrite;
	}

	public void setNetworkKbsWrite(String networkKbsWrite) {
		this.networkKbsWrite = networkKbsWrite;
	}
	
	@Column(name="PUBLICIPID")
	public String getPublicIpId() {
		return publicIpId;
	}

	public void setPublicIpId(String publicIpId) {
		this.publicIpId = publicIpId;
	}
	
	@Column(name="PUBLICIP")
	public String getPublicIp() {
		return publicIp;
	}

	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}
	
	@Column(name="TEMPLATE_ID")
	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	@Column(name="TEMPLATENAME")
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	@Column(name="TEMPLATEDISPLAYTEXT")
	public String getTemplateDisplayText() {
		return templateDisplayText;
	}

	public void setTemplateDisplayText(String templateDisplayText) {
		this.templateDisplayText = templateDisplayText;
	}
	
	@Column(name="ZONENAME")
	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
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
	public Date getStoptime() {
		return stoptime;
	}

	public void setStoptime(Date stoptime) {
		this.stoptime = stoptime;
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

	@Column
	public String getHostid() {
		return hostid;
	}

	public void setHostid(String hostid) {
		this.hostid = hostid;
	}

	@Column
	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	@Column
	public String getHaenable() {
		return haenable;
	}

	public void setHaenable(String haenable) {
		this.haenable = haenable;
	}
	
	
}
