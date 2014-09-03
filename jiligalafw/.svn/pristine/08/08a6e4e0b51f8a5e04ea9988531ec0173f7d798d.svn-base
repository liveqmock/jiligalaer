<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源 - 我的网络 - 基础网络 - CIDR编辑</title>
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
function add(){
	window.location.href="${ctx}/network/saveCidr.do";
}
function back(){
	window.location.href="${ctx}/network/basicNet.do";
}

</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/network/saveCidr.do" method="post" name="listForm">

					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr bgcolor="#ffffff" height="40">
					  	<td width="10"></td>
					  	<td class="f16_1">安全组01&nbsp;&nbsp;>&nbsp;&nbsp;CIDR</td>
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
                                  	  <td width="20%" class="f13_1" align="left">CIDR：<input type="text" name="" value="" size="10"/></td>
                                      <td width="20%" class="f13_1" align="left">起始端口：&nbsp;&nbsp;<input type="text" name="" value="" size="10"/></td>
                                      <td width="20%" class="f13_1" align="left">终止端口：&nbsp;&nbsp;<input type="text" name="" value="" size="10"/></td>
                                      <td width="40%" class="f13_1" align="right">
                                      	<img src="${ctx}/images/btn27.png" alt="新增" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:add();"/>
										<img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:back();"/>
									    &nbsp;&nbsp;
                                      </td>
                                    </tr> 
                                    <tr height="30">
                                  	  <td width="20%" class="f13_1" align="left">协&nbsp;议：
	                                  	  <select name="" style="width: 95px;">
	                                  	  	<option>TCP</option>
	                                  	  	<option>UDP</option>
	                                  	  	<option>ICMP</option>
	                                  	  </select>
                                  	  </td>
                                      <td width="20%" class="f13_1" align="left">ICMP类型：<input type="text" name="" value="" size="10"/></td>
                                      <td width="20%" class="f13_1" align="left">ICMP代码：<input type="text" name="" value="" size="10"/></td>
                                      <td width="40%" class="f13_1" align="right"></td>
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
					                <td width="7%" align="center" class="f12">序号</td>
					                <td width="15%" align="center" class="f12">CIDR </td>
					                <td width="10%" align="center" class="f12">协议</td>
					                <td width="15%" align="center" class="f12">起始端口</td>
					                <td width="15%" align="center" class="f12">终止端口 </td>
					                <td width="15%" align="center" class="f12">ICMP类型</td>
					                <td width="15%" align="center" class="f12">ICMP代码</td>
					                <td width="8%" align="center" class="f12">操作</td>
					              </tr>
					            </table>
					            <div id="order" style="height:440px; z-index:1; overflow-y: scroll;overflow-x:hidden;">   
					              <table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					                <tr bgcolor="#deecef" height="20">
					                  <td width="7%" align="center" class="f12_1">1</td>
					                  <td width="15%" align="left" class="f12_1"></td>
					                  <td width="10%" align="center" class="f12_1"></td>
					                  <td width="15%" align="center" class="f12_1"></td>
					                  <td width="15%" align="left" class="f12_1"></td>
					                  <td width="15%" align="center" class="f12_1"></td>
					                  <td width="15%" align="center" class="f12_1"></td>
					                  <td width="8%" align="center" class="f12_1">删除</td>					                  
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