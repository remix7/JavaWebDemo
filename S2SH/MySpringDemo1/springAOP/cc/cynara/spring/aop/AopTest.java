package cc.cynara.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.spring.aop.annotation.Person;
import cc.cynara.spring.aop.annotation.PersonDaoImpl;

public class AopTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/aop/applicationContext.xml");
		PersonDaoImpl dao = (PersonDaoImpl)context.getBean("personDao");
		Person person = new Person();
		person.setPname("aaaa");
		person.setPsex("1");
	}
}
