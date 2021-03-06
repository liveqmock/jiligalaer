package sy.controller.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sy.common.model.ECContext;
import sy.common.model.QueryContext;
import sy.common.util.Constants;
import sy.common.util.validator.ValidatorException;
import sy.controller.shared.BaseControllerTemplate;
import sy.domain.vo.base.BasicRoleVo;
import sy.domain.vo.base.BasicUserVo;
import sy.service.base.BasicRoleServiceI;
import sy.service.base.BasicUserRoleServiceI;
import sy.service.base.BasicUserServiceI;
import sy.service.shared.BasicServiceI;

/**
 * 管理員信息
 * 
 * @author lidongbo
 * 
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes("basicUserVo")
public class BasicAdminController extends
		BaseControllerTemplate<BasicUserVo> {

	@Autowired
	private BasicUserServiceI basicUserService;
	@Autowired
	private BasicUserRoleServiceI basicUserRoleService;
	@Autowired
	private BasicRoleServiceI basicRoleService;

	public BasicUserRoleServiceI getBasicUserRoleService() {
		return basicUserRoleService;
	}

	public void setBasicUserRoleService(
			BasicUserRoleServiceI basicUserRoleService) {
		this.basicUserRoleService = basicUserRoleService;
	}

	public String getViewPath() {
		return "base";
	}

	public BasicUserServiceI getBasicUserService() {
		return basicUserService;
	}

	public void setBasicUserService(BasicUserServiceI basicUserService) {
		this.basicUserService = basicUserService;
	}

	public BasicRoleServiceI getBasicRoleService() {
		return basicRoleService;
	}

	public void setBasicRoleService(BasicRoleServiceI basicRoleService) {
		this.basicRoleService = basicRoleService;
	}

	@Override
	public BasicServiceI<BasicUserVo> getService() {
		return basicUserService;
	}

	/**
	 * 查询管理員信息
	 */
	@RequestMapping(value = "list")
	public String list(HttpServletRequest request, ModelMap modelMap)
			throws ValidatorException {
		QueryContext context = new ECContext(request, modelMap,
				getNameSpace());
		String userFlag = request.getParameter("userFlag");
		if ("".equals(userFlag) || null == userFlag) {
			userFlag = String.valueOf(Constants.USER_FLAG_ADMIN);
		}
		context.put("$in_userFlag", userFlag);
		List<BasicRoleVo> basicRoleVoList = null;

		try {
			basicRoleVoList = basicRoleService.getAllBasicRoleVo();

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("roleList", basicRoleVoList);
		String roleFlag = "";
		String queryType = request.getParameter("queryType");
		// queryType为1标示简单查询中的用户状态查询，0为简单查询中的角色查询，2为高级查询.
		if ("0".equals(queryType)) {
			context.put("$lk_userName", null);
			context.put("$lk_userAccount", null);
			context.put("$lk_tel", null);
			context.put("$in_state", null);
			context.put("$eq_state", null);
			roleFlag = request.getParameter("roleFlag");
			request.setAttribute("roleFlag", roleFlag);

		} else if ("1".equals(queryType)) {
			context.put("$lk_userName", null);
			context.put("$lk_userAccount", null);
			context.put("$lk_tel", null);
			context.put("$in_state", null);
			context.put("$eq_role", null);
			String stateFlag = request.getParameter("stateFlag");
			context.put("$eq_state", stateFlag);
		} else {
			context.put("$eq_state", null);
			context.put("$in_state", null);
			String[] stateArr = request.getParameterValues("state");
			String stateStr = "";
			if (stateArr != null && stateArr.length > 0) {
				for (int i = 0; i < stateArr.length; i++) {
					stateStr += stateArr[i] + ",";
				}
				context.put("$in_state",
						stateStr.substring(0, stateStr.length() - 1));
				request.setAttribute("stateStr",
						stateStr.substring(0, stateStr.length() - 1));
			}
			String[] roleArr = request.getParameterValues("role");
			String roleStr = "";
			if (roleArr != null && roleArr.length > 0) {
				for (int i = 0; i < roleArr.length; i++) {
					roleStr += roleArr[i] + ",";
				}
				request.setAttribute("roleStr",
						roleStr.substring(0, roleStr.length() - 1));
				roleFlag = roleStr.substring(0, roleStr.length() - 1);
			}
		}
		List<BasicUserVo> basicUserVoList = null;
		try {
			basicUserVoList = basicUserRoleService
					.getBasicUserRoleTotalByUser(roleFlag, context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.initTotalRows(modelMap);
		modelMap.put("list", basicUserVoList);
		request.setAttribute("queryType", queryType);
		return getViewPath() + "/adminList";

	}

	protected void prepareEditView(HttpServletRequest request,
			ModelMap modelMap, BasicUserVo obj) {
		super.prepareEditView(request, modelMap, obj);
		Map<String, String> stateMap = new HashMap<String, String>();
		if (null == obj.getState()
				|| Constants.USER_STATE_PASS == obj.getState()) {
			stateMap.put("3", "审批通过");
		} else {
			stateMap.put("0", "停用");
			stateMap.put("1", "未激活");
			stateMap.put("2", "待审批");
			stateMap.put("3", "审批通过");
			stateMap.put("-1", "注销");
			stateMap.put("-2", "审批拒绝");
		}
		modelMap.put("state", stateMap);
	}
	
//	public String getSavedView() {
//		return getCloseView();
//	}
}
