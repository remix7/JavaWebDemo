利用spring  aop 重构权限查看工资   一个目标类可以跟很多个切面  注意通知的使用
1.编写目标类 SalaryManagerImpl 并工资查看方法
2.编写切面 Logger 日志   Prvilege 权限  Security 安全
3.编写 applocationContext.xml文件   引入以下三个
	xmlns:aop="http://www.springframework.org/schema/aop" 
	http://www.springframework.org/schema/aop 
    http://www.springframework.org/schema/aop/spring-aop-2.5.xsd
4.编写aop
	<aop:config>
		<aop:pointcut expression="execution(* cc.cynara.spring.aop.aspects.SalaryManagerImpl.*(..))" id="preform"/>
		<aop:aspect ref="logger">
			<aop:before method="logging" pointcut-ref="preform"/>
		</aop:aspect>
		<aop:aspect ref="security">
			<aop:before method="security" pointcut-ref="preform"/>
		</aop:aspect>
		<aop:aspect ref="privilege">
			<aop:around method="showPrivilege" pointcut-ref="preform"/>
	</aop:aspect>
测试即可