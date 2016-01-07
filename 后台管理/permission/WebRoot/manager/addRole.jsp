<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/hader.jsp" %>
<center>
<h1>添加角色</h1>

	<form action="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=addRole" method="post">
		<table  border="1" width="38%">
			<tr>
				<td>角色名称(*)</td>
				<td><input type="text" name="name" value="${role.name}"/>${formBean.errors.name}</td>
			</tr>
				<td>描述(*)</td>
				<td><input type="text" name="description" value="${role.description}"/>${formBean.errors.description}</td>
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
