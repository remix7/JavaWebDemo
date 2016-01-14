<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/client/hader.jsp" %>
  <head>  
    <title>购物车</title>
	
  </head>
  ${message}
    <c:if test="${empty sessionScope.cart.items}">
		您还没有购物！
	</c:if>
	<c:if test="${!empty sessionScope.cart.items}">
	<br/>
		<table border="1" width="58%" align="center">
			<tr>
				<th>序号</th>
				<th>书名</th>
				<th>作者</th>
				<th>售价</th>
				<th>数量</th>
				<th>小计</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>${me.value.book.name}</td>
					<td>${me.value.book.author}</td>
					<td>${me.value.book.price}￥</td>
					<td>${me.value.num}</td>
					<td>${me.value.price }￥</td>
					<td>
						<a href="#">修改</a>&nbsp;&nbsp;
						<a href="#">删除</a>
					</td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="7" align="center">
					总数量:${sessionScope.cart.num}&nbsp;&nbsp;
					总金额:${sessionScope.cart.price}&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/servlet/ClientServlet?operation=saveOrders">生成订单</a>
					</td>
				</tr>
		</table>
	</c:if>
  </body>
</html>
