<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/hader.jsp" %>
<center>
   <h1>用户列表</h1> 
   <a href="${pageContext.request.contextPath}/manager/addUser.jsp">添加</a>
   <c:if test="${empty user}">
   	没有任何用户!
   </c:if>
   <c:if test="${!empty user}">
   		<table border="1" width="58%">
   			<tr>
   				<th>[序号]</th>
   				<th>[用户名]</th>
   				<th>[昵称]</th>
   				<th>[操作]</th>
   			</tr>
   		<c:forEach items="${user}" var="u" varStatus="vs">
   			<tr bgcolor="${vs.index%2==0?'#CF815E':'#9DE0E0'}">
   				<td>${vs.count}</td>
   				<td>${u.username}</td>
   				<td>${u.nick}</td>
   				<td>
   					<a href="javascript:delOne('${u.id}')">[删除]</a>&nbsp;&nbsp;
   					<a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?updateUser=${u.id}">[修改]</a>&nbsp;&nbsp;
   					<a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=grantRole2UserUI&userId=${u.id}">[权限分配]</a>
   				</td>
   			</tr>
   		</c:forEach>
   		</table>
   </c:if>
   <script type="text/javascript">
 	function delOne(userId) {
		var sure = window.confirm("确定要删除吗?");
		if (sure) {
			window.location.href = "${pageContext.request.contextPath}/servlet/MyControllerServlet?delOneUser="+userId;
		}
	}
 		
	</script>
  </body>
  </center>
</html>
