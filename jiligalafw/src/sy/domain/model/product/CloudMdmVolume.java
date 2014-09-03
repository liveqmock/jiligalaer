package sy.domain.model.product;

import java.util.Date;

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
@Table(name = "CLOUD_MDM_VOLUME")
public class CloudMdmVolume extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7373460569987037297L;
	private String name;
	private String zoneid;
	private String type;
	private String deviceid;
	private String virtualmachineid;
	private String size;
	private Date created;
	private Date attached;
	private String state;
	private String account;
	private String domainid;
	private String domain;
	private String storagetype;
	private String hypervisor;
	private String storage;
	private String destroyed;
	private String serviceofferingid;
	private String isextractable;
	private String diskofferingid;
	private String snapshotid;

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getZoneid() {
		return zoneid;
	}

	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

	@Column
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column
	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	@Column
	public String getVirtualmachineid() {
		return virtualmachineid;
	}

	public void setVirtualmachineid(String virtualmachineid) {
		this.virtualmachineid = virtualmachineid;
	}

	@Column
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column
	public Date getAttached() {
		return attached;
	}

	public void setAttached(Date attached) {
		this.attached = attached;
	}

	@Column
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
	public String getStoragetype() {
		return storagetype;
	}

	public void setStoragetype(String storagetype) {
		this.storagetype = storagetype;
	}

	@Column
	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	@Column
	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	@Column
	public String getDestroyed() {
		return destroyed;
	}

	public void setDestroyed(String destroyed) {
		this.destroyed = destroyed;
	}

	@Column
	public String getServiceofferingid() {
		return serviceofferingid;
	}

	public void setServiceofferingid(String serviceofferingid) {
		this.serviceofferingid = serviceofferingid;
	}

	@Column
	public String getIsextractable() {
		return isextractable;
	}

	public void setIsextractable(String isextractable) {
		this.isextractable = isextractable;
	}

	@Column
	public String getDiskofferingid() {
		return diskofferingid;
	}

	public void setDiskofferingid(String diskofferingid) {
		this.diskofferingid = diskofferingid;
	}

	@Column
	public String getSnapshotid() {
		return snapshotid;
	}

	public void setSnapshotid(String snapshotid) {
		this.snapshotid = snapshotid;
	}

}
