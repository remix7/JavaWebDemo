package com.remix.request;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.remix.domain.Student;

public class RequestDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student s = new Student();
		request.setCharacterEncoding("UTF-8");
		System.out.println("封装前:"+s);
		try {
			BeanUtils.populate(s, request.getParameterMap());
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("封装后:"+s);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
