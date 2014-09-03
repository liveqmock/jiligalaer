package sy.service.base;

import java.util.List;

import sy.common.model.QueryContext;
import sy.domain.model.base.BasicUserRole;
import sy.domain.vo.base.BasicRoleVo;
import sy.domain.vo.base.BasicUserRoleVo;
import sy.domain.vo.base.BasicUserVo;
import sy.service.shared.BasicServiceI;

/**
 *
 * @author lidongbo
 *
 */
public interface BasicUserRoleServiceI extends BasicServiceI<BasicUserRoleVo> {

	public List<BasicRoleVo> getRoleByUser(BasicUserVo userVo);
	
	public void save(String userId, String roleIds);
	
	public List<BasicRoleVo> getRoleTotalByUser(List<BasicRoleVo> basicRoleVoTotal,BasicUserVo userVo) throws Exception;

	public List<BasicUserRole>  getUserByRoles(String roleIds,QueryContext context);
	public List<BasicUserVo>  getBasicUserRoleTotalByUser(String roleIds,QueryContext context) throws Exception;
	
}
