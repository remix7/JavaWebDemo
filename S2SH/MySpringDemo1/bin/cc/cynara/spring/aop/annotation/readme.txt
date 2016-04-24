使用spring注解和aop的方式 来重写spring_hibernate
1.在applicationContext.xml中头文件
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
           http://www.springframework.org/schema/aop 
           http://www.springframework.org/schema/aop/spring-aop-2.5.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context-2.5.xsd">
     然后加入注解扫描机智
     <context:component-scan base-package="cc.cynara.spring.aop.annotation"></context:component-scan>
     开启aop注解扫描机智
     <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
2.将persondaoimpl目标类  和Mytransatction切面  加入到spring管理
	@Component  使用这个注解
3.定义aop @Aspect
	在定义@Aspect标记的类中加入任意一个方法  编切入点表达式  并且 id = poi
	如:@Pointcut("execution(* cc.cynara.spring.aop.annotation.PersonDaoImpl.*(..))")
		private void poi(){} //方法签名  返回值必须是void 修饰符最好是private
4.@Before("poi()") 定义前置通知  中间的value是切面的id
5.@AfterReturning(value="poi()",returning="val") 定义后置通知 value是切面id returning是返回值

特别要注意execution(* cc.cynara.spring.aop.annotation.PersonDaoImpl.*(..))的书写