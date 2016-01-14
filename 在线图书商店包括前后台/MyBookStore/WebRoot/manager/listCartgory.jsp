<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manager/category.jsp" %>
<hr/>
<h3 align="center">查看所有分类</h3>

	<c:if test="${cs==null}">
		对不起,没有任何分类!
	</c:if>
	<c:if test="${cs!=null}">
	<table border="1" width="58%" align="center">
				<tr>
					<th>序号</th>
					<th>名称</th>
					<th>描述</th>
					<th>操作</th>
				</tr>
		<c:forEach items="${cs}" var="c" varStatus="vs">
			
				<tr>
					<td>${vs.count }</td>
					<td>${c.name}</td>
					<td>${c.description }</td>
					<td>
						<a href="#">修改 </a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=delCategory&id=${c.id}">删除 </a>
					</td>
				</tr>
			
		
		</c:forEach>
		</table>
	</c:if>
  </body>
</html>
