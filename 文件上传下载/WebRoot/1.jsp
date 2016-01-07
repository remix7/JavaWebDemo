<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>文件上传</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/uploadFileServlet4" method="post" enctype="multipart/form-data">
    	用户名:<input type="text" name="name"/><br/>
    	文件一:<input type="file" name="f1"/><br/>
    	文件二:<input type="file" name="f2"/><br/>
    	<input type="submit" value="上传"/> <br/>
    </form>
  </body>
</html>
