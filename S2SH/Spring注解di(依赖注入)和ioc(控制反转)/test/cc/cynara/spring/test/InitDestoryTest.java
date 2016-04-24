package cc.cynara.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.spring.initdestory.HelloWorld;



public class InitDestoryTest {
	
	
	@Test
	public void testInitDestory(){
		/**
		 * 启动spring容器
		 * 从spring容器中把对象取出来
		 * 对象调用方法
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloInitDestory");
		helloWorld.hello();
		
		ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext)context;
		applicationContext.close();
	}
}
