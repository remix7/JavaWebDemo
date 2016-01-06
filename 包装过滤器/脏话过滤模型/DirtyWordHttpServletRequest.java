package cc.cynara.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * 脏话过滤器
 * @author REMIX-7
 *
 */
public class DirtyWordHttpServletRequest extends HttpServletRequestWrapper {
	private String[] words = {"尼玛","傻逼","杀雕"};
	public DirtyWordHttpServletRequest(HttpServletRequest request){
		super(request);
	}
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(value==null){
			return value;
		}
		for(String dword:words){
			if(value.contains(dword)){
				value = value.replace(dword, "*");
			}
		}
		return value;
	}
}
