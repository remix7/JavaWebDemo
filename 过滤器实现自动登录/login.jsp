<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/AutoLoginServlet" method="post">
    	username:<input type="text" name="username"/><br/>
    	password:<input type="password" name="password"/><br/>
    	<input type="checkbox" name="autoLogin"/>是否自动登录<br/>
    	<input type="submit" value="Login"/>
    </form>
  </body>
</html>
