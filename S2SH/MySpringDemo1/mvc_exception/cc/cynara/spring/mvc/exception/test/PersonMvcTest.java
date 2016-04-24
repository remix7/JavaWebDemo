package cc.cynara.spring.mvc.exception.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.spring.mvc.exception.service.PersonService;

public class PersonMvcTest {
	@Test
	public void personMvcTest() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/mvc/exception/config/applicationContext.xml");
		PersonService personService = (PersonService)context.getBean("personServive");
		personService.savePerson();
	}
}
