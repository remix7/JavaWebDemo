package cc.cynara.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/jdbc/applicationContext.xml");
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		personDao.update();
	}
	@Test
	public void test2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/jdbc/applicationContext.xml");
		PersonDao2 personDao2 = (PersonDao2)context.getBean("personDao2");
		personDao2.update();
	}
	
	@Test
	public void test3(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/jdbc/applicationContext.xml");
		PersonDao3 personDao3 = (PersonDao3)context.getBean("personDao3");
		personDao3.update();
	}
	@Test
	public void test4(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/jdbc/applicationContext.xml");
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		personDao.qurey();
	}
}
