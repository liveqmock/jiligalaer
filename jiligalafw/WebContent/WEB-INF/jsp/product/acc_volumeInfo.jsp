<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卷信息</title>
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

</script>
</head>
<body>
  <form:form modelAttribute="baseVoList" action="${ctx}/accInfo/volumeInfo.do" method="post">

	<table width="806" border="0" cellspacing="0" cellpadding="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td align="left" valign="top">
	      <table width="788" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
	        <tr bgcolor="#92b8c1" height="20">
	          <td width="5%" align="center" class="f12">序号</td>
	          <td width="12%" align="center" class="f12">名称</td>
	          <td width="13%" align="center" class="f12">类型</td>
	          <!--
	          <td width="10%" align="center" class="f12">域名称</td>
	          -->
	          <td width="15%" align="center" class="f12">存储</td>
	          <td width="10%" align="center" class="f12">大小(M)</td>
	          <td width="20%" align="center" class="f12">VM</td>
	          <td width="15%" align="center" class="f12">创建日期</td>
	          <td width="8%" align="center" class="f12">状态</td>
	        </tr>
	      </table>
	      
	      <div id="order" style="height:450px; z-index:1; overflow-y: scroll; overflow-x: hidden;">   
		      <table width="788" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
		        <%int i=0; %>
		        <c:forEach var="item" items="${volumeList}" >
			        <%
			        String bgcolor="#deecef";
			        if(i++ % 2 == 0){
			        	bgcolor="#eef6f7";
			        }
			        %>
					<tr bgcolor="<%=bgcolor %>" height="20">
			            <td width="5%" align="center" class="f12_1"><%=i %></td>
			            <td width="12%" align="left" class="f12_1">${item.name }</td>
			            <td width="13%" align="left" class="f12_1">${item.type }</td>
			            <!--
			            <td width="10%" align="left" class="f12_1">${item.domain }</td>
			            -->
			            <td width="15%" align="left" class="f12_1">${item.storage }</td>
			            <td width="10%" align="right" class="f12_1">${item.size }</td>
			            <td width="20%" align="left" class="f12_1">${item.vmname }</td>
			            <td width="15%" align="center" class="f12_1"><fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd HH:mm"/></td>
			            <td width="8%" align="left" class="f12_1">${item.state }</td>
					</tr>
		          </c:forEach>
		      </table>
	      </div>
	    </td>
	  </tr>
	</table>

  </form:form>
</body>
</html>