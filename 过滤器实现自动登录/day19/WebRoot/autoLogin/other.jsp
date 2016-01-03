<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>其他页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
     <c:if test="${sessionScope.user==null}">
     	<a href="${pageContext.request.contextPath}/autoLogin/login.jsp">登录</a>
     </c:if>
     <c:if test="${sessionScope.user!=null}">
     	欢迎您:${sessionScope.user.nick}&nbsp;&nbsp;
     	<a href="${pageContext.request.contextPath}/autoLogin/index.jsp">主页</a>
     </c:if>
  </body>
</html>
