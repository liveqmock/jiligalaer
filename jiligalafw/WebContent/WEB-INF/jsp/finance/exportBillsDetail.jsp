<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的账单 - 账单 - 扣费详细（按小时区分）</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
<!--
body {
	background-color: #000000;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
form {
	margin: 0px;
	padding: 0px;
}
-->
</style>
<script type="text/javascript">
function doQuery(){
	var form = document.forms.listForm;
	form.action="${ctx}/accBills/exportBills.do";
	loading();
	form.submit();	
}
</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/accBills/exportBills.do" method="post" name="listForm">
		<input type="hidden" name="expDate" value="${expDate }" />

          <table width="962" align="center" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_1.png" width="9" height="9" /></td>
              <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_2.png"></td>
              <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_3.png" width="9" height="9" /></td>
            </tr>
            <tr>
              <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_4.png"></td>
              <td align="center"  valign="top" bgcolor="#ffffff">
		       	
					<!-- 内容区域：查询条件和结果集 -->
					<table width="915" height="665" border="0" cellspacing="0" cellpadding="0">

	                  <tr>
	                    <td colspan="2" height="30" align="center" valign="middle"><b>${expDate} 账单明细</b></td>
	                  </tr>
	                  <tr>
	                    <td width="20"></td> <td height="2" align="center" valign="middle"><hr /></td>
	                  </tr>
	                  		              
					  <tr><td width="20"></td><td height="50" class="f13_1" align="left"><b>扣费总金额（<fmt:formatNumber pattern="#0.00">${expAmountTotal}</fmt:formatNumber>元）</b></td></tr>
					  
                      <tr>
                        <td width="20"></td>
						
						<td align="left" valign="top">  
							<ec:table items="list" var="item" onInvokeAction="doQuery()" form="listForm"
						        retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%;" tableId="${tableId}"
							    action="${ctx}/accBills/exportBills.do" showPagination="true" cellspacing="1">
							    <ec:exportXls fileName="账单明细.xls" tooltip="导出Excel" view="xls" />
								<ec:row>
									<ec:column property="_rowNumber" title="序号" cell="rowNumber" style="text-align:center; width: 5%; "/>
									<ec:column property="expDate" title="扣费日期" cell="date" format="yyyy-MM-dd HH:mm" style="text-align:center;width:13% "/>
									<ec:column property="expAmount" title="扣费金额（元）" cell="number" format="#0.00" style="text-align:right;width:8%"/>
									<ec:column property="cloudUserOrderItem.billingTypeName" title="计费类型" cell="number" format="#0.00" style="text-align:right;width:8%"/>
									<ec:column property="cloudUserOrder.cycleName" title="计费周期" cell="number" format="#0.00" style="text-align:right;width:8%" />
									<ec:column property="cloudUserOrder.basicUser.userName" title="用户 " style="text-align:left; width: 8%; "/>
									<ec:column property="cloudUserOrderItem.cloudMdmProduct.prodName" title="产品名称"  style="text-align:left;width:30%"/>
									<ec:column property="cloudUserOrderItem.buyName" title="备注"  style="text-align:left;width:20%"/>
								</ec:row>
							</ec:table> 
					    </td>
					    
                      </tr>
	                  <tr>
	                    <td height="20" colspan="2" ></td>
	                  </tr>

					  <tr>
					  	<td width="20"></td>
					  	<td height="50" class="f13_1" align="center">
					  		<a href="javascript:window.close();"><img src="${ctx}/images/btn8.png" alt="关闭" width="101" height="30" border="0" align="absmiddle"/></a>
						</td>
					  </tr>	                  
                    </table>
                    		       	
              </td>
              <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_5.png"></td>
            </tr>
            <tr>
              <td align="left" valign="top"><img src="${ctx}/images/sheet_border_6.png" width="9" height="9" /></td>
              <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_7.png"></td>
              <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_8.png" width="9" height="9" /></td>
            </tr>
          </table>

                              
	</form:form>
  </body>
</html>