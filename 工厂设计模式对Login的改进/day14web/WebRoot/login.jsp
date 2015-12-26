<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>LOGIN</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	  </head>
  
  <body>
  <hr/>
  ${message}
	    <form action="${pageContext.request.contextPath}/servlet/CenterController?operation=login" method="post">
	    	用户名:<input type="text" name="username" value="${formBean.username}"/>${formBean.errors.username}<br/>
	    	密&nbsp;&nbsp;码:<input type="password" name="password" value="${formBean.password}"/>${formBean.errors.password}<br/>
	    	<input type="submit" value="[提交]">
	    </form>
  </body>
</html>
