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
<script type="text/javascript">
	function linkVm(){
		window.parent.parent.parent.parent.location="${ctx}/index/myVm/list.do";
	} 
</script>

</head>
  <body>
    <form:form modelAttribute="baseVoList" action="${ctx}/panel/accountPanel.do" method="post" name="listForm">

          <table width="962" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td align="center" bgcolor="#F2F2F2">
              	<!-- 当前登录人为账户时才显示 -->
              	<c:if test="${userFlag != '2' }">
	                <div id="control_1">
	                  <table width="264" height="193" border="0" cellpadding="0" cellspacing="0">
	                    <tr>
	                      <td width="112" height="33"><img src="${ctx}/images/control_title_1.png" alt="" width="112" height="29" /></td>
	                      <td colspan="2"></td>
	                    </tr>
	                    <tr>
	                      <td rowspan="4" align="center" valign="bottom"><img src="${ctx}/images/control_ico_1.png" width="97" height="127" /></td>
	                      <td colspan="2" height="30"></td>
	                    </tr>
	                    <tr>
	                      <td align="right" height="50" width="70" class="f12_4" >总计:</td>
	                      <td align="left" class="f12_4">&nbsp;<a href="${ctx}/myVm/list.do" class="f14b2">${totalVm }</a> 台</td>
	                    </tr>
	                    <tr>
	                      <td align="right" height="40" class="f12_4">运行中:</td>
	                      <td align="left" class="f12_4">&nbsp;<a href="${ctx}/myVm/list.do" class="f14b2">${runVm }</a> 台</td>
	                    </tr>
	                    <tr>
	                      <td align="right" height="40" class="f12_4">已停止:</td>
	                      <td align="left" class="f12_4">&nbsp;<a href="${ctx}/myVm/list.do" class="f14b2">${stopVm }</a> 台</td>
	                    </tr>
	                  </table>
	                </div>
	                <div id="control_1">
	                  <table width="264" height="193" border="0" cellpadding="0" cellspacing="0">
	                    <tr>
	                      <td width="133" height="33"><img src="${ctx}/images/control_title_11.png" alt="" width="112" height="29" /></td>
	                      <td colspan="2"></td>
	                    </tr>
	                    <tr>
	                      <td rowspan="4" align="center" valign="bottom"><img src="${ctx}/images/control_ico_5.png" width="113" height="77" /></td>
	                      <td colspan="2" height="55"></td>
	                    </tr>
	                    <tr>
	                      <td align="right" height="40" class="f12_4">存储:</td>
	                      <td align="left" class="f12_4">&nbsp;<a href="" class="f14b2">${storageSize/1024/1024/1024 }</a> GB</td>
	                    </tr>
	                    <tr>
	                      <td align="right" height="40" class="f12_4">IP:</td>
	                      <td align="left" class="f12_4">&nbsp;<a href="" class="f14b2">${ipCount }</a> 个</td>
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
	                      <td align="right" class="f12_4">&nbsp;<a href="${ctx}/onlinePay/list.do" class="f14b2"><fmt:formatNumber pattern="#0.00">${balanceAmount }</fmt:formatNumber></a> 元</td>
	                    </tr>
	                    <tr>
	                      <td align="right" height="40" class="f12_4">本月费用:</td>
	                      <td align="right" class="f12_4">&nbsp;<a href="${ctx}/bill/myBill.do" class="f14b2"><fmt:formatNumber pattern="#0.00">${expAmount }</fmt:formatNumber></a> 元</td>
	                    </tr>
	                    <tr>
	                      <td colspan="2" height="25"></td>
	                    </tr>
	                  </table>
	                </div>
	                
	                <div id="control_1">
	                  <table width="264" height="193" border="0" cellpadding="0" cellspacing="0">
	                    <tr>
	                      <td width="133" height="33"><img src="${ctx}/images/control_title_12.png" alt="" width="112" height="29" /></td>
	                      <td colspan="2"></td>
	                    </tr>
	                    <tr>
	                      <td align="right" height="40" class="f12_4"></td>
	                      <td align="left" class="f12_4"></td>
	                    </tr>                    
	                    <tr>
	                      <td rowspan="4" align="center" valign="bottom"><img src="${ctx}/images/user_account.png" width="89" height="88" /></td>
	                      <td colspan="2" height="30"></td>
	                    </tr>
	                    <tr>
	                      <td align="right" height="50" width="80" class="f12_4" >总计:</td>
	                      <td align="left" class="f12_4"><a href="${ctx }/user/list.do" class="f14b2">${totalUser}</a> 个</td>
	                    </tr>
	                    <%--
	                    <tr>
	                      <td align="right" height="40" class="f12_4">待审批资源:</td>
	                      <td align="left" class="f12_4"><a href="${ctx }/resourcesApproval/list.do" class="f14b2">${approvalRes }</a> 条</td>
	                    </tr>
	                    --%>
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
	                      <td align="center" class="f12_4">&nbsp;<a href="${ctx}/userApproval/list.do" class="f14b2">${approvalCount+approvalRes }</a> 个</td>
	                    </tr>
	                    <tr>
	                      <td align="right" height="40" class="f12_4">待审批用户:</td>
	                      <td align="center"" class="f12_4">&nbsp;<a href="${ctx}/userApproval/list.do" class="f14b2">${approvalCount }</a> 个</td>
	                    </tr>
	                    <tr>
	                      <td align="right" height="40" class="f12_4">待审批资源:</td>
	                      <td align="center" class="f12_4"><a href="${ctx }/resourcesApproval/list.do" class="f14b2">${approvalRes }</a> 个</td>
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
								                      
	                        <div id="container_amount" style="min-width: 110px; height: 165px; width: 270px; margin: 0 auto; padding-top: 5px;"></div>
							<script type="text/javascript">
								Highcharts.setOptions({ 
								    colors: ['#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', 
								'#FFF263', '#6AF9C4'] 
								}); 
	
								$(function() {
									$('#container_amount').highcharts({
										chart : {
											type : 'bar'
										},
										
										title : {
											text : 'Raging Charts'
										},
										//subtitle: {
										//    text: '瑞云'
										//},
										xAxis : {
											categories : [ '扣<br/>费'],
											title : {
												text : null
											}
										},
										yAxis : {
											min : 0,
											max : 100000,
											tickInterval: 10000,         //步长
											title : {
												text : '单位（元）',
												align : 'high'
											},
											labels : {
												overflow : 'justify'
											}
										},
										tooltip : {
											valueSuffix : ' 元'
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
											//x : -40,
											//y : 100,
											floating : true,
											borderWidth : 1,
											//width: 100,
											//heigth: 300,
											backgroundColor : '#FFFFFF',
											shadow : true
										},
										credits : {
											enabled : false
										},
										series : [ {
											name : '本月',
											data : [ parseInt('${currUserAmount}') ]
										}, {
											name : '上月',
											data : [ parseInt('${lastUserAmount}') ]
										} ]
									});
								});
							</script>
						  </td>
	                    </tr>
	                  </table>
	                </div>
	         
	                <div id="control_4" align="center"><img src="${ctx}/images/sheet_line_1.jpg" width="900" height="2" /></div>
                </c:if>
                
                <div id="control_3" style="width: 406px;">
                  <table width="900" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td height="33"><img src="${ctx}/images/control_title_7.png" alt="" width="99" height="26" /></td>
                      <td align="right" class="f13_4"><a href="${ctx}/promotion/promotionInfo.do">更多</a>&nbsp;&nbsp;</td>
                    </tr>                  
                    <tr valign="top">
                      <td colspan="2" width="900" background="${ctx}/images/control_bg_02.jpg">
                      	<table width="900" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                          <tr bgcolor="#92b8c1" height="20" valign="top">
                            <td width="5%" align="center" class="f12">序号</td>
                            <td width="15%" align="center" class="f12">市场活动类型</td>
                            <td width="20%" align="center" class="f12">市场活动名称</td>
                            <td width="15%" align="center" class="f12">开始时间</td>
                            <td width="15%" align="center" class="f12">结束时间</td>
                            <td width="10%" align="center" class="f12">返利方式</td>
                            <td width="10%" align="center" class="f12">返利额度</td>
                            <td width="10%" align="center" class="f12">条件（满）</td>
                          </tr>
                        </table>

                        <table width="900" border="0" cellspacing="1" cellpadding="1" bgcolor="#F2F2F2">
						    <%int j=0; %>
                            <c:forEach var="item" items="${promList}" varStatus="rowCount" >
					        <%
					        String bgcolor="#eef6f7";
					        if(j++ % 2 == 0){bgcolor="#deecef"; }
					        %>
							<c:if test="${rowCount.index < 5 }">
	                          <tr bgcolor="<%=bgcolor %>" height="20" valign="top">
	                            <td width="5%" align="center" class="f12_1"><%=j %></td>
	                            <td width="15%" align="left" class="f12_1">${item.basicPromotionType.itemName }</td>
	                            <td width="20%" align="left" class="f12_1">${item.activityName }</td>
	                            <td width="15%" align="center" class="f12_1"><fmt:formatDate value="${item.startDate }" pattern="yyyy-MM-dd"/></td>
	                            <td width="15%" align="center" class="f12_1"><fmt:formatDate value="${item.endDate }" pattern="yyyy-MM-dd"/></td>
	                            <td width="10%" align="left" class="f12_1">
	                            	<c:if test="${item.rebateFlag=='1' }">比例</c:if>
	                            	<c:if test="${item.rebateFlag=='2' }">金额</c:if>
	                            </td>
	                            <td width="10%" align="right"" class="f12_1">
	                            	<c:choose>
	                            		<c:when test="${item.rebateFlag=='1' }">${item.rebateAmount/100 }%</c:when>
	                            		<c:otherwise>${item.rebateAmount }</c:otherwise>
	                            	</c:choose>
	                            </td>
	                            <td width="10%" align="right" class="f12_1">${item.rebateThresholdValue }</td>
	                          </tr>
	                        </c:if>
	                        
                            </c:forEach>
                        </table>
                          
                      </td>
                    </tr>
                  </table>
                </div>
                
                <div id="control_4" align="center"><img src="${ctx}/images/sheet_line_1.jpg" width="900" height="2" /></div>
         
                <div id="control_3" style="width: 406px;">
                  <table width="396" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="133" height="33"><img src="${ctx}/images/control_title_7.png" alt="" width="99" height="26" /></td>
                      <td align="right" class="f13_4"><a href="${ctx}/noticeMessages/list.do">更多</a>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="3" align="left" valign="top">
                      	<table width="396" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                          <tr bgcolor="#92b8c1" height="20">
                            <td width="10%" align="center" class="f12">序号</td>
                            <td width="20%" align="center" class="f12">日期</td>
                            <td width="70%" align="center" class="f12">内容</td>
                          </tr>
                        </table>
                        
                        <!--<marquee height="120" scrollamount="1" direction="down" onmouseout="start()" onmouseover="stop()"> -->
                        <table width="396" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                            <%int i=0; %>
                            <c:forEach var="item" items="${messList}" varStatus="rowCount" >
					          <%
					          String bgcolor="#eef6f7";
					          if(i++ % 2 == 0){bgcolor="#deecef"; }
					          %>
					          <c:if test="${rowCount.index < 5 }">
		                          <tr bgcolor="<%=bgcolor %>" height="20">
		                            <td width="10%" align="center" class="f12_1"><%=i %></td>
		                            <td width="20%" align="center" class="f12_1">
		                            	<fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd"/>
		                            </td>
		                            <td width="70%" align="left" class="f12_1" title="${item.content }">
										${fn:substring(item.messTitle,0,25) }
									</td>
		                          </tr>
		                      </c:if>
	                        </c:forEach>
                          </table>
                        <!--</marquee>-->
                      </td>
                    </tr>
                  </table>
                </div>

                <div id="control_3" style="width: 406px;float: right;margin-right: 30px;">
                  <table width="396" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="133" height="33"><img src="${ctx}/images/control_title_9.png" alt="" width="99" height="26" /></td>
                      <td align="right" class="f13_4"><a href="${ctx}/remind/myRemind.do">更多</a>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="3" align="left" valign="top">
                      	
                      	<table width="396" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
                          <tr bgcolor="#92b8c1" height="20">
                            <td width="10%" align="center" class="f12">序号</td>
                            <td width="20%" align="center" class="f12">日期</td>
                            <td width="70%" align="center" class="f12">内容</td>
                          </tr>
                        </table>
                        
                        <!--
                        <marquee height="120" scrollamount="1" direction="down" onmouseout="start()" onmouseover="stop()">
                        -->
                          <%int n=0; %>
                          <c:forEach var="item" items="${remindList}" varStatus="rowCount" >
					        <%
					        String bgcolor="#eef6f7";
					        if(n++ % 2 == 0){bgcolor="#deecef"; }
					        %>
					        <c:if test="${rowCount.index < 5 }">
					        <table width="396" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee">
	                          <tr bgcolor="<%=bgcolor %>" height="20">
	                            <td width="10%" align="center" class="f12_1"><%=n %></td>
	                            <td width="20%" align="center" class="f12_1">
	                            	<fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd"/>
	                            </td>
	                            <td width="70%" align="left" class="f12_1" title="${item.message }">
	                            	${fn:substring(item.message,0,25) }
	                            </td>
	                          </tr>
	                        </table>
	                        </c:if>
	                      </c:forEach>
	                    <!--</marquee>-->
                        
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