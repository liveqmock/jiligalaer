<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网络信息</title>
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
  <form:form modelAttribute="baseVoList" action="${ctx}/accInfo/netInfo.do" method="post">

	<table width="806" border="0" cellspacing="0" cellpadding="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td align="left" valign="top">
	      <table width="788" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
	        <tr bgcolor="#92b8c1" height="20">
	          <td width="4%" align="center" class="f12">序号</td>
	          <!--
	          <td width="14%" align="center" class="f12">ID</td>
	          -->
	          <td width="10%" align="center" class="f12">区域</td>
	          <td width="15%" align="center" class="f12">名称</td>
	          <td width="6%" align="center" class="f12">类型</td>
	          <td width="10%" align="center" class="f12">网络域</td>
	          <td width="10%" align="center" class="f12">VLAN</td>
	          <!--
	          <td width="8%" align="center" class="f12">网关</td>
	          <td width="12%" align="center" class="f12">子网掩码</td>
	          -->
	          <td width="10%" align="center" class="f12">CIDR</td>
	          <td width="18%" align="center" class="f12">描述</td>
	        </tr>
	      </table>
	      
	      <div id="order" style="height:450px; z-index:1; overflow-y: scroll;overflow-x:hidden;">   
		      <table width="788" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
		        <%int i=0; %>
		        <c:forEach var="item" items="${networkList}" >
			        <%
			        String bgcolor="#deecef";
			        if(i++ % 2 == 0){
			        	bgcolor="#eef6f7";
			        }
			        %>
					<tr bgcolor="<%=bgcolor %>" height="20">
			            <td width="4%" align="center" class="f12_1"><%=i %></td>
			            <%--
			            <td width="14%" align="left" class="f12_1">${item.networkofferingid }</td>
			            --%>
			            <td width="10%" align="left" class="f12_1">${item.zonename }</td>
			            <td width="15%" align="left" class="f12_1" title="${item.name }">
			            	${fn:substring(item.name,0,35)}
			            </td>
			            <td width="6%" align="left" class="f12_1">${item.type }</td>
			            <td width="10%" align="left" class="f12_1" title="${item.networkdomain }">
			            	${fn:substring(item.networkdomain,0,15) }
			            </td>
			            <td width="10%" align="left" class="f12_1">${item.vlan }</td>
			            <!--
			            <td width="8%" align="left" class="f12_1">${item.gateway }</td>
			            <td width="12%" align="left" class="f12_1">${item.netmask }</td>
			            -->
			            <td width="10%" align="left" class="f12_1">${item.cidr }</td>
			            <td width="18%" align="left" class="f12_1" title="${item.displaytext }">
			            	${fn:substring(item.displaytext,0,20)}
			            </td>
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