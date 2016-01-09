<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>在线用户</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h1>有以下用户在线</h1>
  <hr/>
    <c:if test="${empty applicationScope.users}">
    	不好意思没有用户在线~
    </c:if>
     <c:if test="${!empty applicationScope.users}">
    	<c:forEach items="${applicationScope.users}" var="me">
    	<c:url value="servlet/TirenServlet" var="url">
    		<c:param name="username" value="${me.key}"></c:param>
    	</c:url>
    		${me.key} &nbsp;&nbsp;<a href="${url}">踢出</a>  <br/>
    	</c:forEach>
    </c:if>
  </body>
</html>
