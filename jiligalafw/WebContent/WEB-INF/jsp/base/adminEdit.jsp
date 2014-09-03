<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员信息编辑</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/autoheight.js"></script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
	function submitInfo() {
		if (checkRole()) {
			var reUserPassword = $("#reUserPassword").val().replace(/\s/g, "");
			var userPassword = $("#userPassword").val().replace(/\s/g, "");
			if ((reUserPassword != "")) {
				if (userPassword != reUserPassword) {
					$("#reUserPasswordMessage").html("两次密码不一致!");
					return;
				}
				document.getElementById("userPassword").value=reUserPassword;
			}
			/**
			var state = $("#state").val().replace(/\s/g, "");
			if(state==""){
				document.getElementById("state").value="3";
			}*/
			$("#basicUserVo").submit();
		} else {
			return false;
		}
		return true;
	}
	function checkRole() {
		var iframe = window.frames['roleFrame'];
		var allRole = iframe.document.getElementsByName("checkRole");
		var role = "";
		var tag = false;
		for ( var i = 0; i < allRole.length; i++) {
			if (allRole.item(i).checked) {
				tag = true;
				role = role + allRole.item(i).getAttribute("value") + ",";
				continue;
			}
		}
		if (tag) {
			$("#roleIds").val(role);
			return true;
		} else {
			alert("请选择一个角色!");
			return false;
		}
	}
	function checkEditOrUpdate() {
		var userAccount = $("#userAccount").val().replace(/\s/g, "");
		if (userAccount != "") {
			$("#userAccount").attr("readonly", "readonly");
			$("#userAccount").css("background","#E8F2FE");
		}

	}
	function back(){
		window.location="${ctx}/admin/list.do";
	}
</script>
</head>
<body onload="checkEditOrUpdate()">
	<form:form modelAttribute="basicUserVo" action="${ctx}/admin/save.do" method="post" name="adminEditForm" >

		<form:hidden path="roleIds" id="roleIds" />
		<form:errors path="errors" cssClass="commomError" />
		<form:hidden path="parentBasicUser.userId" id="pareUserId" value="${parentUserId}"/>
		<form:hidden path="userFlag" id="userFlag"  value="0"/>
	
		<table width="962" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center" valign="top" bgcolor="#F2F2F2">
					<table width="915" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="43" align="left" valign="middle"><span class="f18b2">管理员信息编辑</span></td>
							<td align="left" valign="middle">&nbsp;</td>
						</tr>
						<tr><td height="5" colspan="2"></td></tr>
						<tr>
							<td height="2" colspan="2" align="center" valign="middle">
								<img src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" />
							</td>
						</tr>
						<tr><td height="12" colspan="2"></td></tr>

						<tr>
							<td align="center" valign="top">
								<table height="290" border="0" cellpadding="0" cellspacing="0">
									<tr height="30">
										<td width="20"></td>
										<td width="100" align="left" class="f13_1"><form:label path="userAccount">用户名</form:label><span style="color: #ff0000">*</span>：</td>
										<td align="left"><form:input path="userAccount" class="text13" size="30" id="userAccount" /></td>
										<td align="left"><form:errors path="userAccount" cssClass="error" /></td>
									</tr>
									<tr height="30">
										<td width="20"></td>
										<td align="left" class="f13_1"><form:label path="userPassword">密码</form:label><span style="color: #ff0000">*</span>：</td>
										<td align="left"><form:input path="userPassword" class="text13" size="30" id="userPassword" type="password" /></td>
										<td align="left"><form:errors path="userPassword" cssClass="error" /></td>
									</tr>
									<tr height="30">
										<td width="20"></td>
										<td align="left" class="f13_1"><form:label path="reUserPassword">确认密码</form:label><span style="color: #ff0000">*</span>：</td>
										<td align="left"><form:input path="reUserPassword" class="text13" size="30" id="reUserPassword" type="password" /></td>
										<td align="left" style="color: red; font-size: 13px; height: 10px;" id="reUserPasswordMessage" /></td>
									</tr>
									<tr height="30">
										<td width="20"></td>
										<td align="left" class="f13_1"><form:label path="userName">名称</form:label><span style="color: #ff0000">*</span>：</td>
										<td align="left"><form:input path="userName" class="text13" size="30" id="userName" /></td>
										<td align="left"><form:errors path="userName" cssClass="error" /></td>
									</tr>
									<tr height="30">
										<td width="20"></td>
										<td align="left" class="f13_1"><form:label path="tel">联系电话</form:label><span style="color: #ff0000">*</span>：</td>
										<td align="left"><form:input path="tel" class="text13" size="30" id="tel" maxlength="12"/></td>
										<td align="left"><form:errors path="tel" cssClass="error" /></td>
									</tr>
									<tr height="30">
										<td width="20"></td>
										<td align="left" class="f13_1"><form:label path="state">状态</form:label><span style="color: #ff0000">*</span>：</td>
										<td align="left" class="f13_1"><form:radiobuttons path="state" items="${state}" id="state" checked="checked" cssStyle="margin-left:8px;" /></td>
										<td align="left"><form:errors path="state" cssClass="error" /></td>
									</tr>
									<tr height="110">
										<td width="20"></td>
										<td align="left" class="f13_1"><form:label path="remark">备注：</form:label></td>
										<td align="left" colspan="2"><form:textarea path="remark" class="text13" cols="65" rows="5" id="remark" /></td>
									</tr>
								</table>
							</td>
							<td align="right" valign="top"><img src="${ctx}/images/pic1.jpg" width="427" height="290" /></td>
						</tr>

						<tr>
							<td colspan="2" align="left" valign="top">
								<table border="0" cellspacing="0" cellpadding="0">
									<tr height="110">
										<td width="20"></td>
										<td width="80" align="left" valign="top" class="f13_1">角色<span style="color: #ff0000">*</span>：</td>
										<td align="left">
											<table width="700" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
												<tr bgcolor="#92b8c1" height="20">
													<td width="8%" align="center" class="f12">序号</td>
													<td width="25%" align="center" class="f12">角色名称</td>
													<td width="10%" align="center" class="f12">状态</td>
													<td width="47%" align="center" class="f12">功能说明</td>
													<td width="10%" align="center" class="f12">选择</td>
												</tr>
											</table>
											
											<iframe name="roleFrame" id="roleFrame" scrolling="auto" src="${ctx }/userRole/roleCheck.do?userId=${basicUserVo.userId}" height="145px" width="700px"></iframe>
										</td>
									</tr>
								</table>
							</td>
						</tr>

						<tr>
							<td height="14" colspan="2"></td>
						</tr>
						<tr>
							<td colspan="2" align="center" valign="middle">
								<table width="394" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="197" align="center" valign="top">
											<a href="#">
												<img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" align="middle" onclick="javascript:submitInfo();" />
											</a>
										</td>
										<td width="197" align="center" valign="top">
											<a href="#">
												<img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" align="middle" onclick="back();"/>
											</a>
										</td>
										<!--										
										<td width="197" align="center" valign="top">
											<a href="#">
												<img src="${ctx}/images/btnc1.png" alt="重置" width="101" height="30" border="0" align="middle" onclick="document.forms.adminEditForm.reset();return false;"/>
											</a>
										</td>
										-->
									</tr>
								</table>
							</td>
						</tr>
						<tr><td height="14" colspan="2"></td></tr>
						<tr>
							<td height="2" colspan="2" align="center" valign="middle"><img src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" /></td>
						</tr>
						<tr><td height="14" colspan="2"></td></tr>
					</table>
					
			</td>
		  </tr>
		</table>
		
	</form:form>
</body>
</html>