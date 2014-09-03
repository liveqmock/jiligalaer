package sy.domain.vo.product;

import sy.common.util.cloudstack.entity.Diskoffering;

/**
 * 磁盘方案表.
 * 
 * @author CS
 * 
 */
public class CloudMdmDiskSolnVo extends CloudDataSyncBuilder<Diskoffering> {

	private static final long serialVersionUID = 6615366089143182939L;

	/**
	 * 磁盘大小.
	 */
	private String diskSize;
	/**
	 * 磁盘名称.
	 */
	private String name;
	/**
	 * 显示的数据中心信息.
	 */
	private String displayText;
	
	
	private Boolean iscustomized;
	
	private String storagetype;
	
	/**
	 * 选择状态标志
	 */
    private String selectFlag;
    
	

	public String getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(String diskSize) {
		this.diskSize = diskSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public String getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String selectFlag) {
		this.selectFlag = selectFlag;
	}

	public Boolean getIscustomized() {
		return iscustomized;
	}

	public void setIscustomized(Boolean iscustomized) {
		this.iscustomized = iscustomized;
	}

	public String getStoragetype() {
		return storagetype;
	}

	public void setStoragetype(String storagetype) {
		this.storagetype = storagetype;
	}

	
}
