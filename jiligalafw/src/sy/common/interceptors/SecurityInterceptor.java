package sy.common.interceptors;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import sy.controller.base.BasicHelper;
import sy.domain.vo.base.BasicUserVo;

/**
 *
 * @author lidongbo
 *
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private String loginUri;
	
	private List<String> ignoreUris;
	
	private boolean ignoredUri(String uri){
		for (String ignoreUri : ignoreUris) {
			if(uri.equals(ignoreUri)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String path = request.getServletPath();
		
		BasicUserVo userVo = BasicHelper.getCurrentUser(request);
		if(userVo == null
				&& !ignoredUri(path)){
			back2Login(request,response);
			return false;
		}
		return true;
	}

	private void back2Login(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.getWriter().write(
				"<script>parent.parent.location='" + request.getContextPath()
						+ "'+parent.parent.location.hash;</script>");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	public String getLoginUri() {
		return loginUri;
	}

	public void setLoginUri(String loginUri) {
		this.loginUri = loginUri;
	}

	public List<String> getIgnoreUris() {
		return ignoreUris;
	}

	public void setIgnoreUris(List<String> ignoreUris) {
		this.ignoreUris = ignoreUris;
	}

}
