package cc.cynara.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 脏话过滤器模型
 * @author REMIX-7
 *
 */
public class DirtyWordFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		DirtyWordHttpServletRequest drequest = new DirtyWordHttpServletRequest(request);
		chain.doFilter(drequest, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
