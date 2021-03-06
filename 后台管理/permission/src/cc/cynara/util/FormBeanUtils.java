package cc.cynara.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormBeanUtils {
	public static <T>T fillFormBean(Class<T> clazz,HttpServletRequest request){
		try {
			T bean = clazz.newInstance();
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
