<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.remix.servlet.Book"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>书籍列表 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
  	<h1>本站有以下好书</h1>
	<table border="1" width="88%">
		<tr>
			<th>书名</th>
			<th>作者</th>
			<th>价格</th>
			<th>评价</th>
		</tr>
		<%
		Map<String, Book> books = (Map<String, Book>)request.getAttribute("books");
		for(Map.Entry<String,Book> me : books.entrySet()){
			Book book = me.getValue();
		%>
		<tr>
			<td><%=book.getName()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getPrice()%></td>
			<td><%=book.getDescription()%></td>
		</tr>
		
		<%
		}
		%>
	</table>
   </center>
   
  </body>
</html>
