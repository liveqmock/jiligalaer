package sy.domain.vo.product;


import java.util.ArrayList;
import java.util.List;

import sy.domain.vo.shared.BaseVo;

public class CloudProductCustomBuyVo   extends BaseVo {

	private static final long serialVersionUID = 3452132L;
	
	private String mdmZoneId;
	private String zoneInterfaceId;
	private String prodTemplateId;
	private String prodDiskSolnId;
	private String prodCpuSolnId;
	private String hostAmount;
	private String hostName;
	private String stopHostTime;
	private String ipAllocatType;
	private String networkType;
	private String securityGroupId;
	
	private Double oneTimePrice;
	private Double oneTimeRebatePrice;
		 
	private Double yearPrice;
	private Double yearRebatePrice;
	
	private Double monthPrice;
	private Double monthRebatePrice;
	 
	private Double dayPrice;
	private Double dayRebatePrice;
	
	private Double hourPrice;
	private Double hourRebatePrice;
	 
	private String isHaveOneTimePrice;
	private String isHaveCyclePrice;
	
	private String billingCycle;
	
	private String diskSize;
	
	private String netIds;
	private String netInterfaceIds;
	
	
	private String isSuccessCreateVm;
	private String successVmNumber;
	private String failVmNumber;
	private String erroInfo;
	
	private String prodTypeName;
	
	//新建网络
	private String newNetFlag;
	private String networkName;
	private String description;
	private String zoneName;
	private String selValue;
	
	private List<CloudMdmNetworkVo> mdmNetWorkList = new ArrayList<CloudMdmNetworkVo>();
	
	private List<CloudProductDetail> oneTimePriceProdItemList = new ArrayList<CloudProductDetail> ();
	private List<CloudProductDetail> cyclePriceProdItemList = new ArrayList<CloudProductDetail> ();
	
	private CloudProductDetail prodDisk;

	public void addOneTimePriceProd (CloudProductDetail prodItem) {
		oneTimePriceProdItemList.add(prodItem);
	}
	
	public void addCyclePriceProd (CloudProductDetail prodItem) {
		cyclePriceProdItemList.add(prodItem);
	}
	
	public void addMdmNetWork(CloudMdmNetworkVo vo){
		mdmNetWorkList.add(vo);
	}
	
	public void clearPriceInfo() {
		oneTimePrice = 0D;
		yearPrice = 0D;
		monthPrice = 0D;
		dayPrice = 0D;
		
		oneTimeRebatePrice = 0D;
		yearRebatePrice = 0D;
		monthRebatePrice = 0D;
		dayRebatePrice = 0D;
		
		hourPrice = 0D;
		hourRebatePrice = 0D;
		
		isHaveCyclePrice = "0";
		isHaveOneTimePrice = "0";
		oneTimePriceProdItemList.clear();
		mdmNetWorkList.clear();
		cyclePriceProdItemList.clear();
	}
	public String getMdmZoneId() {
		return mdmZoneId;
	}

	public void setMdmZoneId(String mdmZoneId) {
		this.mdmZoneId = mdmZoneId;
	}




	public Double getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(Double hourPrice) {
		this.hourPrice = hourPrice;
	}

	public Double getHourRebatePrice() {
		return hourRebatePrice;
	}

	public void setHourRebatePrice(Double hourRebatePrice) {
		this.hourRebatePrice = hourRebatePrice;
	}

	public String getNetInterfaceIds() {
		return netInterfaceIds;
	}

	public void setNetInterfaceIds(String netInterfaceIds) {
		this.netInterfaceIds = netInterfaceIds;
	}

	public String getZoneInterfaceId() {
		return zoneInterfaceId;
	}

	public void setZoneInterfaceId(String zoneInterfaceId) {
		this.zoneInterfaceId = zoneInterfaceId;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}


	public String getHostName() {
		return hostName;
	}

	public String getStopHostTime() {
		return stopHostTime;
	}

	public String getIpAllocatType() {
		return ipAllocatType;
	}


	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public void setStopHostTime(String stopHostTime) {
		this.stopHostTime = stopHostTime;
	}

	public String getNewNetFlag() {
		return newNetFlag;
	}

	public String getProdTypeName() {
		return prodTypeName;
	}

	public void setProdTypeName(String prodTypeName) {
		this.prodTypeName = prodTypeName;
	}

	public CloudProductDetail getProdDisk() {
		return prodDisk;
	}

	public void setProdDisk(CloudProductDetail prodDisk) {
		this.prodDisk = prodDisk;
	}

	public void setNewNetFlag(String newNetFlag) {
		this.newNetFlag = newNetFlag;
	}

	public String getSelValue() {
		return selValue;
	}

	public void setSelValue(String selValue) {
		this.selValue = selValue;
	}

	public void setIpAllocatType(String ipAllocatType) {
		this.ipAllocatType = ipAllocatType;
	}

	public String getHostAmount() {
		return hostAmount;
	}

	public void setHostAmount(String hostAmount) {
		this.hostAmount = hostAmount;
	}

	public String getSecurityGroupId() {
		return securityGroupId;
	}

	public void setSecurityGroupId(String securityGroupId) {
		this.securityGroupId = securityGroupId;
	}

	public List<CloudProductDetail> getCyclePriceProdItemList() {
		return cyclePriceProdItemList;
	}

	public void setCyclePriceProdItemList(
			List<CloudProductDetail> cyclePriceProdItemList) {
		this.cyclePriceProdItemList = cyclePriceProdItemList;
	}

	public String getProdTemplateId() {
		return prodTemplateId;
	}

	public String getProdDiskSolnId() {
		return prodDiskSolnId;
	}

	public String getProdCpuSolnId() {
		return prodCpuSolnId;
	}

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public void setProdTemplateId(String prodTemplateId) {
		this.prodTemplateId = prodTemplateId;
	}

	public void setProdDiskSolnId(String prodDiskSolnId) {
		this.prodDiskSolnId = prodDiskSolnId;
	}

	public void setProdCpuSolnId(String prodCpuSolnId) {
		this.prodCpuSolnId = prodCpuSolnId;
	}

	public List<CloudMdmNetworkVo> getMdmNetWorkList() {
		return mdmNetWorkList;
	}

	public void setMdmNetWorkList(List<CloudMdmNetworkVo> mdmNetWorkList) {
		this.mdmNetWorkList = mdmNetWorkList;
	}

	public Double getOneTimePrice() {
		return oneTimePrice;
	}

	public Double getYearPrice() {
		return yearPrice;
	}

	public Double getMonthPrice() {
		return monthPrice;
	}

	public Double getDayPrice() {
		return dayPrice;
	}

	

	public String getNetIds() {
		return netIds;
	}

	public void setNetIds(String netIds) {
		this.netIds = netIds;
	}

	public void setOneTimePrice(Double oneTimePrice) {
		this.oneTimePrice = oneTimePrice;
	}

	public void setYearPrice(Double yearPrice) {
		this.yearPrice = yearPrice;
	}

	public void setMonthPrice(Double monthPrice) {
		this.monthPrice = monthPrice;
	}

	public void setDayPrice(Double dayPrice) {
		this.dayPrice = dayPrice;
	}


	

	public String getIsHaveOneTimePrice() {
		return isHaveOneTimePrice;
	}

	public void setIsHaveOneTimePrice(String isHaveOneTimePrice) {
		this.isHaveOneTimePrice = isHaveOneTimePrice;
	}

	public List<CloudProductDetail> getOneTimePriceProdItemList() {
		return oneTimePriceProdItemList;
	}

	public void setOneTimePriceProdItemList(
			List<CloudProductDetail> oneTimePriceProdItemList) {
		this.oneTimePriceProdItemList = oneTimePriceProdItemList;
	}

	public Double getOneTimeRebatePrice() {
		return oneTimeRebatePrice;
	}

	public String getIsSuccessCreateVm() {
		return isSuccessCreateVm;
	}

	public String getSuccessVmNumber() {
		return successVmNumber;
	}

	public String getFailVmNumber() {
		return failVmNumber;
	}

	public String getErroInfo() {
		return erroInfo;
	}

	public void setIsSuccessCreateVm(String isSuccessCreateVm) {
		this.isSuccessCreateVm = isSuccessCreateVm;
	}

	public void setSuccessVmNumber(String successVmNumber) {
		this.successVmNumber = successVmNumber;
	}

	public void setFailVmNumber(String failVmNumber) {
		this.failVmNumber = failVmNumber;
	}

	public void setErroInfo(String erroInfo) {
		this.erroInfo = erroInfo;
	}

	public Double getYearRebatePrice() {
		return yearRebatePrice;
	}

	public Double getMonthRebatePrice() {
		return monthRebatePrice;
	}

	public Double getDayRebatePrice() {
		return dayRebatePrice;
	}

	public void setOneTimeRebatePrice(Double oneTimeRebatePrice) {
		this.oneTimeRebatePrice = oneTimeRebatePrice;
	}

	public void setYearRebatePrice(Double yearRebatePrice) {
		this.yearRebatePrice = yearRebatePrice;
	}

	public void setMonthRebatePrice(Double monthRebatePrice) {
		this.monthRebatePrice = monthRebatePrice;
	}

	public void setDayRebatePrice(Double dayRebatePrice) {
		this.dayRebatePrice = dayRebatePrice;
	}

	public String getBillingCycle() {
		return billingCycle;
	}

	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}

	public String getIsHaveCyclePrice() {
		return isHaveCyclePrice;
	}

	public void setIsHaveCyclePrice(String isHaveCyclePrice) {
		this.isHaveCyclePrice = isHaveCyclePrice;
	}

	public String getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(String diskSize) {
		this.diskSize = diskSize;
	}
	
	
	
	
}
