<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/client/hader.jsp" %>
  <head>  
    <title>所有订单</title>
  </head>
  <h2>所有订单</h2>
    <table border="1" width="42%" align="center">
		  <tr>
		    	<th>序号</th>
		    	<th>订单号</th>
		    	<th>订单数量</th>
		     	<th>金额</th>
		       	<th>明细</th>
		  </tr>
		  <c:forEach items="${orders}" var="o" varStatus="vs">
			  <tr>
				   <td>${vs.count}</td>
				    <td>${o.ordernum}</td>
				    <td>${o.num}</td>
				    <td>￥${o.price}</td>
				    <td>
						<a href="${pageContext.request.contextPath}/servlet/ClientServlet?operation=showOrdersDet&orderid=${o.id}">查看明细</a>
					</td>
			  </tr>
		  </c:forEach>
		 
	</table>

  </body>
</html>
