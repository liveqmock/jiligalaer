<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的虚拟机 - 详细 信息</title>
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
function setZoneType(zoneType){
	 //var doc = parent.document;
     //doc.getElementById('zoneType').value = zoneType;
     var winObj = window.parent;
     winObj.ipButtonHide(zoneType);
}
</script>

</head>
  <body onLoad="setZoneType('${vmVo.cloudMdmZone.networkType }')">
    <form:form modelAttribute="baseVoList" action="${ctx}/myVm/list.do" method="post" name="listForm">

        <table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
           <tr bgcolor="#deecef" height="35">
             <td width="25%" align="left" class="f13_1">&nbsp;&nbsp;<b>所属用户：</b></td>
             <td width="75%" align="left" class="f13_1">&nbsp;
             	<b>
             		${orderVo.basicUser.userAccount }
             	</b>
			 </td>
           </tr>
                   
           <tr bgcolor="#eef6f7" height="35">
             <td width="25%" align="left" class="f13_1">&nbsp;&nbsp;<b>购买方式：</b></td>
             <td width="75%" align="left" class="f13_1">&nbsp;
             	<b>
             	<c:if test="${orderVo.buyType == 'quickBuy' }">快速购买</c:if>
             	<c:if test="${orderVo.buyType == 'customBuy' }">自定义购买</c:if>
             	</b>
			 </td>
           </tr>
           
           <tr bgcolor="#deecef" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;操作系统类型：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.templateName }</td>
           </tr>   
           <tr bgcolor="#eef6f7" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;模板：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.templateDisplayText }</td>
           </tr>          
           <tr bgcolor="#deecef" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;计算方案：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.cloudMdmCPUSoln.name }</td>
           </tr>
           <tr bgcolor="#eef6f7" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;ID：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.interfaceId }</td>
           </tr>
           <tr bgcolor="#deecef" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;区域名称：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.zoneName }</td>
           </tr>        
           <tr bgcolor="#eef6f7" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;主机：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.displayName }</td>
           </tr>   
           <tr bgcolor="#deecef" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;域：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.domain }</td>
           </tr>  
           <tr bgcolor="#eef6f7" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;帐户：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.account }</td>
           </tr>   
           <tr bgcolor="#deecef" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;创建日期：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;
             	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${vmVo.created }"></fmt:formatDate>
             </td>
           </tr>  
           <tr bgcolor="#eef6f7" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;停止时间：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;
             	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${vmVo.stoptime }"></fmt:formatDate>
             </td>
           </tr>
           <tr bgcolor="#deecef" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;虚拟机状态：</td>
             <td width="75%" align="left" class="f12_1">&nbsp;&nbsp;${vmVo.state }</td>
           </tr>
		<%--
           <tr bgcolor="#eef6f7" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;已附加ISO：</td>
             <td width="75%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>		
           <tr bgcolor="#deecef" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;虚拟机管理程序：</td>
             <td width="75%" align="left" class="f12_2">&nbsp;&nbsp;KVM</td>在卷表中存着
           </tr>
           <tr bgcolor="#eef6f7" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;组：</td>
             <td width="75%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>
           <tr bgcolor="#eef6f7" height="25">
             <td width="25%" align="left" class="f12_1">&nbsp;&nbsp;高可用性：</td>
             <td width="75%" align="left" class="f12_2">&nbsp;&nbsp;</td>
           </tr>
		--%>
         </table>
    
        
	</form:form>
  </body>
</html>