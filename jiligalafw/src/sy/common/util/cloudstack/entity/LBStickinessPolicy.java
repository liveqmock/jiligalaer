package sy.common.util.cloudstack.entity;

/**
 * 
 * @author lidongbo
 * 
 */
public class LBStickinessPolicy extends CloudBeanSupport {

	private String lbruleid;
	private String id;
	private String name;
	private String methodname;
	private String params;

	public String getLbruleid() {
		return lbruleid;
	}

	public void setLbruleid(String lbruleid) {
		this.lbruleid = lbruleid;
	}

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

	public String getMethodname() {
		return methodname;
	}

	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
}
