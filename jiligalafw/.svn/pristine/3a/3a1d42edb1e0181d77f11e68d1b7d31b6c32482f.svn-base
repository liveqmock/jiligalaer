package sy.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	private static ThreadLocal<Map<String, String>> cookies = new ThreadLocal<Map<String, String>>();

	public static String getCookie(HttpServletRequest request, String key) {

		Map<String, String> cookieMap = getCookieMap(request);

//		if("CN".equals(cookieMap.get("lanId"))) {
//			String a = "";
//			a = a + "";
//		}
		
		
		return cookieMap.get(key);
	}

	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String key, String value) {
//		Cookie cookies[] = request.getCookies();
//		Cookie c = null;
//		for (int i = 0; i < cookies.length; i++) {
//			c = cookies[i];
//			if (c.getName().equals(key)) {
//				c.setValue(value);
//				response.addCookie(c); // 修改后，要更新到浏览器中
//			}
//		}
		
		Cookie cookie = new Cookie(key, value);
		response.addCookie(cookie);
		
		Map<String, String> cookieMap = getCookieMap(request);
		cookieMap.put(key, value);
	}

	private static Map<String, String> getCookieMap(HttpServletRequest request) {
		Map<String, String> cookieMap = cookies.get();
		if (cookieMap == null) {
			cookieMap = initCookie(request);
		}
		return cookieMap;
	}

	public static Map<String, String> initCookie(HttpServletRequest request) {
		Map<String, String> cookieMap = new HashMap<String, String>();
		cookies.set(cookieMap);

		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie.getValue());
//				System.out.println("cookie name : " + cookie.getName() + "\n cookie value :" + cookie.getValue() + "");
			}
		}
		if (cookieMap.get("lanId") == null || "".equals(cookieMap.get("lanId"))) {
			cookieMap.put("lanId", "CN");
		}

		return cookieMap;
	}

	public static void destroy() {
		cookies.remove();
	}

}
