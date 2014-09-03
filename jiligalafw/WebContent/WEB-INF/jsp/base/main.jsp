<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/table.css">
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/basic.js"></script>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script>
function openurl(nav,id){
	$("div",$("#middle_sheet_name")).removeClass("navSelected").addClass("navUnselect");
	$(nav).removeClass("navUnselect");
	$(nav).addClass("navSelected");
	document.getElementById("innerMainForm").src="${ctx}/main/openResource.do?id="+id;
	
}
</script>

<style>
body {
	margin:0px auto;
	width:1024px;
	background-image:url(../images/middle_bg.jpg);
	background-repeat:repeat;
	background-position:left;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.nav2{
	cursor:pointer;
	font-size:12px;
	color:black;
	display:inline;
	width: 108px;
	height: 23px;
	float: left;
	text-align: center;
	vertical-align: middle;
	font-family:"微软雅黑";
	margin-left: 5px;
}

.navSelected{
	background-image: url("${ctx}/images/nav_menu_1_s.png");
	background-repeat: no-repeat;
	color:white;
}

.navUnselect{
	background-image: url("${ctx}/images/nav_menu_1.png");
	background-repeat: no-repeat;
}
</style>

<!-- middle -->
<div id="middle_bg">
  <div id="middle_sheet">
  	
  	<!-- 二级导航 -->
  	<c:choose>
  		<c:when test="${mainVo.hasSuvNav}">
  			<div id="middle_sheet_name">
		  	<c:forEach items="${mainVo.svbResources}" var="res">
				<div id="${res.resId}" class="nav2 navUnselect" onclick="openurl(this,'${res.resId}')" >
					<span style="line-height: 22px; letter-spacing: 1px;">${res.resName}</span>
				</div>
			</c:forEach>
		    </div>
		    <script type="text/javascript">
			    $(document).ready(function(){
			    	var tar = "${param.uri}";
			    	if(!tar){
			    		$("div",$("#middle_sheet_name")).eq(0).click(); 		
			    	}else{
			    		$("div",$("#middle_sheet_name")).removeClass("navSelected").addClass("navUnselect");
			    		var nav = $("#${CURRENT_SUBNAV_ID}");
			    		nav.removeClass("navUnselect");
			    		nav.addClass("navSelected");
			    		document.getElementById("innerMainForm").src="${ctx}${param.uri}?${param._queryString}";
			    	}
			    	
			    });
  			</script>
  		</c:when>
  		<c:otherwise>
  			<script type="text/javascript">
  				$(document).ready(function(){
  					var tar = "${param.uri}";
  					document.getElementById("middle_sheet_content").style.display="none";
  					document.getElementById("noNav").style.display="block";
			    	if(!tar){
	  					document.getElementById("noNavMainForm").src="${ctx}/${mainVo.resource.resUrl}";
			    	}else{
			    		document.getElementById("noNavMainForm").src="${ctx}${param.uri}?${param._queryString}";
			    	}
  				});
  			</script>
  		</c:otherwise>
  	</c:choose>
  	
    <div id="noNav" style="display: none;">
    	<iframe name="noNavMain" id="noNavMainForm" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
    </div>
    
    <!-- 外层边框 -->
    <div id="middle_sheet_content">
      <table width="980" border="0" cellpadding="0" cellspacing="0" id="tableId" height="450">
        <tr>
          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_1.png" width="9" height="9" /></td>
          <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_2.png"></td>
          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_3.png" width="9" height="9" /></td>
        </tr>
        
        <tr>
          <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_4.png"></td>
          <td align="center" valign="top" bgcolor="#F2F2F2">

            <!-- 功能页面 -->
            <iframe name="innerMain" id="innerMainForm" frameborder="0" scrolling="no" width="100%"  height="450"></iframe>
          </td>
          <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_5.png"></td>
        </tr>
        
        <tr>
          <td align="left" valign="top"><img src="${ctx}/images/sheet_border_6.png" width="9" height="9" /></td>
          <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_7.png"></td>
          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_8.png" width="9" height="9" /></td>
        </tr>
      </table>
    </div>
  </div>
</div>