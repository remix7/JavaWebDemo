package cc.cynara.spring.aop.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AopTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/aop/annotation/applicationContext.xml");
		PersonDaoImpl dao = (PersonDaoImpl)context.getBean("personDao");
		Person person = new Person();
		person.setPname("aaa000a");
		person.setPsex("1");
		dao.savePerson(person);
	}
}
