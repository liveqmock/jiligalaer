<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源 - 我的网络 - 基础网络</title>
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
	form.action="${ctx}/network/basicNet.do";
	loading();
	form.submit();
}
//添加安全组
function add(){
	var txt = '添加安全组<br/><hr></hr><center><br/>安全组名：<input type="text" name="securityGroup" value=""/><br/><br/></center>';
	$.prompt(txt,{
		buttons: {'确定':1, '取消':3},
		callback: function mycallbackform(v,m,f){
			if(v == 3){
				return ;
			}
			if(f.securityGroup=="" || f.securityGroup==null){
				alert("请输安全组名！");
				return ;
			}else{
				$("#securityGroup").val(f.securityGroup);
				var form = document.forms.listForm;
				waitloading();
				form.action='${ctx}/network/saveSecurityGroup.do';
				form.submit();
			}	
		}
	});		
}
function delGroup(groupId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/delSecurityGroup.do?groupId="+groupId;
	waitloading();
	form.submit();
}
function outEdit(groupId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/outEdit.do?groupId="+groupId;
	form.submit();
}

function inEdit(groupId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/inEdit.do?groupId="+groupId;
	form.submit();
}
</script>
<script type="text/javascript">
$(document).ready(function(){
	var msg = '${groupMsg}';
	if(msg!=''){
		alert(msg);
		window.location.href="${ctx}/network/basicNet.do";
	}
});
</script>
</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/network/basicNet.do" method="post" name="listForm">
		<input type="hidden" name="securityGroup" id="securityGroup" value="" />
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
                                      <td width="80" class="f13_1" align="left">安全组名：</td>
                                      <td width="200" class="f13_1">
                                      	<input type="text" name="securityGroupName" id="securityGroupName" value="${securityGroupName }"/>
                                      </td>
                                      <td align="right">
                                      	<img src="${ctx}/images/btn15.png" alt="查找" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:query();"/>
										<img src="${ctx}/images/btn26.png" alt="添加安全组" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:add();"/>
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
                      
		              <tr><td height="20" colspan="3" ></td></tr>
		              
                      <tr>
                        <td width="10"></td>
						<td align="right" valign="top">
					      <table width="100%" border="0" cellpadding="0" cellspacing="0">
					        <tr>
					          <td align="left" valign="top" bgcolor="#FFFFFF" height="250">
					     		<table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              <tr bgcolor="#92b8c1" height="20">
					                <td width="5%" align="center" class="f12">序号</td>
					                <td width="27%" align="center" class="f12">名称</td>
					                <td width="44%" align="center" class="f12">描述</td>
					                <td width="8%" align="center" class="f12">出口规则</td>
					                <td width="8%" align="center" class="f12">入口规则 </td>
					                <td width="8%" align="center" class="f12">删除 </td>
					              </tr>
					            </table>
					            
					            <div id="order" style="height:530px; z-index:1; overflow-y: scroll;overflow-x:hidden;">   
					              <table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
					              	<%int i=0; %>
									<c:forEach var="item" items="${securityList}" >
								        <%
								        String bgcolor="#deecef";
								        if(i++ % 2 == 0){bgcolor="#eef6f7"; }
								        %>
										<tr bgcolor="<%=bgcolor %>" height="20">
						                  <td width="5%" align="center" class="f12_1"><%=i %></td>
						                  <td width="27%" align="left" class="f12_1">${item.name }</td>
						                  <td width="44%" align="left" class="f12_1">${item.description }</td>
						                  <td width="8%" align="center" class="f12_1">
						                   <input type="button" value="编辑" onclick="javascript:outEdit('${item.interfaceId }');" class="btn_bg" style="width: 45px;"/>
						                  </td>
						                  <td width="8%" align="center" class="f12_1">
						                    <input type="button" value="编辑" onclick="javascript:inEdit('${item.interfaceId }');" class="btn_bg" style="width: 45px;"/>
						                  </td>
						                  <td width="8%" align="center" class="f12_1">
						                    <input type="button" value="删除" onclick="javascript:delGroup('${item.interfaceId }');" class="btn_bg" style="width: 45px;"/>
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