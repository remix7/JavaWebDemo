package cc.cynara.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.spring.ioc.createObject.when.HelloWorld;



public class CreateObject_whenTest {
	@Test
	public void testWhen(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(123);
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWhen");
		helloWorld.hello();
	}
}
