<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>促销活动维护</title>
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
p {
	font-family: "宋体";
	  font-size: 13px;
	  color: #000000;
}
-->
</style>
<script type="text/javascript">
/**
function doQuery(){
	document.forms.listForm.submit();
}
*/

function doQuery(queryType){
	loading();
	document.getElementById('queryType').value = queryType;
	document.forms.listForm.submit();
}

/** 发布活动 */
function release(){
	var optionStr="<option value='singleActivity'>单一产品活动</option>";
	optionStr +="<option value='combinationActivity'>组合产品活动</option>";
	optionStr +="<option value='firstRechargeActivity'>首次充值礼包</option>";
	optionStr +="<option value='rechargeRebateActivity'>充值返利</option>";
	optionStr +="<option value='recommendationActivity'>推荐返利</option>";
	var txt = '<p style="font-size:14px;color:#1491ad">市场活动类型选择</p><center><p style="line-height:30px">请选择需要建立的市场活动类型 </p><font size="2">活动类型：</font><select name="actType">'+optionStr+'</select></center>';
	$.prompt(txt,{
		buttons: {'确定':1, '取消':3},
		callback: function mycallbackform(v,m,f){
			if(v == 3){
				return ;
			}
			if(f.actType=="" || f.actType==null ){
				alert("请选择市场活动类型！");
				return ;
			}else{
				window.location="${ctx}/promotion/initEdit.do?promotionType="+f.actType;
			}	
		}
	}); 
}

function promotionTypeQuery(val){
	var form = document.forms.listForm;
	form.queryType.value='0';
	form.promotionType.value=val;
	form.action="${ctx}/promotion/list.do";
	loading();
	form.submit();
}

function rebateTypeQuery(val){
	var form = document.forms.listForm;
	form.queryType.value='1';
	form.rebateFlag.value=val;
	form.action="${ctx}/promotion/list.do";
	loading();
	form.submit();
}

function stateQuery(val){
	var form = document.forms.listForm;
	form.queryType.value='2';
	form.stateFlag.value=val;
	form.action="${ctx}/promotion/list.do";
	loading();
	form.submit();
}

function dateQuery(val){
	var form = document.forms.listForm;
	form.queryType.value='3';
	form.timeFlag.value=val;
	form.action="${ctx}/promotion/list.do";
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

function checkAllBox() {

	var chkstate = '${state}';
	var chkPromotionType = '${chkPromotionType}';
	var chkRebate = '${chkRebate}';
	
	if(chkstate !="" || chkstate != undefined){
		var sts = chkstate.split(",");
		var st = document.getElementsByName("state");
		for ( var i = 0; i < st.length; i++) {
			for ( var j = 0; j < sts.length; j++) {
				if (st[i].value == sts[j]) {
					st[i].checked = true;
				}
			}
		}
	}
	
	if(chkPromotionType !="" || chkPromotionType != undefined){
		var sts = chkPromotionType.split(",");
		var st = document.getElementsByName("chkPromotionType");
		for ( var i = 0; i < st.length; i++) {
			for ( var j = 0; j < sts.length; j++) {
				if (st[i].value == sts[j]) {
					st[i].checked = true;
				}
			}
		}
	}
	
	if(chkRebate !="" || chkRebate != undefined){
		var sts = chkRebate.split(",");
		var st = document.getElementsByName("chkRebate");
		for ( var i = 0; i < st.length; i++) {
			for ( var j = 0; j < sts.length; j++) {
				if (st[i].value == sts[j]) {
					st[i].checked = true;
				}
			}
		}
	}
}


$(document).ready(function(){
		if($("#pageFlag").val()=="1"){
			$("#btnAddPromotion").css('display','none');
		}
});

function doEdit(id){
	window.location = "${ctx}/promotion/edit.do?id="+id;
}
function doRemove(id){
	if(!confirm('确认移除该记录?')){
		return;
	}
	window.location="${ctx}/promotion/delete.do?id="+id;
}

</script>

</head>
  <body onLoad="checkAllBox();">
    <form:form modelAttribute="cloudPromotionActivityVoList" action="${ctx}/promotion/list.do" method="post" name="listForm">
		<input type="hidden" name="promotionType" value="" id="promotionType" />
		<input type="hidden" name="rebateFlag" value="" id="rebateFlag" />
		<input type="hidden" name="timeFlag" value="" id="timeFlag" />
		<input type="hidden" name="stateFlag" value="" id="stateFlag" />
		<input type="hidden" name="queryType" value="" id="queryType" />
		<input type="hidden" name="pageFlag" value="${pageFlag}" id="pageFlag" />
		
		
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
                                      <td width="80" class="f13_1" align="left">类型：</td>
                                      <td width="590">
                                         <a href="javascript:promotionTypeQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                         <c:forEach var="item" items="${promotionTypeList}" varStatus="status">
											<a href="javascript:promotionTypeQuery('${item.itemCode}')" class="f13_3">${item.itemName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
					                   	 </c:forEach>
                                      </td>
                                      <td>
                                        <c:if test="${pageFlag != '1'}">
                                        <img src="${ctx}/images/btn17.png" alt="发布活动" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:release();"/>
                                        &nbsp;&nbsp;
                                        </c:if>
                                      </td>
                                    </tr>                               	  	
                                    <tr height="25">
                                  	  <td></td>
                                      <td width="80" class="f13_1" align="left">返利方式：</td>
                                      <td width="590">
                                         <a href="javascript:rebateTypeQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                         <a href="javascript:rebateTypeQuery('1')" class="f13_3">比例</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                         <a href="javascript:rebateTypeQuery('2')" class="f13_3">金额</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                      </td>
                                      <td></td>
                                    </tr>
                                    <tr height="25">
                                  	  <td></td>
                                      <td width="80" class="f13_1" align="left">状态：</td>
                                      <td>
                                         <a href="javascript:stateQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                         <a href="javascript:stateQuery('1')" class="f13_3">活动</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                         <a href="javascript:stateQuery('0')" class="f13_3">停用</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                      </td>
                                      <td></td>
                                    </tr>
                                    <tr height="25">
                                  	  <td></td>
                                      <td width="80" class="f13_1" align="left">活动日期：</td>
                                      <td width="590" >
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
	                                      	<td class="f13_1" align="left">类型：</td>
	                                      	<td class="f13_3" >
	                                         	<input type="checkbox" name="checkallPromotionType" id="checkallPromotionType" onclick="checkAll('checkallPromotionType','chkPromotionType')" style="vertical-align:middle; margin-top:0px;"/>全部&nbsp;&nbsp;&nbsp;&nbsp;
	                                         	<c:forEach var="item" items="${promotionTypeList}" varStatus="status">
													<input type="checkbox" name="chkPromotionType"  value="${item.itemCode}" style="vertical-align: middle; margin-top: 0px;" />${item.itemName}&nbsp;&nbsp;&nbsp;&nbsp;
												</c:forEach>
																		
	                                      	</td>
	                                      </tr>
	                                      <tr height="25">
	                                    	<td width="30">&nbsp;</td>
	                                      	<td class="f13_1" align="left">返利方式：</td>
	                                      	<td class="f13_3" >
	                                         	<input type="checkbox" name="checkallRebate" id="checkallRebate" onclick="checkAll('checkallRebate','chkRebate')" style="vertical-align:middle; margin-top:0px;"/>全部&nbsp;&nbsp;&nbsp;&nbsp;
	                                         	<input type="checkbox" name="chkRebate"  value="1" style="vertical-align:middle; margin-top:0px;"/>比例&nbsp;&nbsp;&nbsp;&nbsp;
	                                         	<input type="checkbox" name="chkRebate"  value="2" style="vertical-align:middle; margin-top:0px;"/>金额&nbsp;&nbsp;&nbsp;&nbsp;
	                                      	</td>
	                                      </tr>
	                                      <tr height="25">
	                                    	<td width="30">&nbsp;</td>
	                                      	<td class="f13_1" align="left">状态：</td>
	                                      	<td class="f13_3" >
	                                         	<input type="checkbox" name="checkallState" id="checkallState" onclick="checkAll('checkallState','state')" style="vertical-align:middle; margin-top:0px;"/>全部&nbsp;&nbsp;&nbsp;&nbsp;
	                                         	<input type="checkbox" name="state" id="state" value="1" style="vertical-align:middle; margin-top:0px;"/>活动&nbsp;&nbsp;&nbsp;&nbsp;
	                                         	<input type="checkbox" name="state" id="state" value="0" style="vertical-align:middle; margin-top:0px;"/>停用&nbsp;&nbsp;&nbsp;&nbsp;
	                                      	</td>
	                                      </tr>
                                          <tr height="25">
                                       		<td width="30">&nbsp;</td>
                                         	<td class="f13_1" align="left">活动名称：</td>
                                          	<td align="left">
                                          		&nbsp;<form:querylike path="activityName" style="width:220px"/> 
											</td>
                                          </tr>
                                          <tr height="25">
                                       		<td width="30">&nbsp;</td>
                                          	<td class="f13_1" align="left">开始日期：</td>
                                          	<td align="left" class="f13_1">
                                          		&nbsp;<input name="startDateS" type="text" value="${startDateS}" onfocus="WdatePicker()" readonly class="date_but"/>
                      	                    	至&nbsp;<input name="startDateE" type="text" value="${startDateE}" onfocus="WdatePicker()" readonly class="date_but"/>
                                          	</td>
                                          </tr>
                                          <tr height="25">
                                       		<td width="30">&nbsp;</td>
                                          	<td class="f13_1" align="left">结束日期：</td>
                                          	<td align="left" class="f13_1">
                                          		&nbsp;<input name="endDateS" type="text" value="${endDateS}" onfocus="WdatePicker()" readonly class="date_but"/>
                      	                    	至&nbsp;<input name="endDateE" type="text" value="${endDateE}" onfocus="WdatePicker()" readonly class="date_but"/>
                                          	</td>
                                          </tr>
                                          <tr height="50">
                                        	<td width="30">&nbsp;</td>
                                           	<td colspan="2" align="left"  valign="middle">
	                                           	<a href="javascript:void(0)"><img src="${ctx}/images/btns2.png" alt="提交" onclick="doQuery('5')" width="101" height="29" border="0"/></a>
	                                           	&nbsp;&nbsp;&nbsp;&nbsp;
	                                           	<a href="javascript:void(0)"><img src="${ctx}/images/btnc1.png" alt="重置" onclick="document.forms.listForm.reset();" width="101" height="30" border="0"/></a>
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
							<ec:table items="list" var="item" onInvokeAction="doQuery('${queryType }')" form="listForm"
						        retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%;" tableId="${tableId}"
							    action="${ctx}/promotion/list.do" showPagination="true" cellspacing="1">
								<ec:row>
									<ec:column property="_rowNumber" title="序号" cell="rowNumber" style="text-align:center; width: 5%; "/>	
									<ec:column property="basicPromotionType.itemName" title="活动类型" style="text-align:center; width: 10%; "/>
									<ec:column property="activityName" title="活动名称" style="text-align:left; width: 20%; "/>
									<ec:column property="startDate" title="开始时间" cell="date" format="yyyy-MM-dd" style="text-align:center;width:10%"/>
									<ec:column property="endDate" title="结束时间" cell="date" format="yyyy-MM-dd" style="text-align:center;width:10%"/>
									<ec:column property="rebateFlag" value="${item.rebateFlag==1 ?'比例':'金额'}" title="返利方式" style="text-align:center;width:10%"/>
									<ec:column property="rebateAmount"  title="返利额度" style="text-align:right;width:10%">
										<c:choose>
											<c:when test="${item.rebateFlag==1 }">
												返：${item.rebateAmount} %
											</c:when>
											<c:otherwise>
												返：${item.rebateAmount} 元
											</c:otherwise>
										</c:choose>
									</ec:column>
									<ec:column property="rebateThresholdValue" title="返利条件" style="text-align:left;width:10%">
										<c:choose>
											<c:when test="${item.rebateThresholdValue!=null }">
												满：${item.rebateThresholdValue} 元
											</c:when>
										</c:choose>
									</ec:column>
									<ec:column property="state" title="状态" value="${item.state == 0 ? '停用' : '启用'}" style="text-align:center;width:5%" />
									<c:if test="${pageFlag != '1'}">
										<ec:column property="null" width="1%" title="操作" sortable="false" viewsAllowed="html"  style="width: 10%; text-align: center;">
											<center>
												<input  type="button" class="btn_bg" value="修 改" onclick="doEdit('${item.promotionId}')"/>
												<input  type="button" class="btn_bg" value="删 除" onclick="doRemove('${item.promotionId}')"/>
											</center>
										</ec:column>
									</c:if>
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