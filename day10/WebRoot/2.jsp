<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>EL表达式</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	  </head>
  
  <body>
  <!-- 获取域中JavaBean的属性方式 -->
    <jsp:useBean id="p" class="com.remix.domain.Persion"></jsp:useBean>
    <jsp:setProperty property="name" name="p" value="刘涛"/>
    <%=p.getName() %><br/>
    <jsp:getProperty property="name" name="p"/><br/>
    ${p.name }
    <hr/>
    <%=p.getGendle() %><br/>
    <jsp:getProperty property="gendle" name="p"/><br/>
    ${p.gendle }
  </body>
</html>
