<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品管理-单一产品列表-选择资源主页面-IP</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	margin-left: 10px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function selectVal(){
	var ipNum = document.getElementById("ipNum").value;
	var winObj = window.parent.parent.parent;
	winObj.opener.ipAddr(ipNum,"ip");
	winObj.close();

}
</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/singleProd/ipResource.do" method="post" name="listForm">

       	<table width="806" border="0" cellpadding="0" cellspacing="0">
           <tr>
             <td align="center" valign="middle" bgcolor="#FFFFFF" height="350">
	     		<table width="60%" border="0" cellspacing="1" cellpadding="1" >   		
	              <tr bgcolor=#ffffff height="20">
	                <td width="50%" align="center" class="f12_1">
	                	IP地址：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="ipNum" id="ipNum" value="1" readonly="readonly"/> 个IP
	                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                	<input type="button" value="确定" onclick="selectVal()" class="btn_bg" style="width: 60px;"/>
	                </td>
	              </tr>              
	            </table>
             </td>
           </tr>
         </table>
         
	</form:form>
  </body>
</html>