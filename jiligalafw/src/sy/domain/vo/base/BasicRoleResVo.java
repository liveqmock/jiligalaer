package sy.domain.vo.base;

import sy.common.util.validator.annotations.ValidateNotNull;
import sy.domain.vo.shared.BaseVo;

/**
 * 
 * @author lidongbo
 * 
 */
public class BasicRoleResVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6539574559943795276L;

	private String id;

	@ValidateNotNull(description = "角色")
	private BasicRoleVo role;

	@ValidateNotNull(description = "资源")
	private BasicResourceVo resource;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BasicRoleVo getRole() {
		return role;
	}

	public void setRole(BasicRoleVo role) {
		this.role = role;
	}

	public BasicResourceVo getResource() {
		return resource;
	}

	public void setResource(BasicResourceVo resource) {
		this.resource = resource;
	}

}
