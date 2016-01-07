<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/hader.jsp" %>
<center>
<h1>添加用户</h1>

	<form action="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=addUser" method="post">
		<table  border="1" width="38%">
			<tr>
				<td>用户名(*)</td>
				<td><input type="text" name="username" value="${user.username}"/>${formBean.errors.username}</td>
			</tr>
				<td>密码(*)</td>
				<td><input type="password" name="password"/>${formBean.errors.password}</td>
			</tr>
			</tr>
				<td>昵称(*)</td>
				<td><input type="text" name="nick" value="${user.nick}"/>${formBean.errors.nick}</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="保存"/>
				</td>
			</tr>
		</table>
	
	
	</form>
    </center>
  </body>
</html>
