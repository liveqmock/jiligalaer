<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源 - 我的网络 - 高级网络 - IP地址编辑</title>
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
function applyAddr(){
	var networkId = $("#networkId").val();
	//waitloading();
	//window.location.href="${ctx}/network/applyAddr.do?networkId="+networkId;
	openwindow("${ctx}/network/ipApplyInit.do?networkId="+networkId,"计费选择",400,350);
	//window.showModalDialog("${ctx}/network/ipApplyInit.do?networkId="+networkId,"计费选择",400,350);
}
function back(){
	window.location.href="${ctx}/network/highNet.do";
}
//停用静态nat
function natStop(state,ipAddrId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/highNatEdit.do?ipAddrId="+ipAddrId+"&state="+state;
	waitloading();
	form.submit();
}
//启用静态nat
function natStart(state,ipAddrId){
	var callback = function(result){
		if(result){
			if(result.id == ''){
				return;
			}
			var form = document.forms.listForm;
			form.action="${ctx}/network/highNatEdit.do?ipAddrId="+ipAddrId+"&state="+state+"&vmId="+result.id;
			waitloading();
			form.submit();
		}else{
			if(result.id == ''){
				alert("请选择虚拟机");
				return;
			}
		}
	};
	openVmTree("${ctx}","vm",0,"r",$("input[name='vmId']").val(),null,callback,"1",$("#networkId").val());
	//openwindow("${ctx}/network/vmList.do?selectType=radio","选择虚拟机",600,500);
}
//启用VPN
function vpnStart(ipAddrId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/vpnOperate.do?ipAddrId="+ipAddrId+"&state=1";
	waitloading();
	form.submit();
}
//禁用VPN
function vpnStop(ipAddrId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/vpnOperate.do?ipAddrId="+ipAddrId+"&state=0";
	waitloading();
	form.submit();
}
//VPN添加用户
function vpnEdit(ipAddrId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/highVpnEdit.do?ipAddrId="+ipAddrId;
	form.submit();
}
//防火墙维护
function firewallEdit(ipAddrId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/highFirewallEdit.do?ipAddrId="+ipAddrId;
	form.submit();
}
//端口转发维护
function portForward(ipAddrId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/highPortEdit.do?ipAddrId="+ipAddrId;
	form.submit();
}
//负载均衡配置
function loadEdit(ipAddrId){
	var networkId = $("#networkId").val();
	window.location.href="${ctx}/network/highLoadEdit.do?ipAddrId="+ipAddrId+"&networkId="+networkId;
}
//删除IP地址
function delIpAddr(interfaceId, ipAddrId){
	if(confirm("确认删除该IP地址？")){
		var form = document.forms.listForm;
		form.action="${ctx}/network/delIpAddr.do?ipAddrId="+ipAddrId+"&interfaceId="+interfaceId;
		waitloading();
		form.submit();
	}
}
function query(){
	var form = document.forms.listForm;
	form.action="${ctx}/network/highIpAddr.do";
	loading();
	form.submit();
}

function showVmName(remark) {
	var div1 = document.getElementById('div_view'); //将要弹出的层 
	div1.style.display="block"; //div1初始状态是不可见的，设置可为可见 
	div1.style.left=event.clientX+10+"px"; //鼠标目前在X轴上的位置，加10是为了向右边移动10个px方便看到内容 
	div1.style.top=event.clientY+5+"px"; 
	div1.style.position="absolute"; //必须指定这个属性，否则div1层无法跟着鼠标动 
	div1.innerText=remark;
}
//关闭层div1的显示 
function closeVmName() { 
	var div1 = document.getElementById('div_view'); 
	div1.style.display="none"; 
} 

</script>
<script type="text/javascript">
var msg = '${ipOperationMsg}';
if(msg!=''){
	alert(msg);
	var networkId = '${networkId}';
	window.location.href="${ctx}/network/highIpAddr.do?networkId="+networkId;
}
</script>
</head>
  <body onLoad="">
  	<div id="div_view"></div>
    <form:form modelAttribute="baseVoList" action="${ctx}/network/highIpAddr.do" method="post" name="listForm">
		<input type="hidden" name="networkId" id="networkId" value="${networkId }" />
		
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr bgcolor="#ffffff" height="40">
					  	<td width="10"></td>
					  	<td class="f16_1">来宾网络01&nbsp;&nbsp;>&nbsp;&nbsp;IP地址</td>
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
                                  	  <td width="25%" class="f13_1" align="left">IP地址：<input type="text" name="ipAddr" value="${ipAddr }" size="15"/></td>
                                      <td colspan="2" width="25%" class="f13_1" align="right">
                                      	<img src="${ctx}/images/btn15.png" alt="查找" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:query();"/>
										<img src="${ctx}/images/btn28.png" alt="申请IP地址" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:applyAddr();"/>
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
		              <tr><td colspan="3" height="20"></td></tr>
		              
                      <tr>
                        <td width="10"></td>
						<td align="right" valign="top">
					      <table width="100%" border="0" cellpadding="0" cellspacing="0">
					        <tr>
					          <td align="left" valign="top" bgcolor="#FFFFFF" height="100">
								<span class="f12_1"  style="color: #e8be00;font-size:15px;">源Nat IP：</span>
					     		<table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              <tr bgcolor="#92b8c1" height="20">
					                <td width="5%" align="center" class="f12">序号</td>
					                <td width="47%" align="center" class="f12">IP</td>
					                <td width="10%" align="center" class="f12">VPN</td>
					                <td width="10%" align="center" class="f12">防火墙 </td>
					                <td width="10%" align="center" class="f12">端口转发 </td>
					                <td width="10%" align="center" class="f12">负载均衡</td>
					                <td width="8%" align="center" class="f12">删除</td>
					              </tr>
				              	<%int i=0; %>
								<c:forEach var="item" items="${ipList}" >
							        <%
							        String bgcolor="#deecef";
							        if(i++ % 2 == 0){bgcolor="#eef6f7"; }
							        %>
							        <c:if test="${item.issourcenat=='true'}">
										<tr bgcolor="<%=bgcolor %>" height="20">
						                  <td width="5%" align="center" class="f12_1"><%=i %></td>
						                  <td width="47%" align="left" class="f12_1">${item.ipAddress }</td>
						                  <td width="10%" align="center" class="f12_1">
						                  	<c:if test="${item.vpnEnabled==false}">
						                  		<input type="button" value="启用" onclick="javascript:vpnStart('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
						                  	</c:if>
						                  	<c:if test="${item.vpnEnabled==true}">
						                  	    <input type="button" value="维护" onclick="javascript:vpnEdit('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
						                  		<input type="button" value="禁用" onclick="javascript:vpnStop('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
						                  	</c:if>
						                  </td>
						                  <td width="10%" align="center" class="f12_1">
						                    <input type="button" value="维护" onclick="javascript:firewallEdit('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
						                  </td>
						                  <td width="10%" align="center" class="f12_1">
						                    <input type="button" value="维护" onclick="javascript:portForward('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
						                  </td>
						                  <td width="10%" align="center" class="f12_1">
						                    <input type="button" value="维护" onclick="javascript:loadEdit('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
						                  </td>
						                  <td width="8%" align="center" class="f12_1">
						                    <input type="button" value="删除" onclick="javascript:delIpAddr('${item.interfaceId }','${item.id }')" class="btn_bg" style="width: 40px;" />
						                  </td>
						                </tr>
						            </c:if>
				               	  </c:forEach>
				               	</table>
					          </td>
					        </tr>
							
					        <tr>
					          <td align="left" valign="top" bgcolor="#FFFFFF" height="250">
								<span class="f12_1" style="color: #e8be00;font-size:15px;">普通IP：</span>
					     		<table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              <tr bgcolor="#92b8c1" height="20">
					                <td width="5%" align="center" class="f12">序号</td>
					                <td width="10%" align="center" class="f12">IP</td>
					                <td width="10%" align="center" class="f12">是否静态NAT</td>
					                <td width="10%" align="center" class="f12">静态NAT</td>
					                <td width="17%" align="center" class="f12">VM</td>
					                <td width="10%" align="center" class="f12">VPN</td>
					                <td width="10%" align="center" class="f12">防火墙 </td>
					                <td width="10%" align="center" class="f12">端口转发 </td>
					                <td width="10%" align="center" class="f12">负载均衡</td>
					                <td width="8%" align="center" class="f12">删除</td>
					              </tr>
					            </table>
					            <div id="order" style="height:360px; z-index:1; overflow-y: scroll;overflow-x:hidden;">   
					              <table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              	<%int j=0; %>
									<c:forEach var="item" items="${ipList}" >
								        <%
								        String bgcolor="#deecef";
								        if(j++ % 2 == 0){bgcolor="#eef6f7"; }
								        %>
								        <c:if test="${item.issourcenat=='false'}">
											<tr bgcolor="<%=bgcolor %>" height="20">
							                  <td width="5%" align="center" class="f12_1"><%=j %></td>
							                  <td width="10%" align="left" class="f12_1">${item.ipAddress }</td>
							                  <td width="10%" align="center" class="f12_1">
							                    <c:choose>
								                  	<c:when test="${item.isstaticnat=='true' }">
								                  		是
								                  	</c:when>
								                  	<c:otherwise>
								                  		否
								                  	</c:otherwise>
							                  	</c:choose>
											  </td>
							                  <td width="10%" align="center" class="f12_1">
							                    <c:if test="${item.issourcenat!='true'}">
							                  		<c:if test="${item.isstaticnat=='true' }">
							                  		  <input type="button" value="禁用" onclick="javascript:natStop('0','${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
							                  		</c:if>
							                  		<c:if test="${item.isstaticnat=='false' }">
							                  		  <input type="button" value="启用" onclick="javascript:natStart('1','${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
							                  		</c:if>
							                  	</c:if>
							                  </td>
							                  <td width="17%" align="left" class="f12_1">${item.virtualmachinename }</td>
							                  <td width="10%" align="center" class="f12_1">
							                  	<c:if test="${item.vpnEnabled==false}">
							                  		<input type="button" value="启用" onclick="javascript:vpnStart('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
							                  	</c:if>
							                  	<c:if test="${item.vpnEnabled==true}">
							                  		<input type="button" value="维护" onclick="javascript:vpnEdit('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
							                  		<input type="button" value="禁用" onclick="javascript:vpnStop('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
							                  	</c:if>
							                  </td>
							                  <td width="10%" align="center" class="f12_1">
							                    <input type="button" value="维护" onclick="javascript:firewallEdit('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
							                  </td>
							                  <td width="10%" align="center" class="f12_1">
							                    <c:if test="${item.isstaticnat!='true' }">
							                  		<input type="button" value="维护" onclick="javascript:portForward('${item.interfaceId }')" class="btn_bg" style="width: 40px;" />
							                  	</c:if>
							                  </td>
							                  <td width="10%" align="center" class="f12_1">
							                    <c:if test="${item.isstaticnat!='true' }">
							                  		<input type="button" value="维护" onclick="javascript:loadEdit()" class="btn_bg" style="width: 40px;" />
							                  	</c:if>
							                  </td>
							                  <td width="8%" align="center" class="f12_1">
							                    <input type="button" value="删除" onclick="javascript:delIpAddr('${item.interfaceId }','${item.id }')" class="btn_bg" style="width: 40px;" />
							                  </td>
							                </tr>
							            </c:if>
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