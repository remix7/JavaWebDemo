package com.remix.request;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.remix.domain.User;
//��ȡ�������
public class RequestDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test7(request);
	}
	//��ȡ�û�����ı�ܲ���  getParameter���ۻ�ȡ��һ��ֵ
	@SuppressWarnings("unused")
	private void test1(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+":"+password);
	}
	//��ȡ�û�����ı�ܲ���  ��ȡ��������
	@SuppressWarnings("unused")
	private void test2(HttpServletRequest request) {
		String[] usernames = request.getParameterValues("username");
		String[] passwords = request.getParameterValues("password");
		for(String s :usernames){
			System.out.println(s);
		}
		for(String s :passwords){
			System.out.println(s);
		}
	}
	//��ȡ���еĲ�����ȡֵ  
	@SuppressWarnings("unused")
	private void test3(HttpServletRequest request) {
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String paramName = (String) e.nextElement();
				String[] values = request.getParameterValues(paramName);
				System.out.println(paramName+":"+Arrays.asList(values));
				
			}
	}
	//ʹ��javaBean�����ݽ��з�װ
	@SuppressWarnings("unused")
	private void test4(HttpServletRequest request) {
			Enumeration e = request.getParameterNames();
			User user = new User();
			System.out.println("��װǰ"+user);
			while(e.hasMoreElements()){
				String paramName = (String) e.nextElement();
				String[] values = request.getParameterValues(paramName);
				try {
					PropertyDescriptor pd = new PropertyDescriptor(paramName, User.class);
					Method m = pd.getWriteMethod();//�ô�setting����
					if(!(values.length>1)){
						m.invoke(user, values);
					}else{
						m.invoke(user, (Object)values);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("��װ��"+user);
			}
	}
	//ʹ��javaBean�����ݽ��з�װ
	@SuppressWarnings("unused")
	private void test5(HttpServletRequest request) {
			User user = new User();
			System.out.println("��װǰ��"+user);
			Map<String,String[]> map = request.getParameterMap();
			for(Map.Entry<String, String[]> me:map.entrySet()){
//				System.out.println(me.getKey());
//				for(String s : me.getValue()){
//					System.out.println(s);
//				}
				String paramName = me.getKey();
				String[] values = me.getValue();
				try {
					PropertyDescriptor pd = new PropertyDescriptor(paramName, User.class);
					Method m = pd.getWriteMethod();//�ô�setting����
					if(!(values.length>1)){
						m.invoke(user, values);
					}else{
						m.invoke(user, (Object)values);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.println("��װ��:"+user);
	}
	
	//ʹ��javaBean�����ݽ��з�װ  ʹ��BeanUtil�ļ�����
	@SuppressWarnings("unused")
	private void test6(HttpServletRequest request) {
			User user = new User();
			System.out.println("��װǰ��"+user);
			try {
				//ʵ��ԭ�����test5д  ���ֱ���������javaBena��������ͬ
				BeanUtils.populate(user, request.getParameterMap());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("��װ��:"+user);
	}
	
	//���ӻ�ȡ����
	private void test7(HttpServletRequest request) throws IOException {
			ServletInputStream in = request.getInputStream();
			int len = -1;
			byte[] b = new byte[1024];
			while((len = in.read(b))!=-1){
				System.out.println(new String(b,0,len));
			}
			in.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
