<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>财务管理 - 账户余额 - 账户余额详细</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/autoheight.js"></script>
<style type="text/css">
body {
	background-color: #000000;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function exportExcel(){
	var form = document.forms.listForm;
	form.action="${ctx}/balance/exportExcel.do";
	form.submit();
}
function back(){
	window.location="${ctx}/balance/list.do";
}
</script>
</head>
<body>
	<form:form modelAttribute="basicUserVoList" action="${ctx}/balance/view.do" method="post" name="listForm">
	  <input type="hidden" name="userId" value="${userId }" />
	  
      <table width="962" border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
			<td align="center" valign="top" bgcolor="#F2F2F2">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="40" colspan="2" align="center" valign="middle"><span class="f18b2">${userName } （账户余额：<fmt:formatNumber pattern="#0.00">${expVo.payTotalAmount - expVo.expTotalAmount }</fmt:formatNumber> 元）</span></td>
					</tr>
					<tr>
						<td height="2" colspan="2" align="center" valign="middle">
							<hr />
						</td>
					</tr>

					<tr>
						<td align="left" width="30"></td>
						<td align="left" valign="top">

							<table width="906" border="0" cellspacing="0" cellpadding="0">									
							  <tr>
							  	<td width="100%" align="left" valign="top" class="f13_1">账户充值信息：（合计：<fmt:formatNumber pattern="#0.00">${totalPayAmount }</fmt:formatNumber> 元）</td>
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
							      <div id="order" style="height:150px; width:665px; z-index:1; overflow-y: scroll; overflow-x: hidden;">
							          <table width="650" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
								        <c:forEach var="item" items="${payList}" >
								        	<%
									        String bgcolor="#deecef";
									        if(i++ % 2 == 0){ bgcolor="#eef6f7"; }
								        	%>
											<tr bgcolor="<%=bgcolor %>" height="20">
											   <td width="10%" align="center" class="f12_1"><%=i %></td>
											   <td width="20%" align="center" class="f12_1">
											   	 <fmt:formatDate value="${item.payDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
											   </td>
											   <td width="20%" align="left" class="f12_1">
													${item.payTypeName }
											   </td>
											   <td width="25%" align="right" class="f12_1"><fmt:formatNumber pattern="#0.00">${item.payAmount }</fmt:formatNumber></td>
											   <td width="25%" align="right" class="f12_1"><fmt:formatNumber pattern="#0.00">${item.remainingAmount }</fmt:formatNumber></td>
											 </tr>
								        </c:forEach>
								      </table>
								  </div>
							  </tr>
							
							  <tr><td height="30"></td></tr>
							  <tr>
							  	<td width="100%"  align="left" valign="top" class="f13_1">
							  		账户扣费信息：（合计：<fmt:formatNumber pattern="#0.00">${totalExpAmount }</fmt:formatNumber> 元）
							  		&nbsp;&nbsp;&nbsp;&nbsp;
							  		<input type="button" value="导出Excel" style="height: 22px;" onclick="exportExcel()"/>
							  	</td>
							  </tr>	  
							  <tr>
							    <td>
							      <table width="885" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
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
							      <div id="order" style="height:200px; width:900px;; z-index:1; overflow-y: scroll; overflow-x: hidden;">
								      <table width="885" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
										<c:forEach var="item" items="${expItemList}" >
											<%
									        String bgcolor="#deecef";
									        if(j++ % 2 == 0){ bgcolor="#eef6f7"; }
								        	%>
											<tr bgcolor="<%=bgcolor %>" height="20">
											   <td width="5%" align="center" class="f12_1"><%=j %></td>
											   <td width="15%" align="left" class="f12_1">
											   	 <fmt:formatDate value="${item.expDate }" pattern="yyyy-MM-dd HH:mm"/>
											   </td>
											   <td width="12%" align="right" class="f12_1"><fmt:formatNumber pattern="#0.00">${item.expAmount }</fmt:formatNumber></td>
											   <td width="9%" align="center" class="f12_1">
											   		<c:if test="${item.billingType=='0' }">一次性</c:if>
											   		<c:if test="${item.billingType=='1' }">周期性</c:if>
											   </td>
											   <td width="9%" align="center" class="f12_1">
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

						</td>
					</tr>
					<tr><td height="10" colspan="2"></td></tr>
					<tr>
					  <td height="30" colspan="2" align="center">
						<a href="javascript:back();"><img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" align="absmiddle" /></a>
					  </td>
					</tr>
					<tr><td height="10" colspan="2"></td></tr>
				</table>
				
				
				<div id="middle_sheet_s_name">
					<a href="javascript:accInfo('orderInfo',1,'${userId}');"><img src="${ctx}/images/menu_s_1_s.png" border="0" align="absmiddle" id="orderInfo" /></a>
					<a href="javascript:accInfo('detailInfo',0,'${userId}');"><img src="${ctx}/images/menu_s_0.jpg" border="0" align="absmiddle" id="detailInfo" /></a>
				</div>
				<script type="text/javascript">
					function accInfo(url,type,userId) {
						var path="accPay";
						if(type == 1){
							path="accInfo";
						}
						$("#detailInfo")[0].src="${ctx}/images/menu_s_0.jpg";
						$("#orderInfo")[0].src="${ctx}/images/menu_s_1.jpg";
						
						var map = getMap(); 
						map.put("detailInfo","${ctx}/images/menu_s_0_s.png");
						map.put("orderInfo","${ctx}/images/menu_s_1_s.png");
						
						$("#"+url)[0].src=map.get(url);								
						document.getElementById("balanceForm").src = "${ctx}/" + path + "/" + url + ".do?userId="+userId;
					}
				</script>
				<div id="middle_sheet_s">
					<table width="855" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_1.jpg" width="14" height="14" /></td>
							<td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_2.jpg"></td>
							<td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_3.jpg" width="14" height="14" /></td>
						</tr>
						<tr>
							<td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_4.jpg"></td>
							<td align="center" valign="top" bgcolor="#FFFFFF" height="490">

								<iframe id="balanceForm" name="userBalanceForm" src="${ctx}/accInfo/orderInfo.do?userId=${userId}" frameborder="0" scrolling="no" height="100%" width="100%"></iframe>

							</td>
							<td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_5.jpg"></td>
						</tr>
						<tr>
							<td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_6.jpg" width="14" height="14" /></td>
							<td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_7.jpg"></td>
							<td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_8.jpg" width="14" height="14" /></td>
						</tr>
					</table>
				</div>

			</td>
		</tr>
	</table>

	</form:form>
</body>
</html>