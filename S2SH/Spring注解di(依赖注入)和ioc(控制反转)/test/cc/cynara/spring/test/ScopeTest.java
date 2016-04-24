package cc.cynara.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.spring.scope.HelloWorld;



public class ScopeTest {
	
	
	@Test
	public void testScope(){
		/**
		 * 启动spring容器
		 * 从spring容器中把对象取出来
		 * 对象调用方法
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloScope");
		HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloScope");
		System.out.println(helloWorld);
		System.out.println(helloWorld2);
	}
}
