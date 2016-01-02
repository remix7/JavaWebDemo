<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.cynara.cc/jsp/jstl/exampletag" prefix="ecynara" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>简单foreach</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	  </head>
  
  <body>
    <%
    List list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(5);
    pageContext.setAttribute("list",list);
    %>
   <ecynara:forEach items="${list}" var="s" >
   	${s}
   </ecynara:forEach>
  </body>
</html>
