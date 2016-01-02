<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入自定义taglib标签 -->
<%@ taglib uri="http://www.cynara.cc/jsp/jstl/simpletag" prefix="scynara" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>自定义标签</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	您的IP地址是：<scynara:showLocalAddr/>
  </body>
</html>
