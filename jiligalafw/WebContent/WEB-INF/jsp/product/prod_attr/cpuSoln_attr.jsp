<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品管理-单一产品-计算方案产品属性</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	margin-left: 5px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">

</script>

</head>
  <body>
    
    <!-- 产品属性：计算方案 -->
    <table height="100%" width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
      <tr bgcolor="#deecef" height="25" >
        <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;产品类型：</td>
        <td width="80%" height="25" align="left" class="f12_1">计算资源</td>
      </tr>   
      <tr bgcolor="#eef6f7" height="25" >
        <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;名称：</td>
        <td width="80%" height="25" align="left" class="f12_1">${mdmVo.name }</td>
      </tr>  
      <tr bgcolor="#deecef" height="25" >
        <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;ID：</td>
        <td width="80%" height="25" align="left" class="f12_1">${mdmVo.interfaceId }</td>
      </tr>
      <tr bgcolor="#eef6f7" height="25" >
        <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;CPU核数：</td>
        <td width="80%" height="25" align="left" class="f12_1">${mdmVo.cpuNumber }</td>
      </tr>
      <tr bgcolor="#deecef" height="25" >
        <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;CPU频率：</td>
        <td width="80%" height="25" align="left" class="f12_1">${mdmVo.cpuSpeed }</td>
      </tr>
      <tr bgcolor="#eef6f7" height="25" >
        <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;内存大小：</td>
        <td width="80%" height="25" align="left" class="f12_1">${mdmVo.memory }</td>
      </tr>                                                                                                                        
      <tr bgcolor="#deecef" height="25" >
        <td width="20%" height="25" align="left" class="f12_1">&nbsp;&nbsp;描述：</td>
        <td width="80%" height="25" align="left" class="f12_1">${mdmVo.displayText }</td>
      </tr>
    </table>
    
  </body>
</html>