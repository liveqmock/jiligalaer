<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源 - 我的网络 - VPC网络 - IP地址编辑</title>
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
function back(){
	window.location.href="${ctx}/network/vpcNet.do";
}

function loadEdit(){
	//window.location.href="${ctx}/network/highLoadEdit.do";
}
function portEdit(){
	//window.location.href="${ctx}/network/highPortEdit.do";
}
</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/network/vpcNet.do" method="post" name="listForm">

					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr bgcolor="#ffffff" height="40">
					  	<td width="10"></td>
					  	<td class="f16_1">VPC网络01&nbsp;&nbsp;>&nbsp;&nbsp;IP地址</td>
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
                                  	  <td width="25%" class="f13_1" align="left">IP地址：<input type="text" name="" value="" size="15"/></td>
                                      <td width="25%" class="f13_1" align="left"></td>
                                      <td colspan="2" width="25%" class="f13_1" align="right">
                                      	<input type="button" value="查询" onclick="query()" class="btn_bg" style="width: 60px;"/>
                                      	&nbsp;&nbsp;
                                      	<input type="button" value="返回" onclick="back()" class="btn_bg" style="width: 60px;"/>
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
		              <tr><td colspan="3" height="20"></td></tr>
		              
                      <tr>
                        <td width="10"></td>
						<td align="right" valign="top">
					      <table width="100%" border="0" cellpadding="0" cellspacing="0">
					        <tr>
					          <td align="left" valign="top" bgcolor="#FFFFFF" height="250">
					     		<table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              <tr bgcolor="#92b8c1" height="20">
					                <td width="5%" align="center" class="f12">序号</td>
					                <td width="10%" align="center" class="f12">IP</td>
					                <td width="10%" align="center" class="f12">静态NAT</td>
					                <td width="10%" align="center" class="f12">VPN</td>
					                <td width="10%" align="center" class="f12">防火墙 </td>
					                <td width="10%" align="center" class="f12">负载均衡</td>
					                <td width="10%" align="center" class="f12">端口转发 </td>
					              </tr>
					            </table>
					            <div id="order" style="height:470px; z-index:1; overflow-y: scroll;overflow-x:hidden;">   
					              <table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					                <tr bgcolor="#deecef" height="20">
					                  <td width="5%" align="center" class="f12_1">1</td>
					                  <td width="10%" align="left" class="f12_1">192.168.1.11</td>
					                  <td width="10%" align="center" class="f12_1"></td>
					                  <td width="10%" align="center" class="f12_1"></td>
					                  <td width="10%" align="center" class="f12_1"></td>
					                  <td width="10%" align="center" class="f12_1"><a href="javascript:loadEdit()">维护</a></td>
					                  <td width="10%" align="center" class="f12_1"><a href="javascript:portEdit()">维护</a></td>
					                </tr>					               
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