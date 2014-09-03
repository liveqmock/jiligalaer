package sy.common.interceptors;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RequestParamInterceptor implements HandlerInterceptor {
	
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(RequestParamInterceptor.class);
	
	private static Pattern SCRIPT_PATTERN = Pattern.compile("<script.*>.*<\\/script\\s*>");
	private static Pattern HTML_PATTERN = Pattern.compile("<[^>]+>");
	
	/**
	 * 在controller后拦截
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在controller前拦截
	 */
	@SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		int flag = 0;
		String[] value = null;

		Map<String, String[]> paramMap = request.getParameterMap();
		for (Object ov : paramMap.values()) {
			if (ov instanceof String[]) {
				value = (String[]) ov;
			} else {
				value = new String[1];
				value[0] = ov.toString();
			}
			
			for (String parmStr : value) {
				// 过滤html标签
				Matcher mHtml = HTML_PATTERN.matcher(parmStr);
				if (mHtml.find()) {
					flag = 1;
				}
				// 过滤script脚本
				Matcher m = SCRIPT_PATTERN.matcher(parmStr);
				if (m.find()) {
					flag = 1;
				}
				// 过滤sql转换函数
				if (parmStr.contains("ascii(") || parmStr.contains("ascii (") || parmStr.contains("chr(") || parmStr.contains("chr (")) {
					flag = 1;
				}
				// 过滤sql关键字
				if (parmStr.contains("alter ") || parmStr.contains("create ") || parmStr.contains("truncate ") || parmStr.contains("drop ")
						|| parmStr.contains("lock table") || parmStr.contains("insert ") || parmStr.contains("update ") || parmStr.contains("delete ")
						|| parmStr.contains("select ") || parmStr.contains("grant ")) {
					flag = 1;
				}
				if (flag == 1) {

					response.setCharacterEncoding("UTF-8");
					response.setHeader("Pragma", "no-cache");
					response.setHeader("Cache-Control", "no-cache");
					response.setHeader("Cache-Control", "no-store");
					response.setDateHeader("Expires", 0);
					
					response.sendRedirect("commons/sqlError.html");
				}
			}
		}

		return true;
	}
}