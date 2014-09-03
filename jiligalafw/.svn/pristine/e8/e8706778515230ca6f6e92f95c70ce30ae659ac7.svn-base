package sy.service.base;

import java.util.List;

import sy.domain.vo.base.BasicRoleVo;
import sy.service.shared.BasicServiceI;

/**
 *
 * @author lidongbo
 *
 */
public interface BasicRoleServiceI extends BasicServiceI<BasicRoleVo> {

    public  List<BasicRoleVo> getAllBasicRoleVo() throws Exception;

	public void disable(BasicRoleVo vo);
	
	public void enable(BasicRoleVo vo);
	
	public List<BasicRoleVo> getBasicRoleVoListByCreater(String creater) throws Exception;
	
	public List<BasicRoleVo> getBasicRoleVoListByUserFlag(int userFlag) throws Exception;
}
