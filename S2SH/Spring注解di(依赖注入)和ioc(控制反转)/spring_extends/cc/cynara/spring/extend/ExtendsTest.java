package cc.cynara.spring.extend;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExtendsTest {
	@Test
	public void extendsTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/extend/applicationContext-extend.xml");
		PersonDao dao = (PersonDao)context.getBean("personDao");
		dao.saveEntity();
		dao.updateEntity();
		System.out.println(dao.getS());
	}
}
