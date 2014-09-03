package sy.common.util.cloudstack.entity;

/**
 * 
 * 端口转发实体
 * @author lidongbo
 * 
 */
public class PortForwardingRule extends CloudBeanSupport {

	private String id;
	@CreateUsing
	private String privateport;
	@CreateUsing
	private String privateendport;
	@CreateUsing
	private String protocol;
	@CreateUsing
	private String publicport;
	@CreateUsing
	private String publicendport;
	@CreateUsing
	private String virtualmachineid;
	private String virtualmachinename;
	private String virtualmachinedisplayname;
	@CreateUsing
	private String ipaddressid;
	private String ipaddress;
	private String state;
	private String cidrlist;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrivateport() {
		return privateport;
	}

	public void setPrivateport(String privateport) {
		this.privateport = privateport;
	}

	public String getPrivateendport() {
		return privateendport;
	}

	public void setPrivateendport(String privateendport) {
		this.privateendport = privateendport;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getPublicport() {
		return publicport;
	}

	public void setPublicport(String publicport) {
		this.publicport = publicport;
	}

	public String getPublicendport() {
		return publicendport;
	}

	public void setPublicendport(String publicendport) {
		this.publicendport = publicendport;
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

	public String getIpaddressid() {
		return ipaddressid;
	}

	public void setIpaddressid(String ipaddressid) {
		this.ipaddressid = ipaddressid;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCidrlist() {
		return cidrlist;
	}

	public void setCidrlist(String cidrlist) {
		this.cidrlist = cidrlist;
	}
}
