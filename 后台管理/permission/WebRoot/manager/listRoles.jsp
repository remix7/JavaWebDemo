<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/hader.jsp" %>
<center>
   <h1>角色列表</h1> 
   <a href="${pageContext.request.contextPath}/manager/addRole.jsp">添加</a>
   <c:if test="${empty roles}">
   	没有任何角色
   </c:if>
   <c:if test="${!empty roles}">
   		<table border="1" width="58%">
   			<tr>
   				<th>[序号]</th>
   				<th>[角色]</th>
   				<th>[描述]</th>
   				<th>[操作]</th>
   			</tr>
   		<c:forEach items="${roles}" var="r" varStatus="vs">
   			<tr bgcolor="${vs.index%2==0?'#CF815E':'#9DE0E0'}">
   				<td>${vs.count}</td>
   				<td>${r.name}</td>
   				<td>${r.description}</td>
   				<td>
   					<a href="javascript:delOne('${r.id}')">[删除]</a>&nbsp;&nbsp;
   					<a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?updateRole=${r.id}">[修改]</a>&nbsp;&nbsp;
   					<a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=grantMenu2RoleUI&roleId=${r.id}">[角色分配]</a>
   				</td>
   			</tr>
   		</c:forEach>
   		</table>
   </c:if>
   <script type="text/javascript">
 	function delOne(roleId) {
		var sure = window.confirm("确定要删除吗?");
		if (sure) {
			window.location.href = "${pageContext.request.contextPath}/servlet/MyControllerServlet?delOneRole="+roleId;
		}
	}
 		
	</script>
  </body>
  </center>
</html>
