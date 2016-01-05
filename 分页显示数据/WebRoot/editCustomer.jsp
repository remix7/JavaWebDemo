<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>修改用户</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
	</head>
  
  <body style="text-align: center;">
  <br/>
  <h1>修改用户</h1>
  <hr/>
    	<form action="${pageContext.request.contextPath}/servlet/UpdateCustomerServlet" method="post">
    	<input type="hidden" name="id" value="${c.id }"/>
    		<table width="78%" border="1">
    			<tr>
    				<td>[姓名:]</td>
    				<td>
    					<input type="text" name="name" value="${formBean.name}${c.name}" />
    				</td>
    			</tr>
    			<tr>
    				<td>[性别:]</td>
    				<td>
    					<input type="radio" name="gender" value="1" ${c.gender==1?'checked="checked"':''}${formBean.gender==1?'checked="checked"':''}/>男
    					<input type="radio" name="gender" value="0" ${c.gender==0?'checked="checked"':''}${formBean.gender==0?'checked="checked"':''}/>女
    				</td>
    			</tr>
    			<tr>
    				<td>[生日(如2015-12-27):]</td>
    				<td>
    					<input type="text" name="birthday" value="${formBean.birthday}${c.birthday}"/>${formBean.errors.birthday}
    				</td>
    			</tr>
    			<tr>
    				<td>[电话:]</td>
    				<td>
    					<input type="text" name="cellphone" value="${formBean.cellphone}${c.cellphone}"/>
    				</td>
    			</tr>
    			<tr>
    				<td>[邮箱:]</td>
    				<td>
    					<input type="text" name="email" value="${formBean.email}${c.email}"/>
    				</td>
    			</tr>
    			<tr>
    				<td>[爱好:]</td>
    				<td>
    					<input type="checkbox" name="hobbies" value="吃饭" ${fn:contains(c.hobby,'吃饭')?'checked="checked"':''}/>吃饭
    					<input type="checkbox" name="hobbies" value="睡觉"${fn:contains(c.hobby,'睡觉')?'checked="checked"':''}/>睡觉
    					<input type="checkbox" name="hobbies" value="打豆豆" ${fn:contains(c.hobby,'打豆豆')?'checked="checked"':''}/>打豆豆
    				</td>
    			</tr>
    			<tr>
    				<td>[类型:]</td>
    				<td>
    					<input type="radio" name="type" value="普通客户" ${c.type=='普通客户'?'checked="checked"':''}>普通客户
    					<input type="radio" name="type" value="VIP"${c.type=='VIP'?'checked="checked"':''}/>VIP${formBean.type }
    				</td>
    			</tr>
    			<tr>
    				<td>[描述:]</td>
    				<td>
    					<textarea name="description" rows="3" cols="48">${c.description}</textarea>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center">
    					<input type="submit" value="保存"/>
    				</td>
    			</tr>
    		</table>
    	</form>
  </body>
</html>
