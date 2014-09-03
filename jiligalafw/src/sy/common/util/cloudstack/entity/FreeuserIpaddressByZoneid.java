package sy.common.util.cloudstack.entity;

/**
 * 
 * @author luobin
 * 
 */
public class FreeuserIpaddressByZoneid extends CloudBeanSupport {
	
	private String useripaddressid;
	private String zoneid;
	private String publicipaddress;
	
	public String getUseripaddressid() {
		return useripaddressid;
	}
	public void setUseripaddressid(String useripaddressid) {
		this.useripaddressid = useripaddressid;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public String getPublicipaddress() {
		return publicipaddress;
	}
	public void setPublicipaddress(String publicipaddress) {
		this.publicipaddress = publicipaddress;
	}
	
	
}
