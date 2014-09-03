package sy.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.domain.vo.base.BasicResourceVo;
import sy.domain.vo.base.BasicRoleVo;
import sy.domain.vo.base.BasicUserVo;
import sy.service.shared.BaseService;

/**
 * 
 * @author lidongbo
 * 
 */
@Service("basicAuthorizationService")
public class BasicAuthorizationService extends BaseService implements
		BasicAuthorizationServiceI {

	@Autowired
	private BasicUserRoleServiceI basicUserRoleService;

	@Autowired
	private BasicRoleResServiceI basicRoleResService;
	
	public BasicUserRoleServiceI getBasicUserRoleService() {
		return basicUserRoleService;
	}

	public void setBasicUserRoleService(BasicUserRoleServiceI basicUserRoleService) {
		this.basicUserRoleService = basicUserRoleService;
	}
	
	public BasicRoleResServiceI getBasicRoleResService() {
		return basicRoleResService;
	}

	public void setBasicRoleResService(BasicRoleResServiceI basicRoleResService) {
		this.basicRoleResService = basicRoleResService;
	}

	public void setBasicRoleResService(BasicRoleResService basicRoleResService) {
		this.basicRoleResService = basicRoleResService;
	}

	public List<BasicResourceVo> getResources(BasicUserVo userVo){
		List<BasicRoleVo> roles = basicUserRoleService.getRoleByUser(userVo);
		return basicRoleResService.getResourcesByRole(roles);
	}
}
