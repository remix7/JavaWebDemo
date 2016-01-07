<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>后台管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<dir style="background-color:  silver;">
			<a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=listAllMenu">菜单管理</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=listAllRole">角色管理</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/servlet/MyControllerServlet?operation=listAllUser">用户管理</a>
		</dir>
		<hr/>
	