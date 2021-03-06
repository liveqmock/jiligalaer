<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源-添加网络-高级网络-添加</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/basic.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	margin: 0px auto;
	background:#ffffff;
	background-repeat: repeat;
	background-position: left;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function save(){
	var form = document.forms.listForm;
	if(form.networkName.value == ''){
		alert("请输入网络名称");
		return false;
	}
	if(form.description.value == ''){
		alert("请输入描述");
		return false;
	}
	//var zone = document.getElementsByName("zone");
	//var val=$('input:radio[name="zoneId"]:checked').val();
	if($("#zoneId").val()==''){
		alert("请选择数据中心!");
		return false;
	}
	var val=$('input:radio[name="selValue"]:checked').val();
	if(val==null){
		alert("请选择网络方案!");
		return false;
	}
	//alert($('input:radio[name="prodId"]:checked').val());
	//$('#selValue').val($('input:radio[name="prodId"]:checked').val());
	
	if(confirm("确认保存该网络？")){
		form.action="${ctx}/network/saveHighNet.do";
		waitloading();
		form.submit();
	}
}
function back(){
	var form = document.forms.listForm;
	form.action="${ctx}/network/highNet.do";
	form.submit();
}
function queryNetwork(zoneId){
	var form = document.forms.listForm;
	form.action="${ctx}/network/addHighNet.do?zoneId="+zoneId;
	form.submit();
}
//数据中心选择
function selectZone(){
	var callback = function(result){
		if(result){
			$("input[name='zoneId']").val(result.id);
			$("input[name='zoneName']").val(result.name);
		}
	};
	openZoneTree("${ctx}","zone",0,"r",$("input[name='zoneId']").val(),null,callback,"1");
}
</script>
<script type="text/javascript">
var msg = '${networkAddMsg}';
if(msg!=''){
	alert(msg);
	window.location.href="${ctx}/network/highNet.do";
}
</script>
</head>
<body onLoad="">
	<form:form modelAttribute="baseVoList" action="${ctx}/network/saveHighNet.do" method="post" name="listForm">
		  <!--<input type="hidden" name="selValue" id="selValue" value="" /> -->
		  
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="10"></td>
              <td align="left" valign="top">
                
                <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#f2f2f2">
                  <tr height="30" bgcolor="#ffffff">
                    <td>
			     		<table width="100%" border="0" cellspacing="1" cellpadding="1" >
			              <tr height="25">
			                <td width="10%" align="right" class="f12_1"><span style="color: red;">*</span>网络名称：</td>
			                <td width="20%" align="left" class="f12_1">&nbsp;<input type="text" name="networkName" size="15" maxlength="30"/></td>
			                <td width="7%" align="right" class="f12_1"><span style="color: red;">*</span>描述：</td>
			                <td width="35%" align="left" class="f12_1">&nbsp;<input type="text" name="description" size="40" maxlength="100"/></td>
			                <td width="28%" align="right" class="f12_1">
			                	<img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:save();"/>
							    <img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:back();"/>
							    &nbsp;&nbsp;
			                </td>
			              </tr>
			              <tr height="30" bgcolor="#ffffff">
		                    <td width="10%" align="right" class="f12_1"><span style="color: red;">*</span>数据中心：</td>
		                    <td colspan="4" align="left" class="f12_1">
		                    	&nbsp;
								<input type="hidden" name="zoneId" id="zoneId" />
								<input type="text" name="zoneName" onclick="selectZone()" readonly class="select_but"/>
		                    </td>
		                  </tr>       
			            </table>
                    </td>
                  </tr>
                </table>

                <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">
                  <tr height="5"><td></td></tr>
                </table>
                
                <!--<span class="f12_1">网络方案选择：</span>
                -->
                <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">
                  <tr height="30">
                    <td>
                    	
			     		<table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
			              <tr bgcolor="#92b8c1" height="20">
			                <td width="4%" align="center" class="f12">序号</td>
			                <td width="20%" align="center" class="f12">网络方案名称</td>
			                <td width="9%" align="center" class="f12">带宽大小(M)</td>
			                <td width="30%" align="center" class="f12">描述</td>
			                <td width="8%" align="center" class="f12">一次性收费（元）</td>
			                <td width="7%" align="center" class="f12">年收费（元）</td>
			                <td width="7%" align="center" class="f12">月收费（元）</td>
			                <td width="7%" align="center" class="f12">天收费（元）</td>
			                <td width="8%" align="center" class="f12">小时收费（元）</td>
			              </tr>
			            </table>
			            
			            <%int i=0; %>
			            <div id="order" style="height:495px; z-index:1; overflow-y: scroll;overflow-x:hidden;">
			              <table width="815" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
							
							  <c:forEach var="item" items="${netWorklist}" >
						        <%
						        String bgcolor="#deecef";
						        if(i++ % 2 == 0){bgcolor="#eef6f7"; }
						        %>
								<tr bgcolor="<%=bgcolor %>" height="20">
				                  <td width="4%" align="center" class="f12_1"><%=i %></td>
				                  <td width="20%" align="left" class="f12_1" title="${item[1] }">${fn:substring(item[1],0,25)}</td>
				                  <td width="9%" align="right" class="f12_1">${item[2] }</td>
				                  <td width="30%" align="left" class="f12_1" title="${item[3] }">${item[3] }</td>
				                  <td width="8%" align="center" class="f12_1">
				                  	<c:if test="${item[5] != null}">
				                  		<input type="radio" name="selValue" id="radio1" value="${item[0]}_${item[5]}_${item[9]}_${item[10]}_0">${item[5]}
				                  	</c:if>
				                  </td>
				                  <td width="7%" align="center" class="f12_1">
				                  	<c:if test="${item[6] != null}">
				                  		<input type="radio" name="selValue" id="radio1" value="${item[0]}_${item[6]}_${item[9]}_${item[10]}_2">${item[6]}
				                  	</c:if>
				                  </td>
				                  <td width="7%" align="center" class="f12_1">
				                  	<c:if test="${item[7] != null}">
				                  		<input type="radio" name="selValue" id="radio1" value="${item[0]}_${item[7]}_${item[9]}_${item[10]}_3">${item[7]}
				                  	</c:if>
				                  </td>
				                  <td width="7%" align="center" class="f12_1">
				                  	<c:if test="${item[8] != null}">
				                  		<input type="radio" name="selValue" id="radio1" value="${item[0]}_${item[8]}_${item[9]}_${item[10]}_4">${item[8]}
				                  	</c:if>
				                  </td>
				                  <td width="8%" align="center" class="f12_1">
				                  	<c:if test="${item[11] != null}">
				                  		<input type="radio" name="selValue" id="radio1" value="${item[0]}_${item[11]}_${item[9]}_${item[10]}_5">${item[11]}
				                  	</c:if>
				                  </td>				                  
				                </tr>
				              </c:forEach>		                
			              </table>
			            </div>
                                                    
                    </td>
                  </tr>
                </table>
   
              <td width="10"></td>
            </tr>
          </table>

	</form:form>
</body>
</html>