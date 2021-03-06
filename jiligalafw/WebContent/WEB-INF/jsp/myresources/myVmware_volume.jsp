<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的虚拟机 - 卷</title>
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
	
	<div id="order" style="height:500px; width:590px; z-index:1; overflow-y: scroll;overflow-x:hidden;">
	<%int i=1; %>
	<c:forEach items="${volumeList }" var="item" varStatus="rowCount">
        <table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
           <tr bgcolor="#deecef" height="25">
             <td width="100%" colspan="4" align="left" class="f12_1">&nbsp;&nbsp;卷 <%=i++ %></td>
           </tr>   
           <tr bgcolor="#eef6f7" height="25">
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;存储</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.name }</td>
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;大小</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.size/1024/1024/1024 } GB</td>
           </tr>  
           <tr bgcolor="#deecef" height="25">
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;状态</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.state }</td>
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;存储类型</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.type }</td>
           </tr>   
           <tr bgcolor="#eef6f7" height="25">
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;设备</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.deviceid }</td>
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;设备ID</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.deviceid }</td>
           </tr>
           <tr bgcolor="#deecef" height="25">
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;创建日期</td>
             <td width="35%" align="left" class="f12_1">&nbsp;
             	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.created }"></fmt:formatDate>
             </td>
             <td width="15%" align="left" class="f12_1">&nbsp;&nbsp;ID</td>
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;${item.interfaceId }</td>
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
	</div>
	
	<%--
	<c:forEach var="item" items="${volumeList }">
        <table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
          <tr bgcolor="#deecef" height="20">
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;存储</td>
             <td width="70%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>   
           <tr bgcolor="#eef6f7" height="20">
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;大小</td>
             <td width="70%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>  
           <tr bgcolor="#deecef" height="20">
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;状态</td>
             <td width="70%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>   
           <tr bgcolor="#eef6f7" height="20">
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;存储类型 </td>
             <td width="70%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>  
           <tr bgcolor="#deecef" height="20">
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;类型 </td>
             <td width="70%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>   
           <tr bgcolor="#eef6f7" height="20">
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;设备</td>
             <td width="70%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>  
           <tr bgcolor="#deecef" height="20">
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;设备ID</td>
             <td width="70%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>   
           <tr bgcolor="#eef6f7" height="20">
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;创建日期</td>
             <td width="70%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>
           <tr bgcolor="#eef6f7" height="20">
             <td width="35%" align="left" class="f12_1">&nbsp;&nbsp;ID</td>
             <td width="70%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>           
         </table>
	</c:forEach>   
    --%>
    
	</form:form>
  </body>
</html>