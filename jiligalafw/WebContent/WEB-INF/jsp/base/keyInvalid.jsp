<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="refresh" content="5;url=${ctx}/login/visit.do ;charset=utf-8" /> 
    <title>瑞云云计算门户系统</title>
    <link href="${ctx}/css/css_login.css" rel="stylesheet" />
    <link href="${ctx}/css/css_font.css" rel="stylesheet" />
    <link href="${ctx}/css/css_cycle.css" rel="stylesheet" />
    <style type="text/css">
	    <!--
		  body {
			  background-color: #000000;
			  margin-left: 0px;
			  margin-top: 0px;
			  margin-right: 0px;
			  margin-bottom: 0px;
		  }
		  p {
		  	font-family:"微软雅黑";
			color:red;
			font-size: 16px;
			font-weight:bold;
			line-height:16px;
		  }
      -->
    </style>
<script type="text/javascript"	src="${ctx}/widgets/jquery/jquery-1.4.3.min.js"></script>
<script type="text/javascript"	src="${ctx}/widgets/jquery/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript">

</script>
  </head>
  <body>
    <div id="header_bg"></div>
    <div id="middle_bg" style="height:300px">
      <div id="middle" style="height:300px">
        <div id="register">
  			<form:form  modelAttribute="userRegisterVo" action="${ctx}/base/userRegister/userInfoFill.do"  method="post">
    	    <table width="952" height="280" border="0" cellpadding="0" cellspacing="0" align="center">
				    <tr height="10" style="padding-top: 0px">
				    	<td></td>
				    	<td></td>
				    	<td class="f12" colspan="6" style="text-align: center">
							<p style="font-size: 13px;">链接已失效</p>
							<p style="font-size: 13px;">页面将在5秒后调整至登陆页面</p>
							<p style="font-size: 13px;"><a href="${ctx}/login/visit.do" style="color: red">如果页面未自动跳转，请点击此处</a></p>
				    	</td>
				    </tr>
				    <tr height="15"><td colspan="6"></td></tr>
          </table>
          </form:form>
        </div>
      </div>
    </div>
    <!-- middle -->
		<div>
			<jsp:include page="/commons/footUserReg.jsp"></jsp:include>
		</div>
  </body>
</html>
