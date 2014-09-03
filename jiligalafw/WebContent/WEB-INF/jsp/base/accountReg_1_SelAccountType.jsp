<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
    <title>账户注册-瑞云云计算门户系统</title>
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
      -->
    </style>
<script type="text/javascript"	src="${ctx}/widgets/jquery/jquery-1.4.3.min.js"></script>
<script type="text/javascript"	src="${ctx}/widgets/jquery/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript">
	
	function userReg(){
		$("#userRegisterVo").submit();
	}
   
</script>
  </head>
  <body>
    <div id="header_bg" ></div>
    <div id="middle_bg" style="height:300px">
      <div id="middle"  style="height:300px">
        <div id="register">
  			<form:form  modelAttribute="userRegisterVo" action="${ctx}/base/userRegister/accountInfoFill.do"  method="post">
    	    <table width="952" height="280" border="0" cellpadding="0" cellspacing="0" align="center">
				    <tr height="60px">
				    	<td width="2%" ></td>
				    	<td colspan="7" class="f18_1">注册成为瑞云浩天云计算门户系统账户</td>
				    </tr>
				    <tr height="40px">
				    	<td width="2%" ></td>
				    	<td width="2%" ></td>
				    	<td colspan="6" class="f16_2">
				    	  <span class="f16_3">1 账户类型选择</span>
				    	  &nbsp;&nbsp;&nbsp;&nbsp;》&nbsp;&nbsp;&nbsp;
				    	  2 资料填写
				    	  &nbsp;&nbsp;&nbsp;&nbsp;》&nbsp;&nbsp;&nbsp;
				    	  3 邮箱验证
				    	  &nbsp;&nbsp;&nbsp;&nbsp;》&nbsp;&nbsp;&nbsp;
				    	  4 完成注册
				    	</td>
				    </tr>
				    <tr height="25">
				    	<td><form:input path="invitationKey" type="hidden"  /></td>
				    	<td></td>
				    	<td class="f12" colspan="6" style="font-size:14px;font-weight:bold">
				    		<form:radiobutton path="userAccountType" value="zhengshi" /> 正式账户
				    	</td>
				    </tr>
				    
				    <tr height="25">
				    	<td></td>
				    	<td></td>
				    	<td class="f12" colspan="6" style="font-size:14px;font-weight:bold">
				    		<form:radiobutton path="userAccountType" value="shiyong"/>  试用账户
				    	</td>
				    </tr>

				    <tr height="35">
				    	<td></td>
				    	<td></td>
				    	<td class="f13" colspan="6" align="center">
			    			<img src="${ctx}/images/btns2.png" width="120" height="32" border="0" align="absmiddle"  onclick="javascript:userReg();" style="cursor: pointer;"/>&nbsp;
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
