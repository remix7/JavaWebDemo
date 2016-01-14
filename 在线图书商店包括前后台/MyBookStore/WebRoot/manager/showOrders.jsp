<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manager/hader.jsp" %>
	<h2>未发货订单</h2>
    <table border="1" width="40%" align="center">
    	<tr>
    		<th>序号</th>
    		<th>订单号</th>
    		<th>所属用户</th>
    		<th>商品数量</th>
    		<th>金额</th>
    		<th>查看订单详情</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${orders}" var="o" varStatus="vs">
    		<tr>
	    		<td>${vs.count}</td>
	    		<td align="center">${o.ordernum}</td>
	    		<td>${o.user.username}</td>
	    		<td>${o.num}</td>
	    		<td>${o.price }</td>
	    		<td>
	    			<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=detailedOrder&orderId=${o.id}">查看订单详情</a>
	    		</td>
	    		<td>
	    			<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=updateOrder&orderId=${o.id}">发货</a>
	    		</td>
	    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
