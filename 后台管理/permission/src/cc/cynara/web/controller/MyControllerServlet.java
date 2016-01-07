package cc.cynara.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.cynara.domain.Menu;
import cc.cynara.domain.Role;
import cc.cynara.domain.User;
import cc.cynara.service.BuinessService;
import cc.cynara.service.impl.BuinessServiceImpl;
import cc.cynara.util.FormBeanUtils;
import cc.cynara.web.formbean.MenuFormBean;
import cc.cynara.web.formbean.RoleFormBean;
import cc.cynara.web.formbean.UserFormBean;

public class MyControllerServlet extends HttpServlet {

	private BuinessService s = new BuinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if("listAllMenu".equals(operation)){
			listAllMenu(request,response);
		}
		if("addMenu".equals(operation)){
			addMenu(request,response);
		}
		if("updataMenu".equals(operation)){
			updataMenu(request,response);
		}
		String del = request.getParameter("delOneMenu");
		if(del!=null){
			delOneMenu(del,request,response);
		}
		if(request.getParameter("updateMenu")!=null){
			findOneMenu(request,response);
		}
		if("listAllRole".equals(operation)){
			findAllRole(request,response);
		}
		if("addRole".equals(operation)){
			addRole(request,response);
		}
		String roleId = request.getParameter("delOneRole");
		if(roleId!=null){
			delOneRole(roleId,request,response);
		}
		if(request.getParameter("updateRole")!=null){
			findOneRole(request,response);
		}
		if("updataRole".equals(operation)){
			updataRole(request,response);
		}
		if("grantMenu2RoleUI".equals(operation)){
			grantMenu2RoleUI(request,response);
		}
		if("grantMenu2Role".equals(operation)){
			grantMenu2Role(request,response);
		}
		if("listAllUser".equals(operation)){
			listAllUser(request,response);
		}
		if("addUser".equals(operation)){
			addUser(request,response);
		}
		String userId = request.getParameter("delOneUser");
		if(userId!=null){
			delOneUser(userId,request,response);
		}
		if(request.getParameter("updateUser")!=null){
			findOneUser(request,response);
		}
		if("updataUser".equals(operation)){
			updataUser(request,response);
		}
		if("grantRole2UserUI".equals(operation)){
			grantRole2UserUI(request,response);
		}
		if("grantRole2User".equals(operation)){
			grantRole2User(request,response);
		}
		//--------------------------------------------以下是操作客户端
		if("showCuntomerMenu".equals(operation)){
			showCuntomerMenu(request,response);
		}
		if("login".equals(operation)){
			login(request,response);
		}
		if("logOut".equals(operation)){
			logOut(request,response);
		}
	}
	/**
	 * 用户注销
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		showCuntomerMenu(request, response);
	}
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = s.findUserByUsernameAndPassword(username,password);
		if(u==null){
			User u1 = s.findUserByUsername(username);
			if(u1==null){
				request.setAttribute("errors", "用户不存在!");
				request.getRequestDispatcher("/customer/login.jsp").forward(request, response);
			}else{
				request.setAttribute("username", username);
				request.setAttribute("errors", "用户名或密码错误!");
				request.getRequestDispatcher("/customer/login.jsp").forward(request, response);
			}
		}else{
			request.getSession().setAttribute("user", u);
			showCuntomerMenu(request, response);
		}
	}
	/**
	 * 展示前台
	 * @param request
	 * @param response
	 */
	private void showCuntomerMenu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		List<Menu> menus = s.FindAllMenu();
		request.setAttribute("menu", menus);
		request.getRequestDispatcher("/customer/index.jsp").forward(request, response);
	}
	//------------------------------------以下是操作后台
	/**
	 * 建立用户和权限直接的关系
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void grantRole2User(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String[] rIds = request.getParameterValues("rIds");//所有的菜单的ID
		if(rIds!=null&&rIds.length>0){
			s.grantRole2User(userId,rIds);
		}
		request.getRequestDispatcher("/servlet/MyControllerServlet?operation=listAllUser").forward(request, response);
	}
	/**
	 * 角色和用户
	 * 建立新的关系
	 * @param request
	 * @param response
	 */
	private void grantRole2UserUI(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String userId = request.getParameter("userId");
		User u  = s.unionFindUserById(userId);
		List<Role> roles = s.findAllRole();
		request.setAttribute("user", u);
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/manager/grantRole2UserUI.jsp").forward(request, response);
	}
	/**
	 * 更新用户信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void updataUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User u = s.findUserById(id);
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setNick(request.getParameter("nick"));
		UserFormBean formBean = FormBeanUtils.fillFormBean(UserFormBean.class, request);
		if(!formBean.validate()){
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/manager/updataUser.jsp").forward(request, response);
		}else{
			s.updateUser(u);
			listAllUser(request, response);
		}
	}
	/**
	 * 根据Id查询一个用户
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void findOneUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User u  = s.findUserById(request.getParameter("updateUser"));
		request.setAttribute("user", u);
		request.getRequestDispatcher("/manager/updataUser.jsp").forward(request, response);
	}
	/**
	 * 根据用户id删除用户
	 * @param userId
	 * @param request
	 * @param response
	 */
	private void delOneUser(String userId, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		s.delRoleRelation(userId);
		s.delOneUser(userId);
//		listAllMenu(request, response);
		response.setHeader("Refresh", "0;URL="+request.getContextPath()+"/servlet/MyControllerServlet?operation=listAllUser");
		
	}
	/**
	 * 添加一个用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User u =new User();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setNick(request.getParameter("nick"));
		request.setAttribute("user", u);
		UserFormBean formBean = FormBeanUtils.fillFormBean(UserFormBean.class, request);
		if(!formBean.validate()){
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/manager/addUser.jsp").forward(request, response);
		}else{
			s.addUser(u);
			listAllUser(request, response);
		}
	}
	/**
	 * 显示所有的用户
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void listAllUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<User> users = s.findAllUser();
		request.setAttribute("user", users);
		request.getRequestDispatcher("/manager/listUser.jsp").forward(request, response);
	}
	/**
	 * 角色和菜单
	 * 建立新的关系
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void grantMenu2Role(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String roleId = request.getParameter("roleId");
		String[] mIds = request.getParameterValues("mIds");//所有的菜单的ID
		if(mIds!=null&&mIds.length>0){
			s.grantMenu2Role(roleId,mIds);
		}
		request.getRequestDispatcher("/servlet/MyControllerServlet?operation=listAllRole").forward(request, response);
		
	}
	/**
	 * 得到角色分配列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void grantMenu2RoleUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String roleId = request.getParameter("roleId");
		Role r = s.findRoleById(roleId);
		List<Menu> menus = s.FindAllMenu();
		request.setAttribute("role", r);
		request.setAttribute("menus", menus);
		request.getRequestDispatcher("/manager/grantMenu2RoleUI.jsp").forward(request, response);
	}
	/**
	 * 更新角色信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updataRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Role r = s.findRoleById(id);
		r.setName(request.getParameter("name"));
		r.setDescription(request.getParameter("description"));
		RoleFormBean formBean = FormBeanUtils.fillFormBean(RoleFormBean.class, request);
		if(!formBean.validate()){
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/manager/updataRole.jsp").forward(request, response);
		}else{
			s.updateRole(r);
			findAllRole(request, response);
		}
	}
	/**
	 * 查询一个角色
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findOneRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Role r  = s.findRoleById(request.getParameter("updateRole"));
		request.setAttribute("role", r);
		request.getRequestDispatcher("/manager/updataRole.jsp").forward(request, response);
	}
	/**
	 * 删除一个角色
	 * @param delRoleId
	 * @param request
	 * @param response
	 */
	private void delOneRole(String roleId, HttpServletRequest request,
			HttpServletResponse response) {
		s.delRoleRelationByRoleId(roleId);
		s.delMenuRelation(roleId);
		s.delOneRole(roleId);
//		listAllMenu(request, response);
		response.setHeader("Refresh", "0;URL="+request.getContextPath()+"/servlet/MyControllerServlet?operation=listAllRole");
	}
	/**
	 * 添加一个角色
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Role r = new Role();
		r.setName(request.getParameter("name"));
		r.setDescription(request.getParameter("description"));
		request.setAttribute("role", r);
		RoleFormBean formBean = FormBeanUtils.fillFormBean(RoleFormBean.class, request);
		if(!formBean.validate()){
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/manager/addRole.jsp").forward(request, response);
		}else{
			s.addRole(r);
			findAllRole(request, response);
		}
	}
	/**
	 * 查询出所有的角色
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findAllRole(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Role> roles = s.findAllRole();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/manager/listRoles.jsp").forward(request, response);
	}
	/**
	 * 更新菜单信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updataMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		Menu m = s.findMenuById(id);
		m.setName(request.getParameter("name"));
		m.setUri(request.getParameter("uri"));
		m.setDescription(request.getParameter("description"));
		MenuFormBean formBean = FormBeanUtils.fillFormBean(MenuFormBean.class, request);
		if(!formBean.validate()){
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/manager/updataMenu.jsp").forward(request, response);
		}else{
			s.updateMenu(m);
			listAllMenu(request, response);
		}
	}
	/**
	 * 查询一个菜单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findOneMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Menu m = s.findMenuById(request.getParameter("updateMenu"));
		request.setAttribute("menu", m);
		request.getRequestDispatcher("/manager/updataMenu.jsp").forward(request, response);
	}
	/**
	 * 删除一个
	 * @param del
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delOneMenu(String del, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		s.deleteMenu(del);
//		listAllMenu(request, response);
		response.setHeader("Refresh", "0;URL="+request.getContextPath()+"/servlet/MyControllerServlet?operation=listAllMenu");
	}
	/**
	 * 添加菜单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addMenu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		Menu m =new Menu();
		m.setName(request.getParameter("name"));
		m.setUri(request.getParameter("uri"));
		m.setDescription(request.getParameter("description"));
		request.setAttribute("menu", m);
		MenuFormBean formBean = FormBeanUtils.fillFormBean(MenuFormBean.class, request);
		if(!formBean.validate()){
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/manager/addMenu.jsp").forward(request, response);
		}else{
			s.addMenu(m);
			listAllMenu(request, response);
		}
	}
	/**
	 * 获得所有菜单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listAllMenu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		List<Menu> menus = s.FindAllMenu();
		request.setAttribute("menus", menus);
		request.getRequestDispatcher("/manager/listMenu.jsp").forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
