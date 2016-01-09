<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <c:if test="${sessionScope.user==null}">
	    <form action="${pageContext.request.contextPath}/servlet/LoginSerlvet" method="post">
	    	username:<input type="text" name="username"/><br/>
	    	<input type="submit" value="LOGIN"/>
	    </form>
   </c:if>
   <c:if test="${sessionScope.user!=null}">
   欢迎您:${sessionScope.user.username}
   </c:if>
    <hr/>
    <a href="onlineUser.jsp">在线用户</a>
  </body>
</html>
