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

public class AllCharacterEncodingFilter implements Filter {
	private FilterConfig filterConfig;

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 获取配置的Parma值 如果没有给定默认值
		String encoding = filterConfig.getInitParameter("encoding");
		System.out.println(encoding);
		if (encoding == null) {
			encoding = "UTF-8";
		}
		// 设定post请求方式的中文编码问题
		request.setCharacterEncoding(encoding);
		// 设置响应输出的编码 字符流和字节流
		response.setCharacterEncoding(encoding);// 字节流输出时通知客户端使用的码表
		response.setContentType("text/html;charset=" + encoding);//
		// 放行
		 MyHttpServletRequest mRequest = new MyHttpServletRequest(request);
		chain.doFilter(mRequest, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
