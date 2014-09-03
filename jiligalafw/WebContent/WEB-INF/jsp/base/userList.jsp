<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>用户信息</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	background-color: #F2F2F2;
	margin-left: 5px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
	function doQuery(queryType) {
		loading();
		document.getElementById('queryType').value = queryType;
		document.forms.listForm.submit();
	}
	function add(){
		var form = document.forms.listForm;
		form.action = "${ctx}/user/edit.do";
		form.submit();
	}
	function roleTypeQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '0';
		form.roleFlag.value = val;
		form.action = "${ctx}/user/list.do";
		loading();
		form.submit();
	}
	function stateQuery(val) {
		var form = document.forms.listForm;
		form.queryType.value = '1';
		form.stateFlag.value = val;
		form.action = "${ctx}/user/list.do";
		loading();
		form.submit();
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
	function checkRoleBox(){
		var roleStr = '${roleStr}';
		var sts = roleStr.split(",");
		var st = document.getElementsByName("role");
		for(var i=0;i<st.length;i++){
			for(var j=0;j<sts.length;j++){
	   			if(st[i].value==sts[j]){
	    			st[i].checked=true;
	 			}
			}
		}
	}
	function open_high() {
		document.getElementById('search').style.display = 'block';
		document.getElementById('openSearch').style.display = 'none';
	}
	function close_high() {
		document.getElementById('search').style.display = 'none';
		document.getElementById('openSearch').style.display = 'block';
	}
	function display() {
		var queryType = '${queryType}';
		if (queryType == '2') {
			open_high();
		}
	}

	function gotoInvitation(userFlag) {
		openwindow("${ctx}/base/userRegister/gotoInvitation.do?userFlag="+userFlag, "发送邀请", 928,468);
	}
	function doEdit(id){
		window.location="${ctx}/user/edit.do?id="+id;
	}
	function doAdd(){
		window.location="${ctx}/user/edit.do";
	}
	
	function doControlPanel(id){
		window.open("${ctx}/index/panel/accountPanel.do?id="+id);
	}	
</script>

</head>
<body onLoad="checkbox();checkRoleBox();display();">

	<form:form modelAttribute="basicUserVoList" action="${ctx}/user/list.do" method="post" name="listForm">
		<input type="hidden"  name="roleFlag" value="" id="roleFlag" />
		<input type="hidden"  name="stateFlag" value="" id="stateFlag" />
		<input type="hidden"  name="queryType" value="" id="queryType" />

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
									<tr height="25">
										<td></td>
										<td width="80" class="f13_1" align="left">状态：</td>
										<td >
											<a href="javascript:stateQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;
										    <a href="javascript:stateQuery('1')" class="f13_3">未激活</a>&nbsp;&nbsp;
										    <a href="javascript:stateQuery('2')" class="f13_3">待审批</a>&nbsp;&nbsp;
											<a href="javascript:stateQuery('3')" class="f13_3">审批通过</a>&nbsp;&nbsp;
											<a href="javascript:stateQuery('0')" class="f13_3">停用</a>&nbsp;&nbsp;
											<a href="javascript:stateQuery('-1')" class="f13_3">注销</a>
										</td>
										<td width="340" height="25" align="right" valign="middle">
										  <c:if test="${user.userFlag != 0 }">
											<img src="${ctx}/images/btn23.png" alt="添加用户" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:doAdd();"/>
											<img src="${ctx}/images/btn24.png" alt="邀请用户" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:gotoInvitation('2');"/>
											<img src="${ctx}/images/btn25.png" alt="邀请账户" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:gotoInvitation('1');"/>				
											&nbsp;&nbsp;
										  </c:if>
										</td>
									</tr>
									<tr height="25">
										<td></td>
										<td width="80" class="f13_1" align="left">角色类型：</td>
										<td>
										 	<a href="javascript:roleTypeQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;
										 	<c:forEach var="item" items="${roleList}" varStatus="status" >
												<a href="javascript:roleTypeQuery('${item.roleId}')" class="f13_3">${item.roleName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
											</c:forEach>
										</td>
										<td></td>
									</tr>

									<!-- 高级搜索 -->
									<tr height="25" style="cursor: pointer;" onclick="open_high()">
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
											<table width="100%" border="0" cellspacing="1" cellpadding="0" id="search" style="display: none">
	                                     	  	<tr>
	                                     	        <td colspan="3" align="left" valign="top">
	                                     	        	<hr style="border: 1px dashed #ccc; width: 100%; height:1px;" />
	                                     	        </td>
	                                            </tr>

												<tr height="25">
													<td width="30">&nbsp;</td>
													<td class="f13_1" align="left">状态：</td>
													<td class="f13_3"><input type="checkbox"
														name="checkall" id="checkall"
														onclick="checkAll('checkall','state')"
														style="vertical-align: middle; margin-top: 0px;" />全部&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="checkbox" name="state" id="state"
														value="1"
														style="vertical-align: middle; margin-top: 0px;" />未激活&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="checkbox" name="state" id="state"
														value="2"
														style="vertical-align: middle; margin-top: 0px;" />待审批&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="checkbox" name="state" id="state"
														value="3"
														style="vertical-align: middle; margin-top: 0px;" />审批通过&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="checkbox" name="state" id="state"
														value="0"
														style="vertical-align: middle; margin-top: 0px;" />停用&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="checkbox" name="state" id="state"
														value="-1"
														style="vertical-align: middle; margin-top: 0px;" />注销&nbsp;&nbsp;&nbsp;&nbsp;
													</td>
												</tr>
												<tr height="25">
													<td width="30">&nbsp;</td>
													<td class="f13_1" align="left">用户角色：</td>
													<td class="f13_3"><input type="checkbox"
														name="checkRoleAll" id="checkRoleAll"
														onclick="checkAll('checkRoleAll','role')"
														style="vertical-align: middle; margin-top: 0px;" name="role" id="role"/>全部&nbsp;&nbsp;&nbsp;&nbsp;
														 <c:forEach var="item" items="${roleList}" varStatus="status" >
														<input type="checkbox" name="role" id="role"
														value="${item.roleId}"
														style="vertical-align: middle; margin-top: 0px;" />${item.roleName}&nbsp;&nbsp;&nbsp;&nbsp;
														</c:forEach>
													</td>
												</tr>
												<tr height="25">
													<td width="30">&nbsp;</td>
													<td class="f13_1" align="left">姓名：</td>
													<td align="left"><form:querylike path="userName" /></td>
												</tr>
												<tr height="25">
													<td width="30">&nbsp;</td>
													<td class="f13_1" align="left">用户名：</td>
													<td align="left"><form:querylike path="userAccount" /></td>
												</tr>
												<tr height="25">
													<td width="30">&nbsp;</td>
													<td class="f13_1" align="left">联系电话：</td>
													<td align="left"><form:querylike path="tel" /></td>
												</tr>

												<tr height="50">
													<td width="30">&nbsp;</td>
													<td colspan="2" align="left" valign="middle"><a
														href="javascript:void(0)"><img
															src="${ctx}/images/btns2.png" alt="提交"
															onclick="doQuery('2')" width="101" height="29"
															border="0" /></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
														href="javascript:void(0)"><img
															src="${ctx}/images/btnc1.png" alt="重置"
															onclick="document.forms.listForm.reset();return false;"
															width="101" height="30" border="0" /></a></td>
												</tr>
												<tr valign="bottom">
													<td colspan="3" align="center"><img
														src="${ctx}/images/close.png" width="80" height="18"
														border="0" style="cursor: pointer;"
														onclick="close_high()" /></td>
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
		              
					  <tr><td height="20" align="right"></td></tr>
					  
                      <tr>
						<td align="left" valign="top">
						
						<ec:table items="list" var="item" onInvokeAction="doQuery('${queryType }')" form="listForm"
							retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%" tableId="${tableId}"
							action="${ctx}/user/list.do" showPagination="true" cellspacing="1">
							
							<ec:exportXls fileName="用户信息.xls" tooltip="导出Excel" view="xls" />
							
								<ec:row>
									<ec:column property="_rowNumber" title="序号" cell="rowNumber" style="text-align:center; width:5%"/>
							       	<ec:column property="userAccount" title="用户名" style="width:24%; text-align: left;">
							       	    <!-- 管理员在账户管理下查看用户时:不可编辑 -->
										<c:choose>
											<c:when test="${user.userFlag != 0 }">
												<div style="text-decoration:underline;cursor:pointer" onclick="doEdit('${item.userId}')">
													${item.userAccount}
												</div>
											</c:when>
											<c:otherwise>
												${item.userAccount}
											</c:otherwise>
										</c:choose>
							       	</ec:column>
									<ec:column property="userName" title="姓名" style="width:15%; text-align: left;">
										<!-- 管理员在账户管理下查看用户时:不可编辑 -->
										<c:choose>
											<c:when test="${user.userFlag != 0 }">
												<div style="text-decoration:underline;cursor:pointer" onclick="doEdit('${item.userId}')">
													${item.userName}
												</div>
											</c:when>
											<c:otherwise>
												${item.userName}
											</c:otherwise>
										</c:choose>
									</ec:column>
							       	<ec:column property="tel" title="联系电话" style="width:10%; text-align: right;"/>
							       	<ec:column property="registerDate" title="注册日期" cell="date" format="yyyy-MM-dd" style="width:10%; text-align: center;" />
							       	<ec:column property="birthDate" title="出生日期" cell="date" format="yyyy-MM-dd" style="width:10%; text-align: center;"/>
							      	<ec:column property="stateName" title="状态" style="width:10%; text-align: center;" />

							   		<ec:column property="roleNames" title="角色" style="width:6%; text-align: left;"/>
							   		<c:if test="${user.userFlag != 0 }">
								   		<ec:column property="null" title="操作" sortable="false" style="width:10%; text-align: center;" viewsAllowed="html">
											<!--
											<c:if test="${item.state==3 }">
												<input type="button" value="控制板" onclick="doControlPanel('${item.userId}');" class="btn_bg" style="width: 50px;" />
											</c:if>
											-->
										    <c:if test="${ item.state==0 ||   item.state==-1 ||  item.state==3}">
										    	<c:if test="${ item.state==0 ||   item.state==-1}" >
											        <input type="button" value="激活" onclick="activation('2','${ item.userId}')" class="btn_bg" style="width: 40px;" />
											    </c:if>
											    <c:if test="${ item.state==3}" >
													<input type="button" value="停用" onclick="stopUser('${item.userId}');" class="btn_bg" style="width: 40px;" />
											    </c:if>
											</c:if>
											<c:if test="${item.state==1}">
												<input type="button" value="发送激活邮件" onclick="reSendEmail('2','${item.userId}')" class="btn_bg" style="width: 90px;" />
											</c:if>
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
	<script type="text/javascript">
	function activation(flag,userId){
		var form = document.forms.listForm;
		if(confirm('确认激活用户?')){
			form.action="${ctx}/user/userActivation.do?userId="+userId+"&flag="+flag;
			loading();
			form.submit();
		}
	}
	function stopUser(userId){
		var form = document.forms.listForm;
		if(confirm('确认停用用户 ?')){
			form.action="${ctx}/user/stopUser.do?userId="+userId+"&userFlag=2";
			loading();
			form.submit();
		}
	}
	function reSendEmail(flag,userId){
		var form = document.forms.listForm;
		if(confirm('确认重新发送邮件至该用户?')){
			form.action="${ctx}/account/reSendEmail.do?userId="+userId+"&flag="+flag;
			loading();
			form.submit();
		}
	}
	</script>
  </body>
</html>
