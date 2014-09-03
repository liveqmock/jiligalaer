package sy.domain.vo.shared;

import java.io.Serializable;

/**
 *
 * @author lidongbo
 *
 */
public class TreeVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4814004128233011868L;

	private String id;
	
	private String pid;
	
	private String name;
	
	private Boolean result;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
