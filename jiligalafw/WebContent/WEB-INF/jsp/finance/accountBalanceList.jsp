<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>财务管理 - 账户余额</title>
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
p {
	font-family: "宋体";
	font-size: 13px;
	color: #000000;
	margin-left: 60px;
}
-->
</style>
<script type="text/javascript">
	//高级查询
	function query(val) {
		var form = document.forms.listForm;
		form.queryType.value=val;
		form.action="${ctx}/balance/list.do";
		loading();
		form.submit();
	}

	//账户类别查询
	function userAccountTypeQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '0';
		form.userAccountTypeFlag.value = val;
		form.action = "${ctx}/balance/list.do";
		loading();
		form.submit();
	}
	//账户类型查询
	function userIdentityQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '1';
		form.userIdentityFlag.value = val;
		form.action = "${ctx}/balance/list.do";
		loading();
		form.submit();
	}
	//地区查询
	function geoQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '2';
		form.geoFlag.value = val;
		form.action = "${ctx}/balance/list.do";
		loading();
		form.submit();
	}
	//行业查询
	function industryQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '3';
		form.industryFlag.value = val;
		form.action = "${ctx}/balance/list.do";
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
		var userAccountTypeStr = '${userAccountTypeStr}';
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
		var userIdentityStr = '${userIdentityStr}';	
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
		var geoStr = '${geoStr}';
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
		var industryStr = '${industryStr}';			
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
	
	function display() {
		var queryType = '${queryType}';
		if (queryType == '4') {
			open_high();
		}
	}
	function detail(userId){
		//openwindow('${ctx}/balance/view.do?userId='+userId,'余额详情',1024,768);
		window.location = '${ctx}/balance/view.do?userId='+userId;
	}
	function changeCredit(userId,creditAmount,userName){
		if(creditAmount==''){
			creditAmount=0;
		}
		var txt = '<p style="font-size:14px;color:#1491ad">授信额度调整</p><hr></hr>'+
		'<p style="line-height:25px">&nbsp;&nbsp;&nbsp;账户名：'+userName+'</p>'+
		'<p style="line-height:25px">现信用额度：'+creditAmount+'</p>'+
		'<p style="line-height:25px">&nbsp;&nbsp;信用额度：<input type="text" name="creditAmount" size="15" /></p>';
		$.prompt(txt,{
			buttons: {确定:1, 取消:3},
			callback: function mycallbackform(v,m,f){
				if(v == 3){
					return ;
				}
				if(f.creditAmount=="" || f.creditAmount==null ){
					alert("请输入信用额度");
					return ;
				}else if(!checkAmount(f.creditAmount)){
					alert("信用额度输入不正确！");
					return ;
				}else{
					var form = document.forms.listForm;
					form.action="${ctx}/balance/changeCredit.do?userId="+userId+"&creditAmount="+f.creditAmount;
					loading();
					form.submit();
				}	
			}
		});		
	}
</script>

</head>
<body onLoad="checkAllBox();display();">
	<form:form modelAttribute="accountExpenseVoList" action="${ctx}/balance/list.do" method="post" name="listForm">

		<input type="hidden" name="userAccountTypeFlag" value="" id="userAccountTypeFlag" />
		<input type="hidden" name="userIdentityFlag" value="" id="userIdentityFlag" />
		<input type="hidden" name="industryFlag" value="" id="industryFlag" />
		<input type="hidden" name="geoFlag" value="" id="geoFlag" />
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
														<td width="180" align="right"></td>
													</tr>
													<tr height="25">
														<td></td>
														<td width="80" class="f13_1" align="left">账户类型：</td>
														<td>
															<a href="javascript:userIdentityQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp; 
															<c:forEach var="item" items="${userIdentity}" varStatus="status">
																<a href="javascript:userIdentityQuery('${item.itemCode}')" class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
										                    </c:forEach>
										                </td>
														<td></td>
													</tr>
													<tr height="25">
														<td></td>
														<td width="80" class="f13_1" align="left">地区：</td>
														<td>
															<a href="javascript:geoQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<c:forEach var="item" items="${geo}" varStatus="status">
																<a href="javascript:geoQuery('${item.itemCode}')" class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
										                    </c:forEach>
										                </td>
														<td></td>
													</tr>
													<tr height="25">
														<td></td>
														<td width="80" class="f13_1" align="left">行业：</td>
														<td>
															<a href="javascript:industryQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp; 
															<c:forEach var="item" items="${industry}" varStatus="status">
																<a href="javascript:industryQuery('${item.itemCode}')" class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
										                   	</c:forEach>
										                </td>
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
																	<td class="f13_3">
																		<input type="checkbox" name="checkall" id="checkallAccType" onclick="checkAll('checkallAccType','userAccountType')" style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
																		<c:forEach var="item" items="${userAccountType}" varStatus="status">
																			<input type="checkbox" name="userAccountType" id="userAccountType" value="${item.itemCode}"
																				style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
																		</c:forEach>
																	</td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">账户类型：</td>
																	<td class="f13_3">
																		<input type="checkbox" name="checkall" id="checkallIdentity" onclick="checkAll('checkallIdentity','userIdentity')"
																			style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
																		<c:forEach var="item" items="${userIdentity}" varStatus="status">
																			<input type="checkbox" name="userIdentity"
																				id="userIdentity" value="${item.itemCode}" style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
																		</c:forEach>
																	</td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">地区：</td>
																	<td class="f13_3">
																		<input type="checkbox" name="checkall" id="checkallGeo"
																			onclick="checkAll('checkallGeo','geo')" style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
																		<c:forEach var="item" items="${geo}" varStatus="status">
																			<input type="checkbox" name="geo" id="geo" value="${item.itemCode}"
																				style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
																	 	</c:forEach>
																	 </td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">行业：</td>
																	<td class="f13_3">
																		<input type="checkbox" name="checkall" id="checkallIndustry" onclick="checkAll('checkallIndustry','industry')"
																			style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
																		<c:forEach var="item" items="${industry}" varStatus="status">
																			<input type="checkbox" name="industry" id="industry" value="${item.itemCode}"
																				style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
																	 	</c:forEach>
																	 </td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">姓名：</td>
																	<td align="left">
																		<input type="text" name="userName" value="${userName }"/>
																	</td>
																</tr>
																<tr height="25">
																	<td width="30">&nbsp;</td>
																	<td class="f13_1" align="left">账户名：</td>
																	<td align="left">
																		<input type="text" name="userAccount" value="${userAccount }"/>
																	</td>
																</tr>
																<tr height="50">
																	<td width="30">&nbsp;</td>
																	<td colspan="2" align="left" valign="middle">
																		<a href="javascript:void(0)">
																			<img src="${ctx}/images/btns2.png" alt="提交" onclick="query('4')" width="101" height="29"border="0" />
																		</a>
																		&nbsp;&nbsp;&nbsp;&nbsp; 
																		<a href="javascript:void(0)">
																			<img src="${ctx}/images/btnc1.png" alt="重置" onclick="document.forms.listForm.reset();return false;" width="101" height="30" border="0" />
																		</a>
																	</td>
																</tr>
																<tr valign="bottom">
																	<td colspan="3" align="center">
																		<img src="${ctx}/images/close.png" width="80" height="18" border="0" style="cursor: pointer;" onclick="close_high()" />
																	</td>
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
							<tr><td height="2"></td></tr>
							<tr>
								<td height="2" align="center" valign="middle"><img src="${ctx }/images/sheet_line_2.jpg" width="915" height="2" /></td>
							</tr>
							<tr><td height="20"></td></tr>

							<tr>
								<td align="left" valign="top">

									<ec:table items="list" var="item" onInvokeAction="query('${queryType }')"
										form="listForm" retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%"
										tableId="${tableId}" action="${ctx}/balance/list.do" showPagination="true" cellspacing="1">
										
										<ec:exportXls fileName="账户余额.xls" tooltip="导出Excel" view="xls" />
										<ec:row>
											<ec:column property="_rowNumber" title="序号" cell="rowNumber"  style="text-align:center; width:5%" />
											<ec:column property="basicUser.userAccount" title="账户名" style="width:10%; text-align: left;" alias="userAccount" />
											<ec:column property="basicUser.userName" title="姓名" style="width:10%; text-align: left;">
												<a href="#" style="text-decoration:underline;cursor:pointer">
													${item.basicUser.userName}
												</a>
											</ec:column>
											<ec:column property="basicUser.userTypeDictItem.itemName" title="账户类别" style="width:10%; text-align: center;" alias="userType"/>
											<ec:column property="basicUser.userIdentityDictItem.itemName" title="账户类型" style="width:10%; text-align: center;" alias="userIdentity" />
											<ec:column property="basicUser.geoDictItem.itemName" title="地区" style="width:10%; text-align: left;" alias="region" />
											<ec:column property="basicUser.industryDictItem.itemName" title="行业" style="width:10%; text-align: left;" alias="industry" />
											<ec:column property="basicUser.tel" title="联系电话" style="width:10%; text-align: right;" alias="tel" />
											<ec:column property="a" title="余额（元）" style="width:10%; text-align: right;" value="${item.payTotalAmount - item.expTotalAmount }" viewsAllowed="xls" />
											<ec:column property="remainingAmount" title="余额（元）" style="width:10%; text-align: right;" viewsDenied="xls">
												<fmt:formatNumber pattern="#0.00">${item.payTotalAmount - item.expTotalAmount }</fmt:formatNumber>
											</ec:column>
											<ec:column property="creditAmount" title="授信额度（元）" cell="number" format="#0.00" style="width:10%; text-align: right;"/>
											<ec:column property="null" title="操作" style="width:6%; text-align: right;" viewsAllowed="html">
											
												<input type="button" value="余额" onclick="detail('${item.basicUser.userId}')" class="btn_bg" style="width: 40px;"/>&nbsp;
												<input type="button" value="调整额度" onclick="changeCredit('${item.basicUser.userId}','${item.creditAmount }','${item.basicUser.userAccount }')" class="btn_bg" style="width: 65px;"/>
												
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
</body>
</html>