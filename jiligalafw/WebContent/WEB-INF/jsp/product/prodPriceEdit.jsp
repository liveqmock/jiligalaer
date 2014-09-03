<%@ include file="/commons/taglibs.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品管理-产品定价</title>
<link href="css/css_main.css" rel="stylesheet" />
<link href="css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/autoheight.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
<!--
body {
	background-color: #ffffff;
	margin-left: 10px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<%@ include file="/commons/meta.jsp"%>
<script type="text/javascript">
function back(){
	var form = document.forms.editForm;
	form.action="${ctx}/makePrice/prodList.do";
	form.submit();
}
function doSave(){
	var rowID = parseInt(GetTableRowCount("priceTable"));
	if(rowID < 2){
		alert("没有可保存的价格");
		return;
	}
	
	var priceMode = document.getElementsByName("priceMode");
	var oneTimePrice = document.getElementsByName("oneTimePrice");
	var yearPrice = document.getElementsByName("yearPrice");
	var monthPrice = document.getElementsByName("monthPrice");
	var dayPrice = document.getElementsByName("dayPrice");
	var hourPrice = document.getElementsByName("hourPrice");
	
	var effectiveDate = document.getElementsByName("effectiveDate");
	var invalidDate = document.getElementsByName("invalidDate");
	
	if(priceMode){
		for(var i=0; i<priceMode.length; i++){
			if(i > 0){
				if(priceMode[i].value != priceMode[i-1].value){
					alert("定价方式不一致！");
					return;
				}
			}
		}
		for(var i=0; i<priceMode.length; i++){
			//0：一次性，1：周期性
			if(priceMode[i].value=='0'){
				if(oneTimePrice[i].value == ''){
					//alert("请输入价格！");
					//return;
				}
				if(oneTimePrice[i].value != '' && !checkAmount(oneTimePrice[i].value)){
					alert("价格输入不正确！");
					return;
				}
			}else{
				if(yearPrice[i].value == '' || monthPrice[i].value == '' || dayPrice[i].value == '' || hourPrice[i].value == ''){
					//alert("请输入价格！");
					//return;
				}
				if(!checkAmount(yearPrice[i].value) || !checkAmount(monthPrice[i].value) || !checkAmount(dayPrice[i].value) || !checkAmount(hourPrice[i].value)){
					alert("价格输入不正确！");
					return;
				}
			}
			
			if(effectiveDate[i].value==''){
				alert("请选择生效日期！");
				effectiveDate[i].focus();
				return;
			}
			if(invalidDate[i].value==''){
				alert("请选择失效日期！");
				invalidDate[i].focus();
				return;
			}
			if(effectiveDate[i].value > invalidDate[i].value){
				alert("生效日期不能大于失效日期！");
				return;
			}
			
			//验证日期重叠
			if(i > 0){
				if(effectiveDate[i].value <= invalidDate[i-1].value){
					alert("价格日期重叠：第"+(i+1)+"行生效日期不能小于等于第"+i+"行失效日期");
					return;
				}
				if(effectiveDate[i].value != dataAddToStr(invalidDate[i-1].value,1)){
					alert("价格日期不连续：第"+(i+1)+"行生效日期和第"+i+"行失效日期不连续");
					return;
				}
			}
			
		}
	}

	//提交前去除所有disabled，移除disable,后台方可取值
	
	//$("select").attr("disabled", false);
	$(".disabled").each(function() {
        if (parseInt($(this).val()) != -1) {
            $(this).attr("disabled", false);
        }
    });
	
	var form = document.forms.editForm;
	form.action="${ctx}/makePrice/save.do";
	form.submit();
}
</script>
<script type="text/javascript">
var msg = '${saveMsg }';
if(msg != ''){
	alert(msg);
	window.location="${ctx}/makePrice/prodList.do";
}
</script>
</head>
<body>  

  <form:form modelAttribute="cloudMdmProductVoList" action="${ctx}/makePrice/prodList.do" method="post" id="editForm" >
   	  <input type="hidden" name="prodId" id="prodId" value="${prodVo.mdmProduct.id }" />
   	  <input type="hidden" name="prodItemId" id="prodItemId" value="${prodVo.id }" />
   	  <input type="hidden" name="pMode" id="pMode" value="${priceMode }" />
   	  
	  <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr><td height="10" colspan="5"></td></tr>		
        <tr height="30">
          <td width="1%" class="f13_1" align="left"></td>
      	  <td width="20%" class="f13_1" align="left">产品类型：${prodVo.itemTypeName }</td>
          <td width="29%" class="f13_1" align="left" title="${prodVo.mdmProduct.prodName }">
          	产品名称：${fn:substring(prodVo.mdmProduct.prodName,0,30) }
          </td>
          <td width="40%" class="f13_1" align="left" title="${prodVo.mdmProduct.description }">
          	产品描述：${fn:substring(prodVo.mdmProduct.description,0,50) }
          </td>
          <td width="10%" align="right" >
            <img src="${ctx}/images/btn36.png" alt="新增价格" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:AddSignRow()"/>
          </td>
        </tr> 
        
        <tr>
          <td height="2" align="center" valign="middle" colspan="5"><hr /></td>
        </tr>

		<tr>
		  <td align="left" valign="top" colspan="5">
			<fieldset style="text-align: left; width: 98%;">
			    <legend><span class="f14b2">价格列表</span></legend>
	 			<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 10px;">
	                 <tr>
	                   <td align="center" valign="top" colspan="2">
	                   	  
	                  	  <table width="100%" border="0" cellspacing="1" cellpadding="1" bgcolor="#eeeeee" id="priceTable">
							<tr bgcolor="#92b8c1" height="22">
								<td width="10%" align="center" class="f12">序号</td>
								<td width="20%" align="center" class="f12">定价方式</td>
								<c:choose>
									<c:when test="${prodVo.itemType == 'diskSoln' && prodVo.mdmDiskSoln.iscustomized == 'true'}">
										<td width="20%" align="center" class="f12">价格<font style="color: red;">（元/每10G）</font></td>
									</c:when>
									<c:otherwise>
										<td width="20%" align="center" class="f12">价格（元）</td>
									</c:otherwise>								
								</c:choose>
								<td width="20%" align="center" class="f12">生效日期</td>
								<td width="20%" align="center" class="f12">失效日期</td>
								<td width="10%" align="center" class="f12">操作</td>
							</tr>

	                  	    <%int i=0; %>
	                  	    <c:forEach var="item" items="${priceList}" varStatus="status">
						        <%
						        String bgcolor="#deecef";
						        if(i++ % 2 == 0){bgcolor="#eef6f7"; }
						        %>	                  	    								
								<tr style="padding-bottom: 10xp;" bgcolor="<%=bgcolor %>">
									<td align="center" class="f12_1"><%=i %>
										<input type="hidden" name="priceId" value="${item.id }"/>
									</td>
									<td align="center" class="f12_1">
										<select id='priceMode' name='priceMode' disabled="disabled" class="disabled">
											<c:choose>
												<c:when test="${item.priceMode == '0' }">
													<option value="0">一次性定价</option>
												</c:when>
												<c:otherwise>
													<option value='1'>周期性定价</option>
												</c:otherwise>
											</c:choose>										
										</select>
									</td>
									<td align="center" class="f12_1" id="priceTd<%=i %>">
										<c:choose>
											<c:when test="${item.priceMode == '0' }">
												 <input type="text" name="oneTimePrice" id="oneTimePrice" size="7" style="text-align: right;" maxlength="10" value="${item.oneTimePrice }"/>&nbsp;&nbsp;&nbsp;&nbsp;
											</c:when>
											<c:otherwise>
												<input type="text" name="yearPrice" id="yearPrice" size="7" style="text-align: right;" maxlength="10" value="${item.yearPrice }"/>/年</br>
												<input type="text" name="monthPrice" id="monthPrice" size="7" style="text-align: right;" maxlength="10" value="${item.monthPrice }"/>/月</br>
												<input type="text" name="dayPrice" id="dayPrice" size="7" style="text-align: right;" maxlength="10" value="${item.dayPrice }"/>/日</br>
												<input type="text" name="hourPrice" id="hourPrice" size="7" style="text-align: right;" maxlength="10" value="${item.hourPrice }"/>/时
											</c:otherwise>
										</c:choose>
									</td>
									<td align="center" class="f12_1">
										<input type="text" name="effectiveDate" id="effectiveDate" value="${fn:substring(item.effectiveDate,0,10) }" onfocus="WdatePicker()" readonly class="date_but"/>
									</td>
									<td align="center" class="f12_1">
										<input type="text" name="invalidDate" id="invalidDate" value="${fn:substring(item.invalidDate,0,10) }" onfocus="WdatePicker()" readonly class="date_but"/>
									</td>
									<td align="center" class="f12_1"></td>
								</tr>
	                  	    </c:forEach>
	                  	  
					  	  </table>
	                   </td>
	                 </tr>
	            </table>    
	  		</fieldset>
                        
       	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td align="center" valign="bottom" height="50">
              	<a href="javascript:doSave();"><img src="${ctx}/images/btns1.png" alt="保存" width="101" height="30" border="0" /></a>
                &nbsp;&nbsp;&nbsp;
              	<a href="javascript:back();"><img src="${ctx}/images/btn10.png" alt="返回" width="101" height="30" border="0" /></a>
              </td>
            </tr>
          </table>
            
         </td>
       </tr>
     </table>

 </form:form>

<script>

var oneTimePrice = "<input type='text' name='oneTimePrice' id='oneTimePrice' size='7' style='text-align: right;' maxlength='6' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

var cyclePrice = "<input type='text' name='yearPrice' id='yearPrice' size='7' style='text-align: right;' maxlength='6' />/年 <br />";
cyclePrice += "<input type='text' name='monthPrice' id='monthPrice' size='7' style='text-align: right;' maxlength='6' />/月 <br />";
cyclePrice += "<input type='text' name='dayPrice' id='dayPrice' size='7' style='text-align: right;' maxlength='6' />/天  <br />";
cyclePrice += "<input type='text' name='hourPrice' id='hourPrice' size='7' style='text-align: right;' maxlength='6' />/时 <br />";

var priceMode="";
var priceInput="";
if('${priceMode }' == '0'){
	priceMode+="<select id='priceMode' name='priceMode'  disabled='disabled' class='disabled'>";
	priceMode+="<option value='0'>一次性定价</option>";
	priceMode+="</select>";
	
	priceInput = oneTimePrice;
}else if('${priceMode }' == '1'){
	priceMode+="<select id='priceMode' name='priceMode'  disabled='disabled' class='disabled'>";
	priceMode+="<option value='1'>周期性定价</option>";
	priceMode+="</select>";
	
	priceInput = cyclePrice;
}else{
	priceMode=priceMode+"<select id='priceMode' name='priceMode' onchange='changePriceMode(0,this.value)'>";
	priceMode=priceMode+"<option value='1'>周期性定价</option>";
	priceMode=priceMode+"<option value='0'>一次性定价</option>";
	priceMode=priceMode+"</select>";
	
	priceInput = cyclePrice;
}

//获取表行号
function GetTableRowCount(tabId){
	return document.getElementById(tabId).rows.length;
}

function findObj(theObj, theDoc){  
	var p, i, foundObj;    
	if(!theDoc) theDoc = document;  
	if( (p = theObj.indexOf("?")) > 0 && parent.frames.length)  {    
		theDoc = parent.frames[theObj.substring(p+1)].document;    
		theObj = theObj.substring(0,p);  
	}  

	if(!(foundObj = theDoc[theObj]) && theDoc.all) 
		foundObj = theDoc.all[theObj];  

	for (i=0; !foundObj && i < theDoc.forms.length; i++)     
		foundObj = theDoc.forms[i][theObj];  

	for(i=0; !foundObj && theDoc.layers && i < theDoc.layers.length;i++)       
		foundObj = findObj(theObj,theDoc.layers[i].document);  

	if(!foundObj && document.getElementById) 
		foundObj = document.getElementById(theObj);    
	
	return foundObj;
}

//动态添加行
function AddSignRow(){ 
	//获取表行号 
	var rowID = parseInt(GetTableRowCount("priceTable"));
	var signFrame = findObj("priceTable",document);
	
    var bgcolor="#eef6f7";
    if(rowID % 2 == 0){
    	bgcolor="#deecef"; 
    }
    
	//添加行
	var newTR = signFrame.insertRow(signFrame.rows.length);
	newTR.bgColor=bgcolor;
	newTR.style.cssText="padding-bottom: 10xp; "
	newTR.id = "SignItem" + rowID;
	
	//序号
	var rowCountTD=newTR.insertCell(0);
	rowCountTD.className="f12_1";
	rowCountTD.style.cssText="text-align:center;";
	rowCountTD.innerHTML = newTR.rowIndex.toString();
	
	//定价方式
	var priceModeTD=newTR.insertCell(1);
	priceModeTD.className="f12_1";
	priceModeTD.style.cssText="text-align:center;";
	priceModeTD.innerHTML = priceMode;
	
	//价格
	var priceTD=newTR.insertCell(2);
	priceTD.className="f12_1";
	priceTD.style.cssText="text-align:center;";
	priceTD.id="priceTd"+rowID;
	priceTD.innerHTML = priceInput;
	
	//生效时间
	var effectiveDateTD=newTR.insertCell(3);
	effectiveDateTD.className="f12_1";
	effectiveDateTD.style.cssText="text-align:center;";
	var sd = "<input type='text' name='effectiveDate' id='effectiveDate' onfocus='WdatePicker()' readonly='readonly' class='date_but' />";
	effectiveDateTD.innerHTML = sd;

	//失效时间
	var invalidDateTD=newTR.insertCell(4);
	invalidDateTD.className="f12_1";
	invalidDateTD.style.cssText="text-align:center;";
	var ed = "<input type='text' name='invalidDate' id='invalidDate' onfocus='WdatePicker()' readonly='readonly' class='date_but' />";
	invalidDateTD.innerHTML = ed;
	
	//删除
	var newDeleteTD=newTR.insertCell(5);
	newDeleteTD.className="f12_1";
	newDeleteTD.style.cssText="text-align:center;";
	//newDeleteTD.innerHTML = "<a href='javascript:void(0)' onclick=\"DeleteSignRow()\">删除</a></div>";
	
	newDeleteTD.innerHTML = "<input type='button' value='删除' onclick=\"DeleteSignRow()\" class='btn_bg' style='width: 45px;' /></div>";
}

//删除指定行
function DeleteSignRow(){
	var signFrame = findObj("priceTable",document);
	//获取将要删除的行的Index
	var rowIndex = event.srcElement.parentElement.parentElement.rowIndex;
	//删除指定Index的行
	signFrame.deleteRow(rowIndex);
	//重新排列序号，如果没有序号，这一步省略
	for(var i=rowIndex; i<signFrame.rows.length; i++){
		signFrame.rows[i].cells[0].innerHTML = i.toString();
		signFrame.rows[i].cells[2].id = "priceTd"+i.toString();
	}
}

function changePriceMode(rowNum,selVal){
	var signFrame = findObj("priceTable",document);
	var rowIndex = event.srcElement.parentElement.parentElement.rowIndex;
	
	//alert(document.getElementById("priceTd"+rowIndex).innerHTML);
	if(selVal == '0'){
		document.getElementById("priceTd"+rowIndex).innerHTML=oneTimePrice;
	}else{
		document.getElementById("priceTd"+rowIndex).innerHTML=cyclePrice;
	}
}

</script>  
       
</body>
</html>