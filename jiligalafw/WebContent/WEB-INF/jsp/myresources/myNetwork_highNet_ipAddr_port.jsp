<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源 - 我的网络 - 高级网络  - IP地址 - 端口转发</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/basic.js"></script>
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
	if($("#privatePortS").val() == '' || $("#privatePortE").val() == ''){
		alert("请输入专用端口");
		return;		
	}
	if($("#publicPortS").val() == '' || $("#publicPortE").val() == ''){
		alert("请输入公用端口");
		return;		
	}	
	if($("#vmId").val() == ''){
		alert("请选择虚拟机");
		return;
	}
	
	var form = document.forms.listForm;
	form.action="${ctx}/network/savePortForward.do";
	waitloading();
	form.submit();
}
function back(){
	var form = document.forms.listForm;
	form.action="${ctx}/network/highIpAddr.do";
	form.submit();
}
function delPortForward(interfaceId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/delPortForward.do?interfaceId="+interfaceId;
	waitloading();
	form.submit();
}
function selectVm(){
	var callback = function(result){
		if(result){
			$("input[name='vmId']").val(result.id);
			$("input[name='vmName']").val(result.name);
		}
	};
	openVmTree("${ctx}","vm",0,"r",$("input[name='vmId']").val(),null,callback,"1");
	
	//openwindow("${ctx}/network/vmList.do?selectType=radio","选择虚拟机",600,500);
}
</script>
<script type="text/javascript">
var msg = '${portForwardMsg}';
if(msg!=''){
	alert(msg);
	var networkId = '${networkId}';
	var ipAddrId = '${ipAddrId}';
	window.location.href="${ctx}/network/highPortEdit.do?networkId="+networkId+"&ipAddrId="+ipAddrId;
}
</script>
</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/network/highPortEdit.do" method="post" name="listForm">
		<input type="hidden" name="networkId" id="networkId" value="${networkId }" />
		<input type="hidden" name="ipAddrId" id="ipAddrId" value="${ipAddrId }" />
		
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr bgcolor="#ffffff" height="40">
					  	<td width="10"></td>
					  	<td class="f16_1">来宾网络01&nbsp;&nbsp;>&nbsp;&nbsp;IP地址&nbsp;&nbsp;>&nbsp;&nbsp;端口转发</td>
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
                                  	  <td width="10%" class="f13_1" align="right">专用端口：</td>
                                  	  <td width="25%" class="f13_1" align="left">
                                  	  	<input type="text" name="privatePortS" id="privatePortS" value="" size="5"/>
                                  	  	-
                                  	  	<input type="text" name="privatePortE" id="privatePortE" value="" size="5"/>
                                  	  </td>
                                      <td width="10%" class="f13_1" align="right">公用端口：</td>
                                      <td width="25%" class="f13_1" align="left">
                                      	<input type="text" name="publicPortS" id="publicPortS" value="" size="5"/>
                                      	-
                                      	<input type="text" name="publicPortE" id="publicPortE" value="" size="5"/>
                                      </td>
                                      <td width="30%" class="f13_1" align="right">
                                      	<img src="${ctx}/images/btn27.png" alt="新增" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:add();"/>
							            <img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:back();"/>
							            &nbsp;&nbsp;
                                      </td>
                                    </tr>
                                    <tr height="30">
                                      <td width="10%" class="f13_1" align="right">选择虚拟机：</td>
                                      <td width="25%" class="f13_1" align="left">
										<input type="hidden" name="vmId" id="vmId" />
										<input type="text" name="vmName" id="vmName" onclick="selectVm()" readonly class="select_but" style="width: 145px;" />
									  </td>
                                      <td width="10%" class="f13_1" align="right">协议：</td>
                                      <td width="25%" class="f13_1" align="left">
	                                  	  <select name="protocol" id="protocol" >
	                                  	  	<option>TCP</option>
	                                  	  	<option>UDP</option>
	                                  	  	<option>ICMP</option>
	                                  	  </select>                                      
									  </td>
									  <td width="30%" class="f13_1" align="right"></td>
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
					                <td width="15%" align="center" class="f12">专用端口</td>
					                <td width="15%" align="center" class="f12">公用端口</td>
					                <td width="15%" align="center" class="f12">协议</td>
					                <td width="40%" align="center" class="f12">VM</td>
					                <td width="10%" align="center" class="f12">操作</td>
					              </tr>
					            </table>
					            <div id="order" style="height:470px; z-index:1; overflow-y: scroll;overflow-x:hidden;">   
					              <table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              	<%int i=0; %>
									<c:forEach var="item" items="${portForwardList}" >
								        <%
								        String bgcolor="#deecef";
								        if(i++ % 2 == 0){bgcolor="#eef6f7"; }
								        %>
										<tr bgcolor="<%=bgcolor %>" height="20">
						                  <td width="5%" align="center" class="f12_1"><%=i %></td>
						                  <td width="15%" align="left" class="f12_1">${item.privateport } - ${item.privateendport }</td>
						                  <td width="15%" align="center" class="f12_1">${item.publicport } - ${item.publicendport }</td>
						                  <td width="15%" align="center" class="f12_1">${item.protocol }</td>
						                  <td width="40%" align="center" class="f12_1">${item.vmName }</td>
						                  <td width="10%" align="center" class="f12_1">
						                    <input type="button" value="删除" onclick="javascript:delPortForward('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
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