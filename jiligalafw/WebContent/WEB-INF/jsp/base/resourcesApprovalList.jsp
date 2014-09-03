<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>资源审批</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/popup.dialog.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
<!--
body {
	background-color: #F2F2F2;
	margin-left: 5px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script type="text/javascript">
function query(queryType){
	loading();
	document.getElementById('queryType').value=queryType;
	document.forms.listForm.submit();
}

function dateQuery(val){
	var form = document.forms.listForm;
	form.queryType.value='0';
	form.timeFlag.value=val;
	form.action="${ctx}/resourcesApproval/list.do";
	loading();
	form.submit();
}
function stateQuery(val){
	var form = document.forms.listForm;
	form.queryType.value='1';
	form.stateFlag.value=val;
	form.action="${ctx}/resourcesApproval/list.do";
	loading();
	form.submit();
}
function open_high(){
	document.getElementById('search').style.display='block';
	document.getElementById('openSearch').style.display='none';
}
function close_high(){
	document.getElementById('search').style.display='none';
	document.getElementById('openSearch').style.display='block';
}
function setDate(objName){
	document.getElementById(objName).value=WdatePicker();
}
function checkbox(){
	var stateStr = '${stateStr}';
	var sts = stateStr.split(",");
	var st = document.getElementsByName("state");
	for(var i=0;i<st.length;i++){
		for(var j=0;j<sts.length;j++){
   			if(st[i].value==sts[j]){
    			st[i].checked=true;
 			}
		}
	}
}
function display(){
	var queryType = '${queryType}';
	if(queryType == '2'){
		open_high();
	}
}
/**
function approval(id, approvalState) {
	var alt="确认审批通过吗？";
	if(approvalState == '2'){
		alt="确认拒绝吗？";
	}
	if(confirm(alt)){
		loading();
		$.ajax({
			dataType: 'text',
			type : "POST",
			url : "${ctx}/resourcesApproval/approval.do",
			data : "id=" + id + "&approvalState=" + approvalState ,
			async: true,	//异步:关闭
			success : function(msg) {
				unloading();
				alert(msg);
				var form = document.forms.listForm;
				form.submit();
			},				   
			error: function(msg){
				unloading();
		    	alert(msg);
				var form = document.forms.listForm;
				form.submit();		    	
		   	}
		});
	}
}
*/
function approval(id, approvalState){
	var txt = "";
	if(approvalState == 1){
		txt = '审批处理<br/><hr></hr>通过备注：<textArea name="alertName" cols="45" rows="5"></textArea>';
	}else{
		txt = '审批处理<br/><hr></hr>拒绝原因：<textArea name="alertName" cols="45" rows="5"></textArea>';
	}
	
	$.prompt(txt,{
		buttons: {确定:1, 取消:3},
		callback: function mycallbackform(v,m,f){
			if(v == 3){
				return ;
			}
			if(approvalState != 1 && (f.alertName=="" || f.alertName==null) ){
				alert("拒绝原因不能为空");
				return ;
			}else{
				
				loading();
				$.ajax({
					dataType: 'text',
					type : "POST",
					url : "${ctx}/resourcesApproval/approval.do",
					data : "id=" + id + "&approvalState=" + approvalState + "&rejectRemark=" + f.alertName,
					async: true,	//异步:关闭
					success : function(msg) {
						unloading();
						alert(msg);
						var form = document.forms.listForm;
						form.submit();
					},				   
					error: function(msg){
						unloading();
				    	alert(msg);
						var form = document.forms.listForm;
						form.submit();		    	
				   	}
				});
			}	
		}
	});
}


</script>

</head>
  <body onLoad="checkbox();display();">
    <div id="div_view"></div>
   	<form:errors path="errors" />
    <form:form modelAttribute="cloudOrderApprovalVoList" action="${ctx}/resourcesApproval/list.do" method="post" name="listForm">
		
		<input type="hidden" name="timeFlag" value="" id="timeFlag" />
		<input type="hidden" name="stateFlag" value="" id="stateFlag" />
		<input type="hidden" name="queryType" value="" id="queryType" />
		
        <!-- 外层边框 -->
		<div id="middle_sheet_s">
			<table width="950" border="0" cellpadding="0" cellspacing="0" align="center">
		      <tr>
		        <td align="center" valign="top" bgcolor="#F2F2F2" height="670">
		       	
					<!-- 内容区域：查询条件和结果集 -->
					<table width="915" border="0" cellspacing="0" cellpadding="0">
					  <tr>
	                    <td height="2" align="center" valign="middle"><img src="${ctx}/images/sheet_line_2.jpg" width="915" height="2" /></td>
	                  </tr>					
                  	  <tr>
                    	<td align="left" valign="top">
						  <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#a0a0a0">
	                      	<tr height="20" bgcolor="#f2f2f2" >
                          	  <td>
                           		<table width="100%" border="0" cellspacing="1" cellpadding="0">
                               	  	<!-- 简单搜索 -->
                                    <tr height="25">
                                  	  <td></td>
                                      <td width="80" class="f13_1" align="left">申请日期：</td>
                                      <td width="690" >
										<a href="javascript:dateQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('1')" class="f13_3">今日</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('2')" class="f13_3">本周</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('3')" class="f13_3">上周</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('4')" class="f13_3">本月</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('5')" class="f13_3">上月</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('6')" class="f13_3">其它</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                      </td>
                                      <td></td>
                                    </tr>
                                    <tr height="25">
                                  	  <td></td>
                                      <td width="80" class="f13_1" align="left">审批状态：</td>
                                      <td>
                                         <a href="javascript:stateQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                         <a href="javascript:stateQuery('0')" class="f13_3">未处理</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                         <a href="javascript:stateQuery('1')" class="f13_3">已通过</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                         <a href="javascript:stateQuery('2')" class="f13_3">已拒绝</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                      </td>
                                      <td></td>
                                    </tr>
                                     
                                    <!-- 高级搜索 -->
                                    <tr height="25" style="cursor:pointer;" onclick="open_high()">
                                        <td></td>
                                        <td colspan="2" align="left" class="f15">
                                       	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                                       	  <tr>
	                                          	<td width="20" align="left"><img src="${ctx}/images/ico14.png" width="20" height="20" /></td>
	                                          	<td width="80" align="center">高级搜索</td>
	                                          	<td width="20" align="left"><img id="openSearch" src="${ctx}/images/ico15.png" width="20" height="20" /></td>
	                                          	<td>&nbsp;</td>
	                                          <tr>
                                       	  </table>
                                      	</td>
                                      	<td></td>
                                    </tr>
                                       
                                    <tr>
                                      <td width="15"></td>
                                      <td colspan="2">
                                     	<table width="100%" border="0" cellspacing="1" cellpadding="0" id="search" style="display:none">
                                     	  	<tr>
                                     	        <td colspan="3" align="left" valign="top">
                                     	        	<hr style="border: 1px dashed #ccc; width: 100%; height:1px;" />
                                     	        </td>
                                            </tr>
                                             
	                                      	<tr height="25">
		                                      	<td width="30">&nbsp;</td>
		                                        <td class="f13_1" align="left">审批状态：</td>
		                                        <td class="f13_3" >
		                                           	<input type="checkbox" name="checkall" id="checkall" onclick="checkAll('checkall','state')" style="vertical-align:middle; margin-top:0px;"/>全部&nbsp;&nbsp;&nbsp;&nbsp;
		                                           	<input type="checkbox" name="state" id="state" value="0" style="vertical-align:middle; margin-top:0px;"/>未审批&nbsp;&nbsp;&nbsp;&nbsp;
		                                           	<input type="checkbox" name="state" id="state" value="1" style="vertical-align:middle; margin-top:0px;"/>已通过&nbsp;&nbsp;&nbsp;&nbsp;
		                                           	<input type="checkbox" name="state" id="state" value="2" style="vertical-align:middle; margin-top:0px;"/>已拒绝&nbsp;&nbsp;&nbsp;&nbsp;
		                                        </td>
	                                      	</tr>
                                            <tr height="25">
                                          		<td width="30">&nbsp;</td>
                                             	<td class="f13_1" align="left">申请人：</td>
                                             	<td align="left">
                                               		<form:querylike path="createdBy"/>
                                             	</td>
                                            </tr>
                                            <tr height="25">
                                          		<td width="30">&nbsp;</td>
                                             	<td class="f13_1" align="left">申请日期：</td>
                                             	<td align="left" class="f13_1">
                                             		从<input name="dateS" type="text" value="${dateS }" onfocus="WdatePicker()" readonly class="date_but"/>
                         	                    	到<input name="dateE" type="text" value="${dateE }" onfocus="WdatePicker()" readonly class="date_but"/>
                                             	</td>
                                            </tr>

                                            <tr height="50">
	                                          <td width="30">&nbsp;</td>
                                              <td colspan="2" align="left"  valign="middle">
                                              	<a href="javascript:void(0)"><img src="${ctx}/images/btns2.png" alt="提交" onclick="query('5')" width="101" height="29" border="0"/></a>
                                              	&nbsp;&nbsp;&nbsp;&nbsp;
                                              	<a href="javascript:void(0)"><img src="${ctx}/images/btnc1.png" alt="重置" onclick="document.forms.listForm.reset();return false;" width="101" height="30" border="0"/></a>
                                              </td>
                                            </tr>
                                            <tr valign="bottom">
                                          		<td colspan="3" align="center"><img src="${ctx}/images/close.png" width="80" height="18" border="0" style="cursor:pointer;" onclick="close_high()"/></td>
                                          	</tr>
                                        </table>
                                      </td>
                                      <td width="15"></td>
                                    </tr>
                                        
                                </table>                                   	  
                              </td>                                   
                            </tr>
                          </table>
                              
                        </td>
                      </tr>
		              <tr><td height="2"></td></tr>
		              <tr>
		                <td height="2" align="center" valign="middle"><img src="${ctx }/images/sheet_line_2.jpg" width="915" height="2" /></td>
		              </tr>
		              
					  <tr><td height="20"></td></tr>
					  
                      <tr>
						<td align="left" valign="top">

							<ec:table items="list" var="item" onInvokeAction="query('${queryType }')" form="listForm"
						        retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%" tableId="${tableId}"
							    action="${ctx}/resourcesApproval/list.do" showPagination="true" cellspacing="1">
								<ec:row>
									<ec:column property="_rowNumber" title="序号" cell="rowNumber" style="width:5%;text-align:center"/>
									
									<ec:column property="vmName" title="虚拟机名" style="width:15%; text-align: left;"/>
									<ec:column property="cloudUserOrder.oneTimeRebateAmount" cell="number" format="#0.00" title="一次性收费金额(元)" style="width:15%; text-align: right;"/>
									<ec:column property="cloudUserOrder.cycleRebateAmount" cell="number" format="#0.00" title="周期收费金额(元)" style="width:15%; text-align: right;">
										<fmt:formatNumber pattern="#0.00">${item.cloudUserOrder.cycleRebateAmount }</fmt:formatNumber>
										<c:if test="${item.cloudUserOrder.billingCycle==0}">一次性</c:if>
										<c:if test="${item.cloudUserOrder.billingCycle==2}">/年</c:if>
										<c:if test="${item.cloudUserOrder.billingCycle==3}">/月</c:if>
										<c:if test="${item.cloudUserOrder.billingCycle==4}">/天</c:if>
										<c:if test="${item.cloudUserOrder.billingCycle==5}">/小时</c:if>
									</ec:column>
									
										
									<ec:column property="basicUser.userAccount" title="申请用户名" style="width:15%; text-align: left;" alias="userAccount"/>
									<ec:column property="createdBy" title="申请人姓名" style="width:10%; text-align: left;"/>
									<ec:column property="created" title="申请日期" cell="date" format="yyyy-MM-dd" style="width:10%; text-align: center;"/>
									
									<ec:column property="null" width="10%" title="操作" sortable="false" viewsAllowed="html"  style="width: 10%; text-align: center;">
										<center>
											<c:if test="${item.approvalFlag == '0'}">
												<input  type="button" class="btn_bg" value="通过" onclick="approval('${item.id}','1')"/>
												<input  type="button" class="btn_bg" value="拒绝" onclick="approval('${item.id}','2')"/>
											</c:if>
											<c:if test="${item.approvalFlag == '1'}">
												已通过
											</c:if>
											<c:if test="${item.approvalFlag == '2'}">
												已拒绝
											</c:if>
											<c:if test="${item.approvalFlag == '3'}">
												审批失败
											</c:if>											
										</center>
									</ec:column>
								</ec:row>
							</ec:table>

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