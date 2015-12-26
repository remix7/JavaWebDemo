<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>REMIX BLONG</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
	</head>
  
  <body>
  	<center>
  	<h1>欢迎光临REMIX论坛</h1>	
  	<c:if test="${sessionScope.user!=null}">
  			欢迎您:${sessionScope.user.nick==""?sessionScope.user.username:sessionScope.user.nick}！
  			&nbsp;&nbsp;
  		</c:if>
  		<hr/>
  		<c:if test="${sessionScope.user==null}">
  			<a href="${pageContext.request.contextPath}/login.jsp">LOGIN</a>
  			<a href="${pageContext.request.contextPath}/regist.jsp">REGIST</a>
  		</c:if>
  		<c:if test="${sessionScope.user!=null}">
  			<a href="${pageContext.request.contextPath}/servlet/CenterController?operation=logOff">LogOff</a>
  		</c:if>
  		
  	</center>
  </body>
</html>
