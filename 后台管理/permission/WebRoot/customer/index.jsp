<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>欢迎使用</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <c:if test="${sessionScope.user==null}">
    	<a href="${pageContext.request.contextPath}/customer/login.jsp">登录</a>
    </c:if>
     <c:if test="${sessionScope.user!=null}">
    	欢迎您:${sessionScope.user.nick}&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=logOut">注销</a>
    	&nbsp;&nbsp;${errors}
    </c:if>
    <hr/>
    <c:forEach	items="${menu}" var="m">
    	<c:url value="${m.uri}" var="uri"></c:url>
    	<a href="${uri}">${m.name}</a>
    </c:forEach>
  </body>
</html>
