<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户信息编辑</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/IdCardValidate.js"></script>
<script type="text/javascript"
	src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/autoheight.js"></script>
<style type="text/css">
body {
	background-color: #ffffff;
	margin-left: 10px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function submitInfo() {
	document.getElementById("userName1").value = window.parent.document.getElementById("userName").value;
	document.getElementById("userAccount1").value = window.parent.document.getElementById("userAccount").value;
	var userIdentity = window.parent.document.getElementsByName("userIdentityDictItem.dictItemId");
	for ( var i = 0; i < userIdentity.length; i++) {
		if (userIdentity.item(i).checked) {
			document.getElementById("userIdentity1").value = userIdentity.item(i).value;
		}
	}
	var userType = window.parent.document.getElementsByName("userTypeDictItem.dictItemId");
	for ( var i = 0; i < userType.length; i++) {
		if (userType.item(i).checked) {
			document.getElementById("userType1").value = userType.item(i).value;
		}
	}
	var state = window.parent.document.getElementsByName("state");
	for ( var i = 0; i < state.length; i++) {
		if (state.item(i).checked) {
			document.getElementById("state1").value = state.item(i).value;
		}
	}
	if(document.getElementById("userAccount1").value == ''){
		alert("请填写账户名!");
		return ;
	}
	if(!checkEmail($("#userAccount1").val())){
		alert("提示\n账户名必须为E_mail地址，请输入有效的E_mail!");
		return;
	}
	if(document.getElementById("userName1").value == ''){
		alert("请填写姓名!");
		return ;
	}
	if(document.getElementById("userType1").value == ''){
		alert("请选择账户类别!");
		return ;
	}
	if(document.getElementById("userIdentity1").value == ''){
		alert("请选择账户类型!");
		return ;
	}
	if(document.getElementById("tel").value == ''){
		alert("请填写联系电话!");
		return;
	}
	if(!checkTel(document.getElementById("tel").value)){
		alert("请填写正确的联系电话。\n例如：13911884488 或 010-36880728");
		return;		
	}
	
	if(document.getElementById("userIdentity1").value=='gongsiidentity'){
		var companyName = $("#companyName").val().replace(/\s/g, "");
		var businessLicense = $("#businessLicense").val().replace(/\s/g, "");
		var taxCode = $("#taxCode").val().replace(/\s/g, "");
		var businewssOrgCode = $("#businewssOrgCode").val().replace(/\s/g, "");
		if(companyName ==''){
			alert("请填写公司名称!");
			return ;
		}
		if(businessLicense ==''){
			alert("请填写营业执照号!");
			return ;
		}
		if(businewssOrgCode ==''){
			alert("请填写企业组织机构代码!");
			return ;
		}
		if(taxCode ==''){
			alert("请填写税务登记证!");
			return ;
		}
	}else{
		var identityCard = $("#identityCard").val().replace(/\s/g, "");
		if(identityCard ==''){
			alert("请填写身份证号!");
			return ;
		}
		if(!IdCardValidate(identityCard)){
			alert("身份证号填写错误");
			return;
		}
		/**
	    var checkFlag = new clsIDCard(identityCard);    
	    if(!checkFlag.IsValid()){ 
	      	alert("身份证号填写错误"); 
	      	return; 
	    }
		*/
	}
	if(document.getElementById("state1").value == ''){
		alert("请选择状态!");
		return ;
	}
	var reUserPassword = $("#reUserPassword").val().replace(/\s/g, "");
	var userPassword = $("#userPassword").val().replace(/\s/g, "");
	if(userPassword == ''){
		alert("请输入密码!");
		return ;
	}
	if(reUserPassword == ''){
		alert("请输入确认密码!");
		return ;
	}
	if ((reUserPassword != "")) {
		if (userPassword != reUserPassword) {
			$("#reUserPasswordMessage").html("两次密码不一致!");
			return false;
		}
		document.getElementById("userPassword").value=reUserPassword;
	}
	
	$("#userVo").submit();
	return true;
}

/**
$("#identityCard").blur(function(event){ 
    var idCard = $(this).val(); 
    var checkFlag = new clsIDCard(idCard);    
    if(!checkFlag.IsValid()){ 
      alert("身份证号错误"); 
      return false; 
    }else{ 
      //alert( "出生于: " + checkFlag.GetBirthDate() +" 地区:" + checkFlag.GetLocal() +" sex:" + checkFlag.GetSex() ); 
    }     
});
*/
 
function checkUserIdentity() {
	var userIdentity = window.parent.document.getElementsByName("userIdentityDictItem.dictItemId");
	for ( var i = 0; i < userIdentity.length; i++) {
		if (userIdentity.item(i).checked) {
			var val = userIdentity.item(i).value;
			if (val == "gongsiidentity") {
				document.getElementById("tr_identityCard").style.display="none";
 	 			document.getElementById("tr_gongsi1").style.display="";
 	 			document.getElementById("tr_gongsi2").style.display="";
 	 			document.getElementById("tr_gongsi3").style.display="";
 	 			document.getElementById("tr_gongsi4").style.display="";
 	 			document.getElementById("tr_gongsi5").style.display="";
			} else {
				document.getElementById("tr_identityCard").style.display="";
 		 		document.getElementById("tr_gongsi1").style.display="none";
 	 			document.getElementById("tr_gongsi2").style.display="none";
 	 			document.getElementById("tr_gongsi3").style.display="none";
 	 			document.getElementById("tr_gongsi4").style.display="none";
 	 			document.getElementById("tr_gongsi5").style.display="none";
			}
		}
	}
}

function checkRole() {
	var allRole = window.parent.document.getElementsByName("checkRole");
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
function back(){
	var obj = window.parent;
	obj.location="${ctx}/account/list.do";
}

var msg='${saveMsg}';
if(msg != ''){
	alert(msg);
	back();
}
</script>
</head>
<body  onload="checkUserIdentity()">
	<form:form modelAttribute="basicUserVo" action="${ctx}/account/save.do"  enctype="multipart/form-data" method="post" id="userVo">
		
	<form:hidden path="roleIds" id="roleIds" value="${roleIds}"/>
		<form:hidden path="userName" id="userName1" />
		 <form:hidden path="userFlag" value="1" />
		<form:hidden path="userAccount" id="userAccount1" />
		<form:hidden path="userIdentityDictItem.dictItemId" id="userIdentity1" />
		<form:hidden path="userTypeDictItem.dictItemId" id="userType1" />
		<form:hidden path="state" id="state1" />
		<form:errors path="errors" cssClass="commomError" />
	


		<div id="middle_sheet_content" style="width: 805px;">
			<table width="805" border="0" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
				<tr>
					<td align="left" valign="top" bgcolor="#ffffff">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr  bgcolor="#ffffff">
								<td align="center" valign="top">
									<table width="100%" height="290" border="0" cellpadding="0" cellspacing="0" align="left">
										<tr height="30" bgcolor="#deecef">
											<td width="2%"></td>
											<td width="15%" align="left" class="f12_1"><form:label path="userPassword">密码</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left">
									    	  <table align="left" width="100%" border="0" cellspacing="1" cellpadding="0" bordercolor="#cccccc" style='margin:0px; padding:0px;display:inline;'>
											    <tr align="left" bgcolor="#eeeeee" style="height: 20px;" >
											      <td ><form:input path="userPassword" class="f12_1" size="30" id="userPassword" type="password"  onKeyUp='pwStrength(this.value)' onBlur='pwStrength(this.value)' /></td>
											      <td class="f13" width="40" height="20" id="strength_L">弱</td>
											      <td class="f13" width="40" height="20" id="strength_M">中</td>
											      <td class="f13" width="40" height="20" id="strength_H">强</td>
											    </tr>
											  </table>							
											  
											</td>
											<td align="left"><form:errors path="userPassword" cssClass="error" /></td>
										</tr>
										<tr height="30" bgcolor="#eef6f7">
											<td width="2%"></td>
											<td align="left" class="f12_1"><form:label path="reUserPassword">确认密码</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left"><form:input path="reUserPassword" class="f12_1" size="30" id="reUserPassword" type="password" /></td>
											<td align="left" style="color: red; font-size: 13px; height: 10px;" id="reUserPasswordMessage" /></td>
										</tr>
										<tr height="30" bgcolor="#deecef">
											<td width="2%"></td>
											<td align="left" class="f12_1"><form:label path="tel">联系电话</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left"><form:input path="tel" class="f12_1" size="30" id="tel" maxlength="12" /></td>
											<td align="left"><form:errors path="tel" cssClass="error" /></td>
										</tr>
										<tr height="30" bgcolor="#eef6f7">
											<td width="2%"></td>
											<td align="left" class="f12_1"><form:label path="geoDictItem.dictItemId">地区</form:label>：</td>
											<td align="left">
												<form:select path="geoDictItem.dictItemId">
												     <form:option value="" label="--请选择--"/>
												     <form:options items="${geoDictItemMap}" />
												</form:select>
											</td>	
											<td align="left"><form:errors path="geoDictItem.dictItemId" cssClass="error" /></td>
										</tr>
										<tr height="30" bgcolor="#deecef">
											<td width="2%"></td>
											<td align="left" class="f12_1"><form:label path="industryDictItem.dictItemId">行业</form:label>：</td>
											<td align="left">
												<form:select path="industryDictItem.dictItemId">
											     	<form:option value="" label="--请选择--"/>
											     	<form:options items="${industryDictItemMap}" />
												</form:select>
											</td>	
											<td align="left"><form:errors path="industryDictItem.dictItemId" cssClass="error" /></td>
										</tr>
										<tr height="30" id="tr_gongsi1" bgcolor="#eef6f7">
											<td width="2%"></td>
											<td align="left" class="f12_1"><form:label path="companyName">公司名称</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left"><form:input path="companyName" class="f12_1" size="30" id="companyName" /></td>
											<td align="left"><form:errors path="companyName" cssClass="error" /></td>
										</tr>
										<tr height="30" id="tr_gongsi2" bgcolor="#deecef">
											<td width="2%"></td>
											<td align="left" class="f12_1">公司LOGO：</td>
											<td align="left"><input type="file" name="companyLogoFile" size="30"></input></td>
											<td align="left"></td>
										</tr>
										<tr height="30" id="tr_gongsi3" bgcolor="#eef6f7">
											<td width="2%"></td>
											<td align="left" class="f12_1"><form:label path="businessLicense">营业执照号</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left"><form:input path="businessLicense" class="f12_1" size="30" id="businessLicense" /></td>
											<td align="left"><form:errors path="businessLicense" cssClass="error" /></td>
										</tr>
										<tr height="30" id="tr_gongsi4" bgcolor="#deecef">
											<td width="2%"></td>
											<td align="left" class="f12_1"><form:label path="businewssOrgCode">企业组织机构代码</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left"><form:input path="businewssOrgCode" class="f12_1" size="30" id="businewssOrgCode" /></td>
											<td align="left"><form:errors path="businewssOrgCode" cssClass="error" /></td>
										</tr>
										<tr height="30" id="tr_gongsi5" bgcolor="#eef6f7">
											<td width="2%"></td>
											<td align="left" class="f12_1"><form:label path="taxCode">税务登记证</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left"><form:input path="taxCode" class="f12_1" size="30" id="taxCode" /></td>
											<td align="left"><form:errors path="taxCode" cssClass="error" /></td>
										</tr>
										 <tr height="30" id="tr_identityCard" bgcolor="#deecef">
											<td width="2%"></td>
											<td align="left" class="f12_1"><form:label path="identityCard">身份证号</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left"><form:input path="identityCard" class="f12_1" size="30" id="identityCard" /></td>
											<td align="left"><form:errors path="identityCard" cssClass="error" /></td>
										</tr>
										<tr height="110" bgcolor="#eef6f7">
											<td width="2%"></td>
											<td align="left" class="f12_1"><form:label path="remark">备注：</form:label></td>
											<td align="left" colspan="2"><form:textarea path="remark" class="f12_1" cols="65" rows="3" id="remark" /></td>
										</tr>
									</table>
								</td>
								
							</tr>
						
							<tr height="50">
								<td align="center" valign="middle">
									<table width="394" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="197" align="center" valign="top">
												<a href="#">
													<img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" align="middle" onclick="javascript:submitInfo();" />
												</a>
											</td>
											<!--
											<td width="197" align="center" valign="top">
												<a href="#">
													<img src="${ctx}/images/btnc1.png" alt="重置" width="101" height="30" border="0" align="middle" onclick="document.forms.accountForm.reset();return false;"/>
												</a>
											</td>
											-->
											<td width="197" align="center" valign="top">
												<a href="javascript:back();"><img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" /></a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
			</table>
		</div>

	</form:form>


</body>
</html>