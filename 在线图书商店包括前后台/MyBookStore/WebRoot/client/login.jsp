<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/client/hader.jsp" %>
  <head>  
    <title>用户登录</title>
  </head>
  <h2>用户登录</h2>
  <form action="${pageContext.request.contextPath}/servlet/ClientServlet?operation=login" method="post">
  	<table width="" border="0" align="center"">
  		<tr>
  			<td>username:</td>
  			<td>
  				<input type="text" name="username"/>
  			</td>
  		</tr>
  		<tr>
  			<td>password</td>
  			<td>
  				<input type="password" name="password"/>
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2" align="center">
  				<input type="submit" value="LOGIN"/>
  			</td>
  		</tr>
  	</table>
  </form>
    
  </body>
</html>
