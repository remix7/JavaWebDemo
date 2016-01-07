<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/hader.jsp" %>
<center>

<h1>角色分配</h1>
<a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=listAllRole">返回</a>
	<form id="f" action="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=grantMenu2Role" method="post">
		<input type="hidden" name="roleId" value="${role.id}"/>
		<table width="58%" border="1">
			<tr>
				<td colspan="2">[角色名称:${role.name}]</td>
			</tr>
			<tr>
				<td>[已有菜单]</td>
				<td>
					<c:forEach items="${role.menus}" var="r" varStatus="vs">
						${r.name}<br/>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>[所有菜单]</td>
				<td>
				<c:forEach items="${menus}" var="m" varStatus="vs">
						<input type="checkbox" name="mIds" value="${m.id}"/>${m.name}<br/>
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
			var checkBoxs = document.getElementsByName("mIds");
			var selected = false;
			for(var i=0;i<checkBoxs.length;i++){
				if(checkBoxs[i].checked){
					selected = true;
				}
			}
			if(selected){
				document.getElementById("f").submit();
			}else{
				alert("请先选择要分配的菜单!");
			}
		}
	</script>
</center>	
</body>
</html>
