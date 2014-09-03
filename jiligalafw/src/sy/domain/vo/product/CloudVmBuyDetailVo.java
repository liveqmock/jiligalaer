package sy.domain.vo.product;

import sy.domain.vo.shared.BaseVo;

public class CloudVmBuyDetailVo extends BaseVo {

	private static final long serialVersionUID = 6615363709143182939L;

	private Integer count;

	private String vmName;

	private String stopTime;
	
	private String ipAllocatType;

	public CloudVmBuyDetailVo() {
		super();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getIpAllocatType() {
		return ipAllocatType;
	}

	public void setIpAllocatType(String ipAllocatType) {
		this.ipAllocatType = ipAllocatType;
	}
	
	

}
