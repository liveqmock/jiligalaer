<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>公告编辑</title>
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
	$("#noticeMessagesVo").submit();
}
function doReturn(){
	window.location ="${ctx}/noticeMessages/list.do";
}
</script>
</head>
<body>  

  <form:form modelAttribute="noticeMessagesVo" action="${ctx}/noticeMessages/save.do" method="post" >
  <form:errors path="errors" cssClass="commomError"/>

	<table width="962" border="0" cellpadding="0" cellspacing="0">
		<tr>
		  <td align="center"  valign="top" bgcolor="#F2F2F2">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">
                 <tr>
                   <td height="43" align="left" valign="middle"><span class="f18b2">我的公告</span></td>
                   <td align="left" valign="middle">&nbsp;</td>
                 </tr>
                 <tr>
                   <td height="2" colspan="2" align="center" valign="middle"><hr /></td>
                 </tr>
                 <tr>
                   <td height="15" colspan="2" ></td>
                 </tr>

                 <tr>
                   <td align="center" valign="top">
                  	  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                  	  	<!--
                  		<tr height="30">
							<td width="20%"></td>
	                        <td width="15%" align="left" class="f13_1"><form:label path="created">发布日期：</form:label></td>
	                        <td width="50%" align="left">
	                        	<c:choose>
		                        	<c:when test="${noticeMessagesVo.created == null }">
		                        		<jsp:useBean id="now" class="java.util.Date" scope="session"/>
		                        		<fmt:formatDate value="${sessionScope.now}" pattern="yyyy-MM-dd"/>
		                        	</c:when>
		                        	<c:otherwise>
		                        		<fmt:formatDate value="${noticeMessagesVo.created }" pattern="yyyy-MM-dd"/>
		                        	</c:otherwise>
	                        	</c:choose>
	                        </td>
	                        <td width="15%" align="left" class="f13_1"><form:errors path="created" cssClass="error"/></td>
                        </tr>
                        -->
                        <tr height="30">
							<td width="20%"></td>
							<td width="15%" align="left" class="f13_1"><form:label path="messTitle">主题</form:label>：</td>
							<td width="50%" align="left" class="f13_1"><form:input path="messTitle" cssStyle="width:300px;"/></td>
							<td width="15%" align="left" class="f13_1"><form:errors path="messTitle" cssClass="error"/></td>
                        </tr>
                        <tr height="30">
							<td></td>
							<td align="left" class="f13_1"><form:label path="content">内容</form:label>：</td>
							<td align="left" class="f13_1"><form:textarea path="content" cols="35" rows="10" /></td>
							<td align="left" class="f13_1"><form:errors path="content" cssClass="error"/></td>
                        </tr>                        
				  	  </table>
                   </td>
                 </tr>
                 
                 <tr>
                   <td height="35" colspan="2" ></td>
                 </tr>
                 
                 <tr>
                   <td colspan="2" align="center" valign="middle">
                  	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                       <tr>
                         <td width="45%" align="right" valign="top">
                         	<a href="javascript:doSave()"><img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" align="absmiddle"/></a>
                         </td>
                         <td width="10%" align="center" valign="top">
                         </td>
                         <td width="45%" align="left" valign="top">     
                         	<a href="${ctx}/noticeMessages/list.do"><img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" /></a>
                         </td>
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
               </table>
             </td>
           </tr>
         </table>


     </form:form>
        
</body>
</html>