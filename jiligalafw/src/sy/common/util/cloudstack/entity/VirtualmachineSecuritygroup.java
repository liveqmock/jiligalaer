package sy.common.util.cloudstack.entity;


/**
 * 
 * @author lidongbo
 * 
 */
public class VirtualmachineSecuritygroup extends CloudBeanSupport {

	private String virtualmachineid;
	
	private String securitygroupid;

	public String getVirtualmachineid() {
		return virtualmachineid;
	}

	public void setVirtualmachineid(String virtualmachineid) {
		this.virtualmachineid = virtualmachineid;
	}

	public String getSecuritygroupid() {
		return securitygroupid;
	}

	public void setSecuritygroupid(String securitygroupid) {
		this.securitygroupid = securitygroupid;
	}
	
}
