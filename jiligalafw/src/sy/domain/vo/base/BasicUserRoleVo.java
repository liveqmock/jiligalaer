package sy.domain.vo.base;

import sy.common.util.validator.annotations.ValidateNotNull;
import sy.domain.vo.shared.BaseVo;


/**
 *
 * @author lidongbo
 *
 */
public class BasicUserRoleVo extends BaseVo{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4541216383574019307L;
	/**
	 * 主键
	 */
	private String userRoleId;
	/**
	 * 用户外键
	 */
	@ValidateNotNull(description = "用户")
	private BasicUserVo basicUser;
	
	/**
	 * 角色外键
	 */
	@ValidateNotNull(description = "角色")
	private BasicRoleVo basicRole;

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public BasicUserVo getBasicUser() {
		return basicUser;
	}

	public void setBasicUser(BasicUserVo basicUser) {
		this.basicUser = basicUser;
	}

	public BasicRoleVo getBasicRole() {
		return basicRole;
	}

	public void setBasicRole(BasicRoleVo basicRole) {
		this.basicRole = basicRole;
	}

}
