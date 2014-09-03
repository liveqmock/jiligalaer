<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>用户-账单信息</title>
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
function open_high() {
	document.getElementById('search').style.display = 'block';
	document.getElementById('openSearch').style.display = 'none';
}
function close_high() {
	document.getElementById('search').style.display = 'none';
	document.getElementById('openSearch').style.display = 'block';
}
//高级查询
function query(val) {
	var form = document.forms.listForm;
	form.queryType.value=val;
	form.action="${ctx}/accInfo/queryBillInfo.do";
	loading();
	form.submit();
}
//日期查询
function dateQuery(val){
	var form = document.forms.listForm;
	form.queryType.value='0';
	form.timeFlag.value=val;
	form.action="${ctx}/accInfo/queryBillInfo.do";
	loading();
	form.submit();
}
function display() {
	var queryType = '${queryType}';
	if (queryType == '1') {
		open_high();
	}
}
</script>
</head>
<body onLoad="display();">
  <form:form modelAttribute="baseVoList" action="${ctx}/accInfo/queryBillInfo.do" method="post" name="listForm">
		<input type="hidden" name="userId" value="${userId }" />
		<input type="hidden" name="timeFlag" value="" id="timeFlag" />
		<input type="hidden" name="queryType" value="" id="queryType" />
		
     	<table width="806" border="0" cellspacing="0" cellpadding="0">
         <tr><td height="10"></td></tr>
         <tr>
           <td align="left" valign="top" >
           	<table width="801" border="0" cellspacing="1" cellpadding="0" bgcolor="#eeeeee">
              <tr bgcolor="#ffffff" height="20">
                 <td>
                  	<table width="801" border="0" cellspacing="1" cellpadding="0">
                     <tr height="30">
                       <td>&nbsp;</td>
                       <td width="80" class="f13_1" align="left">扣费日期：</td>
                       <td width="690" >
                       	  <a href="javascript:dateQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
                          <a href="javascript:dateQuery('1')" class="f13_3">本月</a>&nbsp;&nbsp;&nbsp;&nbsp;
                          <a href="javascript:dateQuery('2')" class="f13_3">本年</a>&nbsp;&nbsp;&nbsp;&nbsp;
                          <a href="javascript:dateQuery('3')" class="f13_3">去年</a>&nbsp;&nbsp;&nbsp;&nbsp;
                       </td>
                       <td></td>
                     </tr>
                     
                     <tr height="30" style="cursor:pointer;" onclick="open_high()">
                       <td></td>
                       <td colspan="2" align="left" class="f15">
                       	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
                       	  <tr>
                          	<td width="20" align="left"><img src="${ctx}/images/ico14.png" width="20" height="20" /></td>
                          	<td width="80" align="center">高级搜索</td>
                          	<td width="20" align="left"><img id="openSearch" src="${ctx}/images/ico15.png" width="20" height="20" /></td>
                          	<td>&nbsp;</td>
                          <tr>
                       	</table>
                       </td>
                       <td></td>
                     </tr>
                           
                     <tr>
                     	<td width="15"></td>
                     	<td colspan="2">
                     	  <table width="100%" border="0" cellspacing="1" cellpadding="0" id="search" style="display: none;">
                     	  	<tr>
                     	      <td colspan="3" align="left" valign="top"><img src="${ctx}/images/sheet_line_2.png" width="760" height="2" /></td>
                           </tr>
                           <tr height="30">
                          	<td width="15"></td>
                             <td width="80" class="f13_1" align="left">扣费日期：</td>
                                <td align="left" class="f13_1">
                                  	从<input name="dateS" type="text" value="${dateS }" onfocus="WdatePicker()" readonly class="date_but"/>
									到<input name="dateE" type="text" value="${dateE }" onfocus="WdatePicker()" readonly class="date_but"/>
                                </td>
                           </tr>
                           
                           <tr height="50">
                          	<td width="15"></td>
                            <td colspan="2" align="left"  valign="middle">
                            	<a href="javascript:void(0)"><img src="${ctx}/images/btns2.png" alt="提交" onclick="query('1')" width="101" height="29" border="0"/></a>
                            	&nbsp;&nbsp;&nbsp;&nbsp;
                            	<a href="javascript:void(0)"><img src="${ctx}/images/btnc1.png" alt="重置" onclick="document.forms.listForm.reset();return false;" width="101" height="30" border="0"/></a>
                            </td>
                           </tr>
                           <tr valign="bottom">
                          	<td colspan="3" align="center"><img src="${ctx}/images/close.png" width="80" height="18" border="0" align="absmiddle" style="cursor:pointer;" onclick="document.getElementById('search').style.display='none';document.getElementById('openSearch').style.display='block';document.getElementById('order').style.height='330px'"/></td>
                           </tr>
                         </table>
                       </td>
                       <td width="15"></td>
                     </tr>
                   </table>
                 </td>                                   
               </tr>
             </table>
           </td>
         </tr>
        
        <!--
        <tr><td height="20"></td></tr>
        <tr>
          <td align="left" valign="top">
          	<table width="805" border="0" cellspacing="0" cellpadding="0" bgcolor="#eeeeee">
              <tr bgcolor="#ffffff" height="25">
                <td width="5%" align="center" class="f13_3"><a href="#" class="f13_3">《《</a></td>
                <td width="18%" align="center" class="f13_3"><a href="#" class="f13_3">2013年7月（20元）</a></td>
                <td width="18%" align="center" class="f13_3"><a href="#" class="f13_3">2013年8月（20元）</a></td>
                <td width="18%" align="center" class="f13_3"><a href="#" class="f13_3">2013年9月（20元）</a></td>
                <td width="18%" align="center" class="f13_3"><a href="#" class="f13_3">2013年10月（20元）</a></td>
                <td width="5%" align="center" class="f13_3"><a href="#" class="f13_3">》》</a></td>
                <td width="30%" align="center" class="f12_1"></td>
              </tr>          	
            </table>
          </td>
        </tr>
        -->
		<tr><td height="10"></td></tr>
		
		
		<tr><td height="20" class="f12_1">账单总额：<fmt:formatNumber pattern="#0.00">${totalExpAmount }</fmt:formatNumber> 元</td></tr>
        <tr>
          <td align="left" valign="top">
          	<table width="790" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">        	
              <tr bgcolor="#92b8c1" height="20">
		          <td width="5%" align="center" class="f12">序号</td>
		          <td width="15%" align="center" class="f12">扣费日期</td>
		          <td width="12%" align="center" class="f12">扣费金额（元）</td>
		          <td width="9%" align="center" class="f12">计费类型</td>
		          <td width="9%" align="center" class="f12">计费周期</td>
		          <td width="30%" align="center" class="f12">产品名称</td>
		          <td width="20%" align="center" class="f12">备注</td>
              </tr>
            </table>
            
           <div id="order" style="height:350px; width:805px; z-index:1; overflow-y: scroll; overflow-x: hidden;">   
             <table width="790" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
				<%int j=0; %>
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
					   <td width="30%" align="left" class="f12_1">${item.cloudUserOrderItem.cloudMdmProduct.prodName }</td>
					   <td width="20%" align="left" class="f12_1">${item.cloudUserOrderItem.buyName }</td>					   
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