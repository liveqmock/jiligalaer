package sy.common.util.cloudstack.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lidongbo
 * 
 */
public class SecurityGroup extends CloudBeanSupport {

	private String id;
	@CreateUsing
	private String name;
	@CreateUsing
	private String description;
	@CreateUsing
	private String account;
	@CreateUsing
	private String domainid;
	private String domain;

	@EntityClass(cloudBean = Ingressrule.class)
	private List<Ingressrule> ingressrule = new ArrayList<Ingressrule>();

	@EntityClass(cloudBean = Egressrule.class)
	private List<Egressrule> egressrule = new ArrayList<Egressrule>();

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

	public List<Ingressrule> getIngressrule() {
		return ingressrule;
	}

	public void setIngressrule(List<Ingressrule> ingressrule) {
		this.ingressrule = ingressrule;
	}

	public List<Egressrule> getEgressrule() {
		return egressrule;
	}

	public void setEgressrule(List<Egressrule> egressrule) {
		this.egressrule = egressrule;
	}
}
