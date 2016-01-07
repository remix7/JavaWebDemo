package cc.cynara.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.cynara.domain.Menu;
import cc.cynara.domain.Role;
import cc.cynara.domain.User;
import cc.cynara.service.BuinessService;
import cc.cynara.service.impl.BuinessServiceImpl;


public class PersissionFilter implements Filter {
	private BuinessService s = new BuinessServiceImpl();
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//判断用户是否登录
		User user = (User)request.getSession().getAttribute("user");
		//没有登录转向登录页面
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/customer/login.jsp");
			return;
		}
		//已登录
		//拿到当前用户的所有角色
		List<Role> roles = s.findUserById(user.getId()).getRoles();
		//拿到角色的所有菜单 保存到set中  为了不重复
		Set<Menu> menus = new HashSet<Menu>();
		for(Role r : roles){
			Role role = s.findRoleById(r.getId());
			List<Menu> ms = role.getMenus();
			for(Menu m:ms){
				menus.add(m);
			}
		}
		//拿到当前用户访问的Uri  判断是否在权限范围之内
		String uri = request.getRequestURI();
		uri = uri.replace(request.getContextPath(), "");
		boolean hasPersission = false;
		for(Menu m:menus){
			if(uri.equals(m.getUri())){
				hasPersission = true;
				break;
			}
		}
		//不是  提示咩有权限
		if(!hasPersission){
			request.setAttribute("errors", "对不起,您没有访问权限!");
			List<Menu> menuss = s.FindAllMenu();
			request.setAttribute("menu", menuss);
			request.getRequestDispatcher("/customer/index.jsp").forward(request, response);
			return;
		}
		//是放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}


}
