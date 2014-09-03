<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的虚拟机 - 统计数据</title>
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
	background-color:#ffffff;
	background-repeat:repeat;
	background-position:left;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">

</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/myVm/list.do" method="post" name="listForm">

        <table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
          <tr bgcolor="#deecef" height="20">
             <td width="30%" align="left" class="f12_1">&nbsp;&nbsp;CPU总量</td>
             <td width="70%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.cpuNumber } x ${vmVo.cpuSpeed }</td>
           </tr>   
           <tr bgcolor="#eef6f7" height="20">
             <td width="30%" align="left" class="f12_1">&nbsp;&nbsp;CPU利用率</td>
             <td width="70%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.cpuUsed }</td>
           </tr>  
           <tr bgcolor="#deecef" height="20">
             <td width="30%" align="left" class="f12_1">&nbsp;&nbsp;网络读取量</td>
             <td width="70%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.networkKbsRead }MB</td>
           </tr>   
           <tr bgcolor="#eef6f7" height="20">
             <td width="30%" align="left" class="f12_1">&nbsp;&nbsp;网络写入量</td>
             <td width="70%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.networkKbsWrite }MB</td>
           </tr>
         </table>
    
	</form:form>
  </body>
</html>