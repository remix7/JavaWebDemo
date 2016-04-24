模仿Struts2 hibernate 与spring整合全局错误处理  将错误信息放入到  spring的异常通知中  统一的又MyException 来处理

1.编写dao Service action 
2.编写aspect 中异常处理方法  切面
3.编写applicationContext.xml  记住一定要找到目标类  和dao service action中的调用方式
	<bean id="personDao" class="cc.cynara.spring.mvc.exception.dao.impl.PersonDaoImpl"></bean>
    <bean id="personServive" class="cc.cynara.spring.mvc.exception.service.impl.PersonServiceImpl">
    	<property name="personDao">
    		<ref bean="personDao"/>
    	</property>
    </bean>
    <bean id="personAction" class="cc.cynara.spring.mvc.exception.action.PersonAction">
    	<property name="personService">
    		<ref bean="personServive"/>
    	</property>
    </bean>
    <!-- 切面类 -->
    <bean id="myException" class="cc.cynara.spring.mvc.exception.aspect.MyException"></bean>
    
    <aop:config>
    	<aop:pointcut expression="execution(* cc.cynara.spring.mvc.exception.service.impl.*.*(..))" id="preform"/>
    	<aop:aspect ref="myException">
    		<aop:after-throwing method="myException" pointcut-ref="preform" throwing="ex"/>
    	</aop:aspect>
    	
    </aop:config>