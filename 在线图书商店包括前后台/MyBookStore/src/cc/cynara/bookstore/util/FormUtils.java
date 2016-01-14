package cc.cynara.bookstore.util;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.commons.beanutils.BeanUtils;

public class FormUtils {
	public static <T> T fillBean(Class<T> clazz,HttpServletRequest request){
		try {
			T t = clazz.newInstance();
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
