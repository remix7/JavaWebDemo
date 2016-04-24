cglib代理产生的对象  是目标对象的子类

1.导入cglib-nodep-2.1_3.jar
2.编写接口 Interceptor 写上interceptor方法
3 Logger Privilege  Secutity 实现Interceptor接口 重写interceptor 方法
4.SalaryInterceptor 实现的是MethodInterceptor 接口 实现  interceptor方法
	并写一下方法
		public Object createProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);
		enhancer.setSuperclass(this.object.getClass());
		return enhancer.create();
	}
5.在测试类中
	@Test
	public void test(){
		Object manager = new SalaryManagerImpl();
		Logger logger = new Logger();
		Privilege privilege = new Privilege();
		Security security = new Security();
		List<Interceptor> interceptors = new ArrayList<Interceptor>();
		interceptors.add(logger);
		interceptors.add(privilege);
		interceptors.add(security);
		SalaryInterceptor interceptor = new SalaryInterceptor(manager, interceptors);
		SalaryManagerImpl proxy = (SalaryManagerImpl)interceptor.createProxy();
		proxy.showSalary();
	}