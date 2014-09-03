<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>添加虚拟机</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	background-color:#F2F2F2;
	background-repeat:repeat;
	background-position:left;
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
function save(){
	var vmId = $("input[name='vmId']");
	var flag = true;
	for(var i=0; i<vmId.length; i++){
		if(vmId[i].checked == true){
			flag = false;
			break;
		}
	}
	if(flag){
		alert("请选择实例");
		return;
	}
	
	if(confirm("确定添加该实例吗？")){
		var form = document.forms.listForm;
		waitloading();
		form.submit();		
	}
}
</script>
<script type="text/javascript">
var msg = '${loadRuleMsg}';
if(msg!=''){
	alert(msg);
	window.opener.query();
	window.close();
}
</script>
</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/network/addLoadRuleVm.do" method="post" name="listForm">
		<input type="hidden" name="networkId" id="configId" value="${networkId }"/>
		<input type="hidden" name="ipAddrId" id="ipAddrId" value="${ipAddrId }"/>
		<input type="hidden" name="loadRuleId" id="loadRuleId" value="${loadRuleId }"/>
		
          <table width="450" border="0" cellpadding="0" cellspacing="0" align="center">
            <tr>
              <td align="center"  valign="top" bgcolor="#F2F2F2">
                <table border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="40" align="left" valign="bottom"><span class="f16_1">添加实例</span></td>
                    <td align="left" valign="middle">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="2" colspan="2" align="center" valign="middle"><hr /></td>
                  </tr>
                  
                  <tr>
                    <td colspan="2" >
                    
                      	<table width="426" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_1.jpg" width="14" height="14" /></td>
                            <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_2.jpg"></td>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_3.jpg" width="14" height="14" /></td>
                          </tr>
                          <tr>
                            <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_4.jpg"></td>
                            <td align="left" valign="top" bgcolor="#FFFFFF" height="400">
                            
					       	  <table width="410" border="0" cellspacing="1" cellpadding="1">
					       	  	<tr bgcolor="#92b8c1" height="25">
					                <td width="10%" align="center" class="f12">选择</td>
					                <td width="50%" align="center" class="f12">实例名称</td>
					                <td width="40%" align="center" class="f12">创建时间</td>
					              </tr>
					              <%int j=0; %>
                                  <c:forEach var="item" items="${vmlist}" varStatus="status">
                                 	<%
							        String bgcolor="#deecef";
							        if(j++ % 2 == 0){bgcolor="#eef6f7"; }
							        %>	
									<tr bgcolor="<%=bgcolor %>" height="25" valign="top">
										<td width="10%" align="center" height="25" class="f12_1">
											<input type="checkbox" name="vmId" id="vmId" value="${item.interfaceId}" 
											style="vertical-align: bottom; margin-top: 5px;" />
										</td>
										<td width="50%" align="left" height="25">
											&nbsp;${item.name}
										</td>
										<td width="40%" align="left" height="25">
											<fmt:formatDate value="${item.created}" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
									</tr>
								  </c:forEach>							
					          </table>
					          
		                      <table width="300" style="padding-top: 200px;" align="center" border="0" cellspacing="0" cellpadding="0" height="50">
		                        <tr>
		                          <td align="center" valign="top">
		                          	<input type="button" value="确定" onclick="save()" class="btn_bg" style="width: 40px;"/>
		                          	<input type="button" value="关闭" onclick="javascript:window.close()" class="btn_bg" style="width: 40px;"/>
		                          </td>
		                        </tr>
		                      </table>

                            </td>
                            <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_5.jpg"></td>
                          </tr>
                          <tr>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_6.jpg" width="14" height="14" /></td>
                            <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_7.jpg"></td>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_8.jpg" width="14" height="14" /></td>
                          </tr>
                        </table>

                    </td>
                  </tr>
                  
                </table>
              </td>
            </tr>
          </table>
                                         
	</form:form>
  </body>
</html>