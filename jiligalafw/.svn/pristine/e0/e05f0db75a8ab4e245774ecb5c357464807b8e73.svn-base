package sy.controller.base;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.util.Constants;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicRoleVo;
import sy.domain.vo.base.BasicUserRoleVo;
import sy.domain.vo.base.BasicUserVo;
import sy.service.base.BasicRoleServiceI;
import sy.service.base.BasicUserRoleServiceI;
import sy.service.base.BasicUserServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 
 * @author lidongbo
 * 
 */
@Controller
@RequestMapping("/userRole")
@SessionAttributes("basicUserRoleVo")
public class BasicUserRoleController extends
		BaseControllerTemplate<BasicUserRoleVo> {

	@Autowired
	private BasicUserRoleServiceI basicUserRoleService;
	@Autowired
	private BasicUserServiceI basicUserService;

	@Autowired
	private BasicRoleServiceI basicRoleService;

	public BasicRoleServiceI getBasicRoleService() {
		return basicRoleService;
	}

	public void setBasicRoleService(BasicRoleServiceI basicRoleService) {
		this.basicRoleService = basicRoleService;
	}

	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}

	public BasicUserRoleServiceI getBasicUserRoleService() {
		return basicUserRoleService;
	}

	public void setBasicUserRoleService(
			BasicUserRoleServiceI basicUserRoleService) {
		this.basicUserRoleService = basicUserRoleService;
	}

	@Override
	public BasicServiceI<BasicUserRoleVo> getService() {
		return basicUserRoleService;
	}

	@Override
	public String getViewPath() {
		return "base";
	}


	@RequestMapping(value = "roleCheck")
	public String roleCheck(HttpServletRequest request, ModelMap modelMap)
			throws Exception {
		BasicUserVo uVo = this.getCurrentUser(request);
		
		String userId = request.getParameter("userId");
		BasicUserVo userVo = basicUserService.get(userId);
		List<BasicRoleVo> roleList = basicRoleService.getAllBasicRoleVo();
		List<BasicRoleVo> rList = new ArrayList<BasicRoleVo>();
		for(BasicRoleVo roleVo : roleList){
			if(uVo.getUserFlag() != Constants.USER_FLAG_ADMIN){
				if(Integer.valueOf(roleVo.getRoleFlag()).intValue() == (uVo.getUserFlag().intValue()+1)){
					rList.add(roleVo);
				}
			}else{
				rList.add(roleVo);
			}

		}
		List<BasicRoleVo> basicAllRoleVoList = 
			basicUserRoleService.getRoleTotalByUser(rList, userVo);
		
		request.setAttribute("roleList", basicAllRoleVoList);
		return "base/userRoleFrame";
	}
}
