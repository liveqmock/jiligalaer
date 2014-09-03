<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源 - 我的网络 - 高级网络</title>
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
function query(){
	var form = document.forms.listForm;
	form.action="${ctx}/network/highNet.do";
	loading();
	form.submit();
}
//添加高级网络
function add(){
	window.location.href="${ctx}/network/addHighNet.do";
}
//网络IP地址维护
function ipAddrEdit(interfaceId){
	window.location.href="${ctx}/network/highIpAddr.do?networkId="+interfaceId;
}
//出口规则维护
function highOutEdit(networkId){
	window.location.href="${ctx}/network/highOutRule.do?networkId="+networkId;
}
//删除网络
function delNetwork(interfaceId, networkId){
	if(confirm("确认删除该网络？")){
		var form = document.forms.listForm;
		form.action="${ctx}/network/delNetwork.do?interfaceId="+interfaceId+"&networkId="+networkId;
		waitloading();
		form.submit();
	}
}

</script>
<script type="text/javascript">
$(document).ready(function(){
	var msg = '${networkMsg}';
	if(msg!=''){
		alert(msg);
		window.location.href="${ctx}/network/highNet.do";
	}
});

</script>
</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/network/highNet.do" method="post" name="listForm">

					<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  	  <tr>
                  	    <td width="10"></td>
                    	<td align="left" valign="top">
						  <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#f2f2f2">
	                      	<tr height="20" bgcolor="#ffffff" >
                          	  <td>
                          	  
                           		<table width="100%" border="0" cellspacing="1" cellpadding="0">
                               	  	<!-- 一键式搜索 -->
                                    <tr height="30">
                                  	  <td></td>
                                      <td width="250" class="f13_1" align="left">网络名称：<input type="text" name="networkName" value="${networkName }"/></td>
                                      <td width="250" class="f13_1" align="left">网络方案：<input type="text" name="networkSolnName" value="${networkSolnName }" /></td>
                                      <td align="right">
                                      	<img src="${ctx}/images/btn15.png" alt="查找" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:query();"/>
										<img src="${ctx}/images/btn27.png" alt="新增" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:add();"/>
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
		              <tr><td height="20" colspan="3"></td></tr>
		              
                      <tr>
                        <td width="10"></td>
						<td align="right" valign="top">
					      <table width="100%" border="0" cellpadding="0" cellspacing="0">
					        <tr>
					          <td align="left" valign="top" bgcolor="#FFFFFF" height="250">
					     		<table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              <tr bgcolor="#92b8c1" height="20">
					                <td width="5%" align="center" class="f12">序号</td>
					                <td width="15%" align="center" class="f12">网络名称</td>
					                <td width="20%" align="center" class="f12">网络描述</td>
					                <td width="10%" align="center" class="f12">数据中心</td>
					                <td width="29%" align="center" class="f12">网络方案</td>
					                <td width="7%" align="center" class="f12">IP地址</td>
					                <td width="7%" align="center" class="f12">出口规则 </td>
					                <td width="7%" align="center" class="f12">删除 </td>
					              </tr>
					            </table>
					            
					            <div id="order" style="height:530px; z-index:1; overflow-y: scroll;overflow-x:hidden;">   
					              <table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              	
					              	<%int i=0; %>
									<c:forEach var="item" items="${networkList}" >
								        <%
								        String bgcolor="#deecef";
								        if(i++ % 2 == 0){bgcolor="#eef6f7"; }
								        %>
										<tr bgcolor="<%=bgcolor %>" height="20">
						                  <td width="5%" align="center" class="f12_1"><%=i %></td>
						                  <td width="15%" align="left" class="f12_1">${item.name }</td>
						                  <td width="20%" align="left" class="f12_1">${item.displaytext }</td>
						                  <td width="10%" align="left" class="f12_1">${item.zonename }</td>
						                  <td width="29%" align="left" class="f12_1" style="word-break:break-all;">${item.networkofferingname }</td>
						                  <td width="7%" align="center" class="f12_1">
						                    <input type="button" value="维护" onclick="javascript:ipAddrEdit('${item.interfaceId }');" class="btn_bg" style="width: 45px;"/>
						                  </td>
						                  <td width="7%" align="center" class="f12_1">
						                    <input type="button" value="维护" onclick="javascript:highOutEdit('${item.interfaceId }');" class="btn_bg" style="width: 45px;"/>
						                  </td>
						                  <td width="7%" align="center" class="f12_1">
						                    <input type="button" value="删除" onclick="javascript:delNetwork('${item.interfaceId }','${item.id }');" class="btn_bg" style="width: 45px;"/>
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