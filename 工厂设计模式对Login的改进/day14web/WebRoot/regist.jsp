<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>Regist</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	  </head>
  
  <body>
  <center>
  <hr/>
    <form action="${pageContext.request.contextPath}/servlet/CenterController?operation=regist" method="post">
    	<table border="1" width="88%">
    		<tr>
    			<td>[*用户名(2-8位字母)]:</td>
    			<td>
    				<input type="text" name="username" value="${formBean.username}"/>${formBean.errors.username }
    			</td>
    		</tr>
    		<tr>
    			<td>[昵称]:</td>
    			<td>
    				<input type="text" name="nick" value="${formBean.nick}"/>
    			</td>
    		</tr>
    		<tr>
    			<td>[*密码(3-10位数字)]:</td>
    			<td>
    				<input type="password" name="password" value="${formBean.password}"/>${formBean.errors.password}
    			</td>
    		</tr>
    		<tr>
    			<td>[重复密码]:</td>
    			<td>
    				<input type="password" name="password1" value="${formBean.password1}"/>${formBean.errors.password1}
    			</td>
    		</tr>
    		<tr>
    			<td>[*邮箱]:</td>
    			<td>
    				<input type="text" name="email" value="${formBean.email}"/>${formBean.errors.email}
    			</td>
    		</tr>
    		<tr>
    			<td>[*出生日期:]</td>
    			<td>
    				<input type="text" name="brithday" value="${formBean.brithday}"/>${formBean.errors.brithday}
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="SAVE"/>
    			</td>
    		</tr>
    		
    	</table>
    
    </form>
    <hr/>
    </center>
  </body>
</html>
