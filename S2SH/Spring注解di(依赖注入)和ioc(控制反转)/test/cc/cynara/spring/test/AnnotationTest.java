package cc.cynara.spring.test;

import org.junit.Test;

import cc.cynara.spring.annotation.di.Person;
import cc.cynara.spring.utils.SpringInit;

public class AnnotationTest extends SpringInit {
	@Test
	public void annTest(){
		Person person = (Person)context.getBean("person_A");
		person.show();
	}
}	
