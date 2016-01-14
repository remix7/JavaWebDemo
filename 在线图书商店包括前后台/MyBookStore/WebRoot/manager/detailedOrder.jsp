<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manager/hader.jsp" %>
  <hader>
  	<title>订单详情</title>
  </hader>
 <h2>订单明细</h2>
  订单号:${orders.ordernum}&nbsp;&nbsp;金额${orders.price}&nbsp;&nbsp;明细如下:
  <table border="1" width="58%" align="center">
  	<tr>
  		<th>序号</th>
  		<th>书名</th>
  		<th>作者</th>
  		<th>单价</th>
  		<th>数量</th>
  		<th>小计</th>
  	</tr>
  	<c:forEach items="${orders.items}" var="o" varStatus="vs" >
  	<tr></tr>
  		<td>${vs.count}</td>
  		<td>${o.book.name}</td>
  		<td>${o.book.name}</td>
  		<td>${o.book.price}</td>
  		<td>${o.num}</td>
  		<td>${o.price}</td>
  	</tr>
  	</c:forEach>
  </table>
  	 <a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=showOrdes1">返回已发货订单</a>
  </body>
</html>
