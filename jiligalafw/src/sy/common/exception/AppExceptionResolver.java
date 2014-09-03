package sy.common.exception;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class AppExceptionResolver implements HandlerExceptionResolver{
	
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
    	
    	if (ex instanceof AppRuntimeException) {
    		response.setContentType("text/html;charset=UTF-8");
    		PrintWriter out;
			try {
				String format = request.getParameter("format");
				if ("json".equalsIgnoreCase(format)) {
					// 返回错误文本
					out = response.getWriter();
		    		out.print(ex.getMessage());
				} else {
					// 输出错误页面
					request.setAttribute("msg", ex.getMessage());
					request.getRequestDispatcher("commons/authMsg.jsp").forward(request, response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
    		return new ModelAndView();
    	}
    	
    	return null;
    }
}
