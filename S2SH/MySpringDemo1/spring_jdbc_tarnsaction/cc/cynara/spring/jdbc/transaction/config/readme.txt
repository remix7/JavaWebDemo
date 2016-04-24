spring+jdbc 对事务的处理
1.编写javabean  person  提供属性  pid pname psex
2.编写dao personDao 接口  提供查询所有 和save一个
3.编写daoimpl  实现persondao接口  中的方法
5.编写service接口  功能和dao相同
6.编写serviceImpl 实现service 调用daoimpl  实习其中的方法
7.在applicationContext.xml文件中 写入bean dataSource
	 <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    	<property name="locations">
    		<value>classpath:jdbc.properties</value>
    	</property>
    </bean>
    
	 <bean id="dataSource" destroy-method="close" class="org.apache.commons.dbcp.BasicDataSource">
	 	<property name="driverClassName" value="${jdbc.driverClassName}"></property>
	 	<property name="url" value="${jdbc.url}"></property>
	 	<property name="username" value="${jdbc.username}"></property>
	 	<property name="password" value="${jdbc.password}"></property>
	 </bean>
	将dao引入到xml文件中并为其配置DataSource
		<bean id="personDao" class="cc.cynara.spring.jdbc.transaction.dao.impl.PersonDaoImpl">
	   		<property name="dataSource">
	   			<ref bean="dataSource"/>
	   		</property>
	   	</bean>
	 将service引入xml 并为其配置daoimpl
	 	<bean id="personService" class="cc.cynara.spring.jdbc.transaction.service.impl.PersonServiceImpl">
	   		<property name="dao">
	   			<ref bean="personDao"/>
	   		</property>
   		</bean>
   	接下来配置事物相关
   		 <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		   		<property name="dataSource">
		   			<ref bean="dataSource"/>
		   		</property>
 		 </bean>
	 	<tx:advice id="tx" transaction-manager="transactionManager">
	   		<tx:attributes>
	   			<tx:method name="save*" read-only="false"/>
	   		</tx:attributes>
	   	</tx:advice>
	   	
	 接下来aop
	 	<aop:config>
		   	<aop:pointcut expression="execution(* cc.cynara.spring.jdbc.transaction.service.impl.*.*(..))" id="proform"/>
		   		<aop:advisor advice-ref="tx" pointcut-ref="proform"/>
		</aop:config>