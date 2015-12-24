<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>显示购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	  </head>
  
  <body style="text-align: center;">
    	<h1>您购买的商品如下!</h1>
    	<c:if test="${empty sessionScope.cart.items}">
    		您还没有购买任何商品
    	</c:if>
    	<c:if test="${!empty sessionScope.cart.items}">
    		<table border="1" width="88%">
    			<tr>
    				<th>序号</th>
    				<th>书名</th>
    				<th>单价</th>
    				<th>数量</th>
    				<th>小计</th>
    				<th>操作</th>
    			</tr>
    			<c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs">
	    			<tr bgcolor="${vs.index%2==0?'#C179D1':'#9DE0CA'}">
	    				<td>${vs.count}</td>
	    				<td>${me.value.book.name}</td>
	    				<td>${me.value.book.price}</td>
	    				<td>
	    					<input type="text" name="num" value="${me.value.num}" size="3" onchange="changeNum(this,'${me.key}',${me.value.num})"/>
	    				</td>
	    				<td>${me.value.price}</td>
	    				<td>
	    					<a href="javascript:delOne('${me.key}')">[删除]</a>
	    				</td>
	    			</tr>
    			</c:forEach>
    			<tr>
    				<td colspan="2">
    					[<a href="javascript:delAll()">清空购物车</a>]
    				</td>
    				<td colspan="2" align="right">[总计]</td>
    				<td colspan="2">${sessionScope.cart.price}</td>
    			</tr>
    		</table>
    	</c:if>
    	<a href="${pageContext.request.contextPath}">[继续购物]</a>
    	<script type="text/javascript">
    		function changeNum(inputObj,bookId,oldNum){
					var newnum = inputObj.value;//心的数量
					var sure = window.confirm("确定要把数量改为"+newnum+"吗?");//确定返回true
					if(sure){
						window.location.href="${pageContext.request.contextPath}/servlet/changeNumServlet?bookId="+bookId+"&newnum="+newnum;
					}else{
						inputObj.value = oldNum;
					}
        		}
    		//删除一项
    		function delOne(bookId){
				var sure = window.confirm("确定要删除该商品吗？");
				if(sure){
					window.location.href="${pageContext.request.contextPath}/servlet/delOneServlet?bookId="+bookId;
				}
        	}
        	//全部删除
        	function delAll(){
        		var sure = window.confirm("确定要清空购物车吗？");
				if(sure){
					window.location.href="${pageContext.request.contextPath}/servlet/delAllServlet";
				}
            }
    	</script>
    	${message}
  </body>
</html>
