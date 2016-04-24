package cc.cynara.spring.test.mvc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MVCTest {
	@Test
	public void mVCTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/test/mvc/applicationContext-mvc.xml");
		PersonAction action = (PersonAction)context.getBean("personAction");
		action.savePerson();
		
	}
}
