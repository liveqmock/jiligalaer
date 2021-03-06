<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品管理-单一产品列表-选择资源主页面-计算方案</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	margin-left: 10px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function selectVal(id,prodType,name){
	var winObj = window.parent.parent.parent;
	winObj.opener.selectedProduct(id,prodType,name);
	winObj.close();

}
</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/singleProd/computResource.do" method="post" name="listForm">

      <table width="805" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="left" valign="top" bgcolor="#FFFFFF" height="350">
          
     		<table width="790" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
              <tr bgcolor="#92b8c1" height="20">
                <td width="5%" align="center" class="f12">序号</td>
                <td width="30%" align="center" class="f12">计算方案名称</td>
                <td width="10%" align="center" class="f12">CPU数量(C)</td>
                <td width="10%" align="center" class="f12">CPU频率(HZ)</td>
                <td width="10%" align="center" class="f12">内存大小(M)</td>
                <td width="30%" align="center" class="f12">描述</td>
                <td width="5%" align="center" class="f12">选择</td>
              </tr>
            </table>
            
            <%int i=0; %>
            <div id="order" style="height:450px; z-index:1; overflow-y: scroll;overflow-x:hidden;">
              <table width="790" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
				
				  <c:forEach var="item" items="${list}" >
			        <%
			        String bgcolor="#deecef";
			        if(i++ % 2 == 0){bgcolor="#eef6f7"; }
			        %>
					<tr bgcolor="<%=bgcolor %>" height="20">
	                  <td width="5%" align="center" class="f12_1"><%=i %></td>
	                  <td width="30%" align="left" class="f12_1">${item.name }</td>
	                  <td width="10%" align="right" class="f12_1">${item.cpuNumber }</td>
	                  <td width="10%" align="right" class="f12_1">${item.cpuSpeed }</td>
	                  <td width="10%" align="right" class="f12_1">${item.memory }</td>
	                  <td width="30%" align="left" class="f12_1">${item.displayText }</td>
	                  <td width="5%" align="center" class="f12_1">
	                  	<input type="radio" name="radio" id="radio1" value="${item.id }" onclick="selectVal('${item.id }','cpuSoln','${item.name }')">
	                  </td>
	                </tr>
              </c:forEach>
                
              </table>
            </div>
            
          </td>
        </tr>
      </table>
         
	</form:form>
  </body>
</html>