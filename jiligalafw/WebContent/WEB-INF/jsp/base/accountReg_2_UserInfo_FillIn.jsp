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
	body {
		background-color: #000000;
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		margin:0px; padding:0px;
	}
    </style>
 <script type="text/javascript" src="${ctx}/scripts/common.js"></script>
 <script type="text/javascript" src="${ctx}/scripts/IdCardValidate.js"></script>
 <script type="text/javascript"	src="${ctx}/widgets/jquery/jquery-1.4.3.min.js"></script>
 <script type="text/javascript"	src="${ctx}/widgets/jquery/jquery.nivo.slider.pack.js"></script>
 <script type="text/javascript">
 	function refreshimg(object) {
		var d = new Date();
		object.src = '${ctx}/commons/image.jsp?' + d.toString(38);
		$("#rand").focus();
	}

 	function changeImg() {
		$("#imageCode").click();
	}
 	
 	function userReg(){
 		if(document.getElementById("userAccount").value==''){
 			alert('账户名(邮箱)不能为空'); 
 			return false;
 		}
 		if(!checkEmail(document.getElementById("userAccount").value)){
 			alert("请输入有效的邮箱地址!");
 			return;
 		}
 		if(document.getElementById("userPassword").value==''){
 			alert('密码不能为空'); 
 			return false;
 		}
 		if(document.getElementById("reUserPassword").value==''){
 			alert('确认密码不能为空'); 
 			return false;
 		}
 		if(document.getElementById("userName").value==''){
 			alert('姓名不能为空'); 
 			return false;
 		}
 		if(document.getElementById("tel").value==''){
 			alert('联系电话不能为空'); 
 			return false;
 		}
		if(!checkTel(document.getElementById("tel").value)){
			alert("请填写正确的联系电话。\n例如：13911884488 或 010-36880728");
			return false;		
		}
		
 		if($("#userAccountType").val()=="zhengshi"){
	 		var val=$('input:radio[name="userIdentity"]:checked').val();
			if(val=="gongsi"){
				if(document.getElementById("companyName").value==''){
		 			alert('公司名称不能为空'); 
		 			return false;
		 		}
				if(document.getElementById("businessLicense").value==''){
		 			alert('营业执照号不能为空'); 
		 			return false;
		 		}
				if(document.getElementById("businewssOrgCode").value==''){
		 			alert('企业组织机构代码不能为空'); 
		 			return false;
		 		}
				if(document.getElementById("taxCode").value==''){
		 			alert('税务登记证不能为空'); 
		 			return false;
		 		}
			} else {
				if(document.getElementById("identityCard").value==''){
		 			alert('身份证号不能为空'); 
		 			return false;
		 		}
				if(!IdCardValidate(document.getElementById("identityCard").value)){
					alert("身份证号填写错误");
					return false;
				}
			}
 		}
		
		if(document.getElementById("rand").value==''){
 			alert('验证码不能为空'); 
 			return false;
 		}
 		
 		if($("#chkAgree").is(':checked')){
			$("#userRegisterVo").submit();
 		} else {
			alert('请您阅读并同意瑞云浩天的《法律条款》'); 			
 		}
	}
 	
 	function reset(){
		$("#userRegisterVo").reset();
	}
 	
 	$(document).ready(function(){
 		if($("#userAccountType").val()=="shiyong"){
 			$("#accountLabel").html("注册成为瑞云浩天云计算门户系统的试用账户");
 			document.getElementById("tr_gongsi1").style.display="none";
 			document.getElementById("tr_gongsi2").style.display="none";
 			document.getElementById("tr_gongsi3").style.display="none";
 			document.getElementById("tr_identityCard").style.display="none";
 		}else{
 			$("#accountLabel").html("注册成为瑞云浩天云计算门户系统的正式账户");
 			var val=$('input:radio[name="userIdentity"]:checked').val();
 			if(val=="gongsi"){
 	 			document.getElementById("tr_identityCard").style.display="none";
 	 			document.getElementById("tr_gongsi1").style.display="";
 	 			document.getElementById("tr_gongsi2").style.display="";
 	 			document.getElementById("tr_gongsi3").style.display="";
 	 		}else{
 		 		document.getElementById("tr_identityCard").style.display="";
 		 		document.getElementById("tr_gongsi1").style.display="none";
 	 			document.getElementById("tr_gongsi2").style.display="none";
 	 			document.getElementById("tr_gongsi3").style.display="none";
 	 		} 
 		}
 		$(":radio").click(function(){
 			var val=$('input:radio[name="userIdentity"]:checked').val();
 			if($("#userAccountType").val()=="zhengshi"){
	 	 		if(val=="gongsi"){
	 	 			document.getElementById("tr_identityCard").style.display="none";
	 	 			document.getElementById("tr_gongsi1").style.display="";
	 	 			document.getElementById("tr_gongsi2").style.display="";
	 	 			document.getElementById("tr_gongsi3").style.display="";
	 	 		}else{
	 		 		document.getElementById("tr_identityCard").style.display="";
	 		 		document.getElementById("tr_gongsi1").style.display="none";
	 	 			document.getElementById("tr_gongsi2").style.display="none";
	 	 			document.getElementById("tr_gongsi3").style.display="none";
	 	 		}
 			}
	  });
	});
 	
 </script>
 </head>
  <body>
    <div id="header_bg"></div>
    <div id="middle_bg">
      <div id="middle">
        <div id="register">
  		<form:form  modelAttribute="userRegisterVo" action="${ctx}/base/userRegister/saveAccountInfo.do"  enctype="multipart/form-data" method="post">
    	    <table width="982" style="height:470px; margin:0px; padding:0px;" border="0" cellpadding="0" cellspacing="0" align="center">
				    <tr style="height:40px">
				    	<td width="2%" >&nbsp;</td>
				    	<td colspan="5" class="f18_1" id="accountLabel">注册成为瑞云浩天云计算门户系统的正式账户</td>
				    </tr>
				    <tr style="height:40px">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td colspan="4" class="f16_2">
				    	  1 账户类型选择
				    	  &nbsp;&nbsp;&nbsp;&nbsp;》&nbsp;&nbsp;&nbsp;
				    	  <span class="f16_3">2 资料填写</span>
				    	  &nbsp;&nbsp;&nbsp;&nbsp;》&nbsp;&nbsp;&nbsp;
				    	  3 邮箱验证
				    	  &nbsp;&nbsp;&nbsp;&nbsp;》&nbsp;&nbsp;&nbsp;
				    	  4 完成注册
				    	</td>
				    </tr>
				    <tr style="height:40px">
				    	<td width="2%" >&nbsp;</td>
				    	<td colspan="5"><span style="display:block;height:20px;margin-left: 20px;"  class="f13_4" ><form:errors path="errors" /></span></td>
				    </tr>
				    <tr style="height:25px">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >
					    	<form:input path="userAccountType" type="hidden"/>
					    	<form:input path="invitationKey" type="hidden"/>
					    	<form:input path="userFlag" type="hidden"/>
				    	</td>
				    	<td class="f13" width="15%">账户名(邮箱)<span style="color:#ff0000">*</span>：</td>
				    	<td><form:input path="userAccount" type="text"  class="text13" size="30" maxlength="35" />&nbsp;<font size="2" color="red"><form:errors path="userAccount" /></font></td>
				    	<td  class="f13">账户身份<span style="color:#ff0000">*</span>：</td>
				    	<td  class="f12">
				    		<form:radiobutton path="userIdentity" value="gongsi" />公司 &nbsp;
				    		<form:radiobutton path="userIdentity" value="geren" />个人 &nbsp;
				    		<form:radiobutton path="userIdentity" value="dev" />开发者 &nbsp;
				    	</td>
				    </tr>
				    <tr style="height:25px">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td class="f13">密码<span style="color:#ff0000">*</span>：</td>
				    	<td align="left" valign="middle">
				    	  <table align="left" border="0" cellspacing="0" cellpadding="0" style="margin:0px; padding:0px;">
				    	  	<tr>
				    	  		<td>
				    	  			<form:input path="userPassword" type="password" class="text13" size="30" maxlength="15" onKeyUp='pwStrength(this.value)' onBlur='pwStrength(this.value)'/>
									<font size="2" color="red"><form:errors path="userPassword" /></font>
								</td>
				    	  	</tr>
				    	  </table>
				    	  <table align="left" width="105" border="0" cellspacing="1" cellpadding="0" bordercolor="#cccccc" style='margin:0px; padding:0px;display:inline; padding-top: 2px;'>
						    <tr align="center" bgcolor="#eeeeee" style="height: 22px;" >
						      <td class="f13" width="35" id="strength_L">弱</td>
						      <td class="f13" width="35" id="strength_M">中</td>
						      <td class="f13" width="35" id="strength_H">强</td>
						    </tr>
						  </table>
				    	</td>
				    	<td class="f13">确认密码<span style="color:#ff0000">*</span>：</td>
				    	<td><form:input path="reUserPassword" type="password" class="text13" size="30" maxlength="15"/>&nbsp;<font size="2" color="red"><form:errors path="reUserPassword" /></font></td>
				    </tr>
				    <tr style="height:25px">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td class="f13">姓名<span style="color:#ff0000">*</span>：</td>
				    	<td><form:input path="userName" type="text" class="text13" size="30" maxlength="15"/>&nbsp;<font size="2" color="red"><form:errors path="userName" /></font></td>
				    	<td class="f13">联系电话<span style="color:#ff0000">*</span>：</td>
				    	<td><form:input path="tel" type="text" class="text13" size="30" maxlength="12"/>&nbsp;<font size="2" color="red"><form:errors path="tel" /></font></td>
				    </tr>
				    <tr style="height:25px" id="tr_gongsi1">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td class="f13">公司名称<span style="color:#ff0000">*</span>：</td>
				    	<td colspan="3"><form:input path="companyName" type="text" class="text13" size="62" maxlength="30" />&nbsp;<font size="2" color="red"><form:errors path="companyName" /></font></td>
				    </tr>
				    <tr style="height:25px" id="tr_gongsi2">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td class="f13">公司LOGO：</td>
				    	<td>
							<input type="file" name="companyLogoFile" size="28"></input>
						</td>	
						<td class="f13">营业执照号<span style="color:#ff0000">*</span>：</td>
						<td><form:input path="businessLicense" type="text" class="text13" size="30" maxlength="20" />&nbsp;<font size="2" color="red"><form:errors path="businessLicense" /></font></td>
				    </tr>
				    <tr style="height:25px" id="tr_gongsi3">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td class="f13">企业组织机构代码<span style="color:#ff0000">*</span>：</td>
				    	<td><form:input path="businewssOrgCode" type="text" class="text13" size="30" maxlength="20" />&nbsp;<font size="2" color="red"><form:errors path="businewssOrgCode" /></font></td>
				    	<td class="f13">税务登记证<span style="color:#ff0000">*</span>：</td>
				    	<td class="f12"><form:input path="taxCode" type="text" class="text13" size="30" maxlength="20"/>&nbsp;<font size="2" color="red"><form:errors path="taxCode" /></font></td>
				    </tr>
				    <tr style="height:25px" id="tr_identityCard" style="display:none">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td class="f13">身份证号<span style="color:#ff0000">*</span>：</td>
				    	<td><form:input path="identityCard" type="text" class="text13" size="30" maxlength="18" />&nbsp;<font size="2" color="red"><form:errors path="identityCard" /></font></td>
				    	<td class="f13"></td>
				    	<td class="f12"></td>
				    </tr>
				    <tr style="height:25px">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td class="f13">备注：</td>
				    	<td colspan="3"><form:textarea path="remark" cols="82" rows="2"/></td>
				    </tr>
				    <tr style="height:25px">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td class="f13">验证码<span style="color:#ff0000">*</span>：</td>
				    	<td colspan="3" class="f12" valign="bottom">
				    		<form:input path="rand" type="text" class="text13" size="20"  id="rand"/>
				    		<img id="imageCode" src="${ctx}/commons/image.jsp" style="width:57px;cursor:pointer;" height="24" border="0" alt="点击更换验证码" onclick="javascript:refreshimg(this);" />&nbsp;
				    		<font size="2" color="red"><form:errors path="rand" /></font>
				    	</td>
				    </tr>
				    <tr style="height:35px">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td colspan="4" align="center" class="f15_3"><input type="checkbox"  <c:choose><c:when test="${chkAgree=='1'}">checked</c:when></c:choose>  id="chkAgree"/>我已阅读并同意瑞云浩天的&nbsp;&nbsp;<a href="${ctx}/commons/legal.html" style="color:red" target="_blank" >《法律条款》</a> </td>
				    </tr>
				    <tr style="height:35px">
				    	<td width="2%" >&nbsp;</td>
				    	<td width="2%" >&nbsp;</td>
				    	<td class="f13" colspan="4" align="center">
			    			<img src="${ctx}/images/btns2.png" width="120" height="32" border="0" align="middle"  onclick="javascript:userReg();" style="cursor: pointer;"/>
				    		&nbsp;
			    			<img src="${ctx}/images/btnc1.png" width="120" height="32" border="0" align="middle" onclick="javascript:reset();" style="cursor: pointer;"/>
				    		&nbsp;
				    		<a href="${ctx}/base/userRegister/selectAccountType.do">				    		
				    			<img src="${ctx}/images/btn10.png" width="120" height="32" border="0" align="middle" style="cursor: pointer;"/>
				    		</a>
				    	</td>
				    </tr>
				    <tr style="height:15px"><td colspan="6"></td></tr>
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

<script language=javascript> 
	//CharMode函数 
	//测试某个字符是属于哪一类. 
	function CharMode(iN) {
		if (iN >= 48 && iN <= 57) //数字 
			return 1;
		if (iN >= 65 && iN <= 90) //大写字母 
			return 2;
		if (iN >= 97 && iN <= 122) //小写 
			return 4;
		else
			return 8; //特殊字符 
	}
	//bitTotal函数 
	//计算出当前密码当中一共有多少种模式 
	function bitTotal(num) {
		modes = 0;
		for (i = 0; i < 4; i++) {
			if (num & 1)
				modes++;
			num >>>= 1;
		}
		return modes;
	}
	//checkStrong函数 
	//返回密码的强度级别 
	function checkStrong(sPW) {
		if (sPW.length <= 4)
			return 0; //密码太短 
		Modes = 0;
		for (i = 0; i < sPW.length; i++) {
			//测试每一个字符的类别并统计一共有多少种模式. 
			Modes |= CharMode(sPW.charCodeAt(i));
		}
		return bitTotal(Modes);
	}
	//pwStrength函数 
	//当用户放开键盘或密码输入框失去焦点时,根据不同的级别显示不同的颜色 
	function pwStrength(pwd) {
		O_color = "#eeeeee";
		L_color = "#FF0000";
		M_color = "#FF9900";
		H_color = "#33CC00";
		if (pwd == null || pwd == '') {
			Lcolor = Mcolor = Hcolor = O_color;
		} else {
			S_level = checkStrong(pwd);
			switch (S_level) {
			case 0:
				Lcolor = Mcolor = Hcolor = O_color;
			case 1:
				Lcolor = L_color;
				Mcolor = Hcolor = O_color;
				break;
			case 2:
				Lcolor = Mcolor = M_color;
				Hcolor = O_color;
				break;
			default:
				Lcolor = Mcolor = Hcolor = H_color;
			}
		}
		document.getElementById("strength_L").style.background = Lcolor;
		document.getElementById("strength_M").style.background = Mcolor;
		document.getElementById("strength_H").style.background = Hcolor;
		return;
	}
</script>
</html>