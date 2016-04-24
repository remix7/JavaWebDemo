package cc.cynara.spring.jdbc.transaction.test;


import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.spring.jdbc.transaction.bean.Person;
import cc.cynara.spring.jdbc.transaction.dao.PersonDao;
import cc.cynara.spring.jdbc.transaction.service.PersonService;

public class JdbcTransactonTest {
	public static ApplicationContext context ;
	static{
		context = new ClassPathXmlApplicationContext("cc/cynara/spring/jdbc/transaction/config/applicationContext.xml");
	}
	@Test
	public void testDataSource(){
		DataSource dataSource = (DataSource)context.getBean("dataSource");
		System.out.println(dataSource);
	}
	@Test
	public void test1(){
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		List<Person> list = personDao.listPerson();
		for (Person person : list) {
			System.out.println(person.getPname());
		}
//		personDao.savePerson();
	}
	@Test
	public void test2(){
		PersonService personService = (PersonService)context.getBean("personService");
		personService.savePerson();
	
	}
}
