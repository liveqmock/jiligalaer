<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品购买-快速购买-主机配置</title>
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
function next(){
	var count = $("#count").val().replace(/\s/g, "");
	var vmName = $("#vmName").val().replace(/\s/g, "");
	var stopTime =$("#stopTime").val();
	var ipAllocatType = $("#ipAllocatType").val().replace(/\s/g, "");
	if(count=="" || !isDigit(count) || count>10){
		alert("数量不能为空和0，数量必须为数字，且不能大于10台！");
		return false;
	}
	if(count=="0"){
		alert("数量不能为0!");
		return false;
	}
	if(vmName==""){
		alert("主机名不能为空!");
		return false;
	}
	//表达式含义：字母开头，字母和数字加”-“组成，长度5-30位。
	var reg =/^[A-Za-z][A-Za-z0-9-]{4,29}$/;
	if(!reg.test(vmName)){
		alert("主机名必须为字母、数字、”-“组成，由字母开头，长度在5-30位字符");
		return false;
	}	
	if(stopTime ==""){
		//alert("停机时间不能为空!");
		//return false;
	}
	if(stopTime !=""){
		var dt = new Date(stopTime.replace(/-/,"/"));
		var nowDate = new Date();
       	if(dt.getTime()<nowDate.getTime()){
       		alert("结束日期必须大于今天！");
       		return false;
       	}
	}

	if(ipAllocatType == 'assign'){
		if($("#ipAddress").val() == ''){
       		alert("请选择IP地址");
       		return false;
		}
	}
	
  	var form = document.forms.listForm;
	form.submit();		
}
function previous(){
	var form = document.forms.listForm;
	form.action="${ctx}/quickBuy/selectNet.do";
	form.submit();
}
function customBuy(){
	var form = document.forms.listForm;
	form.action="${ctx}/customBuy/selectDc.do";
	form.submit();		
}
function isDigit(s) 
{ 
var patrn=/^[0-9]{1,20}$/; 
if (!patrn.exec(s)) return false;
return true;
}
 
</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="cloudVmBuyDetailVo" action="${ctx}/quickBuy/selectBilling.do" method="post" name="listForm">
		
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
              <td align="right" valign="bottom"><img src="${ctx}/images/buy_ico_03.png" width="18" height="17"/></td>
              <td align="left" height="25" valign="bottom" class="f13_5">&nbsp;3.主机配置</td>  
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>      
            <tr>
              <td height="20"></td>
              <td align="center" valign="bottom"></td>
              <td align="left" height="25" valign="bottom" class="f13_1">&nbsp;4.选择计费</td>
              <td height="20"></td>
            </tr>
            <tr><td colspan="4"><hr style="border: 1px dashed #ccc; width: 84%; height:1px;" /></td></tr>      
            <tr>
              <td height="20"></td>
              <td align="center" valign="bottom"></td>
              <td align="left" height="25" valign="bottom" class="f13_1">&nbsp;5.购买完成</td>
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
              <td align="left" valign="top" bgcolor="#F0F1F2" height="475">
                <table width="336" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="35" align="left" valign="middle"><img src="${ctx}/images/buy_ico_04.gif" width="25" height="26" /></td>
                    <td width="301" align="left" valign="middle" class="f18b2">请配置您的虚拟机</td>
                  </tr>
                  <tr>
                    <td height="5" colspan="2" align="left" valign="middle"><img src="${ctx}/images/buy_blue_line.jpg" width="280" height="1" /></td>
                  </tr>
                </table>
                
                <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                  <tr height="5">
                	<td width="6%" class="f15_1"></td>
                    <td align="left" class="f15_1">${message}</td>
                  </tr>
                  <tr height="35">
                	<td width="6%"></td>
                    <td>
                    	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
                    	  <tr height="35">
                          	<td width="10%" align="left" class="f13_1">数量：</td>
                          	<td class="f13_1"><form:input path="count" type="text" class="text13" id="count" size="5" maxlength="2"/>&nbsp;台&nbsp;(最多10台)</td>
                          </tr>
                          <tr height="35">
                          	<td width="10%" align="left" class="f13_1">主机名：</td>
                          	<td><form:input path="vmName" type="text" class="text13" id="vmName" size="30" maxlength="35"/></td>
                          </tr>
                          <tr height="35">
                          	<td width="10%" align="left" class="f13_1">停机时间：</td>
                          	<td class="f13_1">
                          		<form:input path="stopTime" id="stopTime" type="text" onfocus="WdatePicker({startDate: '%y-%M-%d 00:00:00', dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate: true })"  readonly="readonly" class="date_but" style="width: 150px;"/>
                          	</td>
                          </tr>
                          <tr height="35">
                          	<td width="10%" align="left" class="f13_1">IP地址：</td>
                          	<td id="showIp">
                          		<form:select path="ipAllocatType" id="ipAllocatType" cssStyle="width:150px;" onchange="openIpList(this.value)">
								     <form:option value="auto" label="随机分配"/>
								     <form:option value="assign" label="指定IP"/>
								</form:select>
								<span id="ipText" style="display: none;" class="f13_1">
									IP选择：
									<input type="text" name="ipAddress" id="ipAddress" value="" size="15" onclick="selectIP()" readonly class="select_but"/>
									<input type="hidden" name="ipAddressId" id="ipAddressId" value="" size="15"/>
								</span>                          		
                          	</td>
                          </tr>
                      	</table>
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
	<script type="text/javascript">
	function openIpList(val){
		if(val == 'auto'){
			$("#ipText").hide();
			$("input[name='ipAddress']").val("");
			$("input[name='ipAddressId']").val("");
		}else{
			$("#ipText").show();
		}
	}
	
	function selectIP(){
		var zoneid = '${product_mdmZoneId }';
		var callback = function(result){
			if(result){
				$("input[name='ipAddress']").val(result.name);
				$("input[name='ipAddressId']").val(result.id);
			}
		};
		openIpTree("${ctx}","ip",0,"r",$("input[name='ipAddressId']").val(),null,callback,zoneid);		
	}
	
	</script>	
  </body>
</html>