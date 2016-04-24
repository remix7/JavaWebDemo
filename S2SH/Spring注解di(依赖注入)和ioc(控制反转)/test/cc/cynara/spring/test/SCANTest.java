package cc.cynara.spring.test;

import org.junit.Test;

import cc.cynara.spring.annotation.scan.Person;
import cc.cynara.spring.utils.SpringInit;

public class SCANTest extends SpringInit{
	@Test
	public void scanTest(){
		Person person = (Person)context.getBean("person_SCAN");
		person.show();
	}
}
