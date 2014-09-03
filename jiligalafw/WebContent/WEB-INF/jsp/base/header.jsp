<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
    <script>
    
    function openlink(nav,id,param){
    	if(id != 'swManagement' && id != 'rptManagement'){
        	param = param || '';
        	$("div",$("#menu")).removeClass("navSelected");
        	$(nav).addClass("navSelected");
        	document.getElementById("mainForm").src="${ctx}/main/display.do?navResId="+id+param;    		
    	}
    }
    
    $(document).ready(function(){
    	var tar = "${uri}";
    	if(!tar){
    		$("div",$("#menu")).eq(0).click();    		
    	}else{
    		var nav = $("#${CURRENT_NAV_ID}");
    		openlink(nav,'${CURRENT_NAV_ID}','&uri=${uri}&_queryString=${_queryString}'); 
    	}
    });
    
    function menuBgover(nav){
    	//$(nav).addClass("navSelected");
    }    
    function menuBgout(nav){
    	//$("div",$("#menu")).removeClass("navSelected");
    }
    function myInfo(userFlag){
    	if(userFlag == '0'){
    		window.location="${ctx}/index/admin/edit.do?id=${_user.userId}";
    	}else if(userFlag == '1'){
    		window.openwindow("${ctx}/account/accountDetailInfo.do", "账户信息", 984, 668);
    	}else{
    		window.openwindow("${ctx}/user/userDetailInfo.do", "用户信息", 984, 568);
    	}
    }
    function accountUpgrade(userId){
    	window.openwindow("${ctx}/account/upgradeAccountRedirect.do?userId="+userId, "账户升级",584,468);
    	
    }
	//回退身份
    function identityBack(){
    	var form = document.forms.headForm;
    	form.actionType.value="";
    	form.action="${ctx}/login/identitySwitch.do";
    	form.submit();
    }
	//管理员切换身份到账户
    function identitySwitch(userId){
    	var form = document.forms.headForm;
    	form.actionType.value="1";
    	form.userId.value=userId;
    	form.action="${ctx}/login/identitySwitch.do";
    	form.submit();
    }
    </script>
	
	<style>
	.nav{
		cursor:pointer;
		font-size:15px;
		color:white;
		display:inline;
		width: 85px;
		height: 34px;
		line-height:34px;
		float: left;
		text-align: center;
		vertical-align: middle;
		font-family:"微软雅黑";
	}
	
	.navSelected{
		background-image: url("${ctx}/images/menu_2.jpg");
		background-repeat: no-repeat;
	}

	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		margin: 0px;
		padding: 0px;
		border: 0px;
	}
	form {
		margin: 0px;
		padding: 0px;
		border: 0px;
	}
	</style>
	
	<form action="${ctx}/header/display.do" method="post" name="headForm" id="headForm" >
		<input type="hidden" name="userId" id="userId" value="${parent_user.userId }" />
		<input type="hidden" name="actionType" id="actionType" value="" />
	</form>
	
	<!-- header -->
	<div id="header">
		<img src="${ctx}/images/head.jpg"/>
		<div class="f13_2" id="header_link" align="right">
			<c:if test="${parent_user != null }">
				<a href="javascript:identityBack();" class="f13">切换到${parent_user.userName }</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
			</c:if>
			欢迎 
			<a href="javascript:myInfo('${userFlag }')" class="f13">${_user.userName}</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<c:if test="${userFlag == 1 }">
				<c:if test="${user.userTypeDictItem.itemCode == 'shiyong' }">
					<a href="javascript:accountUpgrade('${user.userId }')" class="f13">升级</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				</c:if>
				<span class="f13" style="color: #C0C0C0;">充值</span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
			</c:if>
			<!--<a href="#" class="f13">设置</a>&nbsp;&nbsp;| &nbsp;&nbsp; -->
			<a href="${ctx}/login/logout.do" class="f13">退出</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
			<a href="#" class="f13">帮助</a> 
	  </div>
	</div>
	
    <div id="menu">
		<c:forEach items="${headerVo.resources}" var="res">
			  
			  <c:if test="${CURRENT_NAV_ID == res.resId}">
			  	<c:set var="navSelected" value="navSelected" />
			  </c:if>
			  <c:if test="${CURRENT_NAV_ID != res.resId}">
			  	<c:set var="navSelected" value="" />
			  </c:if>
			  
			  <div class="nav ${navSelected}" id="${res.resId}" onclick="openlink(this,'${res.resId}')" onmouseover="menuBgover(this)" onmouseout="menuBgout(this)">
				<span style="margin-left:8px; float: left;min-width:60px;width:60px;">${res.resName}</span>
				<span id="menuline" style="background-image: url('${ctx}/images/menu_line.jpg'); float:right; width:2px; height:34px;"></span>
			  </div>
		</c:forEach>
    </div>