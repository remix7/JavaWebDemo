package cc.cynara.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * HttpServletRequestWrapper 是一个默认适配器 它集成HttpservletRequest
 * 可以解决get方式的编码解码问题
 * @author REMIX-7
 *
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper {
	public MyHttpServletRequest(HttpServletRequest request){
		super(request);
	}
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(value==null){
			return value;
		}
		String mathod = super.getMethod();
		if("get".equalsIgnoreCase(mathod)){
			try {
				value = new String(value.getBytes("ISO-8859-1"),super.getCharacterEncoding());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
}
