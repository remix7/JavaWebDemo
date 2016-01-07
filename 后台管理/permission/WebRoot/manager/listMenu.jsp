<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/hader.jsp" %>
<center>
  <h1>菜单列表</h1>
  <a href="${pageContext.request.contextPath}/manager/addMenu.jsp">添加</a>
   <c:if test="${empty menus}">
   	没有任何菜单
   </c:if>
   <c:if test="${!empty menus}">
   		<table border="1" width="58%">
   			<tr>
   				<th>[序号]</th>
   				<th>[菜单名称]</th>
   				<th>[URI]</th>
   				<th>[描述]</th>
   				<th>[操作]</th>
   			</tr>
   		<c:forEach items="${menus}" var="m" varStatus="vs">
   			<tr bgcolor="${vs.index%2==0?'#CF815E':'#9DE0E0'}">
   				<td>${vs.count}</td>
   				<td>${m.name}</td>
   				<td>${m.uri}</td>
   				<td>${m.description}</td>
   				<td>
   					<a href="javascript:delOne('${m.id}')">[删除]</a>&nbsp;&nbsp;
   					<a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?updateMenu=${m.id}">[修改]</a>
   				</td>
   			</tr>
   		</c:forEach>
   		</table>
   </c:if>
   <script type="text/javascript">
 	function delOne(menuId) {
		var sure = window.confirm("确定要删除吗?");
		if (sure) {
			window.location.href = "${pageContext.request.contextPath}/servlet/MyControllerServlet?delOneMenu="+menuId;
		}
	}
 		
	</script>
	
  </body>
 </center>
</html>
