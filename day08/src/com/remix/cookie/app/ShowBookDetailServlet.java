package com.remix.cookie.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.krb5.internal.SeqNumber;
//显示书籍的详细内容
//向客户端写bookHistory的cookie
public class ShowBookDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//显示书籍的详细内容
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		Book b = BookDB.findBookById(id);
		out.write(b.toString());
		//向客户端写bookHistory的Cookie
		String ids = makeIds(request,id);
		Cookie c = new Cookie(Constant.BOOK_HISTORY,ids);
		c.setMaxAge(Integer.MAX_VALUE);
		c.setPath(request.getContextPath());
		response.addCookie(c);
	}
	//  原有Cookied的ID           当前访问的id     应该写回去的ID
	//a cookie[] cs 的id为null    1             bH=1
	//b 没有bH的cookie    		 1			   bH=1
	//c 1                        2                2-1
	//d 2-1                      1                1-2
	//e 1-2                      3                3-1-2
	//f 1-2-3                    2			      2-1-3
	//g 2-1-3					 4				  4-2-1
	private String makeIds(HttpServletRequest request, String id) {
		//a  第一次访问把bH写入访问的
		Cookie cs[] = request.getCookies();
		if(cs==null){
			return id;
		}
		//b	
		Cookie cookie = null;
		for(Cookie c:cs){
			if(Constant.BOOK_HISTORY.equals(c.getName())){
				cookie = c;
				break;
			}
		}
		if(cookie==null){
			return id;
		}
		//cd-g
		String ids[] = cookie.getValue().split("\\-");
		//用LinkedList  操作头尾方便
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));
		//cde
		if(list.size()<3){
			if(list.contains(id)){//cookie的长度小于三  判断是否有访问的是否是二次访问
				list.remove(id);//如果是二次访问  则删除它
			}
			list.addFirst(id);//并把它加到第一位
			
		}else{//fg
			if(list.contains(id)){//cookie的长度等于三  判断是否有访问的是否是二次访问
				list.remove(id);//如果有删除它
			}else{
				list.removeLast();//如果没有删除最后一个
			}
			list.addFirst(id);//把它加到第一位
		}
		StringBuffer sb = new StringBuffer();
		for(int i =0;i < list.size();i++){
			if(i>0){
				sb.append("-");
			}
			sb.append(list.get(i));
		}
		return sb.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
