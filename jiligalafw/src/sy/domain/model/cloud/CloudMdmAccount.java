package sy.domain.model.cloud;

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
@Table(name = "CLOUD_MDM_ACCOUNT")
public class CloudMdmAccount extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6884811488597991091L;

	private String name;
	private String accounttype;
	private String domainid;
	private String domain;
	private String receivedbytes;
	private String sentbytes;
	private String vmlimit;
	private String vmtotal;
	private String vmavailable;
	private String iplimit;
	private String iptotal;
	private String ipavailable;
	private String volumelimit;
	private String volumetotal;
	private String volumeavailable;
	private String snapshotlimit;
	private String snapshottotal;
	private String snapshotavailable;
	private String templatelimit;
	private String templatetotal;
	private String templateavailable;
	private String vmstopped;
	private String vmrunning;
	private String projectlimit;
	private String projecttotal;
	private String projectavailable;
	private String networklimit;
	private String networktotal;
	private String networkavailable;
	private String state;

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
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
	public String getReceivedbytes() {
		return receivedbytes;
	}

	public void setReceivedbytes(String receivedbytes) {
		this.receivedbytes = receivedbytes;
	}

	@Column
	public String getSentbytes() {
		return sentbytes;
	}

	public void setSentbytes(String sentbytes) {
		this.sentbytes = sentbytes;
	}

	@Column
	public String getVmlimit() {
		return vmlimit;
	}

	public void setVmlimit(String vmlimit) {
		this.vmlimit = vmlimit;
	}

	@Column
	public String getVmtotal() {
		return vmtotal;
	}

	public void setVmtotal(String vmtotal) {
		this.vmtotal = vmtotal;
	}

	@Column
	public String getVmavailable() {
		return vmavailable;
	}

	public void setVmavailable(String vmavailable) {
		this.vmavailable = vmavailable;
	}

	@Column
	public String getIplimit() {
		return iplimit;
	}

	public void setIplimit(String iplimit) {
		this.iplimit = iplimit;
	}

	@Column
	public String getIptotal() {
		return iptotal;
	}

	public void setIptotal(String iptotal) {
		this.iptotal = iptotal;
	}

	@Column
	public String getIpavailable() {
		return ipavailable;
	}

	public void setIpavailable(String ipavailable) {
		this.ipavailable = ipavailable;
	}

	@Column
	public String getVolumelimit() {
		return volumelimit;
	}

	public void setVolumelimit(String volumelimit) {
		this.volumelimit = volumelimit;
	}

	@Column
	public String getVolumetotal() {
		return volumetotal;
	}

	public void setVolumetotal(String volumetotal) {
		this.volumetotal = volumetotal;
	}

	@Column
	public String getVolumeavailable() {
		return volumeavailable;
	}

	public void setVolumeavailable(String volumeavailable) {
		this.volumeavailable = volumeavailable;
	}

	@Column
	public String getSnapshotlimit() {
		return snapshotlimit;
	}

	public void setSnapshotlimit(String snapshotlimit) {
		this.snapshotlimit = snapshotlimit;
	}

	@Column
	public String getSnapshottotal() {
		return snapshottotal;
	}

	public void setSnapshottotal(String snapshottotal) {
		this.snapshottotal = snapshottotal;
	}

	@Column
	public String getSnapshotavailable() {
		return snapshotavailable;
	}

	public void setSnapshotavailable(String snapshotavailable) {
		this.snapshotavailable = snapshotavailable;
	}

	@Column
	public String getTemplatelimit() {
		return templatelimit;
	}

	public void setTemplatelimit(String templatelimit) {
		this.templatelimit = templatelimit;
	}

	@Column
	public String getTemplatetotal() {
		return templatetotal;
	}

	public void setTemplatetotal(String templatetotal) {
		this.templatetotal = templatetotal;
	}

	@Column
	public String getTemplateavailable() {
		return templateavailable;
	}

	public void setTemplateavailable(String templateavailable) {
		this.templateavailable = templateavailable;
	}

	@Column
	public String getVmstopped() {
		return vmstopped;
	}

	public void setVmstopped(String vmstopped) {
		this.vmstopped = vmstopped;
	}

	@Column
	public String getVmrunning() {
		return vmrunning;
	}

	public void setVmrunning(String vmrunning) {
		this.vmrunning = vmrunning;
	}

	@Column
	public String getProjectlimit() {
		return projectlimit;
	}

	public void setProjectlimit(String projectlimit) {
		this.projectlimit = projectlimit;
	}

	@Column
	public String getProjecttotal() {
		return projecttotal;
	}

	public void setProjecttotal(String projecttotal) {
		this.projecttotal = projecttotal;
	}

	@Column
	public String getProjectavailable() {
		return projectavailable;
	}

	public void setProjectavailable(String projectavailable) {
		this.projectavailable = projectavailable;
	}

	@Column
	public String getNetworklimit() {
		return networklimit;
	}

	public void setNetworklimit(String networklimit) {
		this.networklimit = networklimit;
	}

	@Column
	public String getNetworktotal() {
		return networktotal;
	}

	public void setNetworktotal(String networktotal) {
		this.networktotal = networktotal;
	}

	@Column
	public String getNetworkavailable() {
		return networkavailable;
	}

	public void setNetworkavailable(String networkavailable) {
		this.networkavailable = networkavailable;
	}

	@Column
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
