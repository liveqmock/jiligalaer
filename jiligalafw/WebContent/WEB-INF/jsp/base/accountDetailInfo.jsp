<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户资料编辑</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/IdCardValidate.js"></script>
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
		var userIdentityState = $("#userIdentityState").val().replace(/\s/g, "");
		var companyName = $("#companyName").val().replace(/\s/g, "");
		var businessLicense = $("#businessLicense").val().replace(/\s/g, "");
		var businewssOrgCode = $("#businewssOrgCode").val().replace(/\s/g, "");
		var taxCode = $("#taxCode").val().replace(/\s/g, "");
		var identityCard = $("#identityCard").val().replace(/\s/g, "");
		if(userName ==''){
			alert("账户姓名不能为空!");
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
		
		if(userIdentityState =='gongsiidentity'){
			if(companyName==''){
				alert("公司名称不能为空!");
				return;
			}
			if(businewssOrgCode==''){
				alert("企业组织机构代码不能为空!");
				return;
			}
			if(taxCode==''){
				alert("税务登记证不能为空!");
				return;
			}
			if(businessLicense==''){
				alert("营业执照号不能为空!");
				return;
			}	
			
		}else{
			if(identityCard==''){
				alert("身份证号不能为空!");
				return;
			}
			if(!IdCardValidate(identityCard)){
				alert("身份证号填写错误");
				return;
			}
			if(identityCard.length == 15){
				$("#userBrithday").val("");
				$("#userBrithday").val('19'+identityCard.substring(6,8)+'-'+identityCard.substring(9,11)+'-'+identityCard.substring(12,14));
			}else{
				$("#userBrithday").val(identityCard.substring(6,10)+'-'+identityCard.substring(10,12)+'-'+identityCard.substring(12,14));
			}
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
			//alert("账户姓名不能为空!");
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
			alert("旧密码输入错误!");
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
			alert("两次新密码不一致!");
			return;
		}
		document.getElementById("password").value=reUserPassword;
		var form = document.forms.basicUserVoForm;
		form.action="${ctx}/account/saveInfo.do?passwrodSave=1";
		form.submit();
		return true;
	}
	function checkAccountIndetity(){
		var userIdentityId = '${userIdentityId}';
		if(userIdentityId == 'gongsiidentity'){
			document.getElementById('gongsi1').style.display = '';
			document.getElementById('gongsi2').style.display = '';
			document.getElementById('gongsi3').style.display = '';
			document.getElementById('geren').style.display = 'none';
		}else{
			document.getElementById('gongsi1').style.display = 'none';
			document.getElementById('gongsi2').style.display = 'none';
			document.getElementById('gongsi3').style.display = 'none';
			document.getElementById('geren').style.display = '';
		}
	}
</script>
<script type="text/javascript">
var msg = '${accountMsg}';
if(msg!=''){
	alert(msg);
	window.parent.parent.parent.close();
}
</script>
</head>
<body onLoad="checkAccountIndetity()">
<form:form modelAttribute="basicUserVo" action="${ctx}/account/saveInfo.do" method="post" name="basicUserVoForm" enctype="multipart/form-data">
	<form:hidden path="userPassword" id="password" />
	<form:hidden path="state" />
	<form:hidden path="userIdentityDictItem.dictItemId" id="userIdentityState" />

	  <table width="962" height="660" border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_1.png" width="9" height="9" /></td>
          <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_2.png"></td>
          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_3.png" width="9" height="9" /></td>
        </tr>
        <tr>
          <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_4.png"></td>
          <td align="center"  valign="top" bgcolor="#ffffff">

			<table align="center" width="915" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td height="45" align="center" valign="middle"><span class="f18b2">账户信息编辑</span></td>
				</tr>
				<tr>
					<td height="2" align="center" valign="middle"><hr /></td>
				</tr>
				<tr>
					<td align="left" height="15"><form:errors path="errors" cssClass="commomError" /></td>
				</tr>

				<tr>
				  <td valign="top">
					<fieldset>
						<legend><span class="f14b2">基本资料</span></legend>
						<table width="100%" height="290" border="0" cellpadding="0" cellspacing="0">
							<tr height="30">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1"><form:label path="userAccount">账户名</form:label><span style="color: #ff0000">*</span>：</td>
								<td align="left" class="f12_1"><form:input path="userAccount" class="text13" readonly="true" style="background-color:#E8F2FE;" size="30" id="userAccount" /></td>
								<td align="left" class="f12_1"><form:errors path="userAccount" cssClass="error" /></td>
								<td align="left" colspan="4"></td>
							</tr>
							<tr height="30">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1"><form:label path="userName">姓名</form:label><span style="color: #ff0000">*</span>：</td>
								<td align="left" class="f12_1"><form:input path="userName" class="text13" size="30" id="userName" /></td>
								<td align="left" style="color: red; font-size: 13px; height: 10px;" id="userNameMessage" /></td>
								<td width="130" align="right" class="f12_1">账户身份：</td>
								<td align="left" class="f12_1">${userIdentity}</td>
								<td align="left"></td>
							</tr>
							
							<tr height="30">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1">行业：</td>
								<td align="left" class="f12_1">
									<form:select path="geoDictItem.dictItemId" cssStyle="width:102px;">
									     <form:option value="" label="--请选择--"/>
									     <form:options items="${geoDictItemMap}" />
									</form:select>								
								</td>
								<td align="left"><form:errors path="geoDictItem.dictItemId" cssClass="error" /></td>
								<td width="130" align="right" class="f12_1">地区：</td>
								<td align="left" class="f12_1">
									<form:select path="industryDictItem.dictItemId" cssStyle="width:110px;">
								     	<form:option value="" label="--请选择--"/>
								     	<form:options items="${industryDictItemMap}" />
									</form:select>								
								</td>
								<td align="left"><form:errors path="industryDictItem.dictItemId" cssClass="error" /></td>
							</tr>							
							<tr height="30">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1"><form:label path="birthDate">出生日期：</form:label></td>
								<td align="left" class="f12_1">
									<%--
									<form:input path="birthDate" class="date_but" size="30" onfocus="WdatePicker()" readonly="true" id="userBrithday" />
									--%>
									<form:input path="birthDate" class="date_but" size="30" readonly="true" id="userBrithday" />
								</td>
								<td align="left" class="f12_1"><form:errors path="birthDate" cssClass="error" /></td>
								<td width="130" align="right" class="f12_1"><form:label path="tel">联系电话</form:label><span style="color: #ff0000">*</span>：</td>
								<td align="left" class="f12_1"><form:input path="tel" class="text13" size="15" id="tel" maxlength="12"/></td>
								<td align="left" style="color: red; font-size: 13px; height: 10px;" id="telMessage" /></td>
							</tr>
							<tr height="30" id="gongsi1">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1"><form:label path="companyName">公司名称</form:label><span style="color: #ff0000">*</span>：</td>
								<td align="left" class="f12_1"><form:input path="companyName" class="text13" size="30" id="companyName" /></td>
								<td align="left" style="color: red; font-size: 13px; height: 10px;" id="companyNameMessage" /></td>
								<td width="130" align="right" class="f12_1"><form:label path="businewssOrgCode">企业组织机构代码</form:label><span style="color: #ff0000">*</span>：</td>
								<td align="left"><form:input path="businewssOrgCode" class="text13" size="30" id="businewssOrgCode" /></td>
								<td align="left" style="color: red; font-size: 13px; height: 10px;" id="businewssOrgCodeMessage" /></td>
							</tr>
							<tr height="30" id="gongsi3">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1"><form:label path="businessLicense">营业执照号</form:label><span style="color: #ff0000">*</span>：</td>
								<td align="left" class="f12_1"><form:input path="businessLicense" class="text13" size="30" id="businessLicense" /></td>
								<td align="left" style="color: red; font-size: 13px; height: 10px;" id="businessLicenseMessage" /></td>
								<td width="130" align="right" class="f12_1"><form:label path="taxCode">税务登记证</form:label><span style="color: #ff0000">*</span>：</td>
								<td align="left" class="f12_1"><form:input path="taxCode" class="text13" size="30" id="taxCode" /></td>
								<td align="left" style="color: red; font-size: 13px; height: 10px;" id="taxCodeMessage" /></td>
							</tr>							
							<tr height="30" id="gongsi2">
								<td width="20"></td>
								<td align="right" class="f12_1">公司LOGO：</td>
								<td align="left" class="f12_1"><input type="file" name="companyLogoFile" size="30"></input></td>
								<td align="left" colspan="4"></td>
							</tr>
	
							<tr height="30" id="geren">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1"><form:label path="identityCard">身份证号</form:label><span style="color: #ff0000">*</span>：</td>
								<td align="left"><form:input path="identityCard" class="text13" size="30" id="identityCard" /></td>
								<td align="left" style="color: red; font-size: 13px; height: 10px;" id="identityCardMessage" /></td>
								<td align="left" colspan="3"></td>
							</tr>
							<tr height="30">
								<td width="20"></td>
								<td align="right" class="f12_1"><form:label path="remark">备注：</form:label></td>
								<td align="left" colspan="5" class="f12_1"><form:textarea path="remark" class="text13" cols="105" rows="3" id="remark" /></td>
							</tr>
							<%--
							<tr height="30">
								<td width="20"></td>
								<td align="right" class="f12_1">状态：</td>
								<td align="left" colspan="5" class="f12_1">${stateName}</td>
							</tr>
							--%>
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
						<table border="0" cellpadding="0" cellspacing="0" align="center">
							<tr height="30">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1">账户名：</td>
								<td align="left" class="f12_1">${userAccountShow}</td>
								<td align="left"></td>
							</tr>
							<!--
							<tr height="30">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1">角色类型：</td>
								<td align="left" class="f12_1">${roleName}</td>
								<td align="left"></td>
							</tr>
							-->
							<tr height="30">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1">旧密码<span style="color: #ff0000">*</span>：</td>
								<td align="left" class="f12_1"><input type="password" id="oldpassword" /></td>
								<td align="left" style="color: red; font-size: 13px; height: 10px;" id="oldPasswordMessage" /></td>
							</tr>
							<tr height="30">
								<td width="20"></td>
								<td width="130"  align="right" class="f12_1">新密码<span style="color: #ff0000">*</span>：</td>
								<td align="left" class="f12_1"><input type="password" id="newpassword" /></td>
								<td align="left" style="color: red; font-size: 13px; height: 10px;" id="newPasswordMessage" /></td>
							</tr>
							<tr height="30">
								<td width="20"></td>
								<td width="130" align="right" class="f12_1">确认新密码<span style="color: #ff0000">*</span>：</td>
								<td align="left" class="f12_1"><input type="password" id="repassword" /></td>
								<td align="left"style="color: red; font-size: 13px; height: 10px;" id="reUserPasswordMessage" /></td>
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
				<tr>
					<td height="14" ></td>
				</tr>
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