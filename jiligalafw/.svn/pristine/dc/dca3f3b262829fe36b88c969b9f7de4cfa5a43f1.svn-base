<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户设置</title>
<link href="css/css_main.css" rel="stylesheet" />
<link href="css/css_font.css" rel="stylesheet" />
<style type="text/css">
<!--
body {
	background-color: #F2F2F2;
	margin-left: 5px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<%@ include file="/commons/meta.jsp"%>
<script type="text/javascript">
function doSave(){
	$("#basicUserQuotaVo").submit();
}

</script>
</head>
<body>  

  <form:form modelAttribute="basicUserQuotaVo" action="${ctx}/basicUserQuota/save.do" method="post" name="editForm" >
	   
   <div id="middle_sheet_myInfo_content">
	  <table width="960" height="430" border="0" cellpadding="0" cellspacing="0">
		<tr>
		  <td align="center"  valign="top" bgcolor="#F2F2F2">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                   <td height="40" align="left" valign="middle"><span class="f18b2">账户设置</span></td>
                   <td align="left" valign="middle">&nbsp;</td>
                 </tr>
                 <tr>
                   <td height="2" colspan="2" align="center" valign="middle"><hr /></td>
                 </tr>
                 <tr><td height="15" colspan="2" ></td></tr>

                 <tr>
                   <td align="center" valign="top" colspan="2">
                  	  <table width="90%" border="0" cellpadding="0" cellspacing="0">
                  		<tr height="30">
							<td width="20%"></td>
	                        <td width="25%" align="right" class="f13_1"><form:label path="testUserNum">试用账户个数：</form:label></td>
	                        <td width="30%" align="left"><form:input path="testUserNum" maxlength="10" /></td>
	                        <td width="25%" align="left" class="f13_1"><form:errors path="testUserNum" cssClass="error"/></td>
                        </tr>
                        <tr height="30">
							<td></td>
							<td align="right" class="f13_1"><form:label path="testCredit">试用账户额度</form:label>：</td>
							<td align="left" class="f13_1"><form:input path="testCredit" maxlength="10" /></td>
							<td align="left" class="f13_1"><form:errors path="testCredit" cssClass="error"/></td>
                        </tr>
                        <%--
                        <tr height="30">
							<td></td>
							<td align="right" class="f13_1"><form:label path="formalCredit">正式账户信用额度</form:label>：</td>
							<td align="left" class="f13_1"><form:input path="formalCredit" maxlength="10" /></td>
							<td align="left" class="f13_1"><form:errors path="formalCredit" cssClass="error"/></td>
                        </tr>
                        --%>
                        <tr height="30">
							<td></td>
							<td align="right" class="f13_1"><form:label path="stopRunDay">信用开机小时</form:label>：</td>
							<td align="left" class="f13_1"><form:input path="stopRunDay" maxlength="2" /></td>
							<td align="left" class="f13_1"><form:errors path="stopRunDay" cssClass="error"/></td>
                        </tr>
                        <tr height="30">
							<td></td>
							<td align="right" class="f13_1"><form:label path="delVmDay">信用删机小时</form:label>：</td>
							<td align="left" class="f13_1"><form:input path="delVmDay" maxlength="2" /></td>
							<td align="left" class="f13_1"><form:errors path="delVmDay" cssClass="error"/></td>
                        </tr>                        
				  	  </table>
                   </td>
                 </tr>
                 
                 <tr align="center">
                   <td height="50" colspan="2" align="center"><b><form:errors path="errors" cssClass="commomError"/></b></td>
                 </tr>
                 
                 <tr>
                   <td colspan="2" align="center" valign="middle">
                  	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                       <tr>
                         <td width="100%" align="center" valign="top">
                         	<a href="javascript:doSave()"><img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" align="absmiddle"/></a>
                         </td>
                         <!--
                         <td width="10%" ></td>
                         <td width="45%" align="left" valign="top">
                         	<a href="javascript:void(0)"><img src="${ctx}/images/btnc1.png" alt="重置" onclick="document.forms.editForm.reset();return false;" width="101" height="30" border="0" align="absmiddle"/></a>
                         </td>
                         -->
                       </tr>
                     </table>
                   </td>
                 </tr>
                 
                 <tr>
                   <td height="20" colspan="2" ></td>
                 </tr>
                 <tr>
                   <td height="2" colspan="2" align="center" valign="middle"><img src="images/sheet_line_2.jpg" width="100%" height="2" /></td>
                 </tr>

                 <tr>
                   <td height="50" colspan="2" ></td>
                 </tr>
               </table>
             </td>
           </tr>
         </table>
       </div>
     </form:form>
        
</body>
</html>