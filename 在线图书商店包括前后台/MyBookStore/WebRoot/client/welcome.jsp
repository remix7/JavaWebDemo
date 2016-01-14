<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/client/hader.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>欢迎使用</title>
	
  </head>
  	<table align="center">
  		<tr>
  			<c:forEach items="${page.records}" var="b">
  				<td>
  					<table border="0">
  						<tr>
  							<td>
  								<img alt="" src="${pageContext.request.contextPath}/files/${b.image}">
  							</td>
  						</tr>
  						<tr>
  							<td>
  								书名:${b.name}<br/>
  								作者:${b.author}<br/>
  								描述:${b.description}<br/>
  								原价:<strike>998.00</strike><br/>
  								现价:${b.price}
  							</td>
  						</tr>
  						<tr>
  							<td align="center">
  								<a href="${pageContext.request.contextPath}/servlet/ClientServlet?operation=buyBook&bookId=${b.id}">购买</a>
  							</td>
  						</tr>
  					</table>
  				</td>
  			</c:forEach>
  		</tr>
  	</table>
  	<%@ include file="/commons/page.jsp" %>
  <body>
 