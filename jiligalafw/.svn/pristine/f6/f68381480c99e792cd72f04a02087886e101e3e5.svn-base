package sy.service.base;

import java.util.List;

import sy.domain.vo.base.BasicResourceVo;
import sy.domain.vo.base.BasicRoleResVo;
import sy.domain.vo.base.BasicRoleVo;
import sy.service.shared.BasicServiceI;

/**
 *
 * @author lidongbo
 *
 */
public interface BasicRoleResServiceI extends BasicServiceI<BasicRoleResVo> {

	public String getResIdsByRoleId(String roleId);
	
	public int deleteByRoleId(String roleId) ;

	public void save(String roleId, String resIds);

	List<BasicResourceVo> getResourcesByRole(List<BasicRoleVo> roles);

}
