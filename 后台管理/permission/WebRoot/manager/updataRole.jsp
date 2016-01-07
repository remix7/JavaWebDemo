<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manager/hader.jsp" %>
<center>
<h1>修改角色</h1>
    <form action="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=updataRole&id=${role.id}" method="post">
    	<table border="1" width="58%" >
    		<tr>
    			<td>菜单名称(*)</td>
    			<td><input type="text" name="name" value="${role.name}"/>${formBean.errors.name}</td>
    		</tr>
    		<tr>
    			<td>描述</td>
    			<td><input type="text" name="description" value="${role.description}"/>${formBean.errors.description}</td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="保存"/>
    			</td>
    			
    		</tr>
    	</table>
    
    </form>
  </body>
  </center>
</html>