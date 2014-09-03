<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源 - 我的网络 - 高级网络  - IP地址 - 负载均衡</title>
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
p {
	font-family: "宋体";
	font-size: 13px;
	color: #000000;
}
-->
</style>
<script type="text/javascript">
function query(){
	var form = document.forms.listForm;
	waitloading();
	form.submit();
}
//新增规则
function add(){
	if($("#balancerName").val() == ''){
		alert("请填写名称");
		return;		
	}
	if($("#publicPort").val() == ''){
		alert("请输入公用端口");
		return;		
	}
	if($("#privatePort").val() == ''){
		alert("请输入专用端口");
		return;		
	}
	if($("#vmId").val() == ''){
		alert("请选择虚拟机");
		return;
	}
	
	var form = document.forms.listForm;
	form.action="${ctx}/network/saveLoadRule.do";
	waitloading();
	form.submit();
}
function back(){
	var form = document.forms.listForm;
	form.action="${ctx}/network/highIpAddr.do";
	form.submit();
}

//选择虚拟机
function selectVm(){
	var networkId = $("#networkId").val();
	var callback = function(result){
		if(result){
			$("input[name='vmId']").val(result.id);
			$("input[name='vmName']").val(result.name);
		}
	};
	openVmTree("${ctx}","vm",0,"c",$("input[name='vmId']").val(),null,callback,"1",networkId);
}
//粘性配置
function config(loadRuleId){
	return window.openwindow("${ctx}/network/stickinessConfigInit.do?loadRuleId="+loadRuleId,"选择虚拟机",530,590);
}
//删除规则
function delRule(loadRuleId){
	if(confirm("确认删除负载均衡吗？")){
		var form = document.forms.listForm;
		form.action="${ctx}/network/delLoadRule.do?loadRuleId="+loadRuleId;
		waitloading();
		form.submit();
	}
}
//修改算法和名称
function editAlgorithm(loadRuleId,ruleName,selVal){
	var optionStr = "";
	if(selVal == 'roundrobin'){
		optionStr +="<option value='roundrobin' selected>轮询算法</option>";
	}else{
		optionStr +="<option value='roundrobin'>轮询算法</option>";
	}
	if(selVal == 'leastconn'){
		optionStr +="<option value='leastconn' selected>最少连接算法</option>";
	}else{
		optionStr +="<option value='leastconn'>最少连接算法</option>";
	}
	if(selVal == 'source'){
		optionStr +="<option value='source' selected>源算法</option>";
	}else{
		optionStr +="<option value='source'>源算法</option>";
	}
	
	var txt = '<p style="font-size:14px;color:#1491ad">修改规则</p><center>';
	txt += '<p style="line-height:30px">名称：<input type="text" name="ruleName" id="ruleName" value="'+ruleName+'" size="12" /></p>';
	txt += '<font size="2">算法：</font><select name="updArithmetic">'+optionStr+'</select></center>';
	$.prompt(txt,{
		buttons: {'确定':1, '取消':3},
		callback: function mycallbackform(v,m,f){
			if(v == 3){
				return ;
			}
			if(f.ruleName==""){
				alert("请输入名称！");
				return ;
			}else{
				if(confirm("确认修改吗？")){
					$("#updArithmetic").val(f.updArithmetic);
					$("#ruleName").val(f.ruleName);
					var form = document.forms.listForm;
					form.action="${ctx}/network/updLoadRule.do?loadRuleId="+loadRuleId;
					waitloading();
					form.submit();
				}
			}	
		}
	}); 
}
function displayVm(rowNumber){
	if($("#vmtrid"+rowNumber).css('display') == 'none'){
		$("#vmtrid"+rowNumber).show();
	}else{
		$("#vmtrid"+rowNumber).hide();
	}
}
function delVm(loadRuleId,vmid){
	if(confirm("确认删除该实例吗？")){
		var form = document.forms.listForm;
		form.action="${ctx}/network/delLoadRuleVm.do?loadRuleId="+loadRuleId+"&vmid="+vmid;
		waitloading();
		form.submit();
	}
}
function addVm(loadRuleId){
	var networkId = $("#networkId").val();
	var ipAddrId = $("#ipAddrId").val();
	var prams = "loadRuleId="+loadRuleId+"&networkId="+networkId+"&ipAddrId="+ipAddrId;
	window.openwindow("${ctx}/network/initAddInstance.do?"+prams,"添加实例",450,530);
}
</script>
<script type="text/javascript">
var msg = '${loadRuleMsg}';
if(msg!=''){
	alert(msg);
	var ipAddrId = '${ipAddrId}';
	var networkId = '${networkId}';
	window.location.href="${ctx}/network/highLoadEdit.do?ipAddrId="+ipAddrId+"&networkId="+networkId;
}
</script>
</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/network/highLoadEdit.do" method="post" name="listForm">
		<input type="hidden" name="ipAddrId" id="ipAddrId" value="${ipAddrId }" />
		<input type="hidden" name="networkId" id="networkId" value="${networkId }" />
		<input type="hidden" name="ruleName" id="ruleName"  />
		<input type="hidden" name="updArithmetic" id="updArithmetic"  />
		
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr bgcolor="#ffffff" height="40">
					  	<td width="10"></td>
					  	<td class="f16_1">来宾网络01&nbsp;&nbsp;>&nbsp;&nbsp;IP地址&nbsp;&nbsp;>&nbsp;&nbsp;负载均衡</td>
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
                                  	  <td width="20%" class="f13_1" align="left">名称：<input type="text" name="balancerName" id="balancerName" value="" size="10"/></td>
                                      <td width="30%" class="f13_1" align="left">&nbsp;&nbsp;&nbsp;
                                      	公用端口：<input type="text" name="publicPort" id="publicPort" value="" size="10"/>
                                      </td>
                                      <td width="20%" class="f13_1" align="left">
                                      	专用端口：<input type="text" name="privatePort" id="privatePort" value="" size="10"/>
                                      </td>
                                      <td width="30%" class="f13_1" align="right">
                                      	<img src="${ctx}/images/btn27.png" alt="新增" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:add();"/>
							            <img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:back();"/>
							            &nbsp;&nbsp;
                                      </td>
                                    </tr> 
                                    <tr height="30">
                                  	  <td width="2%" class="f13_1" align="left">算法：
	                                  	  <select name="arithmetic" style="width: 92px;">
	                                  	  	<option value="roundrobin">轮询算法</option>
	                                  	  	<option value="leastconn">最少连接算法</option>
	                                  	  	<option value="source">源算法</option>
	                                  	  </select>
                                  	  </td>
                                      <td class="f13_1" align="left" colspan="3">
                                      	选择虚拟机：
										<input type="hidden" name="vmId" id="vmId" />
										<input type="text" name="vmName" id="vmName" onclick="selectVm()" readonly class="select_but" style="width: 220px;" />                                      
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
					              <tr bgcolor="#92b8c1" height="25">
					                <td width="5%" align="center" class="f12">序号</td>
					                <td width="25%" align="center" class="f12">名称</td>
					                <td width="10%" align="center" class="f12">公用端口</td>
					                <td width="10%" align="center" class="f12">专用端口</td>
					                <td width="15%" align="center" class="f12">算法</td>
					                <td width="10%" align="center" class="f12">粘贴</td>
					                <td width="10%" align="center" class="f12">VM</td>
					                <td width="15%" align="center" class="f12">操作</td>
					              </tr>
					            </table>
					            <div id="order" style="height:440px; z-index:1; overflow-y: scroll;overflow-x:hidden;">   
					              	<%int j=0; %>
									<c:forEach var="item" items="${loadRuleList}" >
								        <%
								        String bgcolor="#deecef";
								        if(j++ % 2 == 0){bgcolor="#eef6f7"; }
								        %>					              
					              	  <table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
						                <tr bgcolor="<%=bgcolor %>" height="25">
						                  <td width="5%" align="center" class="f12_1"><%=j %></td>
						                  <td width="25%" align="left" class="f12_1" style="vertical-align:middle;" >
						                  	<img title="展开" src="${ctx}/images/open.gif" onclick="displayVm('<%=j%>')" style="cursor: pointer; vertical-align:top;"/>
						                  	${item.name }
						                  </td>
						                  <td width="10%" align="center" class="f12_1">${item.publicport }</td>
						                  <td width="10%" align="center" class="f12_1">${item.privateport }</td>
						                  <td width="15%" align="center" class="f12_1">
						                  	<c:if test="${item.algorithm == 'roundrobin' }">轮询算法</c:if>
						                  	<c:if test="${item.algorithm == 'leastconn' }">最少连接算法</c:if>
						                  	<c:if test="${item.algorithm == 'source' }">源算法</c:if>
						                  </td>
						                  <td width="10%" align="center" class="f12_1">
						                  	<input type="button" value="配置" onclick="config('${item.interfaceId }')" class="btn_bg" style="width: 40px;"/>
						                  </td>
						                  <td width="10%" align="center" class="f12_1">
						                  	<input type="button" value="新增" onclick="addVm('${item.interfaceId }')" class="btn_bg" style="width: 40px;"/>
						                  </td>
						                  <td width="15%" align="center" class="f12_1">
						                  	<input type="button" value="编辑" onclick="editAlgorithm('${item.interfaceId }','${item.name }','${item.algorithm }')" class="btn_bg" style="width: 40px;"/>
						                  	<input type="button" value="删除" onclick="delRule('${item.interfaceId }')" class="btn_bg" style="width: 40px;"/>
						                  </td>					                  
						                </tr>
						                
						                <tr id="vmtrid<%=j %>" style="display: none;">
						                    <td width="5%" align="center" class="f12_1" bgcolor="#ffffff"></td>
						                	<td colspan="7">
						                		<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
						                		<%int i=0; %>
						                		  <c:forEach var="sublist" items="${item.list}" >
											        <%
											        String bgcor="#deecef";
											        if(i++ % 2 == 0){bgcor="#eef6f7"; }
											        %>
						                			<tr bgcolor="<%=bgcor %>" height="25">
						                				<td width="3%" class="f12_1"></td>
						                				<td width="80%" class="f12_1">${sublist.vmname }</td>
						                				<td width="17%" class="f12_1">
						                					<img title="删除" onclick="delVm('${item.interfaceId }','${sublist.virtualmachineid }')" src="${ctx}/images/delete.gif" style="cursor: pointer; vertical-align:top;"/>
						                				</td>
						                			</tr>
						                		  </c:forEach>
						                		</table>
						                	</td>
						                </tr>
						                
						                <tr bgcolor="ffffff" height="10">
						                  <td colspan="8" ></td>
						                </tr>
					              	  </table>
									</c:forEach>
						            										                				                
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