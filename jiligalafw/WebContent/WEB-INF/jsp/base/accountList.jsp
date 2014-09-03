<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>账户维护</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/popup.dialog.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
<!--
body {
	background-color: #F2F2F2;
	margin-left: 5px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script type="text/javascript">
	function doQuery(queryType) {
		loading();
		document.getElementById('queryType').value = queryType;
		document.forms.listForm.submit();
	}
	function stateQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '4';
		form.stateFlag.value = val;
		form.action = "${ctx}/account/list.do";
		loading();
		form.submit();
	}
	function userAccountTypeQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '0';
		form.userAccountTypeFlag.value = val;
		form.action = "${ctx}/account/list.do";
		loading();
		form.submit();
	}
	function userIdentityQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '1';
		form.userIdentityFlag.value = val;
		form.action = "${ctx}/account/list.do";
		loading();
		form.submit();
	}
	function geoQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '2';
		form.geoFlag.value = val;
		form.action = "${ctx}/account/list.do";
		loading();
		form.submit();
	}
	function industryQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '3';
		form.industryFlag.value = val;
		form.action = "${ctx}/account/list.do";
		loading();
		form.submit();
	}

	function open_high() {
		document.getElementById('search').style.display = 'block';
		document.getElementById('openSearch').style.display = 'none';
	}
	function close_high() {
		document.getElementById('search').style.display = 'none';
		document.getElementById('openSearch').style.display = 'block';
	}
	function checkAllBox() {
		var stateStr = '${stateStr}';
		var userAccountTypeStr = '${userAccountTypeStr}';
		var userIdentityStr = '${userIdentityStr}';
		var geoStr = '${geoStr}';
		var industryStr = '${industryStr}';
		if(stateStr !="" || stateStr != undefined){
			var sts = stateStr.split(",");
			var st = document.getElementsByName("state");
			for ( var i = 0; i < st.length; i++) {
				for ( var j = 0; j < sts.length; j++) {
					if (st[i].value == sts[j]) {
						st[i].checked = true;
					}
				}
			}
		}
		if(userAccountTypeStr !="" || userAccountTypeStr != undefined){
			var sts = userAccountTypeStr.split(",");
			var st = document.getElementsByName("userAccountType");
			for ( var i = 0; i < st.length; i++) {
				for ( var j = 0; j < sts.length; j++) {
					if (st[i].value == sts[j]) {
						st[i].checked = true;
					}
				}
			}
		}
		if(userIdentityStr !="" || userIdentityStr != undefined){
			var sts = userIdentityStr.split(",");
			var st = document.getElementsByName("userIdentity");
			for ( var i = 0; i < st.length; i++) {
				for ( var j = 0; j < sts.length; j++) {
					if (st[i].value == sts[j]) {
						st[i].checked = true;
					}
				}
			}
		}
		if(geoStr !="" || geoStr != undefined){
			var sts = geoStr.split(",");
			var st = document.getElementsByName("geo");
			for ( var i = 0; i < st.length; i++) {
				for ( var j = 0; j < sts.length; j++) {
					if (st[i].value == sts[j]) {
						st[i].checked = true;
					}
				}
			}
		}
		if(industryStr !="" || industryStr != undefined){
			var sts = industryStr.split(",");
			var st = document.getElementsByName("industry");
			for ( var i = 0; i < st.length; i++) {
				for ( var j = 0; j < sts.length; j++) {
					if (st[i].value == sts[j]) {
						st[i].checked = true;
					}
				}
			}
		}
	}
	function checkBox( strValue, param){
		if(strValue !="" || strValue != undefined){
			var sts = strValue.split(",");
			var st = document.getElementsByName(param);
			for ( var i = 0; i < st.length; i++) {
				for ( var j = 0; j < sts.length; j++) {
					if (st[i].value == sts[j]) {
						st[i].checked = true;
					}
				}
			}
		}
	}
	function display() {
		var queryType = '${queryType}';
		if (queryType == '5') {
			open_high();
		}
	}
	
	function showAccountEdit(roleId){
		window.location = "${ctx}/account/edit.do";
  	}
	function doUserList(id){
		window.location = "${ctx}/user/list.do?parentUserId="+id;
	}
	function doControlPanel(userId){
		//window.open("${ctx}/index/panel/accountPanel.do?id="+id);
		//window.parent.parent.parent.location = "${ctx}/login/identitySwitch.do?userId="+id+"&actionType=1";
		var winObj = window.parent.parent.parent;
		//alert(winObj.document.body.innerHTML);
		winObj.identitySwitch(userId);
	}
	
	
</script>

</head>
<body onLoad="checkAllBox();display();">
	<form:errors path="errors" />
	<form:form modelAttribute="basicUserVoList" action="${ctx}/account/list.do" method="post" name="listForm">

		<input type="hidden" name="userAccountTypeFlag" value="" id="userAccountTypeFlag" />
		<input type="hidden" name="userIdentityFlag" value="" id="userIdentityFlag" />
		<input type="hidden" name="industryFlag" value="" id="industryFlag" />
		<input type="hidden" name="geoFlag" value="" id="geoFlag" />
		<input type="hidden" name="stateFlag" value="" id="stateFlag" />
		<input type="hidden" name="queryType" value="" id="queryType" />

		<!-- 外层边框 -->
		<div id="middle_sheet_s">
			<table width="950" height="680" border="0" cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td align="center" valign="top" bgcolor="#F2F2F2" height="670">

						<!-- 内容区域：查询条件和结果集 -->
						<table width="915" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="2" align="center" valign="middle"><img src="${ctx}/images/sheet_line_2.jpg" width="915" height="2" /></td>
							</tr>
							<tr>
								<td align="left" valign="top">
									<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#a0a0a0">
										<tr height="20" bgcolor="#f2f2f2">
											<td>
												<table width="100%" border="0" cellspacing="1" cellpadding="0">
													<!-- 一键式搜索 -->
													<tr height="25">
														<td></td>
														<td width="80" class="f13_1" align="left">账户类别：</td>
														<td width="690">
															<a href="javascript:userAccountTypeQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<c:forEach var="item" items="${userAccountType}" varStatus="status">
																<a href="javascript:userAccountTypeQuery('${item.itemCode}')" class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
										                   </c:forEach>
										                </td>
														<td width="280" align="right">
															<img src="${ctx}/images/btn14.png" alt="添加账户" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:showAccountEdit();"/>
															<img src="${ctx}/images/btn34.png" alt="批量停用" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:batchOperate('stopId');"/>
															&nbsp;&nbsp;
															<!--
															<input type="button" value="批量启用" onclick="javascript:batchOperate('startId');" class="btn_bg" style="width: 70px;" />
															<input type="button" value="邀请账户" onclick="" class="btn_bg" style="width: 60px;" />
															-->
														</td>
													</tr>
													<tr height="25">
														<td></td>
														<td width="80" class="f13_1" align="left">账户类型：</td>
														<td><a href="javascript:userIdentityQuery('')"
															class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp; <c:forEach
																var="item" items="${userIdentity}" varStatus="status">
																<a href="javascript:userIdentityQuery('${item.itemCode}')" class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
										                   </c:forEach>
										                </td>
														<td></td>
													</tr>
													<tr height="25">
														<td></td>
														<td width="80" class="f13_1" align="left">地区：</td>
														<td><a href="javascript:geoQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<c:forEach var="item" items="${geo}" varStatus="status">
																<a href="javascript:geoQuery('${item.itemCode}')"
																	class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
										                   </c:forEach>
										                </td>
														<td></td>
													</tr>
													<tr height="25">
														<td></td>
														<td width="80" class="f13_1" align="left">行业：</td>
														<td><a href="javascript:industryQuery('')"
															class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp; <c:forEach
																var="item" items="${industry}" varStatus="status">
																<a href="javascript:industryQuery('${item.itemCode}')"
																	class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
										                   </c:forEach>
										                </td>
														<td></td>
													</tr>
													<tr height="25">
														<td></td>
														<td width="80" class="f13_1" align="left">状态：</td>
														<td><a href="javascript:stateQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="javascript:stateQuery('1')" class="f13_3">未激活</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="javascript:stateQuery('2')" class="f13_3">待审批</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="javascript:stateQuery('3')" class="f13_3">活动</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="javascript:stateQuery('0')" class="f13_3">停用</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="javascript:stateQuery('-1')" class="f13_3">注销</a>&nbsp;&nbsp;&nbsp;&nbsp;
														
														<td></td>
													</tr>

													<!-- 高级搜索 -->
													<tr height="25" style="cursor: pointer;" onclick="open_high()">
														<td></td>
														<td colspan="2" align="left" class="f15">
															<table width="100%" border="0" cellspacing="0" cellpadding="0">
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
															<table width="100%" border="0" cellspacing="1" cellpadding="0" id="search" style="display: none">
																<tr>
																	<td colspan="3" align="left" valign="top">
																		<hr style="border: 1px dashed #ccc; width: 100%; height: 1px;" />
																	</td>
																</tr>

																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">账户类别：</td>
																	<td class="f13_3"><input type="checkbox"
																		name="checkuserAccountType" id="checkuserAccountType"
																		onclick="checkAll('checkuserAccountType','userAccountType')"
																		style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
																		<c:forEach var="item" items="${userAccountType}"
																			varStatus="status">
																			<input type="checkbox" name="userAccountType"
																				id="userAccountType" value="${item.itemCode}"
																				style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
																		</c:forEach>
																	</td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">账户类型：</td>
																	<td class="f13_3"><input type="checkbox"
																		name="checkuserIdentity" id="checkuserIdentity"
																		onclick="checkAll('checkuserIdentity','userIdentity')"
																		style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
																		<c:forEach var="item" items="${userIdentity}"
																			varStatus="status">
																			<input type="checkbox" name="userIdentity"
																				id="userIdentity" value="${item.itemCode}"
																				style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
																		</c:forEach>
																	</td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">地区：</td>
																	<td class="f13_3"><input type="checkbox"
																		name="checkgeo" id="checkgeo"
																		onclick="checkAll('checkgeo','geo')"
																		style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
																		<c:forEach var="item" items="${geo}"
																			varStatus="status">
																			<input type="checkbox" name="geo" id="geo"
																				value="${item.itemCode}"
																				style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
																	 </c:forEach></td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">行业：</td>
																	<td class="f13_3"><input type="checkbox"
																		name="checkindustry" id="checkindustry"
																		onclick="checkAll('checkindustry','industry')"
																		style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
																		<c:forEach var="item" items="${industry}"
																			varStatus="status">
																			<input type="checkbox" name="industry" id="industry"
																				value="${item.itemCode}"
																				style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
																	 </c:forEach></td>
																</tr>

																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">状态：</td>
																	<td class="f13_3"><input type="checkbox"
																		name="checkall" id="checkall"
																		onclick="checkAll('checkall','state')"
																		style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
																		<input type="checkbox" name="state" id="state"
																		value="1"
																		style="vertical-align: middle; margin-top: 0px;" />未激活&nbsp;&nbsp;&nbsp;&nbsp;
																		<input type="checkbox" name="state" id="state"
																		value="2"
																		style="vertical-align: middle; margin-top: 0px;" />待审批&nbsp;&nbsp;&nbsp;&nbsp;
																		<input type="checkbox" name="state" id="state"
																		value="3"
																		style="vertical-align: middle; margin-top: 0px;" />活动&nbsp;&nbsp;&nbsp;&nbsp;
																		<input type="checkbox" name="state" id="state"
																		value="0"
																		style="vertical-align: middle; margin-top: 0px;" />停用&nbsp;&nbsp;&nbsp;&nbsp;
																		<input type="checkbox" name="state" id="state"
																		value="-1"
																		style="vertical-align: middle; margin-top: 0px;" />注销&nbsp;&nbsp;&nbsp;&nbsp;
																	</td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">姓名：</td>
																	<td align="left"><form:querylike path="userName" />
																	</td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">账户名：</td>
																	<td align="left"><form:querylike
																			path="userAccount" /></td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">联系电话：</td>
																	<td align="left"><form:querylike path="tel" /></td>
																</tr>

																<tr height="50">
																	<td width="30">&nbsp;</td>
																	<td colspan="2" align="left" valign="middle"><a
																		href="javascript:void(0)"><img
																			src="${ctx}/images/btns2.png" alt="提交"
																			onclick="doQuery('5')" width="101" height="29"
																			border="0" /></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
																		href="javascript:void(0)"><img
																			src="${ctx}/images/btnc1.png" alt="重置"
																			onclick="document.forms.listForm.reset();return false;"
																			width="101" height="30" border="0" /></a></td>
																</tr>
																<tr valign="bottom">
																	<td colspan="3" align="center"><img
																		src="${ctx}/images/close.png" width="80" height="18"
																		border="0" style="cursor: pointer;"
																		onclick="close_high()" /></td>
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
							<tr>
								<td height="2"></td>
							</tr>
							<tr>
								<td height="2" align="center" valign="middle"><img
									src="${ctx }/images/sheet_line_2.jpg" width="915" height="2" /></td>
							</tr>

							<tr>
								<td height="20"></td>
							</tr>

							<tr>
								<td align="left" valign="top">
								   	<%int i=0; %>
									<ec:table items="list" var="item" onInvokeAction="doQuery('${queryType }')" form="listForm" retrieveRowsCallback="limit"
										sortRowsCallback="limit" sortable="false" style="width:100%"
										tableId="${tableId}" action="${ctx}/account/list.do" showPagination="true" cellspacing="1">
										<ec:exportXls fileName="账户信息.xls" tooltip="导出Excel" view="xls" />
										
										<ec:row>
											
											<ec:column property="_rowNumber" title="序号" cell="rowNumber" style="text-align:center; width:5%" />
											<ec:column property="userTypeDictItem.itemName" title="账户类别" style="width:8%; text-align: center;" />
											<ec:column property="userIdentityDictItem.itemName" title="账户类型" style="width:8%; text-align: center;" alias="userIdentity" />
											<ec:column property="userAccount" title="账户名" style="width:15%; text-align: left;">
											    <a href="javascript:edit('${item.userId }')" style="text-decoration: underline; cursor: pointer">${item.userAccount}</a>
											</ec:column>
											<ec:column property="userName" title="姓名" style="width:10%; text-align: left;">
												<a href="javascript:edit('${item.userId }')" style="text-decoration: underline; cursor: pointer">${item.userName}</a>
											</ec:column>
											<ec:column property="geoDictItem.itemName" title="地区" style="width:8%; text-align: left;" alias="geo" />
											<ec:column property="industryDictItem.itemName" title="行业" style="width:10%; text-align: left;" alias="industry" />
											<ec:column property="registerDate" title="注册日期" cell="date" format="yyyy-MM-dd" style="width:10%; text-align: right;" />
											<ec:column property="tel" title="联系电话" style="width:12%; text-align: right;" />
											<ec:column property="stateName" title="状态" style="width:9%; text-align: center;" />
											
											
											<ec:column property="null5" title="<input type='checkbox' value='' name='checkStopAll' id='checkStopAll'/>停用" sortable="false" viewsDenied="xls">
												<center>
													<c:choose>
														<c:when test="${item.state==3}">
		                									<input type="checkbox" value="${item.userId}" id="stopId_<%=i %>" name="stopId_<%=i %>" class="checkbox1" />
		                								</c:when>
		                								<c:otherwise>
		                									<input type="checkbox" value="${item.userId}" id="stopId_<%=i %>" name="stopId_<%=i %>" disabled/>
		                								</c:otherwise>
													</c:choose>
									 			</center>
											</ec:column>
											<%--
											<ec:column property="null5" title="<input type='checkbox' value='' name='checkStartAll' id='checkStartAll'/>启用" sortable="false" viewsDenied="xls">
												<center>
													<c:choose>
														<c:when test="${item.state==0 ||  item.state==-1}">
		                									<input type="checkbox" value="${item.userId}" id="startId_<%=i %>" name="startId_<%=i %>" class="checkbox2" />
		                								</c:when>
		                								<c:otherwise>
		                									<input type="checkbox" value="${item.userId}" id="startId_<%=i %>" name="startId_<%=i %>" disabled/>
		                								</c:otherwise>
													</c:choose>
									 			</center>
											</ec:column>
											--%>
											<ec:column property="null" title="操作" sortable="false" viewsAllowed="html" style="width:15%; text-align:center;">
												<c:if test="${item.state==3 }">
													<input type="button" value="控制板" onclick="doControlPanel('${item.userId}');" class="btn_bg" style="width: 50px;" />
													<input type="button" value="查看用户" onclick="doUserList('${item.userId}');" class="btn_bg" style="width: 65px;" />
												</c:if>
												
												<c:if test="${item.state==0 ||  item.state==-1}">
												 	<input type="button" value="激活" onclick="activation('1','${item.userId}')" class="btn_bg" style="width: 40px;" />
												</c:if>
												<%--
												<c:if test="${item.state==0 ||  item.state==-1 || item.state==3}">
													<c:if test="${item.state==0 ||  item.state==-1}">
													 	<input type="button" value="激活" onclick="activation('1','${item.userId}')" class="btn_bg" style="width: 40px;" />
													</c:if>
													<c:if test="${item.state==3}">
														<input type="button" value="停用" onclick="stopUser('${item.userId}');" class="btn_bg" style="width: 40px;" />
													</c:if>
												</c:if >
												--%>
												
												<c:if test="${item.state==1}">
													<input type="button" value="发送激活邮件" onclick="reSendEmail('1','${item.userId}')" class="btn_bg" style="width: 90px;" />
												</c:if>
												
											</ec:column>
										</ec:row>
										<%i++; %>
									</ec:table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>

	</form:form>
<script type="text/javascript">
function activation(flag,userId){
	var form = document.forms.listForm;
	if(confirm('确认激活账户?')){
		form.action="${ctx}/user/userActivation.do?userId="+userId+"&flag="+flag;
		loading();
		form.submit();
	}
}
function stopUser(userId){
	var form = document.forms.listForm;
	if(confirm('确认停用账户?')){
		form.action="${ctx}/user/stopUser.do?userId="+userId+"&userFlag=1";
		loading();
		form.submit();
	}
}

function edit(userId){
	window.location="${ctx}/account/edit.do?id="+userId;
}

function reSendEmail(flag,userId){
	var form = document.forms.listForm;
	if(confirm('确认重新发送邮件至该账户?')){
		form.action="${ctx}/account/reSendEmail.do?userId="+userId+"&flag="+flag;
		loading();
		form.submit();
	}
}



$(function(){ 
	$("#checkStopAll").click(function(){
		if(this.checked==true){
			$("input:.checkbox1").checkCbx(1);
		}else{ 
			$("input:.checkbox1").checkCbx(0);
		}
	});
});
$(function(){ 
	$("#checkStartAll").click(function(){
		if(this.checked==true){
			$("input:.checkbox2").checkCbx(1);
		}else{ 
			$("input:.checkbox2").checkCbx(0);
		}
	});
});

$.fn.checkCbx = function(i){ 
	if(i==1){
		return this.each(function(){ 
			if(this.disabled==false){
				this.checked = true; 
			}
		}); 
	}else{
		return this.each(function(){ 
			if(this.disabled==false){
				this.checked = false;
			}
		});
	}
};


function batchOperate(type){
	var form = document.forms.listForm;
	var rowCount = document.getElementById("ec_table").rows.length-2;
	var userIdArr = '';
	if(rowCount>0){
		for(var i=1; i<=rowCount; i++){
			if(document.getElementById(type+'_'+i).checked==true){
				if(i != rowCount){
					userIdArr = userIdArr + document.getElementById(type+'_'+i).value+",";
				}else{
					userIdArr = userIdArr + document.getElementById(type+'_'+i).value;
				}
			}
		}
	}
	if(userIdArr.length==0){
		alert("请选择一条记录！");
		return;
	}else{
		if(type == 'stopId'){
			if(confirm('确认停用账户?')){
				form.action="${ctx}/user/batchOperateUser.do?userIdArr="+userIdArr+"&userFlag=1&state=0";
				loading();
				form.submit();
			}
		}else{
			if(confirm('确认启用账户?')){
				form.action="${ctx}/user/batchOperateUser.do?userIdArr="+userIdArr+"&userFlag=1&state=3";
				loading();
				form.submit();
			}			
		}
	}
}
</script>	
</body>
</html>