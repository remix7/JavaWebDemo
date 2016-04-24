package cc.cynara.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.cynara.spring.di.constructor.Person;





public class DISetTest {
	@Test
	public void dISetTest(){
		/**
		 * 启动spring容器
		 * 从spring容器中把对象取出来
		 * 对象调用方法
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) context.getBean("person_C");
		System.out.println(person.getPname());
		System.out.println(person.getStudents());
		
	}
}
