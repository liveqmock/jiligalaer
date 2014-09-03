<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户信息编辑</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/autoheight.js"></script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
	function checkEditOrUpdate() {
		var userAccount = $("#userAccount").val().replace(/\s/g, "");
		if (userAccount != "" && checkEmail($("#userAccount").val())) {
			$("#userAccount").attr("readonly", "readonly");
			$("#userAccount").css("background","#E8F2FE");
		}

	}
	function changeIframeValue(value) {
		var iframe = document.getElementById("userForm");
		var iframeForm = window.frames['userForm'];
	 	if (iframe.src.lastIndexOf("editInfo")!=-1) {
			var userIdentity =document.getElementsByName("userIdentityDictItem.dictItemId");
			for ( var i = 0; i < userIdentity.length; i++) {
				if (userIdentity.item(i).checked) {
					var val= userIdentity.item(i).value;
					if (val == "gongsiidentity") {
						/**
						$(window.frames['userForm'].document).find("#tr_identityCard").hide();
						$(window.frames['userForm'].document).find("#tr_gongsi1").show();
						$(window.frames['userForm'].document).find("#tr_gongsi2").show();
						$(window.frames['userForm'].document).find("#tr_gongsi3").show();
						$(window.frames['userForm'].document).find("#tr_gongsi4").show();
						$(window.frames['userForm'].document).find("#tr_gongsi5").show();
						*/
					
						iframeForm.document.getElementById("tr_identityCard").style.display="none";
						iframeForm.document.getElementById("tr_gongsi1").style.display="";
						iframeForm.document.getElementById("tr_gongsi2").style.display="";
						iframeForm.document.getElementById("tr_gongsi3").style.display="";
						iframeForm.document.getElementById("tr_gongsi4").style.display="";
						iframeForm.document.getElementById("tr_gongsi5").style.display="";
					
					} else {
						/**
						$(window.frames['userForm'].document).find("#tr_identityCard").show();
						$(window.frames['userForm'].document).find("#tr_gongsi1").hide();
						$(window.frames['userForm'].document).find("#tr_gongsi2").hide();
						$(window.frames['userForm'].document).find("#tr_gongsi3").hide();
						$(window.frames['userForm'].document).find("#tr_gongsi4").hide();
						$(window.frames['userForm'].document).find("#tr_gongsi5").hide();
						*/
						
						iframeForm.document.getElementById("tr_identityCard").style.display="";
						iframeForm.document.getElementById("tr_gongsi1").style.display="none";
						iframeForm.document.getElementById("tr_gongsi2").style.display="none";
						iframeForm.document.getElementById("tr_gongsi3").style.display="none";
						iframeForm.document.getElementById("tr_gongsi4").style.display="none";
						iframeForm.document.getElementById("tr_gongsi5").style.display="none";
						
					}
				}
			}
			
			
		}
	}
	
</script>
</head>
<body onload="checkEditOrUpdate()">
	<form:form modelAttribute="basicUserVo" action="${ctx}/account/save.do" method="post" name="accountForm">
        <form:hidden path="userFlag" value="1" />
		<form:hidden path="roleIds" id="roleIds" value="${roleIds}"/>
		<form:errors path="errors" cssClass="commomError" />

		<div id="middle_sheet_content" style="width: 962px;">
			<table width="962" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center" valign="top" bgcolor="#F2F2F2">
						<table width="915" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td height="43" align="left" valign="middle"><span class="f18b2">账户信息编辑</span></td>
								<td align="left" valign="middle">&nbsp;</td>
							</tr>
							<tr><td height="5" colspan="2"></td></tr>
							<tr>
								<td height="2" colspan="2" align="center" valign="middle">
									<img src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" />
								</td>
							</tr>
							<tr><td height="12" colspan="2"></td></tr>

							<tr>
								<td align="center" valign="top">
									<table height="220" border="0" cellpadding="0" cellspacing="0">
										<tr height="30">
											<td width="20"></td>
											<td width="120" align="left" class="f13_1"><form:label path="userAccount">账户名（邮箱）</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left"><form:input path="userAccount" class="text13" size="30" id="userAccount" /></td>
											<td align="left"><form:errors path="userAccount" cssClass="error" /></td>
										</tr>									
										<tr height="30">
											<td width="20"></td>
											<td width="120" align="left" class="f13_1"><form:label path="userName">姓名</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left"><form:input path="userName" class="text13" size="30" id="userName" /></td>
											<td align="left"><form:errors path="userName" cssClass="error" /></td>
										</tr>
										<tr height="30">
											<td width="20"></td>
											<td width="120" align="left" class="f13_1"><form:label path="userIdentityDictItem.dictItemId">账户类型</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left" class="f13_1">
												<form:radiobuttons path="userIdentityDictItem.dictItemId" items="${userIdentityDictItemMap}" id="userIdentity" onclick="changeIframeValue(this)" /></td>
											<td align="left"><form:errors path="userIdentityDictItem.dictItemId" cssClass="error" /></td>
										</tr>
										<tr height="30">
											<td width="20"></td>
											<td width="120" align="left" class="f13_1"><form:label path="userTypeDictItem.dictItemId">账户类别</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left" class="f13_1"><form:radiobuttons path="userTypeDictItem.dictItemId" items="${userTypeDictItemMap}" id="userType" /></td>
											<td align="left"><form:errors path="userTypeDictItem.dictItemId" cssClass="error" /></td>
										</tr>
										<tr height="30" id="editeTr">
											<td width="20"></td>
											<td width="120" align="left" class="f13_1"><form:label path="state">状态</form:label><span style="color: #ff0000">*</span>：</td>
											<td align="left" class="f13_1"><form:radiobuttons path="state" items="${state}" id="state" /></td>
											<td align="left"><form:errors path="state" cssClass="error" /></td>
										</tr>
										<tr height="30">
											<td width="20"></td>
											<td width="120" align="left" class="f13_1"><b>余额：</b></td>
											<td align="left" class="f13_1">
												&nbsp;<b><fmt:formatNumber pattern="#0.00">${accBalance }</fmt:formatNumber> 元</b>
											</td>
											<td align="left"></td>
										</tr>	
																		
									</table>
								</td>
								<td align="right" valign="top"><img src="${ctx}/images/pic1.jpg" width="427" height="290" /></td>
							</tr>
							<tr>
								<td height="10" colspan="2"></td>
							</tr>
							<!--  <tr>
								<td colspan="2" align="left" valign="top">
									<table border="0" cellspacing="0" cellpadding="0">
										<tr height="110">
											<td width="20"></td>
											<td width="80" align="left" valign="top" class="f13_1">角色<span style="color: #ff0000">*</span>：</td>
											<td align="left">
												<table width="700" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
													<tr bgcolor="#92b8c1" height="20">
														<td width="8%" align="center" class="f12">序号</td>
														<td width="25%" align="center" class="f12">角色名称</td>
														<td width="10%" align="center" class="f12">状态</td>
														<td width="47%" align="center" class="f12">功能说明</td>
														<td width="10%" align="center" class="f12">选择</td>
													</tr>
												</table>
												
												<div id="order" style="height:150px; z-index:1; overflow-y: scroll">   
													<table width="97%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
														<c:forEach var="item" items="${roleList}" varStatus="status">
															<c:choose>
																<c:when test="${ item.isUsed=='check' }">
																	<tr bgcolor="#eef6f7" height="20">
																		<td width="8%" align="center" class="f12_1">${status.index+1}</td>
																		<td width="25%" align="left" class="f12_1">
																			<a href="#" onclick="javascript:showRoleEdit(${item.roleId});">${item.roleName}</a>
																		</td>
																		<td width="10%" align="center" class="f12_1">${item.state=='1'? '有效 ':'无效'}</td>
																		<td width="47%" align="left" class="f12_1">${item.description}</td>
																		<td width="10%" align="center" class="f12_1">
																			<input type="checkbox" name="checkRole" checked="checked" value="${item.roleId}" />
																		</td>
																	</tr>
																</c:when>
																<c:otherwise>
																	<tr bgcolor="#eef6f7" height="20">
																		<td width="8%" align="center" class="f12_1">${status.index+1}</td>
																		<td width="25%" align="left" class="f12_1">
																			<a href="#" onclick="javascript:showRoleEdit(${item.roleId});">${item.roleName}</a>
																		</td>
																		<td width="10%" align="center" class="f12_1">${item.state=='1'? '有效 ':'无效'}</td>
																		<td width="47%" align="left" class="f12_1">${item.description}</td>
																		<td width="10%" align="center" class="f12_1">
																			<input type="checkbox" name="checkRole" value="${item.roleId}" />
																		</td>
																	</tr>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</table>
												</div>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr><td height="30" colspan="2"></td></tr> -->
							<tr>
								<td height="2" colspan="2" align="center" valign="middle"><img src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" /></td>
							</tr>
							<tr><td height="14" colspan="2"></td></tr>
						</table>
						
						
						<!-- 如果是用户登录，以下只能点击前2项菜单 -->
						<div id="middle_sheet_s_name">
							<a href="javascript:detail('editInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_0_s.png" border="0" align="absmiddle" id="editInfo" /></a>
							<a href="javascript:accInfo('orderInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_1.jpg" border="0" align="absmiddle" id="orderInfo" /></a>
							<a href="javascript:accInfo('billInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_2.jpg" border="0" align="absmiddle" id="billInfo" /></a>
							<a href="javascript:accInfo('remindInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_3.jpg" border="0" align="absmiddle" id="remindInfo" /></a>
							<a href="javascript:accInfo('vmInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_4.jpg" border="0" align="absmiddle" id="vmInfo" /></a>
							<a href="javascript:accInfo('netInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_5.jpg" border="0" align="absmiddle" id="netInfo" /></a>
							<a href="javascript:accInfo('templateInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_6.jpg" border="0" align="absmiddle" id="templateInfo" /></a>
							<a href="javascript:accInfo('volumeInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_8.jpg" border="0" align="absmiddle" id="volumeInfo" /></a>
							<a href="javascript:accInfo('ipInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_10.jpg" border="0" align="absmiddle" id="ipInfo" /></a>
							<%--
							<a href="javascript:accInfo('isoInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_9.jpg" border="0" align="absmiddle" id="isoInfo" /></a>
							<a href="javascript:accInfo('snapshotInfo','${basicUserVo.userId }');"><img src="${ctx}/images/menu_s_7.jpg" border="0" align="absmiddle" id="snapshotInfo" /></a>
							--%>
						</div>
						
						<script type="text/javascript">

						function detail(url,userId){
							setMenuBg(url);
							document.getElementById("userForm").src = "${ctx}/account/editInfo.do?userId="+userId+" ";
						}
						function accInfo(url,userId) {
							setMenuBg(url);
							document.getElementById("userForm").src = "${ctx}/accInfo/" + url + ".do?userId="+userId+" ";
						}
						function setMenuBg(url){
							$("#editInfo")[0].src="${ctx}/images/menu_s_0.jpg";
							$("#orderInfo")[0].src="${ctx}/images/menu_s_1.jpg";
							$("#billInfo")[0].src="${ctx}/images/menu_s_2.jpg";
							$("#remindInfo")[0].src="${ctx}/images/menu_s_3.jpg";
							$("#vmInfo")[0].src="${ctx}/images/menu_s_4.jpg";
							$("#netInfo")[0].src="${ctx}/images/menu_s_5.jpg";
							$("#templateInfo")[0].src="${ctx}/images/menu_s_6.jpg";
							$("#volumeInfo")[0].src="${ctx}/images/menu_s_8.jpg";
							$("#ipInfo")[0].src="${ctx}/images/menu_s_10.jpg";
							//$("#isoInfo")[0].src="${ctx}/images/menu_s_9.jpg";
							//$("#snapshotInfo")[0].src="${ctx}/images/menu_s_7.jpg";

							var map = getMap(); 
							map.put("editInfo","${ctx}/images/menu_s_0_s.png");
							map.put("orderInfo","${ctx}/images/menu_s_1_s.png");
							map.put("billInfo","${ctx}/images/menu_s_2_s.png");
							map.put("remindInfo","${ctx}/images/menu_s_3_s.png");
							map.put("vmInfo","${ctx}/images/menu_s_4_s.png");
							map.put("netInfo","${ctx}/images/menu_s_5_s.png");
							map.put("templateInfo","${ctx}/images/menu_s_6_s.png");
							map.put("volumeInfo","${ctx}/images/menu_s_8_s.png");
							map.put("ipInfo","${ctx}/images/menu_s_10_s.png");
							//map.put("snapshotInfo","${ctx}/images/menu_s_7_s.png");
							//map.put("isoInfo","${ctx}/images/menu_s_9_s.png");
							
							$("#"+url)[0].src=map.get(url);
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
									<td align="center" valign="top" bgcolor="#FFFFFF" height="500">

										<iframe id="userForm" name="userForm" src="${ctx}/account/editInfo.do" frameborder="0" scrolling="no" height="100%" width="100%"></iframe>

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
		</div>

	</form:form>
</body>
</html>