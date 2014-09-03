<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品管理-组合产品定制-网络</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	margin:0px auto;
	background-color:#F2F2F2;
	background-repeat:repeat;
	background-position:left;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function next(){
	var form = document.forms.listForm;
	form.action="${ctx}/combinProd/selectTemplate.do";
	form.submit();
}
function previous(){
	var form = document.forms.listForm;
	form.action="${ctx}/combinProd/selectDc.do";
	form.submit();
}
function displayGeneralNet(tableId1,tableId2){
	document.getElementById(tableId1).style.display="block";
	document.getElementById(tableId2).style.display="none";
	window.parent.setNoNavIframeHeight();
}
</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/combinProd/selectNet.do" method="post" name="listForm">
    

          <table width="962" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td align="center"  valign="top" bgcolor="#F2F2F2">
                <table border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="43" align="left" valign="middle"><span class="f18b2">定制流程</span></td>
                    <td align="left" valign="middle">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="5" colspan="2" ></td>
                  </tr>
                  <tr>
                    <td height="2" colspan="2" align="center" valign="middle"><img src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" /></td>
                  </tr>
                  <tr>
                    <td height="10" colspan="2" ></td>
                  </tr>
                  <tr>
                    <td colspan="2" >
                      <div id="middle_sheet_pm_s_name">
                        <img src="${ctx}/images/menu_s_11.jpg" border="0" align="absmiddle" id="" />
                        <img src="${ctx}/images/menu_s_5_s.png" border="0" align="absmiddle" id="" />
                        <img src="${ctx}/images/menu_s_6.jpg" border="0" align="absmiddle" id="" />
                        <img src="${ctx}/images/menu_s_21.png" border="0" align="absmiddle" id="" />
                        <img src="${ctx}/images/menu_s_22.png" border="0" align="absmiddle" id="" />
                        <img src="${ctx}/images/menu_s_14.png" border="0" align="absmiddle" id="" />
                        <img src="${ctx}/images/menu_s_24.png" border="0" align="absmiddle" id="" />
                      </div>
    
                      <div id="middle_sheet_pm_s">

                      	<table width="855" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_1.jpg" width="14" height="14" /></td>
                            <td  height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_2.jpg"></td>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_3.jpg" width="14" height="14" /></td>
                          </tr>
                          <tr>
                            <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_4.jpg"></td>
                            <td align="left" valign="top" bgcolor="#FFFFFF" height="380">
                    		
                    		<!-- 定制流程页面 -->
			                <table width="336" border="0" cellspacing="0" cellpadding="0">
			                  <tr>
			                    <td width="35" align="left" valign="middle"><img src="${ctx}/images/buy_ico_04.gif" width="25" height="26" /></td>
			                    <td width="301" align="left" valign="middle" class="f18b2">请选择您需要的网络</td>
			                  </tr>
			                  <tr>
			                    <td height="5" colspan="2" align="left" valign="middle"><img src="${ctx}/images/buy_blue_line.jpg" width="280" height="1" /></td>
			                  </tr>
			                </table>
			                
							<table width="100%"  border="0" cellpadding="0" cellspacing="0">
			                  <tr height="50">
			                	<td width="6%"></td>
			                    <td align="left" class="f15_1"></td>
			                  </tr>
			                  <tr height="30">
			                	<td width="6%"></td>
			                    <td>
			                    	<table width="200" border="0" cellpadding="0" cellspacing="0">
									  <tr>
									    <td valign="top">
											<table width="250" border="0">
											  <tr>
												<td class="f13_1" height="30" valign="bottom"><input type="radio" value="1" name="radio" checked="checked" onclick="displayGeneralNet('general','high')" />&nbsp;&nbsp;普通网络</td>
											  </tr>
											  <tr><td height="2"><hr style="border: 1px solid #ccc; width: 60%; height:1px;" /></td></tr>
											  <tr>
												<td class="f13_1" height="30" valign="bottom"><input type="radio" value="2" name="radio" onclick="displayGeneralNet('high','general')" />&nbsp;&nbsp;高级网络</td>
											  </tr>
											  <tr><td height="2"><hr style="border: 1px solid #ccc; width: 60%; height:1px;" /></td></tr>
											</table>
										</td>
									    <td>
									    	<!-- 普通网络 -->
										    <table width="350" border="0" style="display: block;" id="general">
											  <tr>
											    <td width="30%" height="20" class="f13_1"></td>
											    <td width="70%" class="f13_1"></td>
											  </tr>								    
											  <tr>
											    <td class="f13_1" width="80%" height="50" valign="top">
											    	<input type="text" name="" size="20" />&nbsp;&nbsp;&nbsp;&nbsp;
											    	<input type="button" class="buttonBg_2" value="添加到安全组" width="101" height="30" onclick=""/>
											    </td>
											    <td >&nbsp;</td>
											  </tr>
											  <tr>
											    <td class="f13_1" height="35" ><input type="radio" value="2" name="radio1" />&nbsp;&nbsp;不加入安全组</td>
											    <td>&nbsp;</td>
											  </tr>
											  <tr>
											    <td class="f13_1" height="35" ><input type="radio" value="2" name="radio1" />&nbsp;&nbsp;WEB完全组</td>
											    <td>&nbsp;</td>
											  </tr>
											  <tr>
											    <td class="f13_1" height="35" ><input type="radio" value="2" name="radio1" />&nbsp;&nbsp;Mail安全组</td>
											    <td>&nbsp;</td>
											  </tr>
											  <tr>
											    <td class="f13_1" height="35" ><input type="radio" value="2" name="radio1" />&nbsp;&nbsp;SSH安全组</td>
											    <td>&nbsp;</td>
											  </tr>
											</table>
											
											<!-- 高级网络-->
										    <table width="400" border="0" style="display: none;" id="high">
											  <tr>
											    <td width="30%" height="20" class="f13_1"></td>
											    <td width="70%" class="f13_1"></td>
											  </tr>							    
											  <tr>
											    <td width="30%" height="35" class="f13_1">
											    	<input type="radio" value="2" name="radio1" />&nbsp;&nbsp;网络1
												</td>
											    <td width="70%" class="f13_1">包含NAT，FW，LB等特性</td>
											  </tr>
											  <tr>
											    <td width="30%" height="35" class="f13_1">
											    	<input type="radio" value="2" name="radio1" />&nbsp;&nbsp;网络2
												</td>
											    <td width="70%" class="f13_1">包含NAT，FW，LB等特性</td>
											  </tr>
											  <tr>
											    <td width="30%" height="35" class="f13_1">
											    	<input type="radio" value="2" name="radio1" />&nbsp;&nbsp;网络3
												</td>
											    <td width="70%" class="f13_1">包含NAT，FW，LB等特性</td>
											  </tr>
											  <tr>
											    <td width="30%" height="35" class="f13_1">
											    	<input type="radio" value="2" name="radio1" />&nbsp;&nbsp;网络4
												</td>
											    <td width="70%" class="f13_1">包含NAT，FW，LB等特性</td>
											  </tr>
											</table>								
										</td>
									  </tr>
									</table>
			                    </td>
			                  </tr>                       
			                </table>
			                <table align="right" width="352" height="33" border="0" cellpadding="0" cellspacing="0">
			                  <tr><td colspan="3" height="25">&nbsp;</td></tr>
			                  <tr>
			                    <td width="117" align="right" valign="middle">
			                    	<img src="${ctx}/images/btn2.png" width="117" height="32" style="cursor:pointer;" onclick="previous()"/>
			                    </td>                  
			                    <td width="185" align="right" valign="middle">
			                    	<img src="${ctx}/images/btn3.png" width="117" height="32" style="cursor:pointer;" onclick="next()"/>
			                    </td>
			                    <td width="15" align="right" valign="middle">&nbsp;</td>
			                  </tr>
			                  <tr><td colspan="3" height="100">&nbsp;</td></tr>
			                </table>			                


                            </td>
                            <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_5.jpg"></td>
                          </tr>
                          <tr>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_6.jpg" width="14" height="14" /></td>
                            <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_7.jpg"></td>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_8.jpg" width="14" height="14" /></td>
                          </tr>
                          <tr><td colspan=3 height="10"></td></tr>
                        </table>
                      </div>
                                          	
                    </td>
                  </tr>
                  <tr>
                    <td height="2" colspan="2" align="center" valign="middle"><img src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" /></td>
                  </tr>
                  <tr>
                    <td height="10" colspan="2" ></td>
                  </tr>                  
                </table>
              </td>
            </tr>
       
          </table>
       
        
	</form:form>
  </body>
</html>