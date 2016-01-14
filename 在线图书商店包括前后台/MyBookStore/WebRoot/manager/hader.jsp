<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body style="text-align: center;">
    <h1>欢迎使用在线书店后台管理系统</h1><hr/>
    <div style="background-color: #cfcfcf" align="left">
    	&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/manager/category.jsp">分类管理</a>&nbsp;&nbsp;
    	&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/manager/bookUI.jsp">图书管理</a>&nbsp;&nbsp;
    	&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=showOrdes0">代发货订单</a>&nbsp;&nbsp;
    	&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/servlet/ManagerServlet?operation=showOrdes1">已发货订单</a>&nbsp;&nbsp;
    </div>
    <hr/>
