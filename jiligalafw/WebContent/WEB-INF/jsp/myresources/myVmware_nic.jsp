<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的虚拟机 - nic</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	margin:0px auto;
	background-color:#ffffff;
	background-repeat:repeat;
	background-position:left;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">

</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/myVm/list.do" method="post" name="listForm">
	<%int i=1; %>
	<c:forEach items="${nicList }" var="item" varStatus="rowCount">
        <table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
           <tr bgcolor="#deecef" height="25">
             <td width="100%" colspan="4" align="left" class="f12_1">&nbsp;&nbsp;NIC <%=i++ %></td>
           </tr>   
           <tr bgcolor="#eef6f7" height="25">
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;Network</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.networkName }</td>
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;类型</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.type }</td>
           </tr>  
           <tr bgcolor="#deecef" height="25">
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;IP地址</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.ipaddress }</td>
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;网络掩码</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.netmask }</td>
           </tr>   
           <tr bgcolor="#eef6f7" height="25">
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;网关</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.gateway }</td>
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;是否默认值</td>
             <td width="35%" align="left" class="f12_1">&nbsp;
             	<c:if test="${item.isDefault=='true'}">是</c:if>
             	<c:if test="${item.isDefault=='false'}">否</c:if>
             </td>
           </tr>  
 		</table>

		<c:if test="${rowCount.last == false}">
	        <table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#ffffff">
	          <tr height="20">
	             <td width="100%"><img src="${ctx}/images/buy_blue_line.jpg" width="740" height="2" /></td>
	           </tr>    
	 		</table>
		</c:if>

	</c:forEach>

	</form:form>
  </body>
</html>