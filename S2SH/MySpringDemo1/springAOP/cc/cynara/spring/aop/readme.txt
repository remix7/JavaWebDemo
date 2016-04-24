使用Spring重构hibernate项目
1.编写javabean dao daoimpl
2.编写切面类 和通知方法
3.修改hibernate.cfg.xml 文件的hbm.xml所在位置
4.在spring配置文件中加入   
		入命名空间
    	xmlns:aop="http://www.springframework.org/schema/aop"
    	http://www.springframework.org/schema/aop 
        http://www.springframework.org/schema/aop/spring-aop-2.5.xsd
5.加入jar包
		aspectjrt.jar
		aspectjweaver.jar
6.在applicationContext.xml中处理操作
	<bean id="personDao" class="cc.cynara.spring.aop.PersonDaoImpl"></bean>
    <bean id="myTransaction" class="cc.cynara.spring.aop.MyTransaction"></bean>
    <!-- 
   	aop配置
    -->
    <aop:config>
    	<!-- 
    		切入点表达式
    	 -->
    	<aop:pointcut expression="execution(* cc.cynara.spring.aop.PersonDaoImpl.*(..))" id="preform"/>
    	<!-- 
    		切面
    	 -->
    	<aop:aspect ref="myTransaction">
    	<!-- 
    		通知
    	 -->
    	 <aop:before method="beginTransaction" pointcut-ref="preform"/>
    	 <aop:after-returning method="commit" pointcut-ref="preform"/>
    	</aop:aspect>
    </aop:config>
    即可完成
    
各种通知：
	通知：
   1、前置通知
      1、在目标方法执行之前执行
      2、无论目标方法是否抛出异常，都执行，因为在执行前置通知的时候，目标方法还没有执行，还没有遇到异常
   2、后置通知
      1、在目标方法执行之后执行
      2、当目标方法遇到异常，后置通知将不再执行
      3、后置通知可以接受目标方法的返回值，但是必须注意：
               后置通知的参数的名称和配置文件中returning="var"的值是一致的
   3、最终通知：
      1、在目标方法执行之后执行
      2、无论目标方法是否抛出异常，都执行，因为相当于finally
   4、异常通知
      1、接受目标方法抛出的异常信息
      2、步骤
           在异常通知方法中有一个参数Throwable  ex
           在配置文件中
              <aop:after-throwing method="throwingMethod" pointcut-ref="perform" throwing="ex"/>
   5、环绕通知
       1、如果不在环绕通知中调用ProceedingJoinPoint的proceed，目标方法不会执行
       2、环绕通知可以控制目标方法的执行
	