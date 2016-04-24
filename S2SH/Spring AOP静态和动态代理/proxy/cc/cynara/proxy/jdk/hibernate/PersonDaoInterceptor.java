package cc.cynara.proxy.jdk.hibernate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonDaoInterceptor implements InvocationHandler {
	private Object target;
	private MyTransaction myTransaction;
	
	
	public PersonDaoInterceptor(Object target, MyTransaction myTransaction) {
		this.target = target;
		this.myTransaction = myTransaction;
	}


	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		this.myTransaction.beginTransaction();
		method.invoke(this.target, args);
		this.myTransaction.commit();
		return null;
	}

}
