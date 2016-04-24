package cc.cynara.spring.hibernate.transaction.test;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.spring.hibernate.transaction.domain.Person;
import cc.cynara.spring.hibernate.transaction.service.PersonService;


public class ServiceTest {
	public static ApplicationContext context;
	static{
		context = new ClassPathXmlApplicationContext("cc/cynara/spring/hibernate/transaction/config/applicationContext.xml");
	}
	@Test
	public void test(){
		PersonService personService = (PersonService)context.getBean("personService");
		List<Person> persons = personService.listPerson();
		for (Person person : persons) {
			System.out.println(person.getPname());
		}
	}
	@Test
	public void test2(){
		Person person = new Person();
		person.setPname("wowoowow");
		person.setPsex("0");
		PersonService personService = (PersonService)context.getBean("personService");
		personService.savePerson(person);
	}
}
