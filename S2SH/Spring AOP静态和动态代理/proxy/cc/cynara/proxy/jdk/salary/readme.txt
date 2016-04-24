 基于权限的动态代理实现   admin用户查看可以薪水  其他都没权限
 1.编写SalaryManager接口  定义查看薪水接口
 2.编写SalaryManagerImpl 实现SalaryManager 其中的查看薪水
 3.编写日志了 logger 定义写日志方法
 5.编写Security 类 确定访问安全
 6.编写Privilege 类定义pro 字段  描述 用户的权限
 7.编写SalaryInterceptor 拦截器   实现InvocationHandler
 8.在SalaryInterceptor 加入目标类  日志 权限 安全
 9.重写invoke方法
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
10.在客户端
	@Test
	public void test(){
		SalaryManager manager = new SalaryManagerImpl();
		Logger logger = new Logger();
		Privilege privilege = new Privilege();
		privilege.setPri("admin");
		Security security = new Security();
		SalaryInterceptor interceptor = new SalaryInterceptor(manager, logger, privilege, security);
		SalaryManager salaryManager = (SalaryManager)Proxy.newProxyInstance(manager.getClass().getClassLoader(), manager.getClass().getInterfaces(), interceptor);
		salaryManager.showSalary();
		
	}