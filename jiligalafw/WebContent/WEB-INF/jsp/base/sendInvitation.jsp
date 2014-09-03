<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<base target="_self"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${invitationTitle}</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: "#F2F2F2";
}
.text13 {
	font-family: "微软雅黑";
	color: #000000;
	font-size: 12px;
	line-height: 15px;
}
.f18b2 {
	font-family: "微软雅黑";
	font-size: 18px;
	padding-top: 5px;
	color: #474f63;
}
td {
	font-family: "微软雅黑";
	font-size: 12px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		if ($("#userFlag").val() == "1") {
			$("#sendLabel").html("发送账户邀请链接");

		} else {
			$("#sendLabel").html("发送用户邀请链接");
		}
	});

	function sendInvitation() {
		$("#userRegisterVo").submit();
	}
	function cancel() {
		self.close();
	}
	function checkEditOrUpdate() {
		var userAccount = $("#userAccount").val().replace(/\s/g, "");
		if (userAccount != "") {
			$("#userAccount").attr("readonly", "readonly");
			$("#userAccount").css("background","#E8F2FE");
		}
	}
</script>
</head>
<body onload="checkEditOrUpdate()" bgcolor="#F2F2F2" >
	<form:form modelAttribute="userRegisterVo" action="${ctx}/base/userRegister/sendInvitation.do" method="post">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" valign="top">
				<tr>
					<td style="height: 10px" colspan="2"><form:input path="userFlag" type="hidden" /></td>
				</tr>
				<tr>
					<td height="20px" align="center"" colspan="2"><span class="f18b2" id="sendLabel"><b>发送账户邀请链接</b></span></td>
				</tr>
				
		        <tr>
					<td style="height: 10px" colspan="2"></td>
				</tr>
				<tr>
                  <td height="2" align="center" valign="middle" colspan="5"><hr /></td>
                </tr>
				<tr>
					<td style="height: 10px" colspan="2"></td>
				</tr>
		
		
				<tr>
					<td width="20%" align="right" style="height: 50px">&nbsp;被邀请人邮箱：</td>
					<td width="80%" align="left">
						<form:input path="userAccount" class="text13" size="35" id="userAccount" />
						<font size="2" color="red"><form:errors path="userAccount" /></font>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" style="height: 50px">&nbsp;邀请链接：</td>
					<td width="80%" align="left">
						<form:textarea path="remark" class="text13" readonly="true" cols="80" rows="3" id="remark" />
					</td>
				</tr>
				<tr>
					<td style="height: 10px" colspan="2"></td>
				</tr>
				<tr>
                  <td height="2" align="center" valign="middle" colspan="5"><hr /></td>
                </tr>
				<tr>
					<td style="height: 10px" colspan="2"></td>
				</tr>
				<tr>
					<td align="center" colspan="2" style="height: 40px">
						<img src="${ctx}/images/btn39.png" alt="发送邀请" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:sendInvitation();"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<img src="${ctx}/images/btn8.png" alt="关  闭" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:cancel();"/>
					</td>
				</tr>
				<tr>
					<td style="height: 20px" colspan="2"></td>
				</tr>			
				
			</table>
	</form:form>
</body>
</html>