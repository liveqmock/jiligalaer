<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>控制板</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/JSCharts/jscharts.js"></script>
<script src="${ctx}/widgets/Highcharts/jquery-1.8.3.js"></script>
<script src="${ctx}/widgets/Highcharts/highcharts.js"></script>
<script src="${ctx}/widgets/Highcharts/exporting.js"></script>
<style type="text/css">
body {
	background-color: #F2F2F2;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
/* 未访问的链接 */
a:link {text-decoration: underline; font-size: 13px;}      
/* 已访问的链接 */
a:visited {text-decoration: underline;; font-size: 13px;}  
/* 当有鼠标悬停在链接上 */
a:hover {color: #FF00FF; text-decoration: underline;; font-size: 13px;}    
/* 被选择的链接 */
a:active {text-decoration: underline;; font-size: 13px;}   

</style>

</head>
  <body>
    <form:form modelAttribute="baseVoList" action="${ctx}/panel/adminPanel.do" method="post" name="listForm">

          <table width="962" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td align="center" bgcolor="#F2F2F2">
              	
                <div id="control_1">
                  <table width="264" height="193" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="133" height="33"><img src="${ctx}/images/control_title_1.png" alt="" width="112" height="29" /></td>
                      <td colspan="2"></td>
                    </tr>
                    <tr>
                      <td rowspan="4" align="center" valign="bottom"><img src="${ctx}/images/control_ico_1.png" width="97" height="127" /></td>
                      <td colspan="2" height="30"></td>
                    </tr>
                    <tr>
                      <td align="right" height="50" width="42" class="f12_4" >总计:</td>
                      <td align="left" class="f12_4">&nbsp;<a href="#" class="f14b2">${totalVm }</a>台</td>
                    </tr>
                    <tr>
                      <td align="right" height="40" class="f12_4">正式:</td>
                      <td align="left" class="f12_4">&nbsp;<a href="#" class="f14b2">${zsVmCount }</a>台</td>
                    </tr>
                    <tr>
                      <td align="right" height="40" class="f12_4">试用:</td>
                      <td align="left" class="f12_4">&nbsp;<a href="#" class="f14b2">${csVmCount }</a>台</td>
                    </tr>
                  </table>
                </div>
                <div id="control_1">
                  <table width="264" height="193" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="133" height="33"><img src="${ctx}/images/control_title_2.png" alt="" width="112" height="29" /></td>
                      <td colspan="2"></td>
                    </tr>
                    <tr>
                      <td rowspan="4" align="center" valign="bottom"><img src="${ctx}/images/user_account.png" width="89" height="88" /></td>
                      <td colspan="2" height="30"></td>
                    </tr>
                    <tr>
                      <td align="right" height="50" width="42" class="f12_4" >总计:</td>
                      <td align="left" class="f12_4">&nbsp;<a href="${ctx}/account/list.do" class="f14b2">${totalAccount}</a>个</td>
                    </tr>
                    <tr>
                      <td align="right" height="40" class="f12_4">正式:</td>
                      <td align="left" class="f12_4">&nbsp;<a href="${ctx}/account/list.do" class="f14b2">${zhengshiAccount}</a>个</td>
                    </tr>
                    <tr>
                      <td align="right" height="40" class="f12_4">试用:</td>
                      <td align="left" class="f12_4">&nbsp;<a href="${ctx}/account/list.do" class="f14b2">${shiyongAccount}</a>个</td>
                    </tr>
                  </table>
                </div>
                <div id="control_1">
                  <table width="264" height="193" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="110" height="33"><img src="${ctx}/images/control_title_3.png" alt="" width="110" height="29" /></td>
                      <td colspan="2"></td>
                    </tr>
                    <tr>
                      <td rowspan="4" align="center" valign="bottom"><img src="${ctx}/images/control_ico_3.png" width="79" height="75" /></td>
                      <td colspan="2" height="55"></td>
                    </tr>
                    <tr>
                      <td align="right" height="40" class="f12_4">余额 :</td>
                      <td align="right" class="f12_4">&nbsp;<a href="${ctx}/balance/list.do" class="f14b2"><fmt:formatNumber pattern="#0.00">${balanceAmount }</fmt:formatNumber></a>元</td>
                    </tr>
                    <tr>
                      <td align="right" height="40" class="f12_4">本月收入:</td>
                      <td align="right" class="f12_4">&nbsp;<a href="${ctx}/accBills/list.do" class="f14b2"><fmt:formatNumber pattern="#0.00">${expAmount }</fmt:formatNumber></a>元</td>
                    </tr>
                    <tr>
                      <td colspan="2" height="25"></td>
                    </tr>
                  </table>
                </div>
                
                
                <div id="control_1">
                  <table width="264" height="193" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="112" height="33"><img src="${ctx}/images/control_title_4.png" alt="" width="112" height="29" /></td>
                      <td colspan="2"></td>
                    </tr>
                    <tr>
                      <td rowspan="4" align="center" valign="bottom"><img src="${ctx}/images/control_ico_4.png" width="57" height="81" /></td>
                      <td colspan="2" height="30"></td>
                    </tr>
                    <tr>
                      <td align="right" height="50" width="100" class="f12_4" >总计:</td>
                      <td align="center" class="f12_4">&nbsp;<a href="${ctx}/accApproval/list.do" class="f14b2">${zsApprovalCount+syApprovalCount }</a>个</td>
                    </tr>
                    <tr>
                      <td align="right" height="40" class="f12_4">正式待审批账户:</td>
                      <td align="center" class="f12_4">&nbsp;<a href="${ctx}/accApproval/list.do" class="f14b2">${zsApprovalCount }</a>个</td>
                    </tr>
                    <tr>
                      <td align="right" height="40" class="f12_4">试用待审批账户:</td>
                      <td align="center" class="f12_4">&nbsp;<a href="${ctx}/accApproval/list.do" class="f14b2">${syApprovalCount }</a>个</td>
                    </tr>
                  </table>
                </div>
                
                <div id="control_2">  
                  <table height="193" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="133" height="33"><img src="${ctx}/images/control_title_5.png" alt="" width="112" height="29" /></td>
                      <td colspan="2" align="left" valign="bottom" class="f12_4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td height="54" colspan="3" align="left" valign="bottom">
                        <input type="hidden" name="totalUserNum" id="totalUserNum" value="${zsApprovalCount+syApprovalCount }">
                        
                        <div id="container" style="min-width: 110px; height: 165px; width: 585px; margin: 0 auto; padding-top: 5px;"></div>
						<script type="text/javascript">
						Highcharts.setOptions({ 
						    colors: ['#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', 
						'#FFF263', '#6AF9C4'] 
						}); 

							$(function() {
								$('#container').highcharts({
									chart : {
										type : 'bar'
									},
									
									title : {
										text : 'Raging Charts'
									},
									xAxis : {
										categories : [ '用户', '账户'],
										title : {
											text : null
										}
									},
									yAxis : {
										min : 0,
										max : 100,
										allowDecimals:false,     //不显示小数
										tickInterval: 5,         //步长
										title : {
											text : '单位（个）',
											align : 'high'
										},
										labels : {
											overflow : 'justify'
										}
									},
									tooltip : {
										valueSuffix : ' 个'
									},
									plotOptions : {
										bar : {
											dataLabels : {
												enabled : true
											}
										}
									},
									legend : {
										layout : 'vertical',
										align : 'right',
										verticalAlign : 'top',
										floating : true,
										borderWidth : 1,
										backgroundColor : '#FFFFFF',
										shadow : true
									},
									credits : {
										enabled : false
									},
									series : [ {
										name : '本月',
										data : [ parseInt('${currMonthUserNum}'), parseInt('${lastMonthUserNum}') ]
									}, {
										name : '上月',
										data : [ parseInt('${currMonthAccountNum}'), parseInt('${lastMonthAccountNum}') ]
									} ]
								});
							});
						</script>
					  </td>
                    </tr>
                  </table>
                </div>
         
                <div id="control_4" align="center"><img src="${ctx}/images/sheet_line_1.jpg" width="900" height="2" /></div>

                <div id="control_3">
                  <table width="900" border="0" cellpadding="0" cellspacing="0">
                  	<tr>
                      <td height="33"><img src="${ctx}/images/control_title_6.png" alt="" width="112" height="29" /></td>
                    </tr>

				<c:forEach items="${list }" var="list">
                    <tr>
                      <td width="900" height="104" background="${ctx}/images/control_bg_02.jpg">
                      
						<table width="900" height="55" border="0" >
						  <tr>
						    <td width="200" rowspan="3" class="f12_1" style="padding-left: 10px;">区域：${list.key }</td>
						    <td width="140" height="20" align="left" valign="middle" class="f13_4">内存</td>
						    <td width="140" height="20" align="left" valign="middle" class="f13_4">CPU</td>
						    <td width="140" height="20" align="left" valign="middle" class="f13_4">存储</td>
						    <td width="140" height="20" align="left" valign="middle" class="f13_4">IP</td>
						  </tr>
						  <tr>
							  <c:forEach items="${list.value }" var="item">
								  	<c:if test="${item.type == '0' }">
									  	<td width="140" height="20" align="left" valign="middle" class="f12_1">
									   		<fmt:formatNumber pattern="#0">${item.capacityused/1073741824 }</fmt:formatNumber>GHZ / <fmt:formatNumber pattern="#0">${item.capacitytotal/1073741824 }</fmt:formatNumber>GHZ
									  	</td>
									</c:if>
								  	<c:if test="${item.type == '1' }">
									    <td width="140" height="20" align="left" valign="middle" class="f12_1">
									    	<fmt:formatNumber pattern="#0">${item.capacityused/1024 }</fmt:formatNumber>GB / <fmt:formatNumber pattern="#0">${item.capacitytotal/1024 }</fmt:formatNumber>GB</td>
									</c:if>
								  	<c:if test="${item.type == '2' }">
									    <td width="140" height="20" align="left" valign="middle" class="f12_1">
									    	<fmt:formatNumber pattern="#0">${item.capacityused/1073741824 }</fmt:formatNumber>TB /<fmt:formatNumber pattern="#0">${item.capacitytotal/1073741824 }</fmt:formatNumber>TB</td>
									</c:if>
									<c:choose>
										<c:when test="${item.cloudMdmZone.networkType == 'Basic' }">
										  	<c:if test="${item.type == '8' }">
											    <td width="140" height="20" align="left" valign="middle" class="f12_1">${item.capacityused }个 / ${item.capacitytotal }个</td>
											</c:if>											
										</c:when>
										<c:otherwise>
										  	<c:if test="${item.type == '4' }">
											    <td width="140" height="20" align="left" valign="middle" class="f12_1">${item.capacityused }个 / ${item.capacitytotal }个</td>
											</c:if>											
										</c:otherwise>
									</c:choose>
							  </c:forEach>
						  </tr>
						  <tr>
							  <c:forEach items="${list.value }" var="item">
							  	<c:if test="${item.type == '0' }">
								    <td width="140" height="15" align="left" valign="middle">
										<div style="width: 120px; height: 15px; background: #fff; border: solid 1px #0187A4; text-align: left;">
											<div style="width: ${item.percentused }%; height: 15px; background: #0187A4; text-align: center; line-height: 15px;" class="f12_1">${item.percentused }%</div>
										</div>
									</td>
								</c:if>
							  	<c:if test="${item.type == '1' }">
								    <td width="140" height="15" align="left" valign="middle">
										<div style="width: 120px; height: 15px; background: #fff; border: solid 1px #0187A4; text-align: left;">
											<div style="width: ${item.percentused }%; height: 15px; background: #0187A4; text-align: center; line-height: 15px;" class="f12_1">${item.percentused }%</div>
										</div>
									</td>
								</c:if>
							  	<c:if test="${item.type == '2' }">
								    <td width="140" height="15" align="left" valign="middle">
										<div style="width: 120px; height: 15px; background: #fff; border: solid 1px #0187A4; text-align: left;">
											<div style="width: ${item.percentused }%; height: 15px; background: #0187A4; text-align: center; line-height: 15px;" class="f12_1">${item.percentused }%</div>
										</div>
									</td>
								</c:if>

								<c:choose>
									<c:when test="${item.cloudMdmZone.networkType == 'Basic' }">
									  	<c:if test="${item.type == '8' }">
										    <td width="140" height="15" align="left" valign="middle">
												<div style="width: 120px; height: 15px; background: #fff; border: solid 1px #0187A4; text-align: left;">
													<div style="width: ${item.percentused }%; height: 15px; background: #0187A4; text-align: center; line-height: 15px;" class="f12_1">${item.percentused }%</div>
												</div>
											</td>
										</c:if>											
									</c:when>
									<c:otherwise>
									  	<c:if test="${item.type == '4' }">
										    <td width="140" height="15" align="left" valign="middle">
												<div style="width: 120px; height: 15px; background: #fff; border: solid 1px #0187A4; text-align: left;">
													<div style="width: ${item.percentused }%; height: 15px; background: #0187A4; text-align: center; line-height: 15px;" class="f12_1">${item.percentused }%</div>
												</div>
											</td>
										</c:if>											
									</c:otherwise>
								</c:choose>
							  </c:forEach>
							<%--
						    <td width="140" height="15" align="left" valign="middle">
								<div style="width: 120px; height: 15px; background: #fff; border: solid 1px #0187A4; text-align: left;">
									<div style="width: 10%; height: 15px; background: #0187A4; text-align: center; line-height: 15px;" class="f12_1">10%</div>
								</div>
							</td>
						    <td width="140" height="15" align="left" valign="middle">
								<div style="width: 120px; height: 15px; background: #fff; border: solid 1px #0187A4; text-align: left;">
									<div style="width: 10%; height: 15px; background: #0187A4; text-align: center; line-height: 15px;" class="f12_1">10%</div>
								</div>
							</td>
						    <td width="140" height="15" align="left" valign="middle">
								<div style="width: 120px; height: 15px; background: #fff; border: solid 1px #0187A4; text-align: left;">
									<div style="width: 10%; height: 15px; background: #0187A4; text-align: center; line-height: 15px;" class="f12_1">10%</div>
								</div>
							</td>
							--%>
						  </tr>
						</table>
						
                      </td>
                    </tr>
                    <tr>
                      <td height="10"></td>
                    </tr>
				</c:forEach>
			
                  </table>
                </div>
                
                <div id="control_4" align="center"><img src="${ctx}/images/sheet_line_1.jpg" width="900" height="2" /></div>
         
                <div id="control_3">
                  <table width="264" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="133" height="33"><img src="${ctx}/images/control_title_7.png" alt="" width="99" height="26" /></td>
                      <td align="right" class="f13_4"><a href="${ctx}/noticeMessages/list.do">更多</a>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="3" align="left" valign="top">
                      	<table width="264" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                          <tr bgcolor="#92b8c1" height="20">
                            <td width="13%" align="center" class="f12">序号</td>
                            <td width="30%" align="center" class="f12">日期</td>
                            <td width="57%" align="center" class="f12">内容</td>
                          </tr>
                        </table>
                        
                        <table width="264" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                          <%int i=0; %>
                          <c:forEach var="item" items="${messList}" varStatus="rowCount" >
					        <%
					        String bgcolor="#eef6f7";
					        if(i++ % 2 == 0){bgcolor="#deecef"; }
					        %>
					        <c:if test="${rowCount.index < 5 }">
	                          <tr bgcolor="<%=bgcolor %>" height="20">
	                            <td width="13%" align="center" class="f12_1"><%=i %></td>
	                            <td width="30%" align="center" class="f12_1">
	                            	<fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd"/>
	                            </td>
	                            <td width="57%" align="left" class="f12_1" title="${item.content }">
									${fn:substring(item.messTitle,0,10) }
								</td>
	                          </tr>
	                        </c:if>
	                      </c:forEach>
	                    </table>
	                      
                      </td>
                    </tr>
                  </table>
                </div>
                <div id="control_3" style="height: 180px;">
                  <table width="264" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="133" height="33"><img src="${ctx}/images/control_title_8.png" alt="" width="99" height="26" /></td>
                      <td align="right" class="f13_4"><a href="${ctx}/warning/myWarning.do">更多</a>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="3" align="left" valign="top">
                      	<table width="264" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                          <tr bgcolor="#92b8c1" height="20">
                            <td width="13%" align="center" class="f12">序号</td>
                            <td width="30%" align="center" class="f12">日期</td>
                            <td width="57%" align="center" class="f12">内容</td>
                          </tr>
						</table>
						
                        <table width="264" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                          <%int m=0; %>
                          <c:forEach var="item" items="${eventList}" varStatus="rowCount" >
					        <%
					        String bgcolor="#eef6f7";
					        if(m++ % 2 == 0){bgcolor="#deecef"; }
					        %>
					        <c:if test="${rowCount.index < 5 }">
	                          <tr bgcolor="<%=bgcolor %>" height="20">
	                            <td width="13%" align="center" class="f12_1"><%=m %></td>
	                            <td width="30%" align="center" class="f12_1">
	                            	<fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd"/>
	                            </td>
	                            <td width="57%" align="left" class="f12_1" title="${item.description }">
									${fn:substring(item.description,0,20) }
								</td>
	                          </tr>
	                        </c:if>
	                      </c:forEach>
                        </table>
                        
                      </td>
                    </tr>
                  </table>
                </div>
                <div id="control_3" style="padding-bottom: 15px;">
                  <table width="264" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="133" height="33"><img src="${ctx}/images/control_title_9.png" alt="" width="99" height="26" /></td>
                      <td align="right" class="f13_4"><a href="${ctx}/remind/myRemind.do">更多</a>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="3" align="left" valign="top">
                      	<table width="264" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                          <tr bgcolor="#92b8c1" height="20">
                            <td width="13%" align="center" class="f12">序号</td>
                            <td width="30%" align="center" class="f12">日期</td>
                            <td width="57%" align="center" class="f12">内容</td>
                          </tr>
                        </table>
                        
                        <table width="264" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                          <%int n=0; %>
                          <c:forEach var="item" items="${remindList}" varStatus="rowCount" >
					        <%
					        String bgcolor="#eef6f7";
					        if(n++ % 2 == 0){bgcolor="#deecef"; }
					        %>
					        <c:if test="${rowCount.index < 5 }">
	                          <tr bgcolor="<%=bgcolor %>" height="20">
	                            <td width="13%" align="center" class="f12_1"><%=n %></td>
	                            <td width="30%" align="center" class="f12_1">
	                            	<fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd"/>
	                            </td>
	                            <td width="57%" align="left" class="f12_1" title="${item.message }">
									${fn:substring(item.message,0,10) }
								</td>
	                          </tr>
	                        </c:if>
	                      </c:forEach>
                        </table>
                        
                      </td>
                    </tr>
                  </table>
                </div>
                    
              </td>
            </tr>
          </table>
                   
	</form:form>
  </body>
</html>