package cc.cynara.bookstore.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper {
	
	public MyHttpServletRequest(HttpServletRequest request){
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(value==null){
			return value;
		}
		String mathod = super.getMethod();
		if("get".equalsIgnoreCase(mathod)){
			try {
				value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
}	
