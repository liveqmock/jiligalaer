package sy.common.util.cloudstack.entity;

import sy.common.util.valuesetter.Reference;

/**
 * 安全组入口规则
 * @author lidongbo
 * 
 */
public class Ingressrule extends CloudBeanSupport {

	private String ruleid;
	@CreateUsing
	private String protocol;
	@CreateUsing
	private String startport;
	@CreateUsing
	private String endport;
	private String cidr;
	@CreateUsing
	private String icmptype;
	@CreateUsing
	private String icmpcode;
	@CreateUsing
	private String account;
	private String securitygroupname;

	@CreateUsing
	@Reference
	private String securitygroupid;
	
	@CreateUsing
	private String cidrlist;
	@CreateUsing
	private String domainid;
	
	
	public String getId() {
		return ruleid;
	}
	
	public String getRuleid() {
		return ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getStartport() {
		return startport;
	}

	public void setStartport(String startport) {
		this.startport = startport;
	}

	public String getEndport() {
		return endport;
	}

	public void setEndport(String endport) {
		this.endport = endport;
	}

	public String getCidr() {
		return cidr;
	}

	public void setCidr(String cidr) {
		this.cidr = cidr;
	}

	public String getIcmptype() {
		return icmptype;
	}

	public void setIcmptype(String icmptype) {
		this.icmptype = icmptype;
	}

	public String getIcmpcode() {
		return icmpcode;
	}

	public void setIcmpcode(String icmpcode) {
		this.icmpcode = icmpcode;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSecuritygroupname() {
		return securitygroupname;
	}

	public void setSecuritygroupname(String securitygroupname) {
		this.securitygroupname = securitygroupname;
	}

	public String getSecuritygroupid() {
		return securitygroupid;
	}

	public void setSecuritygroupid(String securitygroupid) {
		this.securitygroupid = securitygroupid;
	}

	public String getCidrlist() {
		return cidrlist;
	}

	public void setCidrlist(String cidrlist) {
		this.cidrlist = cidrlist;
	}

	public String getDomainid() {
		return domainid;
	}

	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}

}
