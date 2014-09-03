<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="content">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<title>我的资源 - 我的网络</title>
<link href="${ctx}/css/table.css" rel="stylesheet" />
<link href="${ctx}/css/css_main.css" rel="stylesheet" />
<link href="${ctx}/css/css_font.css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/widgets/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="${ctx}/widgets/jquery/jquery-impromptu.3.2.min.js"></script>
<style type="text/css">
body {
	margin:0px auto;
	background-color:#F2F2F2;
	background-repeat:repeat;
	background-position:left;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<script type="text/javascript">

</script>

</head>
  <body onLoad="">
    <form:form modelAttribute="baseVoList" action="${ctx}/network/list.do" method="post" name="listForm">

          <table width="962" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td align="center"  valign="top" bgcolor="#F2F2F2">
                 
                  <table width="952" border="0" cellspacing="0" cellpadding="0" align="center">

                    <tr>
                      <td align="left" valign="top" bgcolor="#F0F1F2">
                        <table width="952" border="0" cellspacing="0" cellpadding="0">

                          <tr><td colspan=2 height="15"></td></tr>
                          <tr>
                            <td height="5" colspan="2">
                              <div id="middle_sheet_myR_s_name">
                                <a href="javascript:vmwareInfo('basicNet')"><img src="${ctx}/images/menu_s_17_s.png" border="0" align="absmiddle" id="basicNet"/></a>
                                <a href="javascript:vmwareInfo('highNet')"><img src="${ctx}/images/menu_s_18.png" border="0" align="absmiddle" id="highNet"/></a>
                                
                                <a href="javascript:vmwareInfo('vpcNet')" style="display: none;"><img src="${ctx}/images/menu_s_25.png" border="0" align="absmiddle" id="vpcNet"/></a>
                              	
                              </div>
								<script type="text/javascript">
								function vmwareInfo(url){
									$("#basicNet")[0].src="${ctx}/images/menu_s_17.png";
									$("#highNet")[0].src="${ctx}/images/menu_s_18.png";
									$("#vpcNet")[0].src="${ctx}/images/menu_s_25.png";
									
									var map = getMap(); 
									map.put("basicNet","${ctx}/images/menu_s_17_s.png");
									map.put("highNet","${ctx}/images/menu_s_18_s.png");
									map.put("vpcNet","${ctx}/images/menu_s_25_s.png");
									
									$("#"+url)[0].src=map.get(url);
									
									document.getElementById("networkForm").src="${ctx}/network/"+url+".do";
								}
								</script>
								
                              <div id="middle_sheet_myR_s">
                              	<table width="878" border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_1.jpg" width="14" height="14" /></td>
                                    <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_2.jpg"></td>
                                    <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_3.jpg" width="14" height="14" /></td>
                                  </tr>
                                  <tr>
                                    <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_4.jpg"></td>
                                    <td align="center" valign="top" bgcolor="#FFFFFF">

										<iframe id="networkForm" name="networkIframeForm" src="${ctx}/network/basicNet.do" frameborder="0" scrolling="no" height="620" width="100%"></iframe>

                                    </td>
                                    <td width="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_5.jpg"></td>
                                  </tr>
                                  <tr>
                                    <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_6.jpg" width="14" height="14" /></td>
                                    <td height="14" align="left" valign="top" background="${ctx}/images/sheet_s_border_7.jpg"></td>
                                    <td width="14" height="14" align="left" valign="top"><img src="${ctx}/images/sheet_s_border_8.jpg" width="14" height="14" /></td>
                                  </tr>
                                </table>
                              </div>
                            </td>
                          </tr>                          
                        </table>
                      </td>
                    </tr>
                  </table>
                                          
              </td>
            </tr>
          </table>
    
        
	</form:form>
  </body>
</html>