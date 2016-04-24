package cc.cynara.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInterceptor implements InvocationHandler {
	
	private Object target; //目标类
	private Transaction transaction;//引入事物
	
	public PersonInterceptor(Object target, Transaction transaction) {
		super();
		this.target = target;
		this.transaction = transaction;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		this.transaction.beginTransaction();  //开启事物
		method.invoke(this.target, args);  //调用方法
		this.transaction.commit();		//提交事物
		return null;
	}

}
