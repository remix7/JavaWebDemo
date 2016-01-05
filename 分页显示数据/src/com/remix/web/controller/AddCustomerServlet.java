package com.remix.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.remix.domain.Customer;
import com.remix.service.CustomerService;
import com.remix.service.impl.CustomerServiceImpl;
import com.remix.util.FormBeanUtils;
import com.remix.web.formbean.CustomerFormBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
//添加用户
public class AddCustomerServlet extends HttpServlet {
	private CustomerService s = new CustomerServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			CustomerFormBean formBean = FormBeanUtils.fillFormBean(CustomerFormBean.class, request);
			if(!formBean.validate()){
				request.setAttribute("formBean", formBean);
				request.getRequestDispatcher("/addCustomer.jsp").forward(request, response);
				return;
			}
			//填充模型formBean-->javaBean
			Customer c = new Customer();
			ConvertUtils .register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(c, formBean);
			//对爱好进行特殊处理
			String[] hobbies = formBean.getHobbies();
			if(hobbies!=null&&hobbies.length>0){
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<hobbies.length;i++){
					if(i>0)
						sb.append(",");
					sb.append(hobbies[i]);
				}
				c.setHobby(sb.toString());
			}
			//保存到数据库
			s.addCustomer(c);
//			request.setAttribute("message", "添加成功！");
//			request.getRequestDispatcher("/message.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "服务器忙！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
