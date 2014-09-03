package sy.common.util.cloudstack.entity;

/**
 * 
 * @author lidongbo
 * 
 */
public class Domain extends CloudBeanSupport {

	private String id;

	@CreateUsing
	private String name;
	private String level;
	private String parentdomainid;
	private String parentdomainname;
	private String haschild;
	private String path;

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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParentdomainid() {
		return parentdomainid;
	}

	public void setParentdomainid(String parentdomainid) {
		this.parentdomainid = parentdomainid;
	}

	public String getParentdomainname() {
		return parentdomainname;
	}

	public void setParentdomainname(String parentdomainname) {
		this.parentdomainname = parentdomainname;
	}

	public String getHaschild() {
		return haschild;
	}

	public void setHaschild(String haschild) {
		this.haschild = haschild;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
