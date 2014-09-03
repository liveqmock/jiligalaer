<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账单信息</title>
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
  <form:form modelAttribute="baseVoList" action="${ctx}/accInfo/billInfo.do" method="post">

	<table width="806" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	  	<td width="100%" align="left" valign="top" class="f13_1">充值信息：（合计：<fmt:formatNumber pattern="#0.00">${totalPayAmount}</fmt:formatNumber> 元）</td>
	  </tr>
	  <tr>
	    <td align="left" valign="top">
	      <table width="650" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
	        <tr bgcolor="#92b8c1" height="20">
	          <td width="10%" align="center" class="f12">序号</td>
	          <td width="20%" align="center" class="f12">充值日期</td>
	          <td width="20%" align="center" class="f12">充值方式</td>
	          <td width="25%" align="center" class="f12">充值金额（元）</td>
	          <td width="25%" align="center" class="f12">充值后余额（元）</td>
	        </tr>
	      </table>
	      
	      <%int i=0; %>
	      <div id="order" style="height:180px; width:665px; z-index:1; overflow-y: scroll;overflow-x: hidden;">
		      <table width="650" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
		        <c:forEach var="item" items="${payList}" >
			        <%
			        String bgcolor="#deecef";
			        if(i++ % 2 == 0){
			        	bgcolor="#eef6f7";
			        }
			        %>
					<tr bgcolor="<%=bgcolor %>" height="20">
					   <td width="10%" align="center" class="f12_1"><%=i %></td>
					   <td width="20%" align="center" class="f12_1">
					   	 <fmt:formatDate value="${item.payDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
					   </td>
					   <td width="20%" align="left" class="f12_1">${item.payTypeName }</td>
					   <td width="25%" align="right" class="f12_1"><fmt:formatNumber pattern="#0.00">${item.payAmount }</fmt:formatNumber></td>
					   <td width="25%" align="right" class="f12_1"><fmt:formatNumber pattern="#0.00">${item.remainingAmount }</fmt:formatNumber></td>
					 </tr>
		         </c:forEach>
		      </table>
		  </div>
	  </tr>
	
	  <tr><td height="30"></td></tr>
	  <tr>
	  	<td width="100%"  align="left" valign="top" class="f13_1">账单信息：（合计：<fmt:formatNumber pattern="#0.00">${totalExpAmount }</fmt:formatNumber> 元）</td>
	  </tr>	  
	  <tr>
	    <td>
	      <table width="785" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
	        <tr bgcolor="#92b8c1" height="20">
	          <td width="5%" align="center" class="f12">序号</td>
	          <td width="15%" align="center" class="f12">扣费日期</td>
	          <td width="12%" align="center" class="f12">扣费金额（元）</td>
	          <td width="9%" align="center" class="f12">计费类型</td>
	          <td width="9%" align="center" class="f12">计费周期</td>
	          <td width="25%" align="center" class="f12">产品名称</td>
	          <td width="25%" align="center" class="f12">备注</td>
	        </tr>
	      </table>
	      
	      <%int j=0; %>
	      <div id="order" style="height:195px; z-index:1; width:800px; overflow-y: scroll;overflow-x: hidden;">
		      <table width="785" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
				<c:forEach var="item" items="${expItemList}" >
					<%
			        String bgcolor="#deecef";
			        if(j++ % 2 == 0){ bgcolor="#eef6f7"; }
		        	%>
					<tr bgcolor="<%=bgcolor %>" height="20">
					   <td width="5%" align="center" class="f12_1"><%=j %></td>
					   <td width="15%" align="center" class="f12_1">
					   	 <fmt:formatDate value="${item.expDate }" pattern="yyyy-MM-dd HH:mm"/>
					   </td>
					   <td width="12%" align="right" class="f12_1"><fmt:formatNumber pattern="#0.00">${item.expAmount }</fmt:formatNumber></td>
					   <td width="9%" align="center" class="f12_1">
					   		<c:if test="${item.billingType=='0' }">一次性</c:if>
					   		<c:if test="${item.billingType=='1' }">周期性</c:if>
					   </td>
					   <td width="9%" align="left" class="f12_1">
					   	<c:choose>
		            		<c:when test="${item.billingType == '1' }">
								<c:if test="${item.cloudUserOrder.billingCycle == '2' }">年收费</c:if>
								<c:if test="${item.cloudUserOrder.billingCycle == '3' }">月收费</c:if>
								<c:if test="${item.cloudUserOrder.billingCycle == '4' }">天收费</c:if>
								<c:if test="${item.cloudUserOrder.billingCycle == '5' }">小时收费</c:if>
		            		</c:when>
		            		<c:otherwise>
		            			一次性收费
		            		</c:otherwise>
		            	</c:choose>
					   </td>
					   <td width="25%" align="left" class="f12_1">${item.cloudUserOrderItem.cloudMdmProduct.prodName }</td>
					   <td width="25%" align="left" class="f12_1">${item.cloudUserOrderItem.buyName }</td>
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