<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/manager/hader.jsp" %>

<div align="left" style="background-color: #cfcfcf">
		&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=showCategoryUI">添加图书</a>&nbsp;&nbsp;
    	&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=listAllBook">查看图书</a>&nbsp;&nbsp;
	</div>
	<hr/>
<h3 align="center">添加图书</h3>
    <form action="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=addBook" method="post" enctype="multipart/form-data">
    	<table width="" border="1" align="center">
    		<tr>
    			<td>书名</td>
    			<td>
    				<input type="text" name="name"/>
    			</td>
    		</tr>
    		<tr>
    			<td>作者</td>
    			<td>
    				<input type="text" name="author"/>
    			</td>
    		</tr>
    		<tr>
    			<td>售价</td>
    			<td>
    				<input type="text" name="price"/>
    			</td>
    		</tr>
    		<tr>
    			<td>图片</td>
    			<td>
    				<input type="file" name="img"/>
    			</td>
    		</tr>
    		<tr>
    			<td>描述</td>
    			<td>
    				<textarea rows="5" cols="30" name="description"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td>所属分类</td>
    			<td>
    				<select name="category_id">
    					<c:forEach items="${cs}" var="c">
    						<option value="${c.id}">${c.name}</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="提交" />
    			</td>
    		</tr>
    		
    	</table>
    </form>
    ${message}
  </body>
</html>
