package sy.domain.vo.product;

import java.util.ArrayList;
import java.util.List;

import sy.common.util.cloudstack.entity.SecurityGroup;

/**
 * 
 * @author lidongbo
 * 
 */
public class CloudSecurityGroupVo extends CloudDataSyncBuilder<SecurityGroup> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7576249050565596464L;
	private String name;
	private String description;
	private String account;
	private String domainid;
	private String domain;

	@CloudDataSyncBuilderClass(beanClass = CloudIngressruleVo.class)
	private List<CloudIngressruleVo> ingressrule = new ArrayList<CloudIngressruleVo>();

	@CloudDataSyncBuilderClass(beanClass = CloudEgressruleVo.class)
	private List<CloudEgressruleVo> egressrule = new ArrayList<CloudEgressruleVo>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<CloudIngressruleVo> getIngressrule() {
		return ingressrule;
	}

	public void setIngressrule(List<CloudIngressruleVo> ingressrule) {
		this.ingressrule = ingressrule;
	}

	public List<CloudEgressruleVo> getEgressrule() {
		return egressrule;
	}

	public void setEgressrule(List<CloudEgressruleVo> egressrule) {
		this.egressrule = egressrule;
	}
}
