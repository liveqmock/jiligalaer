<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404 Not Found</title>
<style type="text/css">
<!--
.t {
        font-family: Verdana, Arial, Helvetica, sans-serif;
        color: #CC0000;
}
.c {
        font-family: Verdana, Arial, Helvetica, sans-serif;
        font-size: 11px;
        font-weight: normal;
        color: #000000;
        line-height: 18px;
        text-align: center;
        border: 1px solid #CCCCCC;
        background-color: #FFFFEC;
}
body {
        background-color: #FFFFFF;
        margin-top: 100px;
}
-->
</style>
<script type="text/javascript">
function goLogin(){
	alert("待实现，填写登陆地址");
	//top.window.location = './admin.htm';
}
</script>
</head>
<body>
<div align="center">
  <h2><span class="t">${msg}</span></h2>
  <table border="0" cellpadding="8" cellspacing="0" width="460">
    <tbody>
      <tr>
        <td class="c"><input type="button" onclick="goLogin()" value="重新登录"></td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>