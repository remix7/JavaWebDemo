<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/client/hader.jsp" %>
  <head>  
    <title>注册</title>
  </head>
  <h3>新用户注册</h3>
  <form action="${pageContext.request.contextPath}/servlet/ClientServlet?operation=regist" method="post">
	  <table width="" border="0" align="center">
	  		<tr>
	  			<td>*用户名</td>
	  			<td>
	  				<input type="text" name="username"/>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>*密码</td>
	  			<td>
	  				<input type="password" name="password"/>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>*昵称</td>
	  			<td>
	  				<input type="text" name="nick"/>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>*手机</td>
	  			<td>
	  				<input type="text" name="phone"/>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>*住址</td>
	  			<td>
	  				<input type="text" name="address"/>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>*邮箱</td>
	  			<td>
	  				<input type="text" name="email"/>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td colspan="2" align="center">
	  				<input type="submit" value="提交"/>
	  			</td>
	  		</tr>
	  </table>
  </form>
  </body>
</html>
