package sy.domain.vo.product;

import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.entity.NetworkType;
import sy.common.util.cloudstack.entity.Zone;

/**
 * 数据中心表
 * 
 * @author CS
 * 
 */
public class CloudMdmZoneVo extends CloudDataSyncBuilder<Zone> {

	private static final long serialVersionUID = 6615366709143182939L;

	/**
	 * 显示的数据中心信息
	 */
	private String displayText;
	/**
	 * 简述.
	 */
	private String description;
	/**
	 * 网络带宽类型.
	 */
	private String networkType;

	private String name;

	/**
	 * 选择状态标志
	 */
	private String selectFlag;

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String selectFlag) {
		this.selectFlag = selectFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NetworkType getNetworkTypeAsObj(){
		if(NetworkType.Advanced.getName().equalsIgnoreCase(networkType)){
			return NetworkType.Advanced;
		}else if(NetworkType.Basic.getName().equalsIgnoreCase(networkType)){
			return NetworkType.Basic;
		}else{
			throw new CloudException("未知的网络类型！‘"+networkType+"’");
		}
	}
}
