package cc.cynara.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GzipFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		GzipHttpServletResponse gresponse = new GzipHttpServletResponse(response);
		chain.doFilter(request, gresponse);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//把数据压缩到缓存流中
		GZIPOutputStream gos = new GZIPOutputStream(baos);
		//取出数据 压缩后的
		byte[] b = gresponse.getOldBytes();
		System.out.println(b.length);
		gos.write(b);
		gos.close();
		//取出压缩后的数据
		b = baos.toByteArray();
		System.out.println(b.length);
		//输出前告诉浏览器压缩方式
		response.setHeader("Content-Encoding", "gzip");
		response.setContentLength(b.length);
		//用服务器的响应对象输出
		ServletOutputStream sos = response.getOutputStream();
		sos.write(b);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
