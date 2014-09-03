<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品管理-组合产品列表</title>
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
function prodCustom(){
	//return window.open("${ctx}/combinProd/selectDc.do");
	return window.openwindow("${ctx}/combinProd/selectDc.do","选择资源",980,645);
}
function getProdItemInfo(id,name){
	var form = document.forms.listForm;
	form.action="${ctx}/combinProd/list.do?editType=upd&prodId="+id;
	form.submit();
}
function getProdInfo(){
	var form = document.forms.listForm;
	form.action="${ctx}/combinProd/list.do";
	form.submit();
}
function save(){
	var form = document.forms.listForm;	
	if($("#prodName").val() ==''){
		alert("产品名称不能为空!");
		return;
	}
	
	form.id.value="";
	if($("#editType").val() == 'upd'){
		//编辑保存
		form.action="${ctx}/combinProd/editSave.do";
	}else{
		form.action="${ctx}/combinProd/save.do";
		//新增保存
	}
	form.submit();
}
function selectedProductItem(){
	var form = document.forms.listForm;
	form.id.value="";
	form.action="${ctx}/combinProd/list.do?saveFlag=1";
	form.submit();
}
function keyDown() {
  	if (event.keyCode==13) {
  		query();
  	}
}
function query(){
	var form = document.forms.listForm;
	form.id.value="";
	form.submit();
}
function doDel(){
	if(confirm("确认删除吗？")){
		var form = document.forms.listForm;
		var prodId =$("#prodId").val().replace(/\s/g, "");
		form.action="${ctx}/combinProd/delete.do?prodId="+prodId;
		form.submit();
	}
}
function selectedProductItem(){
	$("#prodName").val("");
	$("#description").val("");
	$("#prodId").val("");//基础产品表：产品ID
	$("#editType").val("");
	var form = document.forms.listForm;
	form.action="${ctx}/combinProd/list.do?saveFlag=1";
	form.submit();
}
//设置选择背景颜色
function setBgColor(rowNo){
	var rows = document.getElementById("tableId").rows.length;
	for(var i=0; i<=rows; i++){
		if(rowNo == i){
			document.getElementById("leftTd"+i).style.backgroundColor ="#1C9DBA";
			document.getElementById("rightTd"+i).style.backgroundColor ="#1C9DBA";
		}else{
			document.getElementById("leftTd"+i).style.backgroundColor ="";
			document.getElementById("rightTd"+i).style.backgroundColor ="";
		}
	}
}
</script>
<script type="text/javascript">
var msg = '${prodSaveMsg}';
if(msg!=''){
	alert(msg);
	window.location.href="${ctx}/combinProd/list.do";
}
</script>
</head>
  <body onLoad="">
    <form:form modelAttribute="cloudMdmProductItemVo" action="${ctx}/combinProd/list.do" method="post" name="listForm">
      <form:hidden path="id" id="id"/>
      <input type="hidden" id="cpId" name="cpId" value="${cpId}"/>
      <input type="hidden" id="editType" name="editType" value="${editType}"/>
      
          <table width="962" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td align="center"  valign="top" bgcolor="#F2F2F2">

			<div id="middle_sheet_myR_01">
			<table width="230" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="38" height="50" align="center" valign="middle"><img
						src="${ctx}/images/myR_ico_01.png" width="20" height="21" /></td>
					<td width="182" align="left" valign="middle" class="f16_1">
					已有产品&nbsp;&nbsp;<img src="${ctx}/images/btn6.png" width="62" height="22"
						border="0" align="absmiddle" style="cursor: pointer;"
						onclick="prodCustom()" /></td>
				</tr>

				<tr valign="top">
					<td colspan="2">
					<div id="order" style="height: 295px; z-index: 1; overflow-y: scroll; overflow-x: hidden; width: 97%;">
					<table width="98%" align="right" border="0" cellpadding="0" cellspacing="0" id="tableId">
						<%int i=0; %>
						<c:forEach var="item" items="${cloudMdmProductVoList}" varStatus="status">
						
							<tr height="28" valign="middle" style="cursor: pointer;" onclick="getProdItemInfo('${item.id}','${item.prodName}')">
							<c:choose>
								<c:when test="${cpId == item.id }">
									<td width="10" height="28" bgcolor="#1C9DBA">&nbsp;</td>
									<td height="28" align="left" bgcolor="#1C9DBA" class="f13_1"  id="rightTd<%=i %>">${fn:substring(item.prodName,0,15)}</td>								
								</c:when>
								<c:otherwise>
									<td width="10" height="28">&nbsp;</td>
									<td height="28" align="left" class="f13_1"  id="rightTd<%=i %>">${fn:substring(item.prodName,0,15)}</td>
								</c:otherwise>
							</c:choose>
							</tr>
						</c:forEach>
					</table>
					</div>
					</td>
				</tr>

                <tr>
                  <td height="5" colspan="2" align="center" valign="middle"><img src="${ctx}/images/buy_blue_line.jpg" width="210" height="2" /></td>
                </tr>
				<tr>
					<td align="center" valign="middle" colspan="2"><input
						type="text" class="text13" id="keyword" name="keyword"
						value="${keyword }" size="20" style="height: 15px;" onkeydown="keyDown()" /> <img
						src="${ctx}/images/btn7.png" width="62" height="22" border="0"
						align="absmiddle" style="cursor: pointer;" onclick="query()" /></td>
				</tr>
			</table>
			</div>

			<div id="middle_sheet_myR_02">
                  <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="12"><img src="${ctx}/images/buy_sheet_border_01.png" width="12" height="35" /></td>
                      <td width="694" background="${ctx}/images/buy_sheet_border_02.png" align="left" class="f18_1">产品维护</td>
                      <td width="10"><img src="${ctx}/images/buy_sheet_border_03.png" width="10" height="35" /></td>
                    </tr>
                    <tr>
                      <td background="${ctx}/images/buy_sheet_border_04.png">&nbsp;</td>
                      <td align="left" valign="top" bgcolor="#F0F1F2">
                        <table width="336" border="0" cellspacing="0" cellpadding="0">
                          <tr  height="40">
                            <td colspan="2" width="687" align="left" valign="middle" class="f13_1">
                            	产品名称：
                            	<form:input path="mdmProduct.prodName" class="text13" size="40" id="prodName" />
                            	<form:hidden path="mdmProduct.id" id="prodId"/>
                            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            	<c:if test="${baocunFlag ==1}">
                            		<img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="save()"/>
                            	</c:if>
                            	<c:if test="${shanchuFlag ==1}">
	                            	<input type="button" value="删&nbsp;&nbsp;除" class="buttonBg_1" onclick="doDel();"/>
                            	</c:if> 
                            	</td>
                          </tr>
						  <tr  height="35">
                            <td colspan="2" width="637" align="left" valign="middle" class="f13_1">
                            	产品描述：
                            	<form:input path="mdmProduct.description" class="text13" size="83" id="description"/>
                            </td>
                          </tr>                          
                          <tr>
                            <td height="5" colspan="2" align="left" valign="middle"><img src="${ctx}/images/buy_blue_line.jpg" width="690" height="1" /></td>
                          </tr>
                          <tr  height="30">
                            <td colspan="2" width="637" align="left" class="f15_1">产品属性：</td>
                          </tr>
                          <tr>
                            <td height="5" colspan="2">
                              <div id="middle_sheet_myR_s">
                              	<table width="692" border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_1.jpg" width="14" height="14" /></td>
                                    <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_2.jpg"></td>
                                    <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_3.jpg" width="14" height="14" /></td>
                                  </tr>
                                  <tr>
                                    <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_4.jpg"></td>
                                    <td align="center" valign="top" bgcolor="#FFFFFF" height="220" >
	                                  <table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
	                                    <tr bgcolor="#deecef" height="25">
                                          <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;数据中心：</td>
                                          <td width="80%" height="25" align="left" class="f12_1">${mdmZoneName}</td>
                                        </tr>    
                                       <!-- <tr bgcolor="#eef6f7" height="25">
                                          <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;网络方案：</td>
                                          <td width="80%" height="25" align="left" class="f12_1">${cloudMdmNetworkSolnDetail.prodName}</td>
                                        </tr>   --> 
                                        <tr bgcolor="#deecef" height="25">
                                          <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;计算方案：</td>
                                          <td width="80%" height="25" align="left" class="f12_1">${cloudMdmCPUSolnDetail.prodName}</td>
                                        </tr>   
                                        <tr bgcolor="#eef6f7" height="25">
                                          <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;磁盘方案：</td>
                                           <c:choose>
		                                 <c:when test="${cloudMdmDiskSolnDetail.prodName == null}">
		                                 	<td width="80%" align="left" class="f12_1">No,thanks.</td>
		                                 </c:when>
		                                 <c:otherwise>
		                                   <td width="80%" height="25" align="left" class="f12_1">${cloudMdmDiskSolnDetail.prodName}</td>
		                                 </c:otherwise>
		                               </c:choose>
                                         
                                        </tr>  
                                        <tr bgcolor="#deecef" height="25">
                                          <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;模板：</td>
                                          <td width="80%" height="25" align="left" class="f12_1">${cloudMdmTemplateDetail.prodName}</td>
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
                                </table>
                              </div>
                            </td>
                          </tr>                          
                        </table>
                      </td>
                      <td background="${ctx}/images/buy_sheet_border_05.png"></td>
                    </tr>
                    <tr>
                      <td><img src="${ctx}/images/buy_sheet_border_06.png" width="12" height="13" /></td>
                      <td height="13" background="${ctx}/images/buy_sheet_border_07.png"></td>
                      <td><img src="${ctx}/images/buy_sheet_border_08.png" width="10" height="13" /></td>
                    </tr>
                  </table>
                </div>
                
              </td>
            </tr>
          </table>
        
	</form:form>
  </body>
</html>