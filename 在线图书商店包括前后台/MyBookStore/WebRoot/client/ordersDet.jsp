<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/client/hader.jsp" %>
  <head>  
    <title>订单明细</title>
  </head>
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
  		<td>${o.book.author}</td>
  		<td>${o.book.price}</td>
  		<td>${o.num}</td>
  		<td>${o.price}</td>
  	</tr>
  	</c:forEach>
  	<tr>
  		<td colspan="6" align="center">
  			收货人信息:${sessionScope.user.nick}&nbsp;&nbsp;
  			邮寄地址:${sessionScope.user.address}&nbsp;&nbsp;
  			联系电话:${sessionScope.user.phone}
  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单状态:${orders.state==0?'未发货':'已发货'}
  		</td>
  	</tr>
  </table>
 
  </body>
</html>
