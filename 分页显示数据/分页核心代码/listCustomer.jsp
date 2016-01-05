<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>所有用户信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body style="text-align: center;">
		<br />
		<h1>
			用户信息列表
		</h1>
		<hr />
		<form
			action="${pageContext.request.contextPath}/servlet/DelMormCustomerServlet"
			method="post" id="f1">
			<table width="88%" border="0">
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/addCustomer.jsp">添加</a>&nbsp;&nbsp;
						<a href="javascript:delMorm()">删除</a>
					</td>
				</tr>
				<tr>
					<td>
						<c:if test="${empty	page.records}">
    			对不起，没有任何客户的信息！
    		</c:if>
						<c:if test="${!empty page.records}">
							<table width="100%" border="1">
								<tr>
									<th>
										选择
									</th>
									<th>
										姓名
									</th>
									<th>
										性别
									</th>
									<th>
										生日
									</th>
									<th>
										电话
									</th>
									<th>
										邮箱
									</th>
									<th>
										兴趣
									</th>
									<th>
										类型
									</th>
									<th>
										描述
									</th>
									<th>
										操作
									</th>
								</tr>
								<c:forEach items="${page.records}" var="c" varStatus="vs">
									<tr bgcolor="${vs.index%2==0?'#CF815E':'#9DE0E0'}">
										<td>
											<input type="checkbox" name="ids" value="${c.id}" />
										</td>
										<td>
											${c.name}
										</td>
										<td>
											${c.gender==1?'男':'女'}
										</td>
										<td>
											${c.birthday}
										</td>
										<td>
											${c.cellphone}
										</td>
										<td>
											${c.email}
										</td>
										<td>
											${c.hobby}
										</td>
										<td>
											${c.type}
										</td>
										<td>
											${c.description}
										</td>
										<td>
											<a
												href="${pageContext.request.contextPath}/servlet/UpdateCustomerServletUI?customerId=${c.id}">修改</a>&nbsp;&nbsp;
											<a href="javascript:delOne('${c.id}')">删除</a>
										</td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
					</td>
				</tr>
				<tr>
					<td style="text-align: center;">
						<%@ include file="/commons/page.jsp"%>
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
	function delOne(customerId) {
		var sure = window.confirm("确定要删除吗?");
		if (sure) {
			window.location.href = "${pageContext.request.contextPath}/servlet/DelOneCustomerServlet?customerId="
					+ customerId;
		}
	}
	function delMorm() {
		//它是一个数组
		var idsObject = document.getElementsByName("ids");
		//alert(idsObject.length);
		var selectd = false;
		for ( var i = 0; i < idsObject.length; i++) {
			if (idsObject[i].checked) {
				selectd = true;
				break;
			}
		}
		if (selectd) {
			//选了
			var sure = window.confirm("确定要删除吗?");
			if (sure) {
				document.getElementById("f1").submit();
			}
		} else {
			alert("请先选择要删除的记录！");
		}
	}
</script>
	</body>
</html>
