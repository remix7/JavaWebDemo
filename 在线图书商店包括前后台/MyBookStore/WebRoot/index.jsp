<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
  
  <body>
   <jsp:forward page="/servlet/ClientServlet">
   	<jsp:param value="showIndexCategory" name="operation"/>
   </jsp:forward>
  </body>
</html>
