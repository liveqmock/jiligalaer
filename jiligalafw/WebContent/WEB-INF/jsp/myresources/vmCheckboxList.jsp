<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源-高级网络-选择虚拟机共用页面</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	margin: 0px auto;
	background-color: #F2F2F2;
	background-repeat: repeat;
	background-position: left;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function ok(){
	var form = document.forms.listForm;
	//form.action="${ctx}/addNetwork/selectNetwork.do";
	//form.submit();
	window.close();
}
</script>

</head>
<body onLoad="">
	<form:form modelAttribute="baseVoList" action="${ctx}/addNetwork/selectDc.do" method="post" name="listForm">

          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td align="left" valign="top" bgcolor="#F0F1F2">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="100%" align="left" valign="bottom" class="f16b2" height="40">选择虚拟机</td>
                  </tr>
                  <tr>
                    <td height="10" align="left" valign="middle"><img src="${ctx}/images/buy_blue_line.jpg" width="100%" height="1" /></td>
                  </tr>
                </table>
                
                <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                  <tr height="10">
                	<td width="5%"></td>
                    <td align="left" class="f15_1"></td>
                  </tr>
                  <tr height="30">
                	<td width="5%"></td>
                    <td>
                    	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
                    	
                    	  <tr height="30">
                    	  	<td width="2%"></td>
                          	<td width="30%" height="30" align="left" class="f13_1"><input type="checkbox" name="checkbox" value=""/>北京数据中心</td>
                          	<td class="f13_1">
								北京数据中心位于xxxx，机房规模。
							</td>
                          </tr>
                          <tr height="30">
                    	  	<td width="2%"></td>
                          	<td width="20%" height="30" align="left" class="f13_1"><input type="checkbox" name="checkbox" value=""/>上海数据中心</td>
                          	<td class="f13_1">
								上海数据中心位于xxxx，机房规模。
							</td>
                          </tr>
                    	  <tr height="30">
                    	  	<td width="2%"></td>
                          	<td width="30%" height="30" align="left" class="f13_1"><input type="checkbox" name="checkbox" value=""/>北京数据中心</td>
                          	<td class="f13_1">
								北京数据中心位于xxxx，机房规模。
							</td>
                          </tr>
                          <tr height="30">
                    	  	<td width="2%"></td>
                          	<td width="20%" height="30" align="left" class="f13_1"><input type="checkbox" name="checkbox" value=""/>上海数据中心</td>
                          	<td class="f13_1">
								上海数据中心位于xxxx，机房规模。
							</td>
                          </tr>
                                                   
                      	</table>
                    </td>
                  </tr>                       
                </table>
                
                <table align="right" width="100%" height="100" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="100%" align="center" valign="middle">
                    	<img src="${ctx}/images/btn11.png" width="117" height="32" style="cursor:pointer;" onclick="ok()"/>
                    </td>
                  </tr>
                </table>
              </td>     
            </tr>
          </table>

	</form:form>
</body>
</html>