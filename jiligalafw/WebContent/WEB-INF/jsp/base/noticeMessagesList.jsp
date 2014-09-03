<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的公告</title>
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
	background-color: #F2F2F2;
	margin-left: 5px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script type="text/javascript">
function doQuery(val){
	var form = document.forms.listForm;
	form.queryType.value=val;
	loading();
	document.forms.listForm.submit();
}
//日期查询
function dateQuery(val){
	var form = document.forms.listForm;
	form.queryType.value='0';
	form.timeFlag.value=val;
	loading();
	form.submit();
}

function create(){
	//openwindow("${ctx}/index/noticeMessages/edit.do","add", "1024","668");
	window.location="${ctx}/noticeMessages/edit.do";
}

function edit(id){
	//openwindow("${ctx}/index/noticeMessages/edit.do?id="+id,"edit", "1024","668");
	window.location="${ctx}/noticeMessages/edit.do?id="+id;
}

function remove(id){
	window.location="${ctx}/noticeMessages/delete.do?id="+id;
}

function open_high(){
	document.getElementById('search').style.display='block';
	document.getElementById('openSearch').style.display='none';
}
function close_high(){
	document.getElementById('search').style.display='none';
	document.getElementById('openSearch').style.display='block';
}
function display(){
	var queryType = '${queryType}';
	if(queryType == '1'){
		open_high();
	}
}
</script>

</head>
	<body onLoad="display();">
    <form:form modelAttribute="noticeMessagesVoList" action="${ctx}/noticeMessages/list.do" method="post" name="listForm">
		<input type="hidden" name="timeFlag" value="" id="timeFlag" />
		<input type="hidden" name="queryType" value="" id="queryType" />
		
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
                              	  <tr height="30">
                              		<td></td>
                              		<!-- 这里2个宽度需要设置，否则查询条件会移动 -->
                                	<td width="80" class="f13_1" align="left">日期：</td>
                                	<td width="580" valign="middle">
										<a href="javascript:dateQuery('')" class="f13_3">全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('1')" class="f13_3">今日</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('2')" class="f13_3">本周</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('3')" class="f13_3">上周</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('4')" class="f13_3">本月</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('5')" class="f13_3">上月</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:dateQuery('6')" class="f13_3">其它</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                	</td>
                                	<td valign="middle">
                                		<c:if test="${userFlag==0 }">
	                            	      <img src="${ctx}/images/btn19.png" alt="发布公告" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="create();"/>
                                		  &nbsp;&nbsp;
                                		</c:if>
                                	</td>
                              	  </tr>
                              	  
	                              <tr height="25" style="cursor:pointer;" onclick="open_high()">
	                              	<td></td>
	                                <td colspan="2" align="left" class="f15">
	                                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	                                	  <tr>
		                                  	<td width="20" align="left"><img src="${ctx}/images/ico14.png" width="20" height="20" /></td>
		                                  	<td width="80" align="center">高级搜索</td>
		                                  	<td width="20" align="left"><img style="display:none" id="openSearch" src="${ctx}/images/ico15.png" width="20" height="20" /></td>
		                                  	<td>&nbsp;</td>
		                                  <tr>
	                                	</table>
	                                </td>
	                                <td></td>
	                              </tr>
	                              
                              	  <tr>
                              		<td width="15"></td>
                              		<td colspan="2">
                              	  		<table width="100%" border="0" cellspacing="1" cellpadding="0" id="search" style="display:none;">
                                   	  	  <tr>
                                   	        <td colspan="3" align="left" valign="top">
                                   	        	<hr style="border: 1px dashed #ccc; width: 100%; height:1px;" />
                                   	        </td>
                                          </tr>
                                     
                                          <tr height="25">
                                        	<td width="30">&nbsp;</td>
                                           	<td width="80" align="left" class="f13_1" >日期：</td>
                                           	<td align="left" class="f13_1">
                                           		从<input name="dateS" type="text" value="${dateS }" onfocus="WdatePicker()" readonly class="date_but"/>
                       	                    	到<input name="dateE" type="text" value="${dateE }" onfocus="WdatePicker()" readonly class="date_but"/>
                                           	</td>
                                          </tr>
                                          <tr height="25">
                                       		<td width="30">&nbsp;</td>
                                          	<td class="f13_1" align="left">关键字：</td>
                                          	<td align="left">
                                            	<input type="text" name="content" value="${content }">
                                          	</td>
                                          </tr>
                                          <tr height="50">
                                         	<td width="30">&nbsp;</td>
                                            <td colspan="2" align="left"  valign="middle">
                                            	<a href="javascript:void(0)"><img src="${ctx}/images/btns2.png" alt="提交" onclick="doQuery('1')" width="101" height="29" border="0"/></a>
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
                	
                      <tr>
						<td align="left" valign="top">                

		                   	<ec:table items="list" var="item" onInvokeAction="query()" form="listForm"
						        retrieveRowsCallback="limit" sortRowsCallback="limit" sortable="false" style="width:100%" tableId="${tableId}"
							    action="${ctx}/noticeMessages/list.do" showPagination="true" cellspacing="1">
								<ec:row>
									<ec:column property="_rowNumber" title="序号" cell="rowNumber" style="width:5%; text-align:center; "/>
									
									<ec:column property="messTitle" title="主题" style="width:30%; text-align: left;"/>
									<ec:column property="content" title="内容" style="width:50%; text-align: left;"/>
									<ec:column property="created" title="日期" cell="date" format="yyyy-MM-dd" style="width:10%; text-align: center;"/>
									<c:if test="${userFlag=='0' }">
										<ec:column property="null" width="5%" title="操作" sortable="false" viewsAllowed="html">
											<center>
												<input  type="button" class="btn_bg" value="修改" onclick="edit('${item.messId}')"/>
												<input  type="button" class="btn_bg" value="删除" onclick="remove('${item.messId}')"/>
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