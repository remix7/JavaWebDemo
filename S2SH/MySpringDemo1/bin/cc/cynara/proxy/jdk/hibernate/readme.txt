利用动态代理 给hibernate进行重构
jdk 结合hibernate 

jdk 动态代理标志  $proxy4
  动态代理内容就是invoke中的内容  代理对象方法体中的内容  就是invoke中的内容
1.编写一个domain  person
2.编写一个personDao接口  定义要实现的方法
3.编写一个工具类 hibernateUtils  实现获取sessionFactory
4.编写一个类继承hibernate 并且实现personDao 从写dao中的方法
5.编写一个能够开启事物和关闭事物的类  mytransaction   并写上开启事物和关闭事物的方法
6.编写拦截器类 PersonDaoInterceptor 实现InvocationHandler  重写invoke 方法
	1.确定目标类
	2.引入事物
	3.在invoke方法中先开启事物 在执行方法  再关闭事物
7.编写测试类ProxyJdkHibernateTest
	将PersonDaoInterceptor中需要的参数做出来并通过构造方法传递给PersonDaoInterceptor
	实现它即可
	PersonDao personDao = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);

	注：
		在hibernate.cfg.xml文件中加入
			<!-- 
				告诉hibernate session是由线程产生
			-->
			<property name="current_session_context_class">thread</property>
			
			
			
		拦截器中invoke方法体的内容就是代理对象方法的内容
		当客户点只想代理对象.方法时  金融拦截器invoke方法体
		拦截器中invoke方法的method参数是在调用的时候赋值