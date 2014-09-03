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
@Table(name = "CLOUD_EGRESSRULE")
public class CloudEgressrule extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7785295662057522283L;
	private String protocol;
	private String startport;
	private String endport;
	private String cidr;
	private String icmptype;
	private String icmpcode;
	private String account;
	private String securitygroupname;
	
	private String securityGroupId;

	@Column
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Column
	public String getStartport() {
		return startport;
	}

	public void setStartport(String startport) {
		this.startport = startport;
	}

	@Column
	public String getEndport() {
		return endport;
	}

	public void setEndport(String endport) {
		this.endport = endport;
	}

	@Column
	public String getCidr() {
		return cidr;
	}

	public void setCidr(String cidr) {
		this.cidr = cidr;
	}

	@Column
	public String getIcmptype() {
		return icmptype;
	}

	public void setIcmptype(String icmptype) {
		this.icmptype = icmptype;
	}

	@Column
	public String getIcmpcode() {
		return icmpcode;
	}

	public void setIcmpcode(String icmpcode) {
		this.icmpcode = icmpcode;
	}

	@Column
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column
	public String getSecuritygroupname() {
		return securitygroupname;
	}

	public void setSecuritygroupname(String securitygroupname) {
		this.securitygroupname = securitygroupname;
	}

	@Column
	public String getSecurityGroupId() {
		return securityGroupId;
	}

	public void setSecurityGroupId(String securityGroupId) {
		this.securityGroupId = securityGroupId;
	}
}
