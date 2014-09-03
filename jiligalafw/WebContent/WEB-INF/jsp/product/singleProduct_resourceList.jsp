<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>产品管理-单一产品维护-选择资源主页面</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/autoheight.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	background-color:#000000;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
form{
	margin:0px;
	padding:0px;
}
</style>
<script type="text/javascript">
function selectResource(){

}
function enter(id,prodType){
	//var winObj = window.parent.parent.parent.opener;
	//winObj.selectedProduct(id,prodType);
	//window.parent.parent.close();
}
</script>

</head>
  <body>
    <form:form modelAttribute="baseVoList" action="${ctx}/singleProd/selectResource.do" method="post" name="listForm">
		
      	<table width="962" align="center" border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_1.png" width="9" height="9" /></td>
	          <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_2.png"></td>
	          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_3.png" width="9" height="9" /></td>
	        </tr>          
            <tr>
              <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_4.png"></td>
              <td align="center"  valign="top" bgcolor="#F2F2F2">
                <table border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td height="43" align="left" valign="middle"><span class="f18b2">单一产品 -> 选择资源</span></td>
                    <td align="left" valign="middle">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="5" colspan="2" ></td>
                  </tr>
                  <tr>
                    <td height="2" colspan="2" align="center" valign="middle"><img src="${ctx}/images/sheet_line_2.jpg" width="940" height="2" /></td>
                  </tr>
                  <tr>
                    <td height="5" colspan="2" ></td>
                  </tr>
                  <tr>
                    <td colspan="2" >
                      <div id="middle_sheet_pm_s_name">
                        <a href="javascript:resourceInfo('computResource');"><img src="${ctx}/images/menu_s_15_s.png" border="0" align="absmiddle" id="computResource" /></a>
                        <a href="javascript:resourceInfo('diskResource');"><img src="${ctx}/images/menu_s_16.png" border="0" align="absmiddle" id="diskResource" /></a>
                        <!--
                        <a href="javascript:resourceInfo('basicNet');"><img src="${ctx}/images/menu_s_17.png" border="0" align="absmiddle" id="basicNet" /></a>
                        <a href="javascript:resourceInfo('highNet');"><img src="${ctx}/images/menu_s_18.png" border="0" align="absmiddle" id="highNet" /></a>
                        <a href="javascript:resourceInfo('ipResource');"><img src="${ctx}/images/menu_s_19.png" border="0" align="absmiddle" id="ipResource" /></a>
                        -->                        
                        <a href="javascript:resourceInfo('templateRes');"><img src="${ctx}/images/menu_s_6.jpg" border="0" align="absmiddle" id="templateRes" /></a> 
                        <a href="javascript:resourceInfo('networkSoln');"><img src="${ctx}/images/menu_s_14.png" border="0" align="absmiddle" id="networkSoln" /></a>
                      </div>
                      
						<script type="text/javascript">
						function resourceInfo(url){
							$("#computResource")[0].src="${ctx}/images/menu_s_15.png";
							$("#diskResource")[0].src="${ctx}/images/menu_s_16.png";
							//$("#basicNet")[0].src="${ctx}/images/menu_s_17.png";
							//$("#highNet")[0].src="${ctx}/images/menu_s_18.png";
							//$("#ipResource")[0].src="${ctx}/images/menu_s_19.png";
							$("#templateRes")[0].src="${ctx}/images/menu_s_6.jpg";
							$("#networkSoln")[0].src="${ctx}/images/menu_s_14.png";
							
							var map = getMap(); 
							map.put("computResource","${ctx}/images/menu_s_15_s.png");
							map.put("diskResource","${ctx}/images/menu_s_16_s.png");
							//map.put("basicNet","${ctx}/images/menu_s_17_s.png");
							//map.put("highNet","${ctx}/images/menu_s_18_s.png");
							//map.put("ipResource","${ctx}/images/menu_s_19_s.png");
							map.put("templateRes","${ctx}/images/menu_s_6_s.png");
							map.put("networkSoln","${ctx}/images/menu_s_14_s.png");
							
							$("#"+url)[0].src=map.get(url);
							
							document.getElementById("resourceForm").src="${ctx}/singleProd/"+url+".do";
						}
						</script>	
	                      
                      <div id="middle_sheet_pm_s">
                      	<table width="855" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_1.jpg" width="14" height="14" /></td>
                            <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_2.jpg"></td>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_3.jpg" width="14" height="14" /></td>
                          </tr>
                          <tr>
                            <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_4.jpg"></td>
                            <td align="left" valign="top" bgcolor="#FFFFFF" height="380">
                    			    
                    			<iframe id="resourceForm" name="resourceIframeForm" src="${ctx}/singleProd/computResource.do" frameborder="0" scrolling="no" width="100%" height="480"></iframe>
                    			    
                            </td>
                            <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_5.jpg"></td>
                          </tr>
                          <tr>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_6.jpg" width="14" height="14" /></td>
                            <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_7.jpg"></td>
                            <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_8.jpg" width="14" height="14" /></td>
                          </tr>
                          <tr><td colspan=3 height="10"></td></tr>
                        </table>
                      </div>
                                          	
                    </td>
                  </tr>

                  
                  <tr>
                    <td colspan="2" align="center" valign="middle">
                    	<table width="394" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td align="center" valign="top"><a href="javascript:window.parent.parent.close();"><img src="${ctx}/images/btn8.png" alt="关闭" width="101" height="30" border="0" align="absmiddle"/></a></td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                  
                  <tr>
                    <td height="10" colspan="2" ></td>
                  </tr>
                </table>
              </td>
              <td width="9" align="left" valign="top" background="${ctx}/images/sheet_border_5.png"></td>
            </tr>
	        <tr>
	          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_6.png" width="9" height="9" /></td>
	          <td height="9" align="left" valign="top" background="${ctx}/images/sheet_border_7.png"></td>
	          <td width="9" height="9" align="left" valign="top"><img src="${ctx}/images/sheet_border_8.png" width="9" height="9" /></td>
	        </tr>
          </table>

	</form:form>
  </body>
</html>