package cc.cynara.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.spring.ioc.alias.HelloWorld;


public class AliasTest {
	
	
	@Test
	public void testCreateObject(){
		/**
		 * 启动spring容器
		 * 从spring容器中把对象取出来
		 * 对象调用方法
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("tt");
		helloWorld.hello();
	}
}
