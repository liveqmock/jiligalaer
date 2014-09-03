package sy.domain.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * CPU计算方案表
 * 
 * @author CS
 * 
 */
@Entity
@Table(name = "CLOUD_MDM_CPU_SOLN")
public class CloudMdmCPUSoln extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3624974548758505616L;

	/**
	 * CPU名称.
	 */
	private String name;
	/**
	 * 显示的数据中心信息.
	 */
	private String displayText;
	/**
	 * CPU数量.
	 */
	private String cpuNumber;
	/**
	 * CPU频率
	 */
	private String cpuSpeed;
	/**
	 * 内存
	 */
	private String memory;

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DISPLAYTEXT")
	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	@Column(name = "CPUNUMBER")
	public String getCpuNumber() {
		return cpuNumber;
	}

	public void setCpuNumber(String cpuNumber) {
		this.cpuNumber = cpuNumber;
	}

	@Column(name = "CPUSPEED")
	public String getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(String cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}

	@Column(name = "MEMORY")
	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}
}
