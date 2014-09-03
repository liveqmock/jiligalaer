<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品购买-快速购买-购买完成</title>
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
	background-image:url(../images/middle_bg.jpg););
	background-repeat:repeat;
	background-position:left;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function againBuy(){
	var form = document.forms.listForm;
	form.action="${ctx}/quickBuy/selectVm.do";
	form.submit();	
}
function customBuy(){
	var form = document.forms.listForm;
	form.action="${ctx}/quickBuy/selectVm.do";
	form.submit();		
}
</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/quickBuy/finishBuy.do" method="post" name="listForm">
		
        <div id="middle_sheet_buy_01">
          <table width="210" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td colspan="4" align="left" valign="top">
              	<img src="${ctx}/images/buy_title_01.png" width="210" height="29" border="0" usemap="#Map"/>
              	<map name="Map" id="Map">
			    	<area shape="rect" coords="8,10,93,27" href="javascript:customBuy();" />
			    	<area shape="rect" coords="113,5,195,26"/>
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
              <td width="150" align="left" height="25" valign="bottom" class="f13_5">&nbsp;1.虚拟机</td>
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
              <td align="right" valign="bottom"><img src="${ctx}/images/buy_ico_02.png" width="18" height="17"/></td>
              <td align="left" height="25" valign="bottom" class="f13_5">&nbsp;3.主机配置</td>  
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>      
            <tr>
              <td height="20"></td>
              <td align="right" valign="bottom"><img src="${ctx}/images/buy_ico_02.png" width="18" height="17"/></td>
              <td align="left" height="25" valign="bottom" class="f13_5">&nbsp;4.选择计费</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>      
            <tr>
              <td height="20"></td>
              <td align="right" valign="bottom"><img src="${ctx}/images/buy_ico_03.png" width="18" height="17"/></td>
              <td align="left" height="25" valign="bottom" class="f13_5">&nbsp;5.购买完成</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>       
          </table>
        </div>
        
        <div id="middle_sheet_buy_02">
          <table width="751" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="12"><img src="${ctx}/images/buy_sheet_border_01.png" width="12" height="35" /></td>
              <td width="729" background="${ctx}/images/buy_sheet_border_02.png" align="left" class="f18_1">产品购买（快速）</td>
              <td width="10"><img src="${ctx}/images/buy_sheet_border_03.png" width="10" height="35" /></td>
            </tr>
            <tr>
              <td background="${ctx}/images/buy_sheet_border_04.png" ></td>
              <td align="left" valign="top" bgcolor="#F0F1F2">
                <table width="336" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="35" align="left" valign="middle"><img src="${ctx}/images/buy_ico_04.gif" width="25" height="26" /></td>
                    <td width="301" align="left" valign="middle" class="f18b2">购买完毕</td>
                  </tr>
                  <tr>
                    <td height="5" colspan="2" align="left" valign="middle"><img src="${ctx}/images/buy_blue_line.jpg" width="280" height="1" /></td>
                  </tr>
                </table>
                
                <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                  <tr height="10">
                	<td width="6%"></td>
                    <td align="left" class="f15_1"></td>
                  </tr>
                  <tr height="30">
                	<td width="6%"></td>
                    <td>
                    	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
                    	  <tr height="100">
                    	  <c:if test="${vmstate=='0'}">
                          	<td width="10%" align="left" class="f15_1_error">
                          	 ${message}
                          	</td>
                          </c:if>
                           <c:if test="${vmstate=='1'}">
                          	<td width="10%" align="left" class=f15_1>
                          	 ${success}
                          	</td>
                          </c:if>
                          </tr>
                      	</table>
                    </td>
                  </tr>                       
                </table>
                
                <table align="right" width="352" height="33" border="0" cellpadding="0" cellspacing="0">
                  <tr><td colspan="3" height="10"></td></tr>
                  <tr>
                    <td width="117" align="right" valign="middle">
                    	<img src="${ctx}/images/again.png" width="101" height="29" style="cursor:pointer;" onclick="againBuy()"/>
					</td>
                    <td width="15" align="right" valign="middle"></td>
                  </tr>
                  <tr><td colspan="3" height="290"></td></tr>
                </table>
              </td>     
              <td background="${ctx}/images/buy_sheet_border_05.png"></td>
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