package cc.cynara.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.spring.ioc.createObject.method.HelloWorld;
import cc.cynara.spring.ioc.createObject.method.HelloWorldFactory;


public class CreateObject_methodTest {
	
	
	@Test
	public void testCreateObject_Default(){
		/**
		 * 启动spring容器
		 * 从spring容器中把对象取出来
		 * 对象调用方法
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld_C_M");
		helloWorld.hello();
	}
	@Test
	public void testCreateObject_Factory(){
		/**
		 * 启动spring容器
		 * 从spring容器中把对象取出来
		 * 对象调用方法
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorldFactory = (HelloWorld) context.getBean("helloFactory");
		helloWorldFactory.hello();
	}
}
