<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>首次充值</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script type="text/javascript">
$(document).ready(function(){

});

function savePromotionInfo(){
	$("#cloudPromotionActivityVo").submit();
}
	
function closeWin(){
	window.opener = null;
	window.open('', '_self', '');
	window.close(); 
}
function back(){
	window.location="${ctx}/promotion/list.do";
}

var msg='${promoMsg }';
if(msg != ''){
	alert(msg);
	back();
}
</script>
</head>
<body>
		<form:form modelAttribute="cloudPromotionActivityVo" action="${ctx}/promotion/savePromotionInfo.do" method="post" name="listForm">
		<form:input path="promotionId" type="hidden"/>
          <table width="962" border="0" cellpadding="0" cellspacing="0">
			<tr height="4"><td bgcolor="#ffffff"></td></tr>
            <tr>
              <td align="center" valign="top" bgcolor="#ffffff">
              
					<table width="952" height="680" border="0" cellspacing="0" cellpadding="0">
                  	  <tr>
                  	    <td width="5"></td>
                    	<td align="left" valign="top">
						  <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#a0a0a0">
	                      	<tr height="20" bgcolor="#ffffff" >
                          	  <td>
		                       		<table width="100%" border="0" cellspacing="1" cellpadding="0" >
		                           	  	<!-- 一键式搜索 -->
		                                <tr height="25">
		                              	  <td></td>
		                                  <td width="80" class="f13_1" align="left">&nbsp;&nbsp;活动类型：</td>
		                                  <td width="690" class="f13_1">
		                                     	首次充值礼包
		                                  </td>
		                                  <td><form:input path="promotionType" type="hidden"/></td>
		                                </tr>                               	  	
		                                <tr height="25">
		                              	  <td></td>
		                                  <td width="80" class="f13_1" align="left">&nbsp;&nbsp;活动名称：</td>
		                                  <td width="690">
		                                     <form:input path="activityName" type="text"  class="text13" size="35" />&nbsp;&nbsp;<font size="2" color="red"><form:errors path="activityName" /></font>
		                                  </td>
		                                  <td></td>
		                                </tr>
		                                <tr height="25">
		                              	  <td></td>
		                                  <td width="80" class="f13_1" align="left">&nbsp;&nbsp;活动时间：</td>
		                                  <td class="f13_1">
		                                  	<form:input path="startDate" class="date_but" size="30" onfocus="WdatePicker()" readonly="true" id="startDate" />
											至&nbsp;<form:input path="endDate" class="date_but" size="30" onfocus="WdatePicker()" readonly="true" id="endDate" />&nbsp;&nbsp;
											<font size="2" color="red"><form:errors path="startDate" /></font>                                        
		                                  </td>
		                                  <td></td>
		                                </tr>
		                                <tr height="25">
		                              	  <td></td>
		                                  <td width="80" class="f13_1" align="left">&nbsp;&nbsp;返利额度：</td>
		                                  <td width="690" >
								 			<form:input path="rebateAmount" class="text13" size="10" id="rebateAmount" />&nbsp;<span class="text13" id="lblRebate">元</span>&nbsp;&nbsp;<font size="2" color="red"><form:errors path="rebateAmount" /></font>
		                                  </td>
		                                  <td></td>
		                                </tr>
		                                <tr height="25">
		                              	  <td></td>
		                                  <td width="80" class="f13_1" align="left">&nbsp;&nbsp;状态：</td>
		                                  <td width="690" class="f13_1">
											<form:radiobutton path="state" value="1" />活动
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<form:radiobutton path="state" value="0" />停用
		                                  </td>
		                                  <td></td>
		                                </tr> 
		                                <tr height="25">
	                                  	  <td></td>
	                                      <td width="80" class="f13_1" align="left">&nbsp;&nbsp;返利说明：</td>
	                                      <td width="690" class="f13_1">
	                                      	首次充值时，以金额方式返利。
	                                      </td>
	                                      <td></td>
	                                    </tr>                                       
		                            </table>
		                          </td>
		                        </tr>
		                      </table>
		                    </td>
		                  </tr>
						<tr style="height:2px"><td colspan="2" style="height:2px"></td></tr>
						
						<tr><td width="5"></td><td height="20" class="f13_1" align="left">已有的首次充值礼包 ：</td></tr>
						
						<tr style="height:4px"><td colspan="2" style="height:4px"></td></tr>
						<tr>
			                <!-- <td width="20"></td> -->
							<td align="right"  colspan="2" valign="top">
						      <table width="100%" border="0" cellpadding="0" cellspacing="0">
						        <tr>
						          <td align="left" valign="top" height="330">
						          <iframe name="promotionListFrame" id="promotionListFrame"  frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" src="${ctx }/promotion/listSp.do?promotionType=firstRechargeActivity" height="100%" width="100%"></iframe>
						     		<!-- <table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
						              <tr bgcolor="#92b8c1" height="20">
						                <td width="10%" align="center" class="f12">序号</td>
						                <td width="10%" align="center" class="f12">市场活动名称 </td>
						                <td width="10%" align="center" class="f12">开始时间</td>
						                <td width="10%" align="center" class="f12">结束时间</td>
						                <td width="10%" align="center" class="f12">返利额度 </td>
						                <td width="10%" align="center" class="f12">状态 </td>
						              </tr>
						            </table>
						           <div id="order" style="height:220px; z-index:1; overflow-y: scroll;overflow-x:no;">   
						             <table width="98%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
						               <tr bgcolor="#deecef" height="20">
						                  <td width="10%" align="center" class="f12_1">1</td>
						                  <td width="10%" align="center" class="f12_1"></td>
						                  <td width="10%" align="center" class="f12_1"></td>
						                  <td width="10%" align="center" class="f12_1"></td>
						                  <td width="10%" align="center" class="f12_1"></td>
						                  <td width="10%" align="center" class="f12_1"></td>
						                </tr> 
						              </table>
						            </div> -->
						          </td>
						        </tr>
						      </table>													
							</td>
				        </tr>
						<tr><td height="20" colspan="2" ></td></tr>  
						                     
						<tr>
						  <td colspan="2" align="center" valign="middle" style="text-align: center;">
						  	<a href="#"><img src="${ctx}/images/btn11.png" alt="确定" onclick="javascript:savePromotionInfo();" width="101" height="30" border="0" align="absmiddle"/></a>
							<!--
							&nbsp;&nbsp;&nbsp;&nbsp;
						    <a href="javascript:window.parent.parent.close();"><img src="${ctx}/images/btn8.png" alt="关闭" width="101" height="30" border="0" align="absmiddle"/></a>
						    -->
						    &nbsp;&nbsp;&nbsp;&nbsp;
						    <a href="javascript:back();"><img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" align="absmiddle" /></a>
						  </td>
						</tr>
						<tr><td height="20" colspan="2" ></td></tr>  
						                    
			        </table>
			        
	       	  </td>
	      </tr>
	   </table>

		</form:form>
</body>
</html>