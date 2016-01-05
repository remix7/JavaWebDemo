<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>添加用户</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
	</head>
  
  <body style="text-align: center;">
  <br/>
  <h1>添加用户</h1>
  <hr/>
    	<form action="${pageContext.request.contextPath}/servlet/AddCustomerServlet" method="post">
    		<table width="78%" border="1">
    			<tr>
    				<td>[姓名:]</td>
    				<td>
    					<input type="text" name="name" value="${formBean.name}" />
    				</td>
    			</tr>
    			<tr>
    				<td>[性别:]</td>
    				<td>
    					<input type="radio" name="gender" value="1" ${formBean.name==1?'checked="checked"':''}/>男
    					<input type="radio" name="gender" value="0" ${formBean.name==0?'checked="checked"':''}/>女
    				</td>
    			</tr>
    			<tr>
    				<td>[生日(如2015-12-27):]</td>
    				<td>
    					<input type="text" name="birthday" value="${formBean.birthday}"/>${formBean.errors.birthday}
    				</td>
    			</tr>
    			<tr>
    				<td>[电话:]</td>
    				<td>
    					<input type="text" name="cellphone" value="${formBean.cellphone}"/>
    				</td>
    			</tr>
    			<tr>
    				<td>[邮箱:]</td>
    				<td>
    					<input type="text" name="email" value="${formBean.email}"/>
    				</td>
    			</tr>
    			<tr>
    				<td>[爱好:]</td>
    				<td>
    					<input type="checkbox" name="hobbies" value="吃饭"/>吃饭
    					<input type="checkbox" name="hobbies" value="睡觉"/>睡觉
    					<input type="checkbox" name="hobbies" value="打豆豆"/>打豆豆
    				</td>
    			</tr>
    			<tr>
    				<td>[类型:]</td>
    				<td>
    					<input type="radio" name="type" value="普通客户" ${formBean.type=='普通客户'?'checked="checked"':''}>普通客户
    					<input type="radio" name="type" value="VIP"${formBean.type=='VIP'?'checked="checked"':''}/>VIP${formBean.type }
    				</td>
    			</tr>
    			<tr>
    				<td>[描述:]</td>
    				<td>
    					<textarea name="description" rows="3" cols="48"></textarea>
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
