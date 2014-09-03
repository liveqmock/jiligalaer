<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源 - 我的网络 - 高级网络  - IP地址 - VPN</title>
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
	background-color: #ffffff;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script type="text/javascript">
function save(){
	if($("#vpnUserName").val() == ''){
		alert("请输入用户名");
		return;
	}
	if($("#vpnUserPass").val() == ''){
		alert("请输入密码");
		return;
	}	
	var form = document.forms.listForm;
	form.action="${ctx}/network/saveVpnUser.do";
	waitloading();
	form.submit();
}
function delUser(vpnUserId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/delVpnUser.do?vpnUserId="+vpnUserId;
	waitloading();
	form.submit();
}
function back(){
	var form = document.forms.listForm;
	form.action="${ctx}/network/highIpAddr.do";
	form.submit();
}

</script>
<script type="text/javascript">
var msg = '${vpnUserMsg}';
if(msg!=''){
	alert(msg);
	var networkId = '${networkId}';
	window.location.href="${ctx}/network/highVpnEdit.do?networkId="+networkId;
}
</script>
</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/network/highVpnEdit.do" method="post" name="listForm">
		<input type="hidden" name="networkId" id="networkId" value="${networkId }" />
		
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr bgcolor="#ffffff" height="40">
					  	<td width="10"></td>
					  	<td class="f16_1">来宾网络01&nbsp;&nbsp;>&nbsp;&nbsp;IP地址&nbsp;&nbsp;>&nbsp;&nbsp;VPN</td>
					  	<td width="10"></td>
					  </tr>
                      <tr>
                      	<td width="10"></td>
                        <td height="2" align="left" valign="middle"><img src="${ctx}/images/buy_blue_line.jpg" width="100%" height="1" /></td>
                        <td width="10"></td>
                      </tr>
                      <tr>
                      	<td colspan="3" height="15" ></td>
                      </tr>	                      
                  	  <tr>
                  	    <td width="10"></td>
                    	<td align="left" valign="top">
						  <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#f2f2f2">
	                      	<tr height="20" bgcolor="#ffffff" >
                          	  <td>       	  
                           		<table width="100%" border="0" cellspacing="1" cellpadding="0">
                                    <tr height="30">
                                  	  <td width="25%" class="f13_1" align="left">
                                  	  	用户名：<input type="text" name="vpnUserName" id="vpnUserName" value="" size="10"/>
                                  	  </td>
                                      <td width="25%" class="f13_1" align="left">
                                      	密&nbsp;&nbsp;码：<input type="text" name="vpnUserPass" id="vpnUserPass" value="" size="10"/>
                                      </td>
                                      <td width="50%" class="f13_1" align="right">                                      	
                                      	<img src="${ctx}/images/btn27.png" alt="新增" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:save();"/>
										<img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:back();"/>
									    &nbsp;&nbsp;
                                      </td>
                                    </tr> 
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                        <td width="10"></td>
                      </tr>
		              <tr><td height="20"></td></tr>
		              
                      <tr>
                        <td width="10"></td>
						<td align="right" valign="top">
					      <table width="100%" border="0" cellpadding="0" cellspacing="0">
					        <tr>
					          <td align="left" valign="top" bgcolor="#FFFFFF" height="250">
					     		<table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              <tr bgcolor="#92b8c1" height="20">
					                <td width="10%" align="center" class="f12">序号</td>
					                <td width="40%" align="center" class="f12">用户名</td>
					                <td width="40%" align="center" class="f12">密码</td>
					                <td width="10%" align="center" class="f12">操作</td>
					              </tr>
					            </table>
					            <div id="order" style="height:470px; z-index:1; overflow-y: scroll;overflow-x:hidden;">   
					              <table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              	
					              	<%int i=0; %>
									<c:forEach var="item" items="${vpnUserList}" >
								        <%
								        String bgcolor="#deecef";
								        if(i++ % 2 == 0){bgcolor="#eef6f7"; }
								        %>
										<tr bgcolor="<%=bgcolor %>" height="20">
						                  <td width="10%" align="center" class="f12_1"><%=i %></td>
						                  <td width="40%" align="left" class="f12_1">${item.username }</td>
						                  <td width="40%" align="left" class="f12_1">${item.password }</td>
						                  <td width="10%" align="center" class="f12_1">
						                  	<a href="javascript:delUser('${item.id }')">删除</a>
						                  </td>					                  
						                </tr>
						            </c:forEach>
					                
					              </table>
					            </div>
					          </td>
					        </tr>
					      </table>							
						</td>
						<td width="10"></td>
                      </tr>
	                  <tr>
	                    <td height="20" colspan="3" ></td>
	                  </tr>                      
                    </table>
                  
	</form:form>
  </body>
</html>