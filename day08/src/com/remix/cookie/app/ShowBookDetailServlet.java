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
//��ʾ�鼮����ϸ����
//��ͻ���дbookHistory��cookie
public class ShowBookDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ʾ�鼮����ϸ����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		Book b = BookDB.findBookById(id);
		out.write(b.toString());
		//��ͻ���дbookHistory��Cookie
		String ids = makeIds(request,id);
		Cookie c = new Cookie(Constant.BOOK_HISTORY,ids);
		c.setMaxAge(Integer.MAX_VALUE);
		c.setPath(request.getContextPath());
		response.addCookie(c);
	}
	//  ԭ��Cookied��ID           ��ǰ���ʵ�id     Ӧ��д��ȥ��ID
	//a cookie[] cs ��idΪnull    1             bH=1
	//b û��bH��cookie    		 1			   bH=1
	//c 1                        2                2-1
	//d 2-1                      1                1-2
	//e 1-2                      3                3-1-2
	//f 1-2-3                    2			      2-1-3
	//g 2-1-3					 4				  4-2-1
	private String makeIds(HttpServletRequest request, String id) {
		//a  ��һ�η��ʰ�bHд����ʵ�
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
		//��LinkedList  ����ͷβ����
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));
		//cde
		if(list.size()<3){
			if(list.contains(id)){//cookie�ĳ���С����  �ж��Ƿ��з��ʵ��Ƿ��Ƕ��η���
				list.remove(id);//����Ƕ��η���  ��ɾ����
			}
			list.addFirst(id);//�������ӵ���һλ
			
		}else{//fg
			if(list.contains(id)){//cookie�ĳ��ȵ�����  �ж��Ƿ��з��ʵ��Ƿ��Ƕ��η���
				list.remove(id);//�����ɾ����
			}else{
				list.removeLast();//���û��ɾ�����һ��
			}
			list.addFirst(id);//�����ӵ���һλ
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
