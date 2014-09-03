<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/commons/meta.jsp"%>
<title>资源管理</title>
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
function doQuery(){
	loading();
	document.forms.listForm.submit();
}
function doCreate(){
	//window.open("${ctx}/index/resource/edit.do");
	window.location="${ctx}/resource/edit.do";
}
function doEdit(id){
	window.location="${ctx}/resource/edit.do?id="+id;
}
function doRemove(id){
	if(!confirm('确认移除该记录?')){
		return;
	}
	window.location="${ctx}/resource/delete.do?id="+id;
}
</script>

</head>
<body>

	<form:form modelAttribute="basicResourceVoList" action="${ctx}/resource/list.do" method="post" name="listForm">

        <!-- 外层边框 -->
		<div id="middle_sheet_s">
			<table width="950" border="0" cellpadding="0" cellspacing="0" align="center">
		      <tr>
		        <td align="center" valign="top" bgcolor="#F2F2F2">
		       	
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
									<tr height="30px">
										<td width="2%"></td>
										<td width="12%" class="f13_1" align="right">上级资源名称：</td>
										<td align="left">
											<form:querylike path="parentRes.resName"/>
										</td>										
										<td width="12%" class="f13_1" align="right">资源名称：</td>
										<td align="left">
											<form:querylike path="resName"/>
										</td>
										<td align="right">
											<img src="${ctx}/images/btn15.png" alt="查找" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:doQuery();"/>
											<img src="${ctx}/images/btn20.png" alt="添加资源" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:doCreate();"/>
											&nbsp;&nbsp;
										</td>
									</tr>
									<tr height="30px">
										<td width="2%"></td>
										<td width="12%" class="f13_1" align="right">地址：</td>
										<td align="left">
											<form:querylike path="resUrl"/>
										</td>
										<td width="12%" class="f13_1" align="right">资源分类：</td>
										<td align="left">
											<form:querylike path="resType_itemName"/>
										</td>
										<td></td>
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

							<ec:table items="list" var="item" onInvokeAction="doQuery()" form="listForm"
						        retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%;" tableId="${tableId}"
							    action="${ctx}/resource/list.do" showPagination="true" cellspacing="1">
								<ec:row>
									<ec:column property="_rowNumber" title="序号" cell="rowNumber"  style="width: 5%; text-align: center;"/>
									
									<ec:column property="resType.itemName" title="资源分类"  style="width: 10%; text-align: left;"/>
									<ec:column property="resName" title="资源名称"  style="width: 10%; text-align: left;"/>
									<ec:column property="parentRes.resName" title="上级资源名称"  style="width: 10%; text-align: left;"/>
									<ec:column property="resUrl" title="资源地址"  style="width: 14%; text-align: left;"/>
									<ec:column property="createdBy" title="创建人"  style="width: 9%; text-align: left;"/>
									<ec:column property="created" title="创建时间" cell="date" format="yyyy-MM-dd" style="width: 9%; text-align: center;"/>
									<ec:column property="updatedBy" title="更新人"  style="width: 9%; text-align: left;"/>
									<ec:column property="updated" title="修改时间" cell="date" format="yyyy-MM-dd" style="width: 9%; text-align: center;"/>
									<ec:column property="null" width="1%" title="操作" sortable="false" viewsAllowed="html"  style="width: 10%; text-align: center;">
										<center>
											<input  type="button" class="btn_bg" value="修 改" onclick="doEdit('${item.resId}')"/>
											<input  type="button" class="btn_bg" value="删 除" onclick="doRemove('${item.resId}')"/>
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