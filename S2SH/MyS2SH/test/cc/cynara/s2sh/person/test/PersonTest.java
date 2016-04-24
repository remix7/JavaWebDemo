package cc.cynara.s2sh.person.test;

import java.util.List;

import org.junit.Test;

import cc.cynara.s2sh.domain.Person;
import cc.cynara.s2sh.service.PersonService;
import cc.cynara.s2sh.spring.utils.SpringInit;

public class PersonTest extends SpringInit{
	@Test
	public void test(){
		context.getBean("sessionFactory");
	}
	@Test
	public void listPerson(){
		PersonService personService = (PersonService)context.getBean("personService");
		List<Person> persons = personService.listPerson();
		for (Person person : persons) {
			System.out.println(person.getPname());
		}
	}
	@Test
	public void savePerson(){
		PersonService personService = (PersonService)context.getBean("personService");
		Person person = new Person();
		person.setPname("wwwww");
		person.setPsex("1");
		personService.savePerson(person);
	}
}	
