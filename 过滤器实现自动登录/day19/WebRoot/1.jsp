<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>输入文字</title>

		<!-- 	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">     -->
	</head>

	<body>

		<form action="${pageContext.request.contextPath}/servlet/ServletDemo1"
			method="post">
			<input type="text" name="name" />
			<input type="submit" value="SAVE" />
		</form>
	</body>
</html>
