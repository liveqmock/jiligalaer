<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品管理-组合产品定制-数据中心</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript"
	src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript"
	src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	margin: 0px auto;
	background-color: #000000;
	background-repeat: repeat;
	background-position: left;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
form{
	margin:0px;
	padding:0px;
}
</style>
<script type="text/javascript">
	function next() {
		var mdmZones =  document.getElementsByName("mdmZone");
		var mdmZoneId = "";
		var prodId ="";
		var tag = false;
		for ( var i = 0; i < mdmZones.length; i++) {
			if (mdmZones.item(i).checked) {
				tag = true;
				mdmZoneId = mdmZoneId + mdmZones.item(i).getAttribute("value");
				continue;
			}
		}
		if(mdmZoneId==""){
			alert("请选择数据中心!");
			return;
		}
		var form = document.forms.listForm;
		form.action = "${ctx}/combinProd/selectTemplate.do?mdmZoneId="+mdmZoneId;
		form.submit();
	}
</script>

</head>
<body onLoad="">
	<form:form modelAttribute="baseVoList" action="${ctx}/combinProd/selectDc.do" method="post" name="listForm">

		<table width="962" align="center" border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_1.png" width="9" height="9" /></td>
	          <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_2.png"></td>
	          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_3.png" width="9" height="9" /></td>
	        </tr>          
            <tr>
              <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_4.png"></td>
							<td align="center" valign="top" bgcolor="#F2F2F2">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td height="43" align="left" valign="middle"><span
											class="f18b2">组合产品 -> 定制流程</span></td>
										<td align="left" valign="middle">&nbsp;</td>
									</tr>
									<tr>
										<td height="5" colspan="2"></td>
									</tr>
									<tr>
										<td height="2" colspan="2" align="center" valign="middle"><img
											src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" /></td>
									</tr>
									<tr>
										<td height="5" colspan="2"></td>
									</tr>
									<tr>
										<td colspan="2">
											<div id="middle_sheet_pm_s_name">
												<img src="${ctx}/images/menu_s_11_s.png" border="0"
													align="absmiddle" id="" />  <img
													src="${ctx}/images/menu_s_6.jpg" border="0"
													align="absmiddle" id="" /> <img
													src="${ctx}/images/menu_s_21.png" border="0"
													align="absmiddle" id="" /> <img
													src="${ctx}/images/menu_s_22.png" border="0"
													align="absmiddle" id="" /> <!--<img
													src="${ctx}/images/menu_s_14.png" border="0"
													align="absmiddle" id="" /> --><img
													src="${ctx}/images/menu_s_24.png" border="0"
													align="absmiddle" id="" />
											</div>

											<div id="middle_sheet_pm_s">
												<table width="855" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td width="14" height="14" align="left" valign="top"><img
															src="${ctx}/images/sheet_s_border_1.jpg" width="14"
															height="14" /></td>
														<td height="14" align="left" valign="top"
															background="${ctx}/images/sheet_s_border_2.jpg"></td>
														<td width="14" height="14" align="left" valign="top"><img
															src="${ctx}/images/sheet_s_border_3.jpg" width="14"
															height="14" /></td>
													</tr>
													<tr>
														<td width="14" align="left" valign="top"
															background="${ctx}/images/sheet_s_border_4.jpg"></td>
														<td align="left" valign="top" bgcolor="#FFFFFF"
															height="480">
															<!-- 定制流程页面 -->
															<table width="336" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td width="35" align="left" valign="middle"><img
																		src="${ctx}/images/buy_ico_04.gif" width="25"
																		height="26" /></td>
																	<td width="301" align="left" valign="middle"
																		class="f18b2">请选择一个数据中心</td>
																</tr>
																<tr>
																	<td height="5" colspan="2" align="left" valign="middle"><img
																		src="${ctx}/images/buy_blue_line.jpg" width="280"
																		height="1" /></td>
																</tr>
															</table>

															<table width="100%" border="0" cellpadding="0"
																cellspacing="0">
																<tr height="10">
																	<td width="6%"></td>
																	<td align="left" class="f15_1"></td>
																</tr>
																<tr height="30">
																	<td width="6%"></td>
																	<td>
																		<table width="100%" border="0" cellpadding="0"
																			cellspacing="0">
																			<c:forEach var="item" items="${mdmZoneList}">
																			 <c:choose>
																			  <c:when test="${item.selectFlag==1}">
																			  <tr height="30">
																					<td width="5%"></td>
																					<td width="25%" height="45" align="left"
																						class="f13_1"><input type="radio"
																						name="mdmZone" value="${item.id}" checked="checked"/>${item.name}</td>
																					<td width="70%" class="f13_1">${item.displayText}</td>
																				</tr>
																			   </c:when>
																			   <c:otherwise>
																			    <tr height="30">
																					<td width="5%"></td>
																					<td width="25%" height="45" align="left"
																						class="f13_1"><input type="radio"
																						name="mdmZone" value="${item.id}" />${item.name}</td>
																					<td width="70%" class="f13_1">${item.displayText}</td>
																				</tr>
																			   </c:otherwise>
																			 </c:choose>
																				
																			</c:forEach>
																		</table>
																	</td>
																</tr>
															</table>

															<table align="right" width="352" height="33" border="0"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td colspan="3" height="25">&nbsp;</td>
																</tr>
																<tr>
																	<td width="185" align="right" valign="middle"><img
																		src="${ctx}/images/btn3.png" width="117" height="32"
																		style="cursor: pointer;" onclick="next()" /></td>
																	<td width="15" align="right" valign="middle">&nbsp;</td>
																</tr>
																<tr>
																	<td colspan="3" height="10">&nbsp;</td>
																</tr>
															</table>


														</td>
														<td width="14" align="left" valign="top"
															background="${ctx}/images/sheet_s_border_5.jpg"></td>
													</tr>
													<tr>
														<td width="14" height="14" align="left" valign="top"><img
															src="${ctx}/images/sheet_s_border_6.jpg" width="14"
															height="14" /></td>
														<td height="14" align="left" valign="top"
															background="${ctx}/images/sheet_s_border_7.jpg"></td>
														<td width="14" height="14" align="left" valign="top"><img
															src="${ctx}/images/sheet_s_border_8.jpg" width="14"
															height="14" /></td>
													</tr>
													<tr>
														<td colspan=3 height="10"></td>
													</tr>
												</table>
											</div>

										</td>
									</tr>
                  <tr>
                    <td colspan="2" align="center" valign="middle">
                    	<table width="394" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td align="center" valign="top"><a href="javascript:window.parent.parent.close();"><img src="${ctx}/images/btn8.png" alt="关闭" width="101" height="30" border="0" align="absmiddle"/></a></td>
                        </tr>
                      </table>
                    </td>
                  </tr>
									<tr>
										<td height="10" colspan="2"></td>
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