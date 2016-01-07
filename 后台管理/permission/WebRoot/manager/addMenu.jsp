<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/hader.jsp"%>
<center>
<h1>添加菜单</h1>
	<form action="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=addMenu" method="post">
		<table  border="1" width="38%">
			<tr>
				<td>菜单名称(*)</td>
				<td><input type="text" name="name" value="${menu.name}"/>${formBean.errors.name}</td>
			</tr>
			<tr>
				<td>URI(必须/开头)</td>
				<td><input type="text" name="uri" value="${menu.uri}"/>${formBean.errors.uri}</td>
			</tr><tr>
				<td>描述(*)</td>
				<td><input type="text" name="description" value="${menu.description}"/>${formBean.errors.description}</td>
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
