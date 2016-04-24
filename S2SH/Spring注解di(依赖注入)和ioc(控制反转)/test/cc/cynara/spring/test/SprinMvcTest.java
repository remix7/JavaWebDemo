package cc.cynara.spring.test;

import org.junit.Test;

import cc.cynara.spring.mvc.PersonAction;
import cc.cynara.spring.utils.SpringInit;

public class SprinMvcTest extends SpringInit{
	@Test
	public void test(){
		PersonAction personAction = (PersonAction)context.getBean("personAction");
		personAction.savePerson();
	}
}
