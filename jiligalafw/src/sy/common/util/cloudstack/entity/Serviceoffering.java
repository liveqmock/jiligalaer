package sy.common.util.cloudstack.entity;

import java.util.Date;


/**
 * 
 * @author lidongbo
 * 
 */
public class Serviceoffering extends CloudBeanSupport {
	private String id;
	private String name;
	private String displaytext;
	private String cpunumber;
	private String cpuspeed;
	private String memory;
	private Date created;
	private String storagetype;
	private String offerha;
	private String limitcpuuse;
	private String issystem;
	private String defaultuse;
	private String networkrate;

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

	public String getDisplaytext() {
		return displaytext;
	}

	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}

	public String getCpunumber() {
		return cpunumber;
	}

	public void setCpunumber(String cpunumber) {
		this.cpunumber = cpunumber;
	}

	public String getCpuspeed() {
		return cpuspeed;
	}

	public void setCpuspeed(String cpuspeed) {
		this.cpuspeed = cpuspeed;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getStoragetype() {
		return storagetype;
	}

	public void setStoragetype(String storagetype) {
		this.storagetype = storagetype;
	}

	public String getOfferha() {
		return offerha;
	}

	public void setOfferha(String offerha) {
		this.offerha = offerha;
	}

	public String getLimitcpuuse() {
		return limitcpuuse;
	}

	public void setLimitcpuuse(String limitcpuuse) {
		this.limitcpuuse = limitcpuuse;
	}

	public String getIssystem() {
		return issystem;
	}

	public void setIssystem(String issystem) {
		this.issystem = issystem;
	}

	public String getDefaultuse() {
		return defaultuse;
	}

	public void setDefaultuse(String defaultuse) {
		this.defaultuse = defaultuse;
	}

	public String getNetworkrate() {
		return networkrate;
	}

	public void setNetworkrate(String networkrate) {
		this.networkrate = networkrate;
	}

}
