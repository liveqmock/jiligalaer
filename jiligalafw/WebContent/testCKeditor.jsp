<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>CKEditor</title>
       <script type="text/javascript" src="${ctx}/widgets/ckeditor/ckeditor.js"></script>
    </head>
    <body>
       <form id="form1" name="form1" method="post"
           action="display.jsp">
           <table width="650" height="400" border="0" align="center">
              <tr>
                  <td valign="top">
                     内容:
                  </td>
                  <td>
                     <textarea cols="80" id="content" name="content"></textarea>
                     <script type="text/javascript">
    CKEDITOR.replace('content');
</script>
                  </td>
              </tr>
              <tr>
                  <td></td>
                  <td>
                     <input type="submit" name="Submit" value="提交" />
                     <input type="reset" name="Reset" value="重置" />
                  </td>
              </tr>
           </table>
       </form>
    </body>
</html>