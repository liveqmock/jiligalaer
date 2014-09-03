<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品管理-单一产品列表-选择资源主页面-计算方案</title>
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
	background-color:#F2F2F2;
	background-repeat:repeat;
	background-position:left;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function selProd(prodId,priceId,prodItemId){
	$("#prodId").val(prodId);
	$("#priceId").val(priceId);
	$("#prodItemId").val(prodItemId);
}
function save(){
	var priceId = $("#priceId").val();
	var prodItemId = $("#prodItemId").val();
	var prodId = $("#prodId").val();
	if(priceId == ''){
		alert("请选择计算方案");
		return;
	}
	
	if(confirm("确认改变计算方案吗？")){
		var form = document.forms.listForm;
		form.action="${ctx}/myVm/changeCpu.do?priceId="+priceId+"&prodItemId="+prodItemId+"&prodId="+prodId;
		waitloading();
		form.submit();
	}
}
</script>
<script type="text/javascript">
var msg = '${cpuChangeMsg}';
if(msg!=''){
	alert(msg);
	window.close();
}
</script>
</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/singleProd/computResource.do" method="post" name="listForm">
		<input type="hidden" name="orderId" id="orderId" value="${orderId }"/>
		<input type="hidden" name="billingCycle" id="billingCycle" value="${billingCycle }"/>
		<input type="hidden" name="prodId" id="prodId" />
		<input type="hidden" name="priceId" id="priceId" />
		<input type="hidden" name="prodItemId" id="prodItemId" />
		
          <table width="962" border="0" cellpadding="0" cellspacing="0" align="center">
            <tr>
              <td align="center"  valign="top" bgcolor="#F2F2F2">
                <table border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="50" align="left" valign="bottom"><span class="f16b2">更改计算方案</span></td>
                    <td align="left" valign="bottom">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="2" colspan="2" align="center" valign="middle"><hr /></td>
                  </tr>
                  <tr>
                    <td colspan="2" >
                    
                      <div id="middle_sheet_pm_s">
                      	<table width="855" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_1.jpg" width="14" height="14" /></td>
                            <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_2.jpg"></td>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_3.jpg" width="14" height="14" /></td>
                          </tr>
                          <tr>
                            <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_4.jpg"></td>
                            <td align="left" valign="top" bgcolor="#FFFFFF" height="380">

                            <c:choose>
                            	<c:when test="${fn:length(priceList) < 1 }">
                            		<span class="f13_1" style="color: red;">未找到与虚拟机相同计费方式的计算方案：</span>
                            	</c:when>
                            	<c:otherwise>
                            		<span class="f13_1" style="color: red;">请选择与虚拟机相同计费方式的计算方案：</span>
                            	</c:otherwise>
                            </c:choose>                           
					       	<table width="806" border="0" cellpadding="0" cellspacing="0">
					           <tr>
					             <td align="left" valign="top" bgcolor="#FFFFFF" height="420">
						     		<table width="900" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
						              <tr bgcolor="#92b8c1" height="20">
						                <td width="10%" align="center" class="f12">序号</td>
						                <td width="20%" align="center" class="f12">计算方案名称</td>
						                <td width="35%" align="center" class="f12">描述</td>
						                <td width="20%" align="center" class="f12">价格	
						                	<c:if test="${billingCycle=='0' }">（一次性收费）</c:if>
						                  	<c:if test="${billingCycle=='2' }">（年收费）</c:if>
						                  	<c:if test="${billingCycle=='3' }">（月收费）</c:if>
						                  	<c:if test="${billingCycle=='4' }">（天收费）</c:if>
						                  	<c:if test="${billingCycle=='5' }">（小时收费）</c:if>
						                </td>
						                <td width="15%" align="center" class="f12">选择</td>
						              </tr>
						            </table>

							        <div id="order" style="height:380px; z-index:1; overflow-y: scroll;overflow-x:hidden;">   
							       		<table width="900" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
							             
							              <%int i=0; %>
										  <c:forEach var="item" items="${priceList}" >
									        <%
									        String bgcolor="#deecef";
									        if(i++ % 2 == 0){bgcolor="#eef6f7"; }
									        %>
									        <tr bgcolor="<%=bgcolor %>" height="20">
							                  <td width="10%" align="center" class="f12_1"><%=i %></td>
							                  <td width="20%" align="left" class="f12_1">${item.cloudMdmProduct.prodName }</td>
							                  <td width="35%" align="left" class="f12_1">${item.cloudMdmProduct.description }</td>
							                  <td width="20%" align="right" class="f12_1">
							                  	<c:if test="${billingCycle=='0' }">${item.oneTimePrice } 元</c:if>
							                  	<c:if test="${billingCycle=='2' }">${item.yearPrice } 元</c:if>
							                  	<c:if test="${billingCycle=='3' }">${item.monthPrice } 元</c:if>
							                  	<c:if test="${billingCycle=='4' }">${item.dayPrice } 元</c:if>
							                  	<c:if test="${billingCycle=='5' }">${item.hourPrice } 元</c:if>
							                  </td>
							                  <td width="15%" align="center" class="f12_1">
							                  	<input type="radio" name="radio" id="radio" 
							                  		onclick="selProd('${item.cloudMdmProduct.id}','${item.id }','${item.cloudMdmProductItem.id }')">
							                  </td>
							                </tr>
							        	  </c:forEach>
							        	  
							            </table>
							        </div>
						            
					             </td>
					           </tr>
					         </table>

                            </td>
                            <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_5.jpg"></td>
                          </tr>
                          <tr>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_6.jpg" width="14" height="14" /></td>
                            <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_7.jpg"></td>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_8.jpg" width="14" height="14" /></td>
                          </tr>
                          <tr><td colspan=3 height="20"></td></tr>
                        </table>
                      </div>

                    </td>
                  </tr>
                  <tr>
                    <td height="2" colspan="2" align="center" valign="middle"><img src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" /></td>
                  </tr>
                  <tr>
                    <td height="20" colspan="2" ></td>
                  </tr>
                  <tr>
                    <td colspan="2" align="center" valign="middle">
                    	<table width="394" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td align="center" valign="top"><a href="javascript:save()"><img src="${ctx}/images/btn11.png" alt="确定" width="101" height="30" border="0" align="absmiddle"/></a></td>
                          <td align="center" valign="top"><a href="javascript:window.close()"><img src="${ctx}/images/btn8.png" alt="关闭" width="101" height="30" border="0" align="absmiddle"/></a></td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                  <tr>
                    <td height="10" colspan="2" ></td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
                                         
	</form:form>
  </body>
</html>