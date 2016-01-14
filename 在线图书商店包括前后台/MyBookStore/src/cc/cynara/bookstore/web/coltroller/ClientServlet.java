package cc.cynara.bookstore.web.coltroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.cynara.bookstore.domain.Book;
import cc.cynara.bookstore.domain.Cart;
import cc.cynara.bookstore.domain.CartItem;
import cc.cynara.bookstore.domain.Category;
import cc.cynara.bookstore.domain.OrderItem;
import cc.cynara.bookstore.domain.Orders;
import cc.cynara.bookstore.domain.Page;
import cc.cynara.bookstore.domain.User;
import cc.cynara.bookstore.service.BusnessService;
import cc.cynara.bookstore.service.impl.BusnessServiceImpl;
import cc.cynara.bookstore.util.FormUtils;
import cc.cynara.bookstore.util.OrdersId;

public class ClientServlet extends HttpServlet {

	private BusnessService s = new BusnessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if ("showIndexCategory".equals(operation)) {
			showIndexCategory(request, response);
		}
		if ("showCategoryBooks".equals(operation)) {
			showCategoryBooks(request, response);
		}
		if ("buyBook".equals(operation)) {
			buyBook(request, response);
		}
		if ("regist".equals(operation)) {
			regist(request, response);
		}
		if("login".equals(operation)){
			login(request,response);
		}
		if("logOut".equals(operation)){
			logOut(request,response);
		}
		if("saveOrders".equals(operation)){
			saveOrders(request,response);
		}
		if("myOrders".equals(operation)){
			myOrders(request,response);
		}
		if("showOrdersDet".equals(operation)){
			showOrdersDet(request,response);
		}
	}
	//查看订单的详细信息
	private void showOrdersDet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderid");
		Orders orders = s.findORdersById(orderId);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/client/ordersDet.jsp").forward(request, response);
		
	}
	//用户查看修改订单  根据用户的Id
	private void myOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<Orders> orders = s.findOrdersByUserId(user.getId());
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/client/myOrders.jsp").forward(request, response);
		
		
	}
	//保存用户的订单信息
	private void saveOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//判断用户有没有登录 如果没有 转向登录页面
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			request.getRequestDispatcher("/client/login.jsp").forward(request,response);
			return;
		}
		//有 则取出用户
		//取出购物车
		Cart cart = (Cart) session.getAttribute("cart");
		Orders orders = new Orders();// 把cart中的数据保存到模型中去
		orders.setNum(cart.getNum());
		orders.setPrice(cart.getPrice());
		//搞购物项
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for(Map.Entry<String, CartItem> item:cart.getItems().entrySet()){
			CartItem i = item.getValue();
			OrderItem orderItem = new OrderItem();
			orderItem.setNum(i.getNum());
			orderItem.setPrice(i.getPrice());
			orderItem.setBook(i.getBook());
			orderItems.add(orderItem);
		}
		orders.setItems(orderItems);
		s.addOrders(orders,user);
		session.removeAttribute("cart");
		request.setAttribute("message", "生成订单成功!!");
		request.getRequestDispatcher("/client/message.jsp").forward(request,response);
	}
	//用户注销登录
	private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		request.setAttribute("message", "注销成功,请重新登录!!");
		request.getRequestDispatcher("/client/message.jsp").forward(request,response);
	}
	//用户登录
	private void login(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = s.findUser(username,password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			request.setAttribute("message", "登录成功!!");
			request.getRequestDispatcher("/client/cart.jsp").forward(request,response);
		}else{
			request.setAttribute("message", "用户名或密码错误,请重新登录!!");
			request.getRequestDispatcher("/client/message.jsp").forward(request,response);
		}
	}

	// 用户注册
	private void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = FormUtils.fillBean(User.class, request);
		s.regist(user);
		request.setAttribute("message", "注册成功!!");
		request.getRequestDispatcher("/client/message.jsp").forward(request,
				response);
	}

	// 把书放入到购物车中
	private void buyBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取书的id
		String bookId = request.getParameter("bookId");
		// 获取书
		Book book = s.findBookById(bookId);
		// 看看有没有购物车 没有创建一个把书加入购物车 有就直接加入购物车
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addBook(book);
		// 提示加入成功
		request.setAttribute("message", "购买成功!!");
		request.getRequestDispatcher("/client/message.jsp").forward(request,
				response);
	}

	// 查找分类的书
	private void showCategoryBooks(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pagenum = request.getParameter("pagenum");
		String categoryId = request.getParameter("categoryId");
		Page page = s.findPageRecords(pagenum, categoryId);
		page
				.setUrl("/servlet/ClientServlet?operation=showCategoryBooks&categoryId="
						+ categoryId);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/client/welcome.jsp").forward(request,
				response);
	}

	// 查询所有分类 便于前端显示 & 查询所有书籍 并分类
	private void showIndexCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> cs = s.findAllCategory();
		request.getSession().setAttribute("cs", cs);

		String pagenum = request.getParameter("pagenum");
		Page page = s.findPageRecords(pagenum);
		page.setUrl("/servlet/ClientServlet?operation=showIndexCategory");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/client/welcome.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
