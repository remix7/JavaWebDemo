<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/hader.jsp" %>
<center>

<h1>权限分配</h1>
<a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=listAllUser">返回</a>
	<form id="f" action="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=grantRole2User" method="post">
		<input type="hidden" name="userId" value="${user.id}"/>
		<table width="58%" border="1">
			<tr>
				<td colspan="2">[角色名称:${user.nick}]</td>
			</tr>
			<tr>
				<td>[已有权限]</td>
				<td>
					<c:forEach items="${user.roles}" var="u" varStatus="vs">
						${u.name}<br/>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>[所有权限]</td>
				<td>
				<c:forEach items="${roles}" var="r" varStatus="vs">
						<input type="checkbox" name="rIds" value="${r.id}"/>${r.name}<br/>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="保存" onclick="toSubmit()"/>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function toSubmit(){
			var checkBoxs = document.getElementsByName("rIds");
			var selected = false;
			for(var i=0;i<checkBoxs.length;i++){
				if(checkBoxs[i].checked){
					selected = true;
				}
			}
			if(selected){
				document.getElementById("f").submit();
			}else{
				alert("请先选择要分配的权限!");
			}
		}
	</script>
</center>	
</body>
</html>
