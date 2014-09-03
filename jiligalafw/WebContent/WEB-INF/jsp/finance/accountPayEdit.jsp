<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户充值 编辑</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/basic.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/autoheight.js"></script>
<style type="text/css">
body {
	background-color: #000000;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function doSave(){
	reg = /^[-\+]?\d+(\.\d+)?$/;
	var form = document.getElementById("accountPayForm");
	if(form.userId.value == ''){
		alert("请选择账户名称！");
		return;
	}
	if(form.payAmount.value == ''){
		alert("请输入充值金额！");
		return;
	}
	if(!reg.test(form.payAmount.value)){
		alert("请输入正确的金额！");
		return;
	}
	form.submit();
}

function selectAccount(){
	var callback = function(result){
		if(result){
			getRemainingAmount(result.id);
			accountInfo(result.id);
			$("input[name='userId']").val(result.id);
			$("input[name='userAccount']").val(result.name);
		}
	};
	openAccountTree("${ctx}","account",0,"r",$("input[name='userId']").val(),null,callback,"1");
}

function getRemainingAmount(userId) {
	$.ajax({
	   	type: "POST",
	   	url: '${ctx}'+"/accPay/getRemainingAmount.do",
	   	data: "userId="+userId,
		async: false,
	   	success: function(msg){
	   		var obj = msg;
			if(obj==null || obj=="" || obj=='null' || obj.length==0){
				return false;
			}else {
				//var amount = document.getElementById('remainingAmount'); 
				//amount.innerText = obj;
				//obj从数据库过来的时候包含了“\r\n”
				$("#remainingAmount").text("（余额："+obj+"元）");
			}
		}
	});
}
function accountInfo(userId){
	document.getElementById("payForm").src="${ctx}/accPay/detailInfo.do?userId="+userId;
}
function back(){
	window.location="${ctx}/accPay/list.do";
}
</script>
<script type="text/javascript">
var msg = '${payMsg}';
if(msg!=''){
	alert(msg);
	//window.parent.parent.parent.close();
	back();
}
</script>
</head>
<body>
	<form:form modelAttribute="accountPayVo" action="${ctx}/accPay/save.do" method="post" id="accountPayForm">

			<table width="962" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center" valign="top" bgcolor="#F2F2F2">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td height="40" align="left" valign="middle"><span class="f18b2">账户充值</span></td>
								<td align="left" valign="middle">&nbsp;</td>
							</tr>
							<tr>
								<td height="2" colspan="2" align="center" valign="middle">
									<img src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" />
								</td>
							</tr>

							<tr>
								<td align="left" valign="top">
									<table width="100%" height="150" border="0" cellpadding="0" cellspacing="0">
										<tr height="25">
											<td width="20"></td>
											<td align="left" class="f13_1" width="80">账户名称：</td>
											<td align="left" class="f13_1">
												<input type="hidden" name="userId" id="userId" />
												<input type="text" name="userAccount" onclick="selectAccount()" readonly class="select_but" style="width: 160px;"/>
												<b>
													<span id="remainingAmount" style="white-space: nowrap;"></span>
												</b>
											</td>
											<td align="left"></td>
										</tr>
										<tr height="25">
											<td width="20"></td>
											<td width="80" align="left" class="f13_1">充值方式：</td>
											<td align="left">
												<form:select path="payType">
													<form:option value="1">现金</form:option>
													<form:option value="2">转账</form:option>
													<!--
													<form:option value="3">赠送</form:option>
													<form:option value="4">银联</form:option>
													<form:option value="5">支付宝</form:option>
													-->
												</form:select>
											</td>
											<td align="left"></td>
										</tr>
										<tr height="25">
											<td width="20"></td>
											<td align="left" class="f13_1">充值金额：</td>
											<td align="left" class="f13_1">
												<form:input path="payAmount"/> 元
											</td>	
											<td align="left"></td>
										</tr>
										<tr height="30">
											<td width="20"></td>
											<td align="left" class="f13_1">备注：</td>
											<td align="left">
												<form:textarea path="remark" rows="5" cols="50"/>
											</td>	
											<td align="left"></td>
										</tr>
									</table>
								</td>
								<td align="right" valign="top"></td>
							</tr>
							<tr><td height="14" colspan="2"></td></tr>
			                <tr>
			                   <td colspan="2" align="center" valign="middle">
			                  	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
			                       <tr>
			                         <td width="15%" align="center" valign="top">
			                         	<a href="javascript:doSave()"><img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" align="absmiddle"/></a>
			                         </td>
			                         <td width="1%" ></td>
			                         <td width="45%" align="left" valign="top">
			                         	<a href="javascript:back();"><img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" align="absmiddle" /></a>
			                         </td>
			                         <!--
			                         <td width="45%" align="left" valign="top">
			                         	<a href="javascript:void(0)"><img src="${ctx}/images/btnc1.png" alt="重置" onclick="document.forms.accountPayForm.reset();return false;" width="101" height="30" border="0" align="absmiddle"/></a>
			                         </td>
			                       	 -->
			                       </tr>
			                     </table>
			                   </td>
			                </tr>
							<tr><td height="14" colspan="2"></td></tr>
							<tr>
								<td height="2" colspan="2" align="center" valign="middle"><img src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" /></td>
							</tr>
							<tr><td height="14" colspan="2"></td></tr>
						</table>
						
						
						<div id="middle_sheet_s_name">
							<a href="javascript:accInfo('detailInfo',0,'${userId }');"><img src="${ctx}/images/menu_s_0_s.png" border="0" align="absmiddle" id="detailInfo" /></a>
							<a href="javascript:accInfo('orderInfo',1,'${userId }');"><img src="${ctx}/images/menu_s_1.jpg" border="0" align="absmiddle" id="orderInfo" /></a>
							<a href="javascript:accInfo('billInfo',1,'${userId }');"><img src="${ctx}/images/menu_s_2.jpg" border="0" align="absmiddle" id="billInfo" /></a>							
						</div>
						<script type="text/javascript">
							function accInfo(url,type,userId) {
								if(userId == ''){
									userId = document.getElementById("userId").value;
								}
								var path="accPay";
								if(type == 1){
									path="accInfo";
								}
								$("#detailInfo")[0].src="${ctx}/images/menu_s_0.jpg";
								$("#orderInfo")[0].src="${ctx}/images/menu_s_1.jpg";
								$("#billInfo")[0].src="${ctx}/images/menu_s_2.jpg";
								
								var map = getMap(); 
								map.put("detailInfo","${ctx}/images/menu_s_0_s.png");
								map.put("orderInfo","${ctx}/images/menu_s_1_s.png");
								map.put("billInfo","${ctx}/images/menu_s_2_s.png");
								
								$("#"+url)[0].src=map.get(url);
								document.getElementById("payForm").src = "${ctx}/" + path + "/" + url + ".do?userId="+userId;
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

										<iframe id="payForm" name="userPayForm" src="${ctx}/accPay/detailInfo.do?userId=${userId }" frameborder="0" scrolling="no" height="100%" width="100%"></iframe>

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
			
	</form:form>
</body>
</html>