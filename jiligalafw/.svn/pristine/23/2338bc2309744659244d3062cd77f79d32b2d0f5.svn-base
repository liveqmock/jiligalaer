<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>订单信息</title>
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
//日期查询
function dateQuery(val,userId){
	var form = document.forms.listForm;
	form.timeFlag.value=val;
	form.action="${ctx}/accInfo/orderInfo.do";
	loading();
	form.submit();
}
function query(){
	var form = document.forms.listForm;
	form.action="${ctx}/accInfo/orderInfo.do";
	loading();
	form.submit();
}
</script>
</head>
<body>
  <form:form modelAttribute="cloudUserOrderVoList" action="${ctx}/accInfo/orderInfo.do" method="post" name="listForm">
	<input type="hidden" name="timeFlag" value="${timeFlag }" id="timeFlag" />
	<input type="hidden" name="userId" value="${userId }" id="userId" />
	
	<table width="806" border="0" cellspacing="0" cellpadding="0">
	   <tr><td height="10"></td></tr>
	   <tr>
	     <td align="left" valign="top" >
	       <table width="801" border="0" cellspacing="1" cellpadding="0" bgcolor="#eeeeee">
	         <tr bgcolor="#ffffff" height="20">
	           <td>
	           
	            <table width="801" border="0" cellspacing="1" cellpadding="0">
	               <tr height="30">
	               	<td></td>
	                 <td width="80" class="f13_1" align="left">购买日期：</td>
	                 <td>
						<a href="javascript:dateQuery('','${userId }');" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:dateQuery('1','${userId }');" class="f13_3">今日</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:dateQuery('2','${userId }');" class="f13_3">本周</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:dateQuery('3','${userId }');" class="f13_3">上周</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:dateQuery('4','${userId }');" class="f13_3">本月</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:dateQuery('5','${userId }');" class="f13_3">上月</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:dateQuery('6','${userId }');" class="f13_3">其它</a>&nbsp;&nbsp;&nbsp;&nbsp;
	                 </td>
	                 <td></td>
	               </tr>
	             </table>
	             
	           </td>                                   
	         </tr>
	       </table>
	     </td>
	   </tr>
	   <tr><td height="20"></td></tr>
	  <tr>
	    <td align="left" valign="top">
	    
			<ec:table items="orderList" var="item" onInvokeAction="dateQuery('${timeFlag }','${userId }')" form="listForm"
		        retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%" tableId="${tableId}"
			    action="${ctx}/accInfo/orderInfo.do" showPagination="true" cellspacing="1" rowsDisplayed="15">
			    
			    <ec:exportXls fileName="订单.xls" tooltip="导出Excel" view="xls" />
				<ec:row>
					<ec:column property="_rowNumber" title="序号" cell="rowNumber" style="text-align: center; width:4%"/>
					<ec:column property="cloudMdmProduct.prodName" title="产品名称" style="width:21%; text-align: left;" alias="prodName"/>
					<ec:column property="cloudMdmProductItem.itemTypeName" title="产品类型" style="width:10%; text-align: left;" alias="itemTypeName" />									
					<ec:column property="cloudUserOrder.orderTime" title="购买日期" cell="date" format="yyyy-MM-dd HH:mm" style="width:10%; text-align: center;"/>									
					<ec:column property="1" title="价格（元）" style="width:10%; text-align: right;">
		            	<c:choose>
		            		<c:when test="${item.billingType == '1' }">
								<c:if test="${item.cloudUserOrder.billingCycle == '2' }">${item.cloudProductPrice.yearPrice }/年</c:if>
								<c:if test="${item.cloudUserOrder.billingCycle == '3' }">${item.cloudProductPrice.monthPrice }/月</c:if>
								<c:if test="${item.cloudUserOrder.billingCycle == '4' }">${item.cloudProductPrice.dayPrice }/天</c:if>
								<c:if test="${item.cloudUserOrder.billingCycle == '5' }">${item.cloudProductPrice.hourPrice }/小时</c:if>
		            		</c:when>
		            		<c:otherwise>
		            			${item.cloudProductPrice.oneTimePrice }/一次性
		            		</c:otherwise>
		            	</c:choose>										
					</ec:column>
					<ec:column property="resDestroyTime" title="状态" style="width:5%; text-align: center;" value="${item.resDestroyTime != null ? '销毁' : '有效' }"/>
					<ec:column property="buyName" title="备注" style="width:20%; text-align: left;"/>
				</ec:row>
			</ec:table>
<%--				    
	      <table width="788" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
	        <tr bgcolor="#92b8c1" height="20">
	          <td width="5%" align="center" class="f12">序号</td>
	          <td width="25%" align="center" class="f12">产品名称</td>
	          <td width="10%" align="center" class="f12">产品类型</td>
	          <td width="10%" align="center" class="f12">购买时间</td>
	          <td width="8%" align="center" class="f12">状态</td>
	          <td width="15%" align="center" class="f12">备注</td>
	        </tr>
	      </table>
	      
	      <div id="order" style="height:400px; z-index:1; width:803px; overflow-y: scroll; overflow-x:hidden; ">   
		      <table width="788" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">

			  	<%int j=0; %>
				<c:forEach var="item" items="${orderList}" >
		        <%
		        String bgcolor="#eef6f7";
		        if(j++ % 2 == 0){bgcolor="#deecef"; }
		        %>
		         <tr bgcolor="<%=bgcolor %>" height="20" valign="top">
		            <td width="5%" align="center" class="f12_1"><%=j %></td>
		            <td width="25%" align="left" class="f12_1" title="${item.cloudMdmProduct.prodName }">
		            	${fn:substring(item.cloudMdmProduct.prodName,0,35) }
		            </td>
		            <td width="10%" align="left" class="f12_1">${item.cloudMdmProductItem.itemTypeName }</td>
		            <td width="10%" align="center" class="f12_1"><fmt:formatDate value="${item.cloudUserOrder.orderTime }" pattern="yyyy-MM-dd HH:mm" /></td>
					
		            <td width="8%" align="center" class="f12_1">${item.resDestroyTime != null ? '销毁' : '有效' }</td>
		            <td width="15%" align="left" class="f12_1">${item.buyName }</td>
		          </tr>
	          	</c:forEach>
	          	
		       </table>
	      </div>
--%>	    
	    </td>
	  </tr>
	</table>

  </form:form>
</body>
</html>