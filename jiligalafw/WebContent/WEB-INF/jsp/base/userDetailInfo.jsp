<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息编辑</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/autoheight.js"></script>
<style type="text/css">
body {
	background-color: #000000;
	margin-left: 0px;
	margin-top: 10px;
	margin-right: 0px;
	margin-bottom: 10px;
}
form {
	margin: 0px;
	padding: 0px;
}
</style>
<script type="text/javascript">
	function submitInfo() {
		var userName = $("#userName").val().replace(/\s/g, "");
		var tel = $("#tel").val().replace(/\s/g, "");
		if(userName ==''){
			alert("用户姓名不能为空!");
			return;
		}
		if(tel ==''){
			alert("联系电话不能为空!");
			return;
		}
		if(!checkTel(tel)){
			alert("请填写正确的联系电话。\n例如：13911884488 或 010-36880728");
			return;
		}
	  	$("#basicUserVo").submit();
	  	return true;
	}
	function submitPassInfo() {
		var userName = $("#userName").val().replace(/\s/g, "");
		var tel = $("#tel").val().replace(/\s/g, "");
		
		var reUserPassword = $("#repassword").val().replace(/\s/g, "");
		var newPassword = $("#newpassword").val().replace(/\s/g, "");
		var oldPassword = $("#oldpassword").val().replace(/\s/g, "");
		var password = $("#password").val().replace(/\s/g, "");
		if(userName ==''){
			//alert("用户名不能为空!");
			//return;
		}
		if(tel ==''){
			//alert("联系电话不能为空!");
			//return;
		}
		
		if(oldPassword ==''){
			alert("旧密码不能为空!");
			return;
		}
		if (password != oldPassword) {
			alert("旧密码不正确!");
			return;
		}		
		if(newPassword ==''){
			alert("新密码不能为空!");
			return;
		}
		if(reUserPassword ==''){
			alert("确认新密码不能为空!");
			return;
		}
		if (reUserPassword != newPassword) {
			alert("两次新密码不符!");
			return;
		}
		document.getElementById("password").value=reUserPassword;
		var form = document.forms.basicUserVoForm;
		form.action="${ctx}/user/saveInfo.do?passwrodSave=1";
		form.submit();
		
		return true;
}
	
</script>
<script type="text/javascript">
var msg = '${userMsg}';
if(msg!=''){
	alert(msg);
	window.parent.parent.parent.close();
}
</script>
</head>
<body >
<form:form modelAttribute="basicUserVo" action="${ctx}/user/saveInfo.do" method="post" name="basicUserVoForm">
	<form:hidden path="userPassword"  id="password"/>
	<form:hidden path="state" />
	<form:hidden path="userId" />
	

	  <table width="962" height="568" border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_1.png" width="9" height="9" /></td>
          <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_2.png"></td>
          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_3.png" width="9" height="9" /></td>
        </tr>
        <tr>
          <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_4.png"></td>
          <td align="center" valign="top" bgcolor="#ffffff">
					<table width="915" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="45" align="center" valign="middle"><span class="f18b2">用户信息编辑</span></td>
							<td align="left" valign="middle">&nbsp;</td>
						</tr>
                        
                        <tr>
							<td height="2"  align="center" valign="middle">
								<hr />
							</td>
						</tr>
						<tr><td height="15" ><form:errors path="errors" cssClass="commomError" /></td></tr>

						<tr>
						  <td align="left" valign="top">
							<fieldset>
								<legend><span class="f14b2">基本资料</span></legend>
								<table border="0" cellpadding="0" cellspacing="0">
									<tr height="30">
										<td width="20"></td>
										<td width="130" align="right" class="f12_1"><form:label path="userAccount">用户名</form:label><span style="color: #ff0000">*</span>：</td>
										<td align="left" class="f12_1"><form:input path="userAccount" class="text13" readonly="true" style="background-color:#E8F2FE;" size="30" id="userAccount" /></td>
										<td align="left" class="f12_1"><form:errors path="userAccount" cssClass="error" /></td>
										<td width="130" align="right" class="f12_1"><form:label path="userName">姓名</form:label><span style="color: #ff0000">*</span>：</td>
										<td align="left" class="f12_1"><form:input path="userName" class="text13" size="30" id="userName" /></td>
										<td align="left" style="color: red; font-size: 13px; height: 10px;" id="userNameMessage" /></td>									
									</tr>
									<tr height="30">
										<td width="20"></td>
										<td width="130" align="right" class="f12_1"><form:label path="birthDate">出生日期：</form:label></td>
										<td align="left"><form:input path="birthDate" class="date_but" size="30" onfocus="WdatePicker()" readonly="true" id="userBrithday" /></td>
										<td align="left" class="f12_1"><form:errors path="birthDate" cssClass="error" /></td>
										<td width="130" align="right" class="f12_1"><form:label path="tel">联系电话</form:label><span style="color: #ff0000">*</span>：</td>
										<td align="left" class="f12_1"><form:input path="tel" class="text13" size="30" id="tel" maxlength="12"/></td>
									    <td align="left" style="color: red; font-size: 13px; height: 10px;" id="telMessage" /></td>
									</tr>
									<tr height="30">
									<td width="20"></td>
										<td align="right" class="f12_1"><form:label path="remark">备注：</form:label></td>
										<td align="left" class="f12_1"colspan="5"><form:textarea path="remark" class="text13" cols="95" rows="3" id="remark" /></td>
									</tr>
									<!--
									<tr height="30">
										<td width="20"></td>
										<td align="right" class="f12_1">状态：</td>
										<td align="left" class="f12_1"colspan="5">${stateName}</td>
									</tr>
									-->
								</table>
							</fieldset>
						  </td>
						</tr>
						
						<tr>
							<td align="center" valign="middle" height="60">
								<table width="394" border="0" cellspacing="0" cellpadding="0" height="60">
									<tr>
										<td width="100%" align="center">
											<a href="#">
												<img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" align="absmiddle" onclick="javascript:submitInfo();" />
											</a>
											&nbsp;
											<a href="javascript:window.parent.parent.close();"><img src="${ctx}/images/btn8.png" alt="关闭" width="101" height="30" border="0" align="absmiddle"/></a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						
						<tr>
							<td height="20"></td>
						</tr>
										
						<tr>
						  <td>
						  	<fieldset>
								<legend><span class="f14b2">修改密码</span></legend>
								<table border="0" align="center" cellpadding="0" cellspacing="0">
									<tr height="30">
										<td width="20"></td>
										<td width="100" align="right" class="f12_1">用户名：</td>
										<td align="left" class="f12_1">${userAccountShow}</td>
										<td align="left"></td>
									</tr>
									<!--
									<tr height="30">
										<td width="20"></td>
										<td align="right" class="f12_1">角色类型：</td>
										<td align="left" class="f12_1">${roleName}</td>
										<td align="left"></td>
									</tr>
									-->
									<tr height="30">
										<td width="20"></td>
										<td width="100"  align="right" class="f12_1">旧密码<span style="color: #ff0000">*</span>：</td>
										<td align="left" class="f12_1"><input type="password" id="oldpassword" /></td>
										<td align="left" style="color: red; font-size: 13px; height: 10px;" id="oldPasswordMessage" /></td>
									</tr>
									<tr height="30">
										<td width="20"></td>
										<td width="100"  align="right" class="f12_1">新密码<span style="color: #ff0000">*</span>：</td>
										<td align="left" class="f12_1"><input type="password" id="newpassword" /></td>
										<td align="left" style="color: red; font-size: 13px; height: 10px;" id="newPasswordMessage" /></td>
									</tr>
									<tr height="30">
										<td width="20"></td>
										<td width="100"  align="right" class="f12_1">确认新密码<span style="color: #ff0000">*</span>：</td>
										<td align="left" class="f12_1"><input type="password" id="repassword" /></td>
										<td align="left" style="color: red; font-size: 13px; height: 10px;" id="reUserPasswordMessage" /></td>
									</tr>
								</table>
							</fieldset>
						  </td>
						</tr>
						
						<tr>
							<td align="center" valign="middle" height="60">
								<table width="394" border="0" cellspacing="0" cellpadding="0" height="60">
									<tr>
										<td width="100%" align="center">
											<a href="#">
												<img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" align="middle" onclick="javascript:submitPassInfo();" />
											</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>

						<tr><td height="102" ></td></tr>
					</table>
					
          </td>
          <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_5.png"></td>
        </tr>
        <tr>
         <td align="left" valign="top"><img src="${ctx}/images/sheet_border_6.png" width="9" height="9" /></td>
         <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_7.png"></td>
         <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_8.png" width="9" height="9" /></td>
       </tr>
	</table>

	</form:form>
</body>
</html>