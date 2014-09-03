package sy.controller.base;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import sy.common.util.Constants;
import sy.domain.vo.base.BasicResourceVo;
import sy.domain.vo.base.BasicUserVo;

/**
 *
 * @author lidongbo
 *
 */
public class BasicHelper {

	/**
	 * 获取当前登录的用户
	 * @param request
	 * @return
	 */
	public static BasicUserVo getCurrentUser(HttpServletRequest request){
		return (BasicUserVo) request.getSession().getAttribute(Constants.SESSION_USER_KEY);
	}
	
	/**
	 * 获得当前用户拥有的资源列表
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<BasicResourceVo> getOwnedResources(HttpServletRequest request){
		List<BasicResourceVo> result = (List<BasicResourceVo>) request.getSession().getAttribute(Constants.SESSION_RES_KEY);
		if(result == null){
			result = new ArrayList<BasicResourceVo>();
		}
		return result;
	}

	/**
	 * 获取当前登录的用户
	 * @param request
	 * @return
	 */
	public static BasicUserVo getCurrentUser(WebRequest request) {
		return (BasicUserVo) request.getAttribute(Constants.SESSION_USER_KEY, RequestAttributes.SCOPE_SESSION);
	}
	
}
