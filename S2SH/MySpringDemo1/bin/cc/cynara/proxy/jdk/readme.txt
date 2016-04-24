利用jdk进行动态代理
	jdk的动态代理：
   	1、因为是用jdk的API做到的
   	2、代理对象是动态产生的
	
编写一个拦截器  必须继承InvocationHandler
1.目标类
2.引入事物
3.利用构造方法赋值
4.	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		this.transaction.beginTransaction();  //开启事物
		method.invoke(this.target, args);  //调用方法
		this.transaction.commit();		//提交事物
		return null;
	}
 
 在客户端
 	@Test
	public void test(){
		Object target = new PersonDaoImpl();
		Transaction transaction = new Transaction();
		PersonInterceptor interceptor = new PersonInterceptor(target, transaction);
		/**
		 * loader 目标类的类加载器
		 * interfaces 目标类实现的所有接口
		 * h 拦截器
		 */
		PersonDao dao = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),interceptor);
		dao.deletePerson();
	}