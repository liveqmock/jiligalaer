<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>行业/地区维护</title>
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
function getDictByType(dictType){
	var form = document.forms.listForm;
	$("#dictType").val(dictType);
	loading();
	form.submit();	
}
function doQuery(){
	var form = document.forms.listForm;
	loading();
	form.submit();
}

function add(){
	var optionStr="<option value='industry'>行业</option>";
	optionStr +="<option value='geo'>地区</option>";
	var txt = '<p style="font-size:14px;color:#1491ad">新增信息项</p>'+
		'<left><span style="padding-left:80px;">类型：<select name="dictId" style="width:100px;">'+optionStr+'</select></span>'+
		'<br /><span style="padding-left:80px;">名称：<input type="text" name="itemName" /></span></left>';
	$.prompt(txt,{
		buttons: {'确定':1, '取消':3},
		callback: function mycallbackform(v,m,f){
			if(v == 3){
				return ;
			}
			if(f.itemName=="" || f.itemName==null ){
				alert("请输入名称！");
				return ;
			}else{
				var form = document.forms.listForm;
				$("#itemName").val(f.itemName);
				$("#dictId").val(f.dictId);
				form.action='${ctx}/dictItem/save.do';
				loading();
				form.submit();
			}	
		}
	}); 
}

function edit(dictItemId, dictName, itemName){
	var txt = '<p style="font-size:14px;color:#1491ad">修改信息项</p>'+
		'<left><span style="padding-left:80px;">类型：</font>'+dictName+'</span>'+
		'<br /><span style="padding-left:80px;">名称：<input type="text" name="itemName" value='+itemName+' /></span></left>';
	$.prompt(txt,{
		buttons: {'确定':1, '取消':3},
		callback: function mycallbackform(v,m,f){
			if(v == 3){
				return ;
			}
			if(f.itemName=="" || f.itemName==null ){
				alert("请输入新的名称！");
				return ;
			}else{
				var form = document.forms.listForm;
				$("#itemName").val(f.itemName);
				$("#dictItemId").val(dictItemId);
				form.action='${ctx}/dictItem/save.do';
				loading();
				form.submit();
			}	
		}
	}); 
}

</script>

</head>
	<body>
    <form:form modelAttribute="basicDictItemVoList" action="${ctx}/dictItem/list.do" method="post" name="listForm">
		<input type="hidden" name="dictId" id="dictId" value="" />
		<input type="hidden" name="itemName" id="itemName" value="" />
		<input type="hidden" name="dictType" id="dictType" value="" />
		<input type="hidden" name="dictItemId" id="dictItemId" value="" />
		
        <!-- 外层边框 -->
		<div id="middle_sheet_s">
			<table width="950" height="750" border="0" cellpadding="0" cellspacing="0" align="center">
		      <tr>
		        <td align="center" valign="top" bgcolor="#F2F2F2">
		       	
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
                                   		<td width="10">&nbsp;</td>
                                      	<td width="70" class="f13_1" align="right">类型：</td>
                                      	<td align="left">
                                        	<select name="dictType" onchange="getDictByType(this.value)" style="width:100px;">
                                        		<option value="" <c:if test="${dictType==''}">selected</c:if> >全部</option>
                                        		<option value="geo" <c:if test="${dictType=='geo'}">selected</c:if> >地区</option>
                                        		<option value="industry" <c:if test="${dictType=='industry'}">selected</c:if> >行业</option>
                                        	</select>
                                      	</td>
                                      	<td align="right">
                                      		<input type="button" value="查 询" onclick="javascript:doQuery();" class="btn_bg" style="width: 45px;" />
                                      		<input type="button" value="添 加" onclick="javascript:add();" class="btn_bg" style="width: 45px;" />
                                      		&nbsp;
                                      	</td>
                                      </tr>
                                                                          
                                     <tr height="25">
                                   		<td width="10">&nbsp;</td>
                                      	<td class="f13_1" align="right">名称：</td>
                                      	<td align="left">
                                        	<input type="text" name="keyword" value="${keyword }">
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
                	
                      <tr>
						<td align="left" valign="top">                

		                   	<ec:table items="list" var="item" onInvokeAction="doQuery()" form="listForm"
						        retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%" tableId="${tableId}"
							    action="${ctx}/dictItem/list.do" showPagination="true" cellspacing="1">
								<ec:row>
									<ec:column property="_rowNumber" title="序号" cell="rowNumber" style="width:5%; text-align:center; "/>
									<ec:column property="null" width="1%" title="操作" sortable="false" viewsAllowed="html">
										<center>
											<input  type="button" class="btn_bg" value="修改" onclick="edit('${item.dictItemId}', '${item.basicDict.dictName }', '${item.itemName }')"/>
										</center>
									</ec:column>
									<ec:column property="basicDict.dictName" title="类型" style="width:30%; text-align: left;"/>
									<ec:column property="itemName" title="名称" style="width:30%; text-align: left;"/>
									<ec:column property="created" title="新增日期" cell="date" format="yyyy-MM-dd" style="width:15%; text-align: center;"/>
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