<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品购买-自定义购买-选择模板</title>
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
	background-image:url(../images/middle_bg.jpg);
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

	var TemplateId=$('input:radio[name="prodTemplateId"]:checked').val();
	if (TemplateId != null){
		var form = document.forms.listForm;
		form.action="${ctx}/customBuy/computResource.do";
		form.submit();
	} else {
		alert ('请选择模板');
		return;
	}
	
}
function previous(){
	var form = document.forms.listForm;
	form.action="${ctx}/customBuy/selectNet.do";
	form.submit();
}
function quickBuy(){
	var form = document.forms.listForm;
	form.action="${ctx}/quickBuy/selectVm.do";
	form.submit();		
}
</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="cloudProductCustomBuyVo" action="${ctx}/customBuy/selectTemplate.do" method="post" name="listForm">
		
        <div id="middle_sheet_buy_01">
          <table width="210" border="0" cellpadding="0" cellspacing="0">
            <tr>
              	<td colspan="4" align="left" valign="top">
              		<img src="${ctx}/images/customBuy.png" width="210" height="29" border="0" usemap="#Map"/>
              		<map name="Map" id="Map">
				    	<area shape="rect" coords="8,10,93,27" />
				    	<area shape="rect" coords="113,5,195,26" href="javascript:quickBuy();" />
			    	</map>
              	</td>
            </tr>
            <tr>
              <td colspan="4" height="20"></td>
            </tr>
            <tr>
              <td width="10" height="20"></td>
              <td colspan="2" height="25" align="left" class="f15_1"><img src="${ctx}/images/buy_ico_01.png" width="18" height="18" align="absmiddle"/>&nbsp;购买流程</td>
              <td width="10" height="20"></td>
            </tr>
            <tr>
              <td width="10" height="20"></td>
              <td width="40" align="right" valign="bottom"><img src="${ctx}/images/buy_ico_02.png" width="18" height="17"/></td>
              <td width="150" align="left" height="25" valign="bottom" class="f13_5">&nbsp;1.数据中心</td>
              <td width="10" height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>
            <tr>
              <td height="20"></td>
              <td align="right" valign="bottom"><img src="${ctx}/images/buy_ico_02.png" width="18" height="17"/></td>
              <td align="left" height="25" valign="bottom" class="f13_5">&nbsp;2.网络</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>      
            <tr>
              <td height="20"></td>
              <td align="right" valign="bottom"><img src="${ctx}/images/buy_ico_03.png" width="18" height="17"/></td>
              <td align="left" height="25" valign="bottom" class="f13_5">&nbsp;3.模板</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>      
            <tr>
              <td height="20"></td>
              <td align="center" valign="bottom"></td>
              <td align="left" height="25" valign="bottom" class="f13_1">&nbsp;4.计算资源</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>      
            <tr>
              <td height="20"></td>
              <td align="center" valign="bottom"></td>
              <td align="left" height="25" valign="bottom" class="f13_1">&nbsp;5.磁盘资源</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>         
            <tr>
              <td height="20"></td>
              <td align="center" valign="bottom"></td>
              <td align="left" height="25" valign="bottom" class="f13_1">&nbsp;6.主机配置</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>      
            <tr>
              <td height="20"></td>
              <td align="center" valign="bottom"></td>
              <td align="left" height="25" valign="bottom" class="f13_1">&nbsp;7.信息确认</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>      
            <tr>
              <td height="20"></td>
              <td align="center" valign="bottom"></td>
              <td align="left" height="25" valign="bottom" class="f13_1">&nbsp;8.选择计费</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>         
            <tr>
              <td height="20"></td>
              <td align="center" valign="bottom"></td>
              <td align="left" height="25" valign="bottom" class="f13_1">&nbsp;9.购买完毕</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>                        
          </table>
        </div>
        
        <div id="middle_sheet_buy_02">
          <table width="751" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="12"><img src="${ctx}/images/buy_sheet_border_01.png" width="12" height="35" /></td>
              <td width="729" background="${ctx}/images/buy_sheet_border_02.png" align="left" class="f18_1">产品购买（定制）</td>
              <td width="10"><img src="${ctx}/images/buy_sheet_border_03.png" width="10" height="35" /></td>
            </tr>
            <tr>
              <td background="${ctx}/images/buy_sheet_border_04.png" ></td>
              <td align="left" valign="top" bgcolor="#F0F1F2">
                <table width="336" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="35" align="left" valign="middle"><img src="${ctx}/images/buy_ico_04.gif" width="25" height="26" /></td>
                    <td width="301" align="left" valign="middle" class="f18b2">请选择您需要的模板</td>
                  </tr>
                  <tr>
                    <td height="5" colspan="2" align="left" valign="middle"><img src="${ctx}/images/buy_blue_line.jpg" width="280" height="1" /></td>
                  </tr>
                </table>
                
                <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                  <tr height="5">
                	<td width="6%"></td>
                    <td align="left" class="f15_1"></td>
                  </tr>
                  <tr height="30">
                	<td width="6%"></td>
                    <td>

					  <table width="670" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                       	<tr bgcolor="#92b8c1" height="20">
                         	<td width="5%" align="center" class="f12">序号</td>
                         	<td width="25%" align="center" class="f12">模板名称</td>
                         	<td width="30%" align="center" class="f12">描述</td>
                         	<td width="30%" align="center" class="f12">价格</td>
                         	<td width="10%" align="center" class="f12">选择</td>
                        </tr>
                      </table>
                      <div style="height:342px; z-index:1; overflow-y: scroll; overflow-x: hidden;">   
                          <table width="670" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                            <%int rowNumber=0; %>
                           	<c:forEach var="item" items="${templateList}" varStatus="status">
	                            <tr <% if (rowNumber%2 == 0) {%> bgcolor="#deecef" <% } else { %> bgcolor="#eef6f7" <% } %> height="20">
	                               <td width="5%" align="center" class="f12_1"><%= ++rowNumber %></td>
	                               <td width="25%" align="left" class="f12_1">${item[1]}</td>
	                               <td width="30%" align="left" class="f12_1">${item[4]}</td>
	                               <td width="30%" align="left" class="f12_1">${item[5]}</td>
	                               <td width="10%" align="center" class="f12_1">
	                               	<form:radiobutton path="prodTemplateId" value="${item[0]}" />
	                               </td>
	                            </tr>
	                         </c:forEach>
                            
                          </table>
					  </div>
                   	
                    </td>
                  </tr>                       
                </table>
                
                <table align="right" width="352" height="33" border="0" cellpadding="0" cellspacing="0">
                  <tr><td colspan="3" height="10">&nbsp;</td></tr>
                  <tr>
                    <td width="117" align="right" valign="middle">
                    	<img src="${ctx}/images/btn2.png" width="117" height="32" style="cursor:pointer;" onclick="previous()"/>
                    </td>                  
                    <td width="185" align="right" valign="middle">
                    	<img src="${ctx}/images/btn3.png" width="117" height="32" style="cursor:pointer;" onclick="next()"/>
                    </td>
                    <td width="15" align="right" valign="middle">&nbsp;</td>
                  </tr>
                  <tr><td colspan="3" height="10">&nbsp;</td></tr>
                </table>
              </td>     
              <td background="${ctx}/images/buy_sheet_border_05.png">&nbsp;</td>
            </tr>
            <tr>
              <td><img src="${ctx}/images/buy_sheet_border_06.png" width="12" height="13" /></td>
              <td height="13" background="${ctx}/images/buy_sheet_border_07.png"></td>
              <td><img src="${ctx}/images/buy_sheet_border_08.png" width="10" height="13" /></td>
            </tr>
          </table>
        </div>
        
	</form:form>
  </body>
</html>