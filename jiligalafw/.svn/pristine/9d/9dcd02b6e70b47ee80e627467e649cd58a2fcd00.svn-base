<%@ include file="/commons/taglibs.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品管理-产品定价</title>
<link href="css/css_main.css" rel="stylesheet" />
<link href="css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/autoheight.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
<!--
body {
	background-color: #F2F2F2;
	margin-left: 10px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<%@ include file="/commons/meta.jsp"%>
<script type="text/javascript">
function query(){
	var form = document.forms.listForm;
	loading();
	form.submit();
}

function getProdList(prodType){
	var form = document.forms.listForm;
	form.action="${ctx}/makePrice/prodList.do?prodType="+prodType;
	form.submit();
}

function edit(prodId,priceMode){
	var form = document.forms.listForm;
	form.action="${ctx}/makePrice/editInit.do?prodItemId="+prodId+"&priceMode="+priceMode;
	form.submit();
}
</script>
</head>
<body>  

  <form:form modelAttribute="cloudProductPriceVoList" action="${ctx}/makePrice/prodList.do" method="post" id="listForm" >
   
        <!-- 外层边框 -->
		<div id="middle_sheet_s">
			<table width="950" border="0" cellpadding="0" cellspacing="0" align="center">
		      <tr>
		        <td align="center" valign="top" bgcolor="#F2F2F2">
		       	
					<table width="915" border="0" cellspacing="0" cellpadding="0">
					  <tr>
	                    <td height="2" align="center" valign="middle"><img src="${ctx}/images/sheet_line_2.jpg" width="915" height="2" /></td>
	                  </tr>					
                  	  <tr>
                    	<td align="left" valign="top">
                    	
                    	
                    	 <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#a0a0a0">
	                      	<tr bgcolor="#f2f2f2">
                          	  <td>
                           		<table width="100%" border="0" cellspacing="1" cellpadding="0">
                              	  <tr height="30">
                                	<td width="80" class="f13_1" align="left">产品类型：</td>
                                	<td >
										<select name="prodType" onchange="getProdList(this.value)" style="width: 155px; height: 23px;">
										  <option value="" >全部</option>
										  <c:forEach var="item" items="${prodTypeList}" >
										     <option value="${item.itemCode }" <c:if test="${item.itemCode == prodType}">selected</c:if> >${item.itemName }</option>
										  </c:forEach>
										</select>
									</td>
                                	<td width="80" class="f13_1" align="left">产品描述：</td>
                                	<td >
										<input type="text" name="description" id="description" value="${description }" size="33"/>
									</td>
									<td>
										<img src="${ctx}/images/btn15.png" alt="查找" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:query();"/>
									</td>
                              	  </tr>
                            	  
                              	  <tr height="30">
                                	<td width="80" class="f13_1" align="left">产品名称：</td>
                                	<td ><input type="text" name="prodName" id="prodName" value="${prodName }" /></td>  
                                	<td width="80" class="f13_1" align="left">有效日期：</td>
                                	<td class="f13_1">
										从<input name="dateS" type="text" value="${dateS }" onfocus="WdatePicker()" readonly class="date_but"/>
										到<input name="dateE" type="text" value="${dateE }" onfocus="WdatePicker()" readonly class="date_but"/>
									</td>
                                	<td>&nbsp;</td>
                              	  </tr>                              	  
                            	</table>
                          	  </td>                                   
                        	</tr>
                      	  </table>
                      	  
                      	  
                    	</td>
                      </tr>
                    
	                  <tr><td height="2"></td></tr>
	                  <tr>
	                    <td height="2" align="center" valign="middle"><img src="${ctx }/images/sheet_line_2.jpg" width="915" height="2" /></td>
	                  </tr>
                	
					  <tr><td height="20"></td></tr>
					  
                      <tr>
						<td align="left" valign="top">
						      
		                   	<ec:table items="list" var="item" onInvokeAction="query()" form="listForm"
						        retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%" tableId="${tableId}"
							    action="${ctx}/makePrice/prodList.do" showPagination="true" cellspacing="1">
								<ec:row>
									
									
									<ec:column property="itemTypeName" title="产品类型" style="width:8%; text-align: left;"/>
									<ec:column property="prodName" title="产品名称" style="width:15%; text-align: left;">
										<span title="${item.prodName }">${fn:substring(item.prodName,0,20) }</span>
									</ec:column>
									<ec:column property="description" title="产品描述" style="width:22%; text-align: left;">
										<span title="${item.description }">${fn:substring(item.description,0,30) }</span>
									</ec:column>
									<ec:column property="priceMode" title="定价方式" style="width:8%; text-align: center;">
										<c:if test="${item.priceMode == '0' }">
											一次性
										</c:if>
										<c:if test="${item.priceMode == '1' }">
											周期性
										</c:if>
									</ec:column>
									<ec:column property="price" title="价格" style="width:24%; text-align: right;">
										<c:if test="${item.priceMode == '0' }">
											${item.oneTimePrice }/一次性
										</c:if>
										<c:if test="${item.priceMode == '1' }">
											${item.yearPrice }/年; ${item.monthPrice }/月; ${item.dayPrice }/日; ${item.hourPrice }/时
										</c:if>
									</ec:column>
									
									<ec:column property="effectiveDate" title="生效日期" cell="date" format="yyyy-MM-dd" style="width:9%; text-align: center;"/>
									<ec:column property="invalidDate" title="失效日期" cell="date" format="yyyy-MM-dd" style="width:9%; text-align: center;"/>
                                    
                                    <ec:column property="null" title="操作" style="width:5%; text-align: left;" >
										<a onclick="javascript:edit('${item.prodItemId}','${item.priceMode }')" style="text-decoration:none;"><input type="button" class="btn_bg" value="修改" /></a>
									</ec:column>
								</ec:row>
							</ec:table>
							
					    </td>
					  </tr>

		       	  </table>
		        </td>
		      </tr>
			</table>
		</div>   

  </form:form>
	<script>
	$(document).ready(function(){
		colapsnRowsHtml(0);
		colapsnRowsText(1);
		colapsnRowsText(2);
		colapsnRowsText(3);
	});
	</script>
</body>
</html>