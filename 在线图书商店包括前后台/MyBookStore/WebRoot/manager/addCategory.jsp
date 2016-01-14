<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manager/category.jsp" %>
<hr/>
<h3 align="center">添加分类</h3>
	<form action="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=addCategory" method="post">
		<table border="1" width="" align="center">
			<tr>
				<td>*分类名称</td>
				<td>
					<input type="text" name="name" value="${category.name}"/>${formBean.errors.name}
				</td>
			</tr>
			<tr>
				<td>描述</td>
				<td>
					<textarea rows="3" cols="14" name="description"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="保存"/>
				</td>
			</tr>
		
		</table>
	</form>
  </body>
</html>
