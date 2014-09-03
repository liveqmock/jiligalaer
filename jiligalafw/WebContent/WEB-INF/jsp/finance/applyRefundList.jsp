<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>账户退款申请</title>
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
	//高级查询
	function query(val) {
		var form = document.forms.listForm;
		form.queryType.value=val;
		form.action="${ctx}/applyRefund/list.do";
		loading();
		form.submit();
	}
	//处理状态查询
	function stateQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '0';
		form.stateFlag.value = val;
		form.action = "${ctx}/applyRefund/list.do";
		loading();
		form.submit();
	}
	//申请日期查询
	function dateQuery(val){
		var form = document.forms.listForm;
		form.queryType.value='1';
		form.timeFlag.value=val;
		form.action="${ctx}/applyRefund/list.do";
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
	}
	function display() {
		var queryType = '${queryType}';
		if (queryType == '2') {
			open_high();
		}
	}
	
	function refund(){
		var txt = '<br/>申请日期：'+getCurrDate()+'<br/><br/>申请金额：<input type="text" name="amount" value="" maxlength="10"/> 元<br/><br/>&nbsp;&nbsp;&nbsp;备&nbsp;&nbsp;注&nbsp;：<textarea name="remark" cols="30" rows="4" ></textarea><br/>';
		$.prompt(txt,{
			buttons: {'确定':1, '取消':3},
			callback: function mycallbackform(v,m,f){
				if(v == 3){
					return ;
				}
				if(f.amount=="" || f.amount==null ){
					alert("请输入退款金额！");
					return ;
				}else if(!checkAmount(f.amount)){
					alert("请输入正确的退款金额！");
					return ;
				}else if(parseFloat($("#balanceAmount").val()) <= parseFloat(f.amount)){
					alert("退款金额不能大于账户余额！");
					return ;
				}else{
					var form = document.forms.listForm;
					document.getElementById('applyAmount').value = f.amount;
					document.getElementById('applyRemark').value = f.remark;
					
					document.forms.listForm.action='${ctx}/applyRefund/save.do';
					loading();
					document.forms.listForm.submit();
				}	
			}
		});		
	}
	
	function doDelete(refundId){
		document.forms.listForm.action='${ctx}/applyRefund/delete.do?id='+refundId;
		document.forms.listForm.submit();
	}
	
	var msg = '${applyRefundMsg}';
	if(msg != ''){
		alert(msg);
		window.location='${ctx}/applyRefund/list.do';		
	}
</script>

</head>
<body onLoad="checkAllBox();display();">
	<form:form modelAttribute="accountRefundVoList" action="${ctx}/applyRefund/list.do" method="post" name="listForm">
		<input type="hidden" name="applyAmount" id="applyAmount" />
		<input type="hidden" name="applyRemark" id="applyRemark" />
		
		<input type="hidden" name="stateFlag" value="" id="stateFlag" />
		<input type="hidden" name="timeFlag" value="" id="timeFlag" />
		<input type="hidden" name="queryType" value="" id="queryType" />

		<!-- 外层边框 -->
		<div id="middle_sheet_s">
			<table width="950" height="680" border="0" cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td align="center" valign="top" bgcolor="#F2F2F2" height="670">

						<!-- 内容区域：查询条件和结果集 -->
						<table width="915" border="0" cellspacing="0" cellpadding="0">
							<tr height="30" valign="top">
								<td height="30" align="left" class="f18b3" valign="top">
									账户余额：<fmt:formatNumber pattern="#0.00">${expVo.payTotalAmount - expVo.expTotalAmount }</fmt:formatNumber>元
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img src="${ctx}/images/btn33.png" alt="退款申请" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:refund();"/>
									<!-- 账户余额 -->
									<input type="hidden" name="balanceAmount" id="balanceAmount" value="${expVo.payTotalAmount - expVo.expTotalAmount }" />
								</td>
							</tr>						
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
				                                      <td width="80" class="f13_1" align="left">处理状态：</td>
				                                      <td class="f13_3">
														<a href="javascript:stateQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
														<a href="javascript:stateQuery('0')" class="f13_3">未退款</a>&nbsp;&nbsp;&nbsp;&nbsp;
														<a href="javascript:stateQuery('1')" class="f13_3">已退款</a>&nbsp;&nbsp;&nbsp;&nbsp;
														<a href="javascript:stateQuery('2')" class="f13_3">已拒绝</a>&nbsp;&nbsp;&nbsp;&nbsp;
				                                      </td>
				                                      <td></td>
				                                    </tr>
				                                    <tr height="25">
				                                  	  <td></td>
				                                      <td width="80" class="f13_1" align="left">申请日期：</td>
				                                      <td class="f13_3">
														<a href="javascript:dateQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
														<a href="javascript:dateQuery('1')" class="f13_3">今日</a>&nbsp;&nbsp;&nbsp;&nbsp;
														<a href="javascript:dateQuery('2')" class="f13_3">本周</a>&nbsp;&nbsp;&nbsp;&nbsp;
														<a href="javascript:dateQuery('3')" class="f13_3">上周</a>&nbsp;&nbsp;&nbsp;&nbsp;
														<a href="javascript:dateQuery('4')" class="f13_3">本月</a>&nbsp;&nbsp;&nbsp;&nbsp;
														<a href="javascript:dateQuery('5')" class="f13_3">上月</a>&nbsp;&nbsp;&nbsp;&nbsp;
														<a href="javascript:dateQuery('6')" class="f13_3">其它</a>&nbsp;&nbsp;&nbsp;&nbsp;
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
							                                      	<td width="80" class="f13_1" align="left">处理状态：</td>
							                                      	<td class="f13_3" >
							                                         	<input type="checkbox" name="checkall" id="checkall" onclick="checkAll('checkall','state')" style="vertical-align:middle; margin-top:0px;"/>全部&nbsp;&nbsp;&nbsp;&nbsp;
							                                         	<input type="checkbox" name="state" id="state" value="0" style="vertical-align:middle; margin-top:0px;"/>未退款&nbsp;&nbsp;&nbsp;&nbsp;
							                                         	<input type="checkbox" name="state" id="state" value="1" style="vertical-align:middle; margin-top:0px;"/>已退款&nbsp;&nbsp;&nbsp;&nbsp;
							                                         	<input type="checkbox" name="state" id="state" value="2" style="vertical-align:middle; margin-top:0px;"/>已拒绝&nbsp;&nbsp;&nbsp;&nbsp;
							                                      	</td>
							                                    </tr>
						                                        <tr height="25">
						                                       		<td width="30">&nbsp;</td>
						                                          	<td class="f13_1" align="left">申请日期：</td>
						                                          	<td align="left" class="f13_1">
						                                          		从<input name="dateS" type="text" value="${dateS }" onfocus="WdatePicker()" readonly class="date_but"/>
						                      	                    	到<input name="dateE" type="text" value="${dateE }" onfocus="WdatePicker()" readonly class="date_but"/>
						                                          	</td>
						                                        </tr>
																<tr height="50">
																	<td width="30">&nbsp;</td>
																	<td colspan="2" align="left" valign="middle">
																		<a href="javascript:void(0)">
																			<img src="${ctx}/images/btns2.png" alt="提交" onclick="query('2')" width="101" height="29"border="0" />
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
										tableId="${tableId}" action="${ctx}/applyRefund/list.do" showPagination="true" cellspacing="1">
										
										<ec:exportXls fileName="申请退款.xls" tooltip="导出Excel" view="xls" />
										<ec:row>
											<ec:column property="_rowNumber" title="序号" cell="rowNumber" style="text-align:center; width:5%" />
											<ec:column property="applyDate" title="申请日期" style="width:10%; text-align: center;" cell="date" format="yyyy-MM-dd"/>
											<ec:column property="applyAmount" title="申请金额（元）" cell="number" format="#0.00" style="width:11%; text-align: right;"/>
											<ec:column property="applyRemark" title="申请备注" style="width:22%; text-align: left;"/>
											
											<ec:column property="refundDate" title="退款日期" style="width:10%; text-align: center;" cell="date" format="yyyy-MM-dd"/>
											<ec:column property="refundAmount" title="退款金额（元）" cell="number" format="#0.00" style="width:11%; text-align: right;"/>
											<ec:column property="refundRemark" title="退款备注" style="width:24%; text-align: left;"/>
											<ec:column property="stateName" title="退款状态" style="width:7%; text-align: center;"/>
											
											<ec:column property="null" title="操作" style="width:5%; text-align: center;">
												<c:if test="${item.state == 0 }">
													<input type="button" value="删除" onclick="doDelete('${item.refundId}');" class="btn_bg" />
												</c:if>
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