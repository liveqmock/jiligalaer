<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="favicon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
-->
</style>
<script type="text/javascript"
	src="${ctx}/widgets/jquery/jquery-1.4.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/widgets/jquery/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$('#slider').nivoSlider();
	});
	$(function() {
		$("#userAccount").focus();
	});
	
	function refreshimg(object) {
		var d = new Date();
		object.src = '${ctx}/commons/image.jsp?' + d.toString(38);
		$("#rand").focus();
	}
	function login(){
		$("#loginVo").submit();
	}
	function isInteger(obj) {
		reg = /^[-+]?\d+$/;
		if (!reg.test(obj)) {
			$("#warnMessage").html("验证码不符合!");
		}
	}
	function changeImg() {
		$("#imageCode").click();
	}
	//按回车键触发提交
document.onkeydown = function(e) {
	var event = window.event || e;
	if (event.keyCode == 13) {
		 login();
	}
};
   function display(){
	   var activateFlag = '${activateFlag}';
		if (activateFlag == '1') {
			document.getElementById('activation').style.display ='block';
		}
   }
</script>
</head>
<body  onLoad="display();">
	<div id="header_bg"></div>
	<div id="middle_bg">
		<div id="middle">
			<div id="wrapper">
				<div id="slider-wrapper">
					<div id="slider" class="nivoSlider">
						<a href="#" target="_blank"><img
							src="${ctx}/images/news/1.jpg" width="520" height="305" alt=""
							title="" /></a> <a href="#" target="_blank"><img
							src="${ctx}/images/news/2.jpg" width="520" height="305" alt=""
							title="" /></a> <a href="#" target="_blank"><img
							src="${ctx}/images/news/3.jpg" width="520" height="305" alt=""
							title="" /></a> <a href="#" target="_blank"><img
							src="${ctx}/images/news/4.jpg" width="520" height="305" alt=""
							title="" /></a>
					</div>
				</div>
			</div>
			<div id="login">
		      <form:form modelAttribute="loginVo" action="${ctx}/login/excute.do" method="post">
		            <span style="display:block;height:20px;color: red;"  class="f13_4" ><form:errors path="errors" /></span>
		            <span style="display:none;height:20px;"  class="f13_4" id="activation" ><a href="${ctx}/change/forgotPass.do?activationFlag=1" id="activation" style="color: red;">进入激活邮箱...</a>    </span> 
		     		<table width="330" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="30" align="left" valign="middle"><img src="${ctx}/images/ico1.png" width="23" height="26" /></td>
						<td width="50" align="right" valign="middle" class="f13">
							<form:label path="userAccount">用户名:</form:label>
						</td>
						<td colspan="2" align="left" valign="middle" colspan="2">
							<form:input path="userAccount" type="text" class="text13" size="22" />
				      	</td>
				      	<td width="88" align="left" class="f13_4" style=" font-family: '微软雅黑';font-size:12px; color: red;"><form:errors path="userAccount" /></td>
					</tr>
					<tr>
						<td height="18" colspan="5"></td>
					</tr>
					<tr>
						<td align="left" valign="middle"><img src="${ctx}/images/ico2.png" width="24" height="24" /></td>
						<td align="right" valign="middle" class="f13">
							<form:label path="userPassword">密&nbsp;&nbsp;&nbsp;码:</form:label>
						</td>
						<td align="left" valign="middle" colspan="2">
							<form:input path="userPassword" type="password" class="text13" size="22" />
				     	</td>
				     	<td align="left" class="f13_4" style=" font-family: '微软雅黑';font-size:12px; color: red;"><form:errors path="userPassword" /></td>
					</tr>
					<tr>
					   <td height="18" colspan="5"></td>
					</tr>
					<tr>
						<td align="left" valign="middle"><img src="${ctx}/images/ico3.png" width="24" height="21" /></td>
						<td align="right" valign="middle" class="f13"><form:label path="rand">验证码:</form:label></td>
						<td width="100" ><form:input path="rand" type="text" class="text13" size="12"  id="rand" maxlength="4"/></td>
						<td width="64" align="left" valign="middle">
							&nbsp;<img id="imageCode" src="${ctx}/commons/image.jsp" style="padding-top:3px;width:57px;cursor:pointer;" height="24" border="0" alt="点击更换验证码" onclick="javascript:refreshimg(this);" />
						</td>
						<td class="f13_4" style=" font-family: '微软雅黑';font-size:12px; color: red;"><form:errors path="rand" /></td>
					</tr>
					<tr>
						<td height="30" colspan="5" ></td>
					</tr>
					<tr>
						<td align="center" valign="middle" colspan="2" ><a href="${ctx}/change/forgotPass.do" class="f12">忘记密码?</a></td>
						<td colspan="2" align="center" >
							<a href="javascript:void(0)">
								<img id="clickLogin" src="${ctx}/images/btn1.png" width="120" height="32" border="0" align="middle" onclick="javascript:login();"/>
							</a>
						</td>
						<td class="f13_4">&nbsp;</td>
					</tr>
				</table>
				</form:form>
			</div>
			<div id="signup">
				<img src="${ctx}/images/ico4.png" width="24" height="21" /> <span
					class="f18">还没有账户？</span>&nbsp;<a href="${ctx}/base/userRegister/selectAccountType.do" target="_blank" class="f12">立即注册 》</a>
			</div>
		</div>
	</div>
	<!-- middle -->
	<div id="bottom_bg">
		<div id="bottom">
			<div id="bottom_social">
				<div id="bottom_social_pics">
					<a href="#"><img src="${ctx}/images/social1.jpg" width="65"
						height="65" border="0" align="absmiddle" /></a><br />
					<a href="#" class="f14" style="text-decoration: none;">官方微博</a>
				</div>
				<div id="bottom_social_pics">
					<a href="#"><img src="${ctx}/images/social2.jpg" width="65"
						height="65" border="0" align="absmiddle" /></a><br />
					<a href="#" class="f14" style="text-decoration: none;">官方博客</a>
				</div>
				<div id="bottom_social_pics">
					<a href="#"><img src="${ctx}/images/social3.jpg" width="65"
						height="65" border="0" align="absmiddle" /></a><br />
					<a href="#" class="f14" style="text-decoration: none;">官方论坛</a>
				</div>
			</div>
			<div id="bottom_service">
				<table width="518" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="63" rowspan="3"><div align="center">
								<img src="${ctx}/images/line1.jpg" width="2" height="112" />
							</div></td>
						<td width="24" height="40" align="left" valign="middle"><img
							src="${ctx}/images/ico5.jpg" width="19" height="21" /></td>
						<td width="67" align="left" valign="middle" class="f16">服务热线</td>
						<td width="174" class="f20">400-800-6666</td>
						<td width="190" class="f20">010-66669999</td>
					</tr>
					<tr>
						<td height="35" align="left" valign="middle"><img
							src="${ctx}/images/ico6.jpg" width="19" height="19" /></td>
						<td align="left" valign="middle" class="f16">在线客服</td>
						<td><img src="${ctx}/images/ico7.jpg" width="21" height="22" />
							<a href="#"><img src="${ctx}/images/ico11.jpg" width="64"
								height="22" border="0" align="absmiddle" /></a> <a href="#"><img
								src="${ctx}/images/ico12.jpg" width="63" height="22" border="0"
								align="absmiddle" /></a></td>
						<td><img src="${ctx}/images/ico9.jpg" width="46" height="22" />
							<a href="#"><img src="${ctx}/images/ico11.jpg" alt=""
								width="64" height="22" border="0" align="absmiddle" /></a> <a
							href="#"><img src="${ctx}/images/ico12.jpg" width="63"
								height="22" border="0" align="absmiddle" /></a></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td><img src="${ctx}/images/ico8.jpg" width="21" height="22" />
							<a href="#"><img src="${ctx}/images/ico11.jpg" alt=""
								width="64" height="22" border="0" align="absmiddle" /></a> <a
							href="#"><img src="${ctx}/images/ico12.jpg" width="63"
								height="22" border="0" align="absmiddle" /></a></td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			<div id="links">
				<a href="#"><img src="${ctx}/images/links/linkpic1.jpg" alt=""
					border="0" align="absmiddle" /></a> <a href="#"><img
					src="${ctx}/images/links/linkpic2.jpg" alt="" border="0"
					align="absmiddle" /></a> <a href="#"><img
					src="${ctx}/images/links/linkpic3.jpg" alt="" border="0"
					align="absmiddle" /></a> <a href="#"><img
					src="${ctx}/images/links/linkpic4.jpg" alt="" border="0"
					align="absmiddle" /></a> <a href="#"><img
					src="${ctx}/images/links/linkpic1.jpg" alt="" border="0"
					align="absmiddle" /></a> <a href="#"><img
					src="${ctx}/images/links/linkpic2.jpg" alt="" border="0"
					align="absmiddle" /></a> <a href="#"><img
					src="${ctx}/images/links/linkpic3.jpg" alt="" border="0"
					align="absmiddle" /></a>
			</div>
		</div>
		<!-- bottom-->
	</div>
	<!-- bottom bg-->
	<div id="footer" style="width:100%;">
		<div class="f12" id="footer_nav">
			<a href="#" class="f12">政策法规</a>&nbsp;&nbsp;| &nbsp;&nbsp; <a
				href="#" class="f12">隐私政策</a>&nbsp;&nbsp;| &nbsp;&nbsp; <a href="#"
				class="f12">使用条款</a>&nbsp;&nbsp;| &nbsp;&nbsp; <a href="#"
				class="f12">帮助</a>
		</div>
		<div class="f12" id="footer_content">©2013-2014 RA Systems,Inc.
			保留所有权</div>
	</div>
</body>
</html>
