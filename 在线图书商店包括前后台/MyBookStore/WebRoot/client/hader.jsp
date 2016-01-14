<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
  <link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body style="text-align: center;">
  <h1>欢迎使用</h1>
  <a href="${pageContext.request.contextPath}">首页</a>&nbsp;&nbsp;
  <c:if test="${sessionScope.user==null}">
  		<a href="${pageContext.request.contextPath}/client/login.jsp">登录</a>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/client/regist.jsp">注册</a>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/client/cart.jsp">购物车</a>
  </c:if>
    <c:if test="${sessionScope.user!=null}">
   	 欢迎您:${sessionScope.user.nick}&nbsp;&nbsp;
   	 	<a href="${pageContext.request.contextPath}/client/cart.jsp">购物车</a>&nbsp;&nbsp;
   	 	<a href="${pageContext.request.contextPath}/servlet/ClientServlet?operation=myOrders">我的订单</a>&nbsp;&nbsp;
   	 	<a href="${pageContext.request.contextPath}/servlet/ClientServlet?operation=logOut">注销</a>
    </c:if>
  <hr/>
  <div style="background-color: #cfcfcf" align="left" >
    	
    	<c:forEach items="${sessionScope.cs}" var="c">
    		<a href="${pageContext.request.contextPath}/servlet/ClientServlet?operation=showCategoryBooks&categoryId=${c.id}">${c.name}</a>
    	</c:forEach>
   </div>
   
    
