<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源-申请IP地址</title>
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
function applyIp(){
	var form = document.forms.listForm;
	form.action="${ctx}/applyIp/save.do";
	form.submit();
}
</script>

</head>
<body onLoad="">
	<form:form modelAttribute="baseVoList" action="${ctx}/addNetwork/selectNetwork.do" method="post" name="listForm">

        <div id="middle_sheet_buy_02">
          <table width="920" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td align="left" valign="top" bgcolor="#F0F1F2">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="100%" align="left" valign="middle" class="f16b2">&nbsp;&nbsp;IP地址申请</td>
                  </tr>
                  <tr>
                    <td height="10" align="left" valign="middle"><img src="${ctx}/images/buy_blue_line.jpg" width="100%" height="1" /></td>
                  </tr>
                </table>
                
                <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                  <tr height="30">
                    <td colspan="2" align="left" class="f14b2" valign="bottom" style="padding-left: 46px;"></td>
                  </tr>
                  <tr height="30">
                	<td width="5%"></td>
                    <td align="left">
                    	
			     		<table width="98%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
			              <tr bgcolor="#92b8c1" height="20">
			                <td width="5%" align="center" class="f12">序号</td>
			                <td width="40%" align="center" class="f12">网络名称</td>
			                <td width="40%" align="center" class="f12">描述</td>
			                <td width="5%" align="center" class="f12">选择</td>
			              </tr>
			            </table>
			            
			            <%int i=0; %>
			            <div id="order" style="height:280px; z-index:1; overflow-y: scroll;overflow-x:hidden; width: 100%;">
			              <table width="98%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
							
							  <c:forEach var="item" items="${list}" >
						        <%
						        String bgcolor="#deecef";
						        if(i++ % 2 == 0){bgcolor="#eef6f7"; }
						        %>
								<tr bgcolor="<%=bgcolor %>" height="20">
				                  <td width="5%" align="center" class="f12_1"><%=i %></td>
				                  <td width="40%" align="left" class="f12_1">${item.name }</td>
				                  <td width="40%" align="left" class="f12_1">${item.displayText }</td>
				                  <td width="5%" align="center" class="f12_1">
				                  	<input type="radio" name="radio" id="radio1" value="${item.id }" onclick="selectVal('${item.id }','networkSoln')">
				                  </td>
				                </tr>
				              </c:forEach>
			                
			              </table>
			            </div>
                                                    
                    </td>
                  </tr>
                </table>
                
                <table align="center" width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr><td height="30" class="f15_1" style="color: red;"></td></tr>
                  <tr>               
                    <td align="center" valign="top">
                    	<input type="button" value="申    请" class="buttonBg_1" onclick="javascript:applyIp()" class="btn_bg" />
                    </td>
                  </tr>
                </table>
			                
              </td>     
            </tr>
          </table>
        </div>

	</form:form>
</body>
</html>