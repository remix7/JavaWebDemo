<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="cc.cynara.resources.msg" var="b"/>


<!-- 国际化登录测试 cc.cynara.resources login.jsp 以及 jstl.jar standard.jar -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>
    	<fmt:message key="jsp.login.title" bundle="${b}"></fmt:message>
    </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	  </head>
  
  <body>
    <form action="#" method="post">
    	<fmt:message key="jsp.login.username" bundle="${b}"/>:<input type="text" name="username"/><br/>
    	<fmt:message key="jsp.login.password" bundle="${b}"/>:<input type="password" name="password"/><br/>
    	<input type="submit" value="<fmt:message key='jsp.login.submit' bundle='${b}'/>">
    
    </form>
    
    <%
    pageContext.setAttribute("now",new Date());
    %>
    <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />
    <hr/>
     <%
    pageContext.setAttribute("snow","2016年1月2日 星期六 下午10时13分57秒 CST ");
    %>
    <fmt:parseDate value="${snow}" type="both" dateStyle="full" timeStyle="full"></fmt:parseDate>
    ${s}
  </body>
</html>
