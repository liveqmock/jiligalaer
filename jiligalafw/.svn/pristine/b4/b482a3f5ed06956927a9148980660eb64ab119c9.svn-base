<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<HEAD>
		<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.9.1.min.js"></script> 
</HEAD>
<body>
<%
	Exception exception = (Exception)request.getAttribute("exception");
	if(exception==null && request.getAttribute("javax.servlet.error.exception") instanceof Exception){
		exception = (Exception)request.getAttribute("javax.servlet.error.exception");
	}
	if(exception!=null)exception.printStackTrace();
	boolean isError = exception == null ? false : true;
	//System.out.println("wwwwwwwwwwwwwwwwwwwwww~~~~"+isError);
	if(isError){
	Throwable temp = exception.getCause();
	String login = "<a href=''>登录</a>";
	
%>	<font color="red" size="2">

	执行错误,请联系系统管理员.<br>
	<a href="javascript:history.go(-1);">返回</a><br>
	<%out.println("null".equals(exception.getMessage()) || exception.getMessage() == null ? ("请重新"+login) : exception.getMessage());
		String errorMessage = "";
	if(exception.getMessage().indexOf("org.springframework.web.HttpRequestMethodNotSupportedException") != -1 ||
			exception.getMessage().indexOf("org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException") != -1) {
		errorMessage = "系统错误!";
	} else {
		int index = exception.getMessage().indexOf("Exception:");
		errorMessage = exception.getMessage().substring((index != -1 ? (index+11) : 0));
	}
	int tempIndex = errorMessage.indexOf("Exception:");
	errorMessage = errorMessage.substring((tempIndex != -1 ? (tempIndex+11) : 0));
	%>
</font>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<font color="#FFFFFF">###PAGEERROR###<%=errorMessage %>###PAGEERROR###</font>
<br>
<font color="#FFFFFF">
	<%=exception %>
	   	<%
	   		
	  	 	while(temp != null && (temp = temp.getCause()) != null){
		   		if(temp != null){
		   			out.println("<p>");
					out.println(temp.getMessage());
		   			out.println("</p>");
		   		}
		} %>
<%}%>
</font>
</body>
</html>
