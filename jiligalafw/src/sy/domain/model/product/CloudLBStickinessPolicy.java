package sy.domain.model.product;

import javax.persistence.Entity;
import javax.persistence.Table;

import sy.domain.model.shared.CloudPersistentObject;

/**
 * 
 * @author lidongbo
 * 
 */
@Entity
@Table(name = "LB_STICKINESS_POLICY")
public class CloudLBStickinessPolicy extends CloudPersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5604001237239055446L;
	private String lbruleid;
	private String name;
	private String methodname;
	private String params;

	public String getLbruleid() {
		return lbruleid;
	}

	public void setLbruleid(String lbruleid) {
		this.lbruleid = lbruleid;
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
