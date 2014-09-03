package sy.common.util.cloudstack.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lidongbo
 * 
 */
public class Account extends CloudBeanSupport {

	private String id;
	private String name;
	@CreateUsing
	private String accounttype;
	@CreateUsing
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
	@CreateUsing
	private String timezone;
	
	@EntityClass(cloudBean = User.class)
	private List<User> user = new ArrayList<User>();

	//创建时候使用的参数
	@CreateUsing
	private String email;
	@CreateUsing
	private String firstname;
	@CreateUsing
	private String lastname;
	@CreateUsing
	private String password;
	@CreateUsing
	private String username;
	
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

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
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

	public String getReceivedbytes() {
		return receivedbytes;
	}

	public void setReceivedbytes(String receivedbytes) {
		this.receivedbytes = receivedbytes;
	}

	public String getSentbytes() {
		return sentbytes;
	}

	public void setSentbytes(String sentbytes) {
		this.sentbytes = sentbytes;
	}

	public String getVmlimit() {
		return vmlimit;
	}

	public void setVmlimit(String vmlimit) {
		this.vmlimit = vmlimit;
	}

	public String getVmtotal() {
		return vmtotal;
	}

	public void setVmtotal(String vmtotal) {
		this.vmtotal = vmtotal;
	}

	public String getVmavailable() {
		return vmavailable;
	}

	public void setVmavailable(String vmavailable) {
		this.vmavailable = vmavailable;
	}

	public String getIplimit() {
		return iplimit;
	}

	public void setIplimit(String iplimit) {
		this.iplimit = iplimit;
	}

	public String getIptotal() {
		return iptotal;
	}

	public void setIptotal(String iptotal) {
		this.iptotal = iptotal;
	}

	public String getIpavailable() {
		return ipavailable;
	}

	public void setIpavailable(String ipavailable) {
		this.ipavailable = ipavailable;
	}

	public String getVolumelimit() {
		return volumelimit;
	}

	public void setVolumelimit(String volumelimit) {
		this.volumelimit = volumelimit;
	}

	public String getVolumetotal() {
		return volumetotal;
	}

	public void setVolumetotal(String volumetotal) {
		this.volumetotal = volumetotal;
	}

	public String getVolumeavailable() {
		return volumeavailable;
	}

	public void setVolumeavailable(String volumeavailable) {
		this.volumeavailable = volumeavailable;
	}

	public String getSnapshotlimit() {
		return snapshotlimit;
	}

	public void setSnapshotlimit(String snapshotlimit) {
		this.snapshotlimit = snapshotlimit;
	}

	public String getSnapshottotal() {
		return snapshottotal;
	}

	public void setSnapshottotal(String snapshottotal) {
		this.snapshottotal = snapshottotal;
	}

	public String getSnapshotavailable() {
		return snapshotavailable;
	}

	public void setSnapshotavailable(String snapshotavailable) {
		this.snapshotavailable = snapshotavailable;
	}

	public String getTemplatelimit() {
		return templatelimit;
	}

	public void setTemplatelimit(String templatelimit) {
		this.templatelimit = templatelimit;
	}

	public String getTemplatetotal() {
		return templatetotal;
	}

	public void setTemplatetotal(String templatetotal) {
		this.templatetotal = templatetotal;
	}

	public String getTemplateavailable() {
		return templateavailable;
	}

	public void setTemplateavailable(String templateavailable) {
		this.templateavailable = templateavailable;
	}

	public String getVmstopped() {
		return vmstopped;
	}

	public void setVmstopped(String vmstopped) {
		this.vmstopped = vmstopped;
	}

	public String getVmrunning() {
		return vmrunning;
	}

	public void setVmrunning(String vmrunning) {
		this.vmrunning = vmrunning;
	}

	public String getProjectlimit() {
		return projectlimit;
	}

	public void setProjectlimit(String projectlimit) {
		this.projectlimit = projectlimit;
	}

	public String getProjecttotal() {
		return projecttotal;
	}

	public void setProjecttotal(String projecttotal) {
		this.projecttotal = projecttotal;
	}

	public String getProjectavailable() {
		return projectavailable;
	}

	public void setProjectavailable(String projectavailable) {
		this.projectavailable = projectavailable;
	}

	public String getNetworklimit() {
		return networklimit;
	}

	public void setNetworklimit(String networklimit) {
		this.networklimit = networklimit;
	}

	public String getNetworktotal() {
		return networktotal;
	}

	public void setNetworktotal(String networktotal) {
		this.networktotal = networktotal;
	}

	public String getNetworkavailable() {
		return networkavailable;
	}

	public void setNetworkavailable(String networkavailable) {
		this.networkavailable = networkavailable;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

}
