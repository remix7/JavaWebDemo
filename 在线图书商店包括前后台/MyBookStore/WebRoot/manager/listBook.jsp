<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/manager/hader.jsp" %>
<%@ taglib uri="http://www.cynara.cc/jsp/jstl/myfunctions" prefix="myfn"%>
<div align="left" style="background-color: #cfcfcf">
		&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=showCategoryUI">添加图书</a>&nbsp;&nbsp;
    	&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=listAllBook">查看图书</a>&nbsp;&nbsp;
	</div>
	<hr/>
	<h3 align="center">查看图书</h3>
	<c:if test="${page.records==null}">
		还没有任何图书
	</c:if>
	<c:if test="${page.records!=null}">
		<table align="center" width="58%" border="1">
			<tr>
				<th>序号</th>
				<th>书名</th>
				<th>作者</th>
				<th>售价</th>
				<th>图片</th>
				<th>描述</th>
				<th>所属分类</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${page.records}" var="b" varStatus="vs">
				<tr>
					<td>
						${vs.count}
					</td>
					<td>
						${b.name}
					</td>
					<td>
						${b.author}
					</td>
					<td>
						${b.price}
					</td>
					<td>
						<a  href="${pageContext.request.contextPath}/files/${b.image}">查看图片</a>
					</td>
					<td>
						${b.description}
					</td>
					<td>
						${myfn:getCategoruName(b.category_id)}
					</td>
					<td>
						<a href="#">修改</a>&nbsp;&nbsp;
						<a href="#">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<!-- 分页开始 -->
	<%@ include file="/commons/page.jsp" %>
	<!-- 分页结束 -->
  </body>
</html>
