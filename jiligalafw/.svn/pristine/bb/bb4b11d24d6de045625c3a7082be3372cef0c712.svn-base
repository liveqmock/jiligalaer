<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>账户审批</title>
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
$.ajaxSetup({  
	async: true  
}); 
function approval(userId, approvalState){
	var txt = "";
	if(approvalState == 3){
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
			if(approvalState != 3 && (f.alertName=="" || f.alertName==null) ){
				alert("拒绝原因不能为空");
				return ;
			}else{
				var form = document.forms.listForm;
				loading();
				$.post('${ctx}/accApproval/approval.do', {
					'userId' : userId,
					'rejectRemark' : f.alertName,
					'approvalState':approvalState
				}, function(data) {
					if (data.flag == 01) {
						alert("操作成功!");
					}else{
						alert("操作失败!");
					}
					form.action="${ctx}/accApproval/list.do";
					loading();
					form.submit();
				}, "json");
			}	
		}
	});
}

//高级查询
function query(val) {
	var form = document.forms.listForm;
	form.queryType.value=val;
	form.action="${ctx}/accApproval/list.do";
	loading();
	form.submit();
}

//账户类别查询
function userAccountTypeQuery(val) {
	var form = document.forms.listForm;
	form.queryType.value = '0';
	form.userAccountTypeFlag.value = val;
	form.action = "${ctx}/accApproval/list.do";
	loading();
	form.submit();
}
//账户类型查询
function userIdentityQuery(val) {
	var form = document.forms.listForm;
	form.queryType.value = '1';
	form.userIdentityFlag.value = val;
	form.action = "${ctx}/accApproval/list.do";
	loading();
	form.submit();
}
//地区查询
function geoQuery(val) {
	var form = document.forms.listForm;
	form.queryType.value = '2';
	form.geoFlag.value = val;
	form.action = "${ctx}/accApproval/list.do";
	loading();
	form.submit();
}
//行业查询
function industryQuery(val) {
	var form = document.forms.listForm;
	form.queryType.value = '3';
	form.industryFlag.value = val;
	form.action = "${ctx}/accApproval/list.do";
	loading();
	form.submit();
}
//审批状态
function stateQuery(val) {
	var form = document.forms.listForm;
	form.queryType.value='4';
	form.stateFlag.value=val;
	form.action="${ctx}/accApproval/list.do";
	loading();
	form.submit();
}
//日期查询
function dateQuery(val){
	var form = document.forms.listForm;
	form.queryType.value='5';
	form.timeFlag.value=val;
	form.action="${ctx}/accApproval/list.do";
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
function checkAllBox() {
	var stateStr = '${stateArrStr}';
	if(stateStr !="" || stateStr != undefined){
		var sts = stateStr.split(",");
		var st = document.getElementsByName("state");
		for ( var i = 0; i < st.length; i++) {
			for ( var j = 0; j < sts.length; j++) {
				if (st[i].value == sts[j]) {
					st[i].checked = true;
				}
			}
		}
	}
	var userAccountTypeStr = '${userAccountTypeStr}';
	if(userAccountTypeStr !="" || userAccountTypeStr != undefined){
		var sts = userAccountTypeStr.split(",");
		var st = document.getElementsByName("userAccountType");
		for ( var i = 0; i < st.length; i++) {
			for ( var j = 0; j < sts.length; j++) {
				if (st[i].value == sts[j]) {
					st[i].checked = true;
				}
			}
		}
	}
	var userIdentityStr = '${userIdentityStr}';	
	if(userIdentityStr !="" || userIdentityStr != undefined){
		var sts = userIdentityStr.split(",");
		var st = document.getElementsByName("userIdentity");
		for ( var i = 0; i < st.length; i++) {
			for ( var j = 0; j < sts.length; j++) {
				if (st[i].value == sts[j]) {
					st[i].checked = true;
				}
			}
		}
	}
	var geoStr = '${geoStr}';
	if(geoStr !="" || geoStr != undefined){
		var sts = geoStr.split(",");
		var st = document.getElementsByName("geo");
		for ( var i = 0; i < st.length; i++) {
			for ( var j = 0; j < sts.length; j++) {
				if (st[i].value == sts[j]) {
					st[i].checked = true;
				}
			}
		}
	}
	var industryStr = '${industryStr}';			
	if(industryStr !="" || industryStr != undefined){
		var sts = industryStr.split(",");
		var st = document.getElementsByName("industry");
		for ( var i = 0; i < st.length; i++) {
			for ( var j = 0; j < sts.length; j++) {
				if (st[i].value == sts[j]) {
					st[i].checked = true;
				}
			}
		}
	}
}

function display() {
	var queryType = '${queryType}';
	if (queryType == '6') {
		open_high();
	}
}

//在鼠标显示一个层，该层的内容为div1的内容 
function showTip(remark){		
	var div1 = document.getElementById('div_view'); //将要弹出的层 
	div1.style.display="block"; //div1初始状态是不可见的，设置可为可见 
	div1.style.left=event.clientX+10+"px"; //鼠标目前在X轴上的位置，加10是为了向右边移动10个px方便看到内容 
	div1.style.top=event.clientY+5+"px"; 
	div1.style.position="absolute"; //必须指定这个属性，否则div1层无法跟着鼠标动 
	div1.innerText=remark;

}
//关闭层div1的显示 
function closeTip() { 
	var div1 = document.getElementById('div_view'); 
	div1.style.display="none"; 
} 
</script>

</head>
  <body onLoad="checkAllBox();display();">
    <div id="div_view"></div>
   	<form:errors path="errors" />
    <form:form modelAttribute="basicUserVoList" action="${ctx}/accApproval/list.do" method="post" name="listForm">
		
		<input type="hidden" name="userAccountTypeFlag" value="" id="userAccountTypeFlag" />
		<input type="hidden" name="userIdentityFlag" value="" id="userIdentityFlag" />
		<input type="hidden" name="industryFlag" value="" id="industryFlag" />
		<input type="hidden" name="geoFlag" value="" id="geoFlag" />
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
                               	  	<!-- 一键式搜索 -->
									<tr height="25">
										<td></td>
										<td width="80" class="f13_1" align="left">账户类别：</td>
										<td width="690">
											<a href="javascript:userAccountTypeQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<c:forEach var="item" items="${userAccountType}" varStatus="status">
												<a href="javascript:userAccountTypeQuery('${item.itemCode}')" class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
						                   </c:forEach>
						                </td>
										<td width="180" align="right">
										    <img src="${ctx}/images/btn35.png" alt="批量通过" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:batchOperate('approvalId',3);"/>
										    &nbsp;&nbsp;
										</td>
									</tr>
									<tr height="25">
										<td></td>
										<td width="80" class="f13_1" align="left">账户类型：</td>
										<td>
											<a href="javascript:userIdentityQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp; 
											<c:forEach var="item" items="${userIdentity}" varStatus="status">
												<a href="javascript:userIdentityQuery('${item.itemCode}')" class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
						                    </c:forEach>
						                </td>
										<td></td>
									</tr>
									<tr height="25">
										<td></td>
										<td width="80" class="f13_1" align="left">地区：</td>
										<td>
											<a href="javascript:geoQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<c:forEach var="item" items="${geo}" varStatus="status">
												<a href="javascript:geoQuery('${item.itemCode}')" class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
						                    </c:forEach>
						                </td>
										<td></td>
									</tr>
									<tr height="25">
										<td></td>
										<td width="80" class="f13_1" align="left">行业：</td>
										<td>
											<a href="javascript:industryQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp; 
											<c:forEach var="item" items="${industry}" varStatus="status">
												<a href="javascript:industryQuery('${item.itemCode}')" class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
						                   	</c:forEach>
						                </td>
										<td></td>
									</tr>
													
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
                                         <a href="javascript:stateQuery('2')" class="f13_3">未处理</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                         <a href="javascript:stateQuery('3')" class="f13_3">已通过</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                         <a href="javascript:stateQuery('-2')" class="f13_3">已拒绝</a>&nbsp;&nbsp;&nbsp;&nbsp;
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
												<td class="f13_1" align="left">账户类别：</td>
												<td class="f13_3">
													<input type="checkbox" name="checkall" id="checkallAccType" onclick="checkAll('checkallAccType','userAccountType')" style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
													<c:forEach var="item" items="${userAccountType}" varStatus="status">
														<input type="checkbox" name="userAccountType" id="userAccountType" value="${item.itemCode}"
															style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
													</c:forEach>
												</td>
											</tr>
											<tr height="25">
												<td width="30">&nbsp;</td>
												<td class="f13_1" align="left">账户类型：</td>
												<td class="f13_3">
													<input type="checkbox" name="checkall" id="checkallIdentity" onclick="checkAll('checkallIdentity','userIdentity')"
														style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
													<c:forEach var="item" items="${userIdentity}" varStatus="status">
														<input type="checkbox" name="userIdentity"
															id="userIdentity" value="${item.itemCode}" style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
													</c:forEach>
												</td>
											</tr>
											<tr height="25">
												<td width="30">&nbsp;</td>
												<td class="f13_1" align="left">地区：</td>
												<td class="f13_3">
													<input type="checkbox" name="checkall" id="checkallGeo"
														onclick="checkAll('checkallGeo','geo')" style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
													<c:forEach var="item" items="${geo}" varStatus="status">
														<input type="checkbox" name="geo" id="geo" value="${item.itemCode}"
															style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
												 	</c:forEach>
												 </td>
											</tr>
											<tr height="25">
												<td width="30">&nbsp;</td>
												<td class="f13_1" align="left">行业：</td>
												<td class="f13_3">
													<input type="checkbox" name="checkall" id="checkallIndustry" onclick="checkAll('checkallIndustry','industry')"
														style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
													<c:forEach var="item" items="${industry}" varStatus="status">
														<input type="checkbox" name="industry" id="industry" value="${item.itemCode}"
															style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
												 	</c:forEach>
												 </td>
											</tr>
	                                      
	                                      <tr height="25">
	                                    	<td width="30">&nbsp;</td>
	                                      	<td class="f13_1" align="left">审批状态：</td>
	                                      	<td class="f13_3" >
	                                         	<input type="checkbox" name="checkall" id="checkall" onclick="checkAll('checkall','state')" style="vertical-align:middle; margin-top:0px;"/>全部&nbsp;&nbsp;&nbsp;&nbsp;
	                                         	<input type="checkbox" name="state" id="state" value="2" style="vertical-align:middle; margin-top:0px;"/>未审批&nbsp;&nbsp;&nbsp;&nbsp;
	                                         	<input type="checkbox" name="state" id="state" value="3" style="vertical-align:middle; margin-top:0px;"/>已通过&nbsp;&nbsp;&nbsp;&nbsp;
	                                         	<input type="checkbox" name="state" id="state" value="-2" style="vertical-align:middle; margin-top:0px;"/>已拒绝&nbsp;&nbsp;&nbsp;&nbsp;
	                                         	<input type="checkbox" name="state" id="state" value="0" style="vertical-align:middle; margin-top:0px;"/>停用&nbsp;&nbsp;&nbsp;&nbsp;
	                                         	<input type="checkbox" name="state" id="state" value="-1" style="vertical-align:middle; margin-top:0px;"/>注销&nbsp;&nbsp;&nbsp;&nbsp;
	                                      	</td>
	                                      </tr>
                                          <tr height="25">
                                       		<td width="30">&nbsp;</td>
                                          	<td class="f13_1" align="left">姓名：</td>
                                          	<td align="left">
                                            	<%--<form:querylike path="userName" value/>--%>
                                            	<input type="text" name="userName" value="${userName }"/>
                                          	</td>
                                          </tr>
                                          <tr height="25">
                                       		<td width="30">&nbsp;</td>
                                          	<td class="f13_1" align="left">账户名：</td>
											<td align="left">
                                            	<%--<form:querylike path="userAccount"/>--%>
                                            	<input type="text" name="userAccount" value="${userAccount }"/>
                                          	</td>
                                          </tr>
                                          <tr height="25">
                                       		<td width="30">&nbsp;</td>
                                         	<td class="f13_1" align="left">联系电话：</td>
                                          	<td align="left">
                                            	<input type="text" name="tel" value="${tel }"/>
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
	                                           	<a href="javascript:void(0)"><img src="${ctx}/images/btns2.png" alt="提交" onclick="query('6')" width="101" height="29" border="0"/></a>
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
							<%int i=0; %>
							<ec:table items="list" var="item" onInvokeAction="query('${queryType }')" form="listForm"
						        retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%" tableId="${tableId}"
							    action="${ctx}/accApproval/list.do" showPagination="true" cellspacing="1">
								<ec:row>
									<ec:column property="_rowNumber" title="序号" cell="rowNumber" style="text-align:center; width:5%"/>
									<ec:column property="userIdentityDictItem.itemName" title="账户类别" style="width:9%; text-align: center;"/>
									<ec:column property="userTypeDictItem.itemName" title="账户类型" style="width:9%; text-align: center;"/>
									<ec:column property="userAccount" title="账户名" style="width:20%; text-align: left;"/>
									<ec:column property="userName" title="姓名" style="width:10%; text-align: left;"/>
									<ec:column property="geoDictItem.itemName" title="地区" style="width:9%; text-align: left;"/>
									<ec:column property="industryDictItem.itemName" title="行业" style="width:9%; text-align: left;"/>
									<ec:column property="approvalDate" title="申请日期" cell="date" format="yyyy-MM-dd" style="width:9%; text-align: center;"/>
									<ec:column property="tel" title="联系电话" style="width:9%; text-align: right;"/>
									<ec:column property="stateName" title="状态" style="width:5%; text-align: center;" >
										<span onmouseover="showTip('${item.refuseMemo}')" onMouseOut="closeTip()" >
											${item.stateName }
										</span>
									</ec:column>
									<ec:column property="null5" title="<input type='checkbox' value='' name='checkApprovalAll' id='checkApprovalAll'/>通过" sortable="false" viewsDenied="xls">
										<center>
											<c:choose>
												<c:when test="${item.state == 2}">
                									<input type="checkbox" value="${item.userId}" id="approvalId_<%=i %>" name="approvalId_<%=i %>" class="checkbox1" />
                								</c:when>
                								<c:otherwise>
                									<input type="checkbox" value="${item.userId}" id="approvalId_<%=i %>" name="approvalId_<%=i %>" disabled/>
                								</c:otherwise>
											</c:choose>										
							 			</center>
									</ec:column>									
									<ec:column property="null" title="操作" sortable="false" viewsAllowed="html" style="width:6%; ">
										<center>
											<c:if test="${item.state == 2 }">
												<a onclick="javascript:approval('${item.userId}',3)" style="text-decoration:none;">
													<input type="button" class="btn_bg" value="通过" />
												</a>
												<a onclick="javascript:approval('${item.userId}',-2)" style="text-decoration:none;">
													<input type="button" class="btn_bg" value="拒绝"/>
												</a>
											</c:if>
										</center>
									</ec:column>										
								</ec:row>
								<%i++; %>
							</ec:table>
						</td>
                      </tr>
                        
                    </table>		       	
		        </td>
		      </tr>
			</table>
		</div>
                          
	</form:form>
<script type="text/javascript">
$(function(){ 
	$("#checkApprovalAll").click(function(){
		if(this.checked==true){
			$("input:.checkbox1").checkCbx(1);
		}else{ 
			$("input:.checkbox1").checkCbx(0);
		}
	});
});

$.fn.checkCbx = function(i){ 
	if(i==1){
		return this.each(function(){ 
			if(this.disabled==false){
				this.checked = true; 
			}
		}); 
	}else{
		return this.each(function(){ 
			if(this.disabled==false){
				this.checked = false;
			}
		});
	}
};


function batchOperate(type, approvalState){
	var rowCount = document.getElementById("ec_table").rows.length-2;
	var userIdArr = '';
	if(rowCount>0){
		for(var i=1; i<=rowCount; i++){
			if(document.getElementById(type+'_'+i).checked==true){
				if(i != rowCount){
					userIdArr = userIdArr + document.getElementById(type+'_'+i).value+",";
				}else{
					userIdArr = userIdArr + document.getElementById(type+'_'+i).value;
				}
			}
		}
	}
	if(userIdArr.length==0){
		alert("请选择一条记录！");
		return;
	}else{
		batchApproval(userIdArr, approvalState);			
	}
}

function batchApproval(userIdArr, approvalState){
	var txt = "";
	if(approvalState == 3){
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
			if(approvalState != 3 && (f.alertName=="" || f.alertName==null) ){
				alert("拒绝原因不能为空");
				return ;
			}else{
				var form = document.forms.listForm;
				loading();
				$.post('${ctx}/accApproval/batchApproval.do', {
					'userIdArr' : userIdArr,
					'rejectRemark' : f.alertName,
					'approvalState':approvalState
				}, 
				function(data) {
					if (data.flag == '01') {
						alert("操作成功!");
					}else{
						alert("操作失败!");
					}
					form.action="${ctx}/accApproval/list.do";
					loading();
					form.submit();
				}, 
				"json");
			}	
		}
	});		
}
</script>
  </body>
</html>