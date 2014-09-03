<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>提醒信息</title>
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<link href="${ctx}/css/table.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<style type="text/css">
body {
	margin-left: 10px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">
function open_high() {
	document.getElementById('search').style.display = 'block';
	document.getElementById('openSearch').style.display = 'none';
}
function close_high() {
	document.getElementById('search').style.display = 'none';
	document.getElementById('openSearch').style.display = 'block';
}
//高级查询
function query(val) {
	var form = document.forms.listForm;
	form.queryType.value=val;
	form.action="${ctx}/accInfo/remindInfo.do";
	loading();
	form.submit();
}

//日期查询
function dateQuery(val){
	var form = document.forms.listForm;
	form.queryType.value='0';
	form.timeFlag.value=val;
	form.action="${ctx}/accInfo/remindInfo.do";
	loading();
	form.submit();
}
function display() {
	var queryType = '${queryType}';
	if (queryType == '1') {
		open_high();
	}
}
</script>
</head>
<body onLoad="display();">
  <form:form modelAttribute="baseVoList" action="${ctx}/accInfo/remindInfo.do" method="post" name="listForm">
	<input type="hidden" name="timeFlag" value="" id="timeFlag" />
	<input type="hidden" name="queryType" value="" id="queryType" />
	<input type="hidden" name="userId" value="${userId }" id="userId" />
	
	<table width="806" border="0" cellspacing="0" cellpadding="0">
			
      	  <tr>
        	<td align="left" valign="top">
        	  <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#a0a0a0">
                   	<tr height="20" bgcolor="#ffffff" >
                      	  <td>
                       		<table width="100%" border="0" cellspacing="1" cellpadding="0">
                          	  <tr height="30">
                          		<td></td>
                          		<!-- 这里2个宽度需要设置，否则查询条件会移动 -->
                            	<td width="80" class="f13_1" align="left">日期：</td>
                            	<td width="690">
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
                          	  
                           <tr height="30" style="cursor:pointer;" onclick="open_high()">
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
                                 
                                      <tr height="30">
                                    	<td width="30">&nbsp;</td>
                                       	<td width="80" align="left" class="f13_1" >日期：</td>
                                       	<td align="left" class="f13_1">
                                       		从<input name="dateS" type="text" value="${dateS }" onfocus="WdatePicker()" readonly class="date_but"/>
                   	                    	到<input name="dateE" type="text" value="${dateE }" onfocus="WdatePicker()" readonly class="date_but"/>
                                       	</td>
                                      </tr>
                                      <tr height="30">
                                   		<td width="30">&nbsp;</td>
                                      	<td class="f13_1" align="left">关键字：</td>
                                      	<td align="left">
                                        	<input type="text" name="keyword" value="${keyword }"/>
                                      	</td>
                                      </tr>
                                      <tr height="50">
                                     	<td width="30">&nbsp;</td>
                                        <td colspan="2" align="left"  valign="middle">
                                        	<a href="javascript:void(0)"><img src="${ctx}/images/btns2.png" alt="提交" onclick="query('1')" width="101" height="29" border="0"/></a>
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
  	
	  			  <tr><td height="20"></td></tr>

				  <tr>
				    <td align="left" valign="top">
				      <table width="788" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
				        <tr bgcolor="#92b8c1" height="20">
				          <td width="5%" align="center" class="f12">序号</td>
				          <td width="12%" align="center" class="f12">日期</td>
				          <td width="83%" align="center" class="f12">内容</td>
				        </tr>
				      </table>
				      	  
				      <div id="order" style="height:400px; z-index:1; overflow-y: scroll; overflow-x:hidden; ">   
					      <table width="788" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
			
						  	<%int j=0; %>
							<c:forEach var="item" items="${remindList}" >
					        <%
					        String bgcolor="#eef6f7";
					        if(j++ % 2 == 0){bgcolor="#deecef"; }
					        %>
					         <tr bgcolor="<%=bgcolor %>" height="20" valign="top">
					            <td width="5%" align="center" class="f12_1"><%=j %></td>
					            <td width="12%" align="center" class="f12_1">
					            	<fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd" />
					            </td>
					            <td width="83%" align="left" class="f12_1" title="">${item.message }</td>
					          </tr>
				          	</c:forEach>
				          	
					       </table>
				      </div>
				    </td>
				  </tr>
			</table>

  </form:form>
</body>
</html>