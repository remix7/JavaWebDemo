<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>所有书籍列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	  </head>
  
  <body style="text-align: center;">
    <br/>
    <h1>本站有以下好书！</h1>
    <table border="1" width="88%">
    	<tr>
    		<th>序号</th>
    		<th>ISBN</th>
    		<th>书名</th>
    		<th>作者</th>
    		<th>单价</th>
    		<th>描述</th>
    		<th>购买</th>
    	</tr>
    	<c:forEach items="${books}" var="me" varStatus="vs">
    	<tr bgcolor="${vs.index%2==0?'#C179D1':'#9DE0CA'} ">
    		<td>${vs.count}</td>
    		<td>${me.value.isbn}</td>
    		<td>${me.value.name}</td>
    		<td>${me.value.author}</td>
    		<td>${me.value.price}</td>
    		<td>${me.value.descriptions}</td>
    		<td>
    			[<a href="${pageContext.request.contextPath}/servlet/BuyServlet?bookId=${me.key}">购买</a>]
    		</td>
    	</tr>
    	</c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/servlet/ShowCartServlet">[查看购物车]</a>
  </body>
</html>
