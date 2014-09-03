<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详细信息</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<style type="text/css">
body {
	margin-left: 10px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		var userIdentity = '${basicUser.userIdentityDictItem.dictItemId}'.replace(/\s/g, "");;
 	     if(userIdentity=="gongsiidentity"){
 	 			document.getElementById("tr_identityCard").style.display="none";
 	 			document.getElementById("tr_gongsi1").style.display="";
 	 			document.getElementById("tr_gongsi2").style.display="";
 	 			document.getElementById("tr_gongsi3").style.display="";
 	 			document.getElementById("tr_gongsi4").style.display="";
 	 			document.getElementById("tr_gongsi5").style.display="";
 	 		}else{
 		 		document.getElementById("tr_identityCard").style.display="";
 		 		document.getElementById("tr_gongsi1").style.display="none";
 	 			document.getElementById("tr_gongsi2").style.display="none";
 	 			document.getElementById("tr_gongsi3").style.display="none";
 	 			document.getElementById("tr_gongsi4").style.display="none";
 	 			document.getElementById("tr_gongsi5").style.display="none";
 		}
	 });
</script>
</head>
<body >
  <form:form modelAttribute="baseVoList" action="${ctx}/accInfo/templateInfo.do" method="post">

	<table width="806" border="0" cellspacing="0" cellpadding="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td align="left" valign="top">
	        <table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
	          <tr bgcolor="#deecef" height="25">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;用户名：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.userAccount }</td>
	           </tr>   
	           <tr bgcolor="#eef6f7" height="25">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;账户类别：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.userTypeDictItem.itemName }</td>
	           </tr>  
	           <tr bgcolor="#deecef" height="25">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;账户身份：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.userIdentityDictItem.itemName }</td>
	           </tr>   
	           <tr bgcolor="#eef6f7" height="25">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;状态：</td>
	             <td width="70%" align="left" class="f12_1">${stateName}</td>
	           </tr>  
	           <tr bgcolor="#deecef" height="25">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;地区：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.geoDictItem.itemName }</td>
	           </tr>   
	           <tr bgcolor="#eef6f7" height="25">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;行业：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.industryDictItem.itemName }</td>
	           </tr>  
	           <tr bgcolor="#deecef" height="25">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;联系电话：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.tel }</td>
	           </tr>   
	           <tr bgcolor="#eef6f7" height="25"  id="tr_gongsi1">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;公司名称：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.companyName }</td>
	           </tr>  
	           <tr bgcolor="#deecef" height="25" id="tr_gongsi2">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;公司LOGO：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.companyLogoFileURI }</td>
	           </tr>   
	           <tr bgcolor="#eef6f7" height="25" id="tr_gongsi3">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;营业执照号：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.businessLicense }</td>
	           </tr>  
	           <tr bgcolor="#deecef" height="25" id="tr_gongsi4">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;企业组织机构代码：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.businewssOrgCode }</td>
	           </tr>   
	           <tr bgcolor="#eef6f7" height="25" id="tr_gongsi5">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;税务登记证：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.taxCode }</td>
	           </tr>  
	            <tr bgcolor="#eef6f7" height="25" id="tr_identityCard">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;身份证号：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.identityCard}</td>
	           </tr>  
	           <tr bgcolor="#deecef" height="25">
	             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;备注：</td>
	             <td width="70%" align="left" class="f12_1">${basicUser.remark }</td>
	           </tr> 
	         </table>
	    </td>
	  </tr>
	</table>

  </form:form>
</body>
</html>