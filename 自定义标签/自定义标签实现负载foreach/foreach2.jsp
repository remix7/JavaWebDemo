<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.cynara.cc/jsp/jstl/exampletag" prefix="ecynara" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>简单foreach</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	  </head>
  
  <body>
    <%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    pageContext.setAttribute("list",list);
    %>
   <ecynara:forEach2 items="${list}" var="s" >
   	${s}<br/>
   </ecynara:forEach2><hr/>
    <%
   	Set set = new HashSet();
    set.add("aaaa");
    set.add("bbbb");
    set.add("cccc");
    set.add("dddd");
    pageContext.setAttribute("set",set);
    %>
   <ecynara:forEach2 items="${set}" var="s" >
   	${s}<br/>
   </ecynara:forEach2><hr/>
    <%
   	Map map = new HashMap();
    map.put("a","aaaaa");
    map.put("b","bbbbb");
    map.put("c","ccccc");
    map.put("d","ccccc");
    pageContext.setAttribute("map",map);
    %>
   <ecynara:forEach2 items="${map}" var="me" >
   	${me.key}=${me.value}<br/>
   </ecynara:forEach2><hr/>
   <%
    String strs[] = {"a","b","c","d"};
    pageContext.setAttribute("strs",strs);
    %>
   <ecynara:forEach2 items="${strs}" var="s" >
  	${s}<br/>
   </ecynara:forEach2><hr/>
  </body>
</html>
