spring+hibernate 声明事物处理
1.编写domain  person
2.编写dao 和service 接口
3.编写daoimpl 实现dao 继承hibernateDaoSupport
4.编写serviceImpl 实现 service 并引入dao属性  生成set  get方法 
5.编写person.hbm.xml文件 和hibernate.cfg.xml文件
6.编写applicationContext.xml文件  特别要注意类的引入和property 的传值
	<bean id="transactionManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
		<property name="sessionFactory">
			<ref bean="sessionFactory"/>
		</property>
	</bean>
	<tx:advice id="tx" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="save*" read-only="false"/>
			<tx:method name="list*" read-only="false"/>
		</tx:attributes>
	</tx:advice>
	
	<aop:config>
		<aop:pointcut expression="execution(* cc.cynara.spring.hibernate.transaction.service.impl.PersonServiceImpl.*(..))" id="proform"/>
		<aop:advisor advice-ref="tx" pointcut-ref="proform"/>
	</aop:config>
上述代码是做值得注意的aop和事物   记住测试的时候一定要在编写applicationContext.xml之前要确定能用