package sy.domain.vo.product;

import sy.domain.vo.shared.BaseVo;


/**
 * 
 * @author luobin
 * 
 */
public class CloudLoadRule extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2932311213189339699L;
	
	private String id;
	
	private String lbruleid;

	private String virtualmachineid;
	
	private String vmname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLbruleid() {
		return lbruleid;
	}

	public void setLbruleid(String lbruleid) {
		this.lbruleid = lbruleid;
	}

	public String getVirtualmachineid() {
		return virtualmachineid;
	}

	public void setVirtualmachineid(String virtualmachineid) {
		this.virtualmachineid = virtualmachineid;
	}

	public String getVmname() {
		return vmname;
	}

	public void setVmname(String vmname) {
		this.vmname = vmname;
	}
	

}
