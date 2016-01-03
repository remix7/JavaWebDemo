package cc.cynara.autologin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 实现自动登录
 * 
 * @author REMIX-7
 * 
 */
public class AutoLoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 1,获取名为loginInfo的cookie
		User u = (User)request.getSession().getAttribute("user");
		if(u==null){
			Cookie loginInfoCookie = null;
			Cookie cs[] = request.getCookies();
			for (int i = 0; cs != null && i < cs.length; i++) {
				if ("loginInfo".equals(cs[i].getName())) {
					loginInfoCookie = cs[i];
					break;
				}
			}
			if (loginInfoCookie != null) {
				// 2,有：取出Cookie的值 用户名_加密后的密码
				String user_pass = loginInfoCookie.getValue();
				// 3,拆出用户名和密码
				String username = user_pass.split("\\_")[0];
				username = new String(new BASE64Decoder().decodeBuffer(username));
				System.out.println(username);
				String password = user_pass.split("\\_")[1];
				// 4,再次效验用户名和密码 先根据用户名查出密码 把密码加密后再跟Cookie中的密码进行比对
				User user = UserDB.findUser(username);
				if (user != null) {
					if (password.equals(MD5Util.Md5(user.getPassword()))) {
						// 5,正确 则得到用户放到session中
						request.getSession().setAttribute("user", user);
					}
				}
			}
		}
		// 放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
