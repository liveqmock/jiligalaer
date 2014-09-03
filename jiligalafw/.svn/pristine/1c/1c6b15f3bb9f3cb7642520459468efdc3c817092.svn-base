<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>粘性配置</title>
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
	if(checkVal()){
		if(confirm("确定保存配置吗？")){
			var form = document.forms.listForm;
			form.action="${ctx}/network/saveConfig.do";
			waitloading();
			form.submit();
		}
	}
}
function checkVal(){
	var arithmetic = $("#arithmetic").val();
	if(arithmetic == 'SourceBased'){
		if($("#SourceBased_name").val() == ''){
			alert("请输入名称");
			return false;
		}

	}else if(arithmetic == 'AppCookie'){
		if($("#AppCookie_anme").val() == ''){
			alert("请输入名称");
			return false;			
		}

	}else if(arithmetic == 'LbCookie'){
		if($("#LbCookie_name").val() == ''){
			alert("请输入名称");
			return false;			
		}

	}
	
	return true;
}

function displayConfig(val){
	$("#SourceBased").hide();
	$("#AppCookie").hide();
	$("#LbCookie").hide();
	if(val == 'SourceBased'){
		$("#SourceBased").show();
	}else if(val == 'AppCookie'){
		$("#AppCookie").show();
	}else if(val == 'LbCookie'){
		$("#LbCookie").show();
	}
}
</script>
<script type="text/javascript">
var msg = '${loadRuleMsg}';
if(msg!=''){
	alert(msg);
	window.close();
}
</script>
</head>
  <body onload="displayConfig('${policyVo.methodname }')">
    <form:form modelAttribute="baseVoList" action="${ctx}/network/saveConfig" method="post" name="listForm">
		<input type="hidden" name="loadRuleId" id="loadRuleId" value="${loadRuleId }"/>
		<input type="hidden" name="configId" id="configId" value="${policyVo.id }"/>
		
          <table width="500" border="0" cellpadding="0" cellspacing="0" align="center">
            <tr>
              <td align="center"  valign="top" bgcolor="#F2F2F2">
                <table border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="40" align="left" valign="bottom"><span class="f16b2">配置</span></td>
                    <td align="left" valign="middle">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="2" colspan="2" align="center" valign="middle"><hr /></td>
                  </tr>
                  <tr>
                    <td height="10" colspan="2" ></td>
                  </tr>
                  
                  <tr>
                    <td colspan="2" >
                    
                      	<table width="476" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_1.jpg" width="14" height="14" /></td>
                            <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_2.jpg"></td>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_3.jpg" width="14" height="14" /></td>
                          </tr>
                          <tr>
                            <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_4.jpg"></td>
                            <td align="left" valign="top" bgcolor="#FFFFFF" height="480">
                            
					       	  <table width="460" border="0" cellpadding="0" cellspacing="0">
								<tr height="40">
									<td width="40.5%" align="right" height="30" class="f12_1">类型：</td>
									<td width="60%" align="left" height="30">
                                  	  <select name="arithmetic" id="arithmetic" style="width: 155px; height: 24px;" onchange="displayConfig(this.value)">
                                  	  	<option value="None" >None</option>
                                  	  	<option value="SourceBased" <c:if test="${policyVo.methodname == 'SourceBased'}">selected</c:if> >SourceBased</option>
                                  	  	<option value="AppCookie" <c:if test="${policyVo.methodname == 'AppCookie'}">selected</c:if> >AppCookie</option>
                                  	  	<option value="LbCookie" <c:if test="${policyVo.methodname == 'LbCookie'}">selected</c:if> >LbCookie</option>
                                  	  </select>
									</td>
								</tr>
																		
								<tr id="SourceBased" style="display: ;" valign="top">
								  <td valign="top" colspan="2">
									<table width="460" border="0" cellpadding="0" cellspacing="0" >
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">名称：</td>
											<td width="60%" align="left" height="30">
												<input type="text" name="SourceBased_name" id="SourceBased_name" value="${SourceBased_name }" maxlength="25"/>
											</td>
										</tr>									
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">表大小：</td>
											<td align="left" height="30">
												<input type="text" name="tableSize" id="tableSize" value="${tablesize }" maxlength="5"/>
											</td>
										</tr>
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">过期时间：</td>
											<td align="left" height="30">
												<input type="text" name="expireTime" id="expireTime" value="${expireTime }" maxlength="5"/>
											</td>
										</tr>										
									</table>
								  </td>
								</tr>

								<tr id="AppCookie" style="display: none;">
								  <td valign="top" colspan="2">
									<table width="460" border="0" cellpadding="0" cellspacing="0" style="line-height: 30px;">
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">名称：</td>
											<td width="60%" align="left" height="30">
												<input type="text" name="AppCookie_name" id="AppCookie_name" value="${AppCookie_name }" maxlength="25"/>
											</td>
										</tr>									
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">Cookie名称：</td>
											<td align="left" height="30">
												<input type="text" name="AppCookie_cookieName" id="AppCookie_cookieName" value="${AppCookie_cookieName }" maxlength="25"/>
											</td>
										</tr>
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">模式：</td>
											<td align="left" height="30">
												<input type="text" name="AppCookie_modeName" id="AppCookie_modeName" value="${AppCookie_modeName }" maxlength="25"/>
											</td>
										</tr>
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">长度：</td>
											<td align="left" height="30">
												<input type="text" name="length" id="length" value="${length }" maxlength="5"/>
											</td>
										</tr>
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">持续时间：</td>
											<td align="left" height="30">
												<input type="text" name="holdtime" id="holdtime" value="${holdtime }" maxlength="5" />
											</td>
										</tr>
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">request-learn：</td>
											<td align="left" height="30">
												<input type="checkbox" name="requestLearn" id="requestLearn" value="true" <c:if test="${requestLearn == 'true' }">checked</c:if> />
											</td>
										</tr>
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">prefix：</td>
											<td align="left" height="30">
												<input type="checkbox" name="prefix" id="prefix" value="true" <c:if test="${prefix == 'true' }">checked</c:if> />
											</td>
										</tr>									
									</table>
								  </td>									
								</tr>
								
								<tr id="LbCookie" style="display: none;">
								  <td valign="top" colspan="2">
									<table width="460" border="0" cellpadding="0" cellspacing="0" style="line-height: 30px;">
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">名称：</td>
											<td width="60%" align="left" height="30">
												<input type="text" name="LbCookie_name" id="LbCookie_name" value="${LbCookie_name }" maxlength="25"/>
											</td>
										</tr>									
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">Cookie名称：</td>
											<td align="left" height="30">
												<input type="text" name="LbCookie_cookieName" id="LbCookie_cookieName" value="${LbCookie_cookieName }" maxlength="25"/>
											</td>
										</tr>
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">模式：</td>
											<td align="left" height="30">
												<input type="text" name="LbCookie_modeName" id="LbCookie_modeName" value="${LbCookie_modeName }" maxlength="25"/>
											</td>
										</tr>								
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">nocache：</td>
											<td align="left" height="30">
												<input type="checkbox" name="nocache" id="nocache" value="true" <c:if test="${nocache == 'true' }">checked</c:if> />
											</td>
										</tr>
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">indirect：</td>
											<td align="left" height="30">
												<input type="checkbox" name="indirect" id="indirect" value="true" <c:if test="${indirect == 'true' }">checked</c:if> />
											</td>
										</tr>
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">postonly：</td>
											<td align="left" height="30">
												<input type="checkbox" name="postonly" id="postonly" value="true" <c:if test="${postonly == 'true' }">checked</c:if> />
											</td>
										</tr>
										<tr height="30" valign="top">
											<td width="40%" align="right" height="30" class="f12_1">域：</td>
											<td align="left" height="30">
												<input type="text" name="domain" id="domain" value="${domain }" maxlength="25"/>
											</td>
										</tr>									
									</table>
								  </td>									
								</tr>															  						  							  

								<tr height="50">
				                    <td colspan="2" align="center" valign="middle">
				                      <table width="294" border="0" cellspacing="0" cellpadding="0">
				                        <tr>
				                          <td align="center" valign="top">
				                          	<a href="javascript:save()"><img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" align="absmiddle"/></a>
				                          </td>
				                          <td align="center" valign="top">
				                          	<a href="javascript:window.close()"><img src="${ctx}/images/btn8.png" alt="关闭" width="101" height="30" border="0" align="absmiddle"/></a>
				                          </td>
				                        </tr>
				                      </table>
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