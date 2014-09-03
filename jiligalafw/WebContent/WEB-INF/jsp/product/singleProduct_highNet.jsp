<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品管理-单一产品列表-选择资源主页面-高级网络</title>
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

</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/singleProd/computResource.do" method="post" name="listForm">

       	<table width="806" border="0" cellpadding="0" cellspacing="0">
           <tr>
             <td align="left" valign="top" bgcolor="#FFFFFF" height="380">
     		<table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
              <tr bgcolor="#92b8c1" height="20">
                <td width="10%" align="center" class="f12">序号</td>
                <td width="30%" align="center" class="f12">高级网络名称</td>
                <td width="35%" align="center" class="f12">描述</td>
                <td width="25%" align="center" class="f12">选择</td>
              </tr>
            </table>
           <div id="order" style="height:360px; z-index:1; overflow-y: scroll;overflow-x:no;">   
             <table width="98%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
               <tr bgcolor="#deecef" height="20">
                  <td width="10%" align="center" class="f12_1">1</td>
                  <td width="30%" align="left" class="f12_1">高级网络一</td>
                  <td width="35%" align="left" class="f12_1">1CPU + 2Memory</td>
                  <td width="25%" align="center" class="f12_1"><input type="radio" ></td>
                </tr>
                <tr bgcolor="#eef6f7" height="20">
                  <td align="center" class="f12_1">2</td>
                  <td align="left" class="f12_1">高级网络二</td>
                  <td align="left" class="f12_1">1CPU + 4Memory</td>
                  <td align="center" class="f12_1"><input type="radio" ></td>
                </tr>  
              </table>
            </div>
             </td>
           </tr>
         </table>
         
	</form:form>
  </body>
</html>