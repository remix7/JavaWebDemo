package cc.cynara.proxy.cglib.salary;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class SalaryInterceptor implements MethodInterceptor{
	private Object object;
	private List<Interceptor> interceptors;
	public SalaryInterceptor(Object object, List<Interceptor> interceptors) {
		this.object = object;
		this.interceptors = interceptors;
	}
	public Object createProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);
		enhancer.setSuperclass(this.object.getClass());
		return enhancer.create();
	}
	
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		for (Interceptor interceptor : interceptors) {
			interceptor.interceptor();
		}
		arg1.invoke(this.object, arg2);
		return null;
	}


	
}
