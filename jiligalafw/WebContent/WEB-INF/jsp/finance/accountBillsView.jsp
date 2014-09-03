<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>财务管理 - 账户扣费账单 - 费用明细</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/autoheight.js"></script>
<style type="text/css">
body {
	background-color: #ffffff;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
form {
	margin: 0px;
	padding: 0px;
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<form:form modelAttribute="accountRefundVoList" action="${ctx}/accBills/view.do" method="post">
	  <input type="hidden" name="expDate" value="${expDate }" />
	  
      <table width="962" border="0" cellpadding="0" cellspacing="0" align="center">
        <tr>
          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_1.png" width="9" height="9" /></td>
          <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_2.png"></td>
          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_3.png" width="9" height="9" /></td>
        </tr>      
        <tr>
          <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_4.png"></td>
          <td align="center"  valign="top" bgcolor="#F2F2F2">

			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center" valign="top" bgcolor="#F2F2F2">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td height="40" colspan="2" align="center" valign="middle">
									<span class="f18b2">${basicUser.userName } （扣费账单：${expDate }）</span>
								</td>
							</tr>
							<tr>
								<td height="2" colspan="2" align="center" valign="middle">
									<hr />
								</td>
							</tr>

							<tr>
								<td align="left" width="5" valign="top"></td>
								<td align="left" valign="top">
									<table width="100%" height="100" border="0" cellpadding="0" cellspacing="0">
										<tr height="25">
											<td width="5%"></td>
											<td width="15%" align="left" class="f13_1">账户类别：</td>
											<td width="30%" align="left" class="f13_1">${basicUser.userTypeDictItem.itemName }</td>
											<td width="15%" align="left" class="f13_1">账户类型：</td>
											<td width="30%" align="left" class="f13_1">${basicUser.userIdentityDictItem.itemName }</td>											
											<td width="5%" align="left"></td>
										</tr>																		
										<tr height="25">
											<td ></td>
											<td align="left" class="f13_1">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区：</td>
											<td align="left" class="f13_1">${basicUser.geoDictItem.itemName }</td>
											<td align="left" class="f13_1">行&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</td>
											<td align="left" class="f13_1">${basicUser.industryDictItem.itemName }</td>											
											<td align="left"></td>
										</tr>
										<tr height="25">
											<td ></td>
											<td align="left" class="f13_1">账户名：</td>
											<td colspan="3" align="left" class="f13_1">${basicUser.userAccount }</td>	
											<td align="left"></td>
										</tr>
										<tr height="25">
											<td ></td>
											<td align="left" class="f13_1"><b>扣费金额：</b></td>
											<td colspan="3" align="left" class="f13_1"><fmt:formatNumber pattern="#0.00">${expAmount }</fmt:formatNumber> 元</td>	
											<td align="left"></td>
										</tr>
									</table>
								</td>
							</tr>
							
							<tr><td height="14" colspan="2"></td></tr>
							<tr><td height="30" colspan="2" align="center"><a href="javascript:window.parent.parent.close();"><img src="${ctx}/images/btn8.png" alt="关闭" width="101" height="30" border="0" align="absmiddle"/></a></td></tr>
							<tr><td height="14" colspan="2"></td></tr>
						</table>
						
						
						<div id="middle_sheet_s_name">
							<a href="javascript:accInfo('detail',0,'${basicUser.userId }','${expDate }');"><img src="${ctx}/images/menu_s_0_s.png" border="0" align="absmiddle" id="detail" /></a>
							<a href="javascript:accInfo('orderInfo',1,'${basicUser.userId }','${expDate }');"><img src="${ctx}/images/menu_s_1.jpg" border="0" align="absmiddle" id="orderInfo" /></a>
							<a href="javascript:accInfo('billInfo',1,'${basicUser.userId }','${expDate }');"><img src="${ctx}/images/menu_s_2.jpg" border="0" align="absmiddle" id="billInfo" /></a>
						</div>
						<script type="text/javascript">
							function accInfo(url,type,userId,expDate) {
								var path="accBills";
								if(type == 1){
									path="accInfo";
								}
								$("#detail")[0].src="${ctx}/images/menu_s_0.jpg";
								$("#orderInfo")[0].src="${ctx}/images/menu_s_1.jpg";
								$("#billInfo")[0].src="${ctx}/images/menu_s_2.jpg";
								
								var map = getMap(); 
								map.put("detail","${ctx}/images/menu_s_0_s.png");
								map.put("orderInfo","${ctx}/images/menu_s_1_s.png");
								map.put("billInfo","${ctx}/images/menu_s_2_s.png");
								
								$("#"+url)[0].src=map.get(url);
								document.getElementById("billsForm").src = "${ctx}/" + path + "/" + url + ".do?userId="+userId+"&expDate="+expDate;
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
									<td align="center" valign="top" bgcolor="#FFFFFF" height="530">

										<iframe id="billsForm" name="userBillsForm" src="${ctx}/accBills/detail.do?userId=${basicUser.userId}&expDate=${expDate}" frameborder="0" scrolling="no" height="100%" width="100%"></iframe>

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