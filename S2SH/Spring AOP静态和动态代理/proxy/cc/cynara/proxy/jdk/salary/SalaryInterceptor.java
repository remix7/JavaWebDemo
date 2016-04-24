package cc.cynara.proxy.jdk.salary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SalaryInterceptor implements InvocationHandler{
	private Object object;
	private Logger logger;
	private Privilege privilege;
	private Security security;
	
	public SalaryInterceptor(Object object, Logger logger, Privilege privilege,
			Security security) {
		this.object = object;
		this.logger = logger;
		this.privilege = privilege;
		this.security = security;
	}


	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		this.logger.logging();
		this.security.security();
		if(this.privilege.getPri().equals("admin")){
			method.invoke(this.object, args);
		}else{
			System.out.println("没有权限");
		}
		return null;
	}

}
