<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.cynara.cc/jsp/jstl/exampletag" prefix="ecynara" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>嵌套标签</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	  </head>
  
  <body>
    <%
    	pageContext.setAttribute("grade","A");
    %>
    <ecynara:choose>
    	<ecynara:when test="${grade=='A'}">
    		优秀
    	</ecynara:when>
    	<ecynara:otherwies>
    		一般一般
    	</ecynara:otherwies>
    </ecynara:choose>
  </body>
</html>
