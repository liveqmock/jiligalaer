<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<script type="text/javascript"
	src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
	<script>
	function openWindow(url, name, iWidth, iHeight) {
		var url; //转向网页的地址;
		var name; //网页名称，可为空;
		var iWidth; //弹出窗口的宽度;
		var iHeight; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		window.open(url,name,'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=yes,resizeable=no,location=no,status=no');
	}
	  function showRoleEdit(roleId){
		  window.open("${ctx}/index/role/edit.do?id="+roleId);
	  }
	</script>
<title></title>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
</head>
<body >
		<table width="696" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
			<c:forEach var="item" items="${roleList}" varStatus="status" >
				<c:choose>
					<c:when test="${ item.isUsed=='check' }">
						<tr bgcolor="#eef6f7" height="20">
							<td width="8%" align="center" class="f12_1">${status.index+1}</td>
							<td width="25%" align="left" class="f12_1"><a
								href="#" onclick="javascript:showRoleEdit(${item.roleId});">${item.roleName}</a></td>
							<td width="10%" align="center" class="f12_1">${item.state =='1'? '有效 ':'无效'} </td>
							<td width="47%" align="left" class="f12_1">${item.description}</td>
							<td width="10%" align="center" class="f12_1"><input
								type="checkbox" name="checkRole" checked="checked"
								value="${item.roleId}" /></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr bgcolor="#eef6f7" height="20">
							<td width="8%" align="center" class="f12_1">${status.index+1}</td>
							<td width="25%" align="left" class="f12_1"><a
								href="#" onclick="javascript:showRoleEdit('${item.roleId}');">${item.roleName}</a></td>
							<td width="10%" align="center" class="f12_1">${item.state =='1'? '有效 ':'无效'}</td>
							<td width="47%" align="left" class="f12_1">${item.description}</td>
							<td width="10%" align="center" class="f12_1"><input
								type="checkbox" name="checkRole" value="${item.roleId}" /></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</table>
</body>
</html>