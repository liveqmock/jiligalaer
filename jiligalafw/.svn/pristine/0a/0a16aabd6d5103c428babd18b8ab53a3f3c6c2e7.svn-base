<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<script type="text/javascript"	src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script>
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
	<form:form modelAttribute="cloudPromotionActivityVoList" action="${ctx}/promotion/combinationProductList.do" method="post" name="listForm">
	  <div id="order" style="height:350px; z-index:1; overflow-y: scroll;overflow-x:hidden;">
		<table width="98%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
          <input type="hidden" name="prodName"  id="prodName" />
          <%int rowNumber=0; %>
          <c:forEach var="item" items="${combProdList}" varStatus="status" >
          		<tr <% if (rowNumber%2 == 0) {%> bgcolor="#EEF6F7" <% } else { %> bgcolor="#DEECEF" <% } %> height="20">
	             <td width="5%" align="center" class="f12_1"><%= ++rowNumber %></td>
	             <td width="20%" align="left" class="f12_1">${item[1]}</td>
	             <td width="15%" align="left" class="f12_1">${item[3]}</td>
	             <td width="6%" align="left" class="f12_1">${item[4]}</td>
	             <td width="6%" align="left" class="f12_1">${item[5]}</td>
	             <td width="20%" align="left" class="f12_1">${item[6]}</td>
	             <td width="18%" align="right" class="f12_1">${item[7]}</td>
	             <td width="5%" align="center" class="f12_1">
		             <c:choose>
						<c:when test="${item[8]=='1' }">
							启用
						</c:when>
						<c:otherwise>
							停用
						</c:otherwise>
					</c:choose>
	             </td>
	             <td width="5%" align="center" class="f12_1">
	             	<c:choose>
						<c:when test="${item[10]=='1'}">
				          	<input type="checkbox" name="checkCombProduct"  value="${item[0]}" checked="checked" />
						</c:when>
						<c:otherwise>
							<input type="checkbox" name="checkCombProduct"  value="${item[0]}" />
						</c:otherwise>
					  </c:choose>
	             </td>
	           </tr>
          </c:forEach>
          
          <!-- <tr bgcolor="#deecef" height="20">
             <td width="5%" align="center" class="f12_1">
             	<input type="checkbox" name="checkProduct" checked="checked" value="1" />
             </td>
             <td width="10%" align="left" class="f12_1">1</td>
             <td width="25%" align="left" class="f12_1">企业标准型虚机</td>
             <td width="10%" align="center" class="f12_1">4核CPU</td>
             <td width="10%" align="center" class="f12_1">80G</td>
             <td width="10%" align="center" class="f12_1">500</td>
             <td width="10%" align="center" class="f12_1">标准模板</td>
             <td width="10%" align="center" class="f12_1">1500元/年</td>
             <td width="10%" align="center" class="f12_1">正常</td>
           </tr> --> 
           
         </table>
	  </div>      
	</form:form>
</body>
</html>