package cc.cynara.spring.test;

import org.junit.Test;
import cc.cynara.spring.di.constructor.Person;
import cc.cynara.spring.documnet.DocumentManager;
import cc.cynara.spring.utils.SpringInit;


public class DocumentTest extends SpringInit{
	@Test
	public void documentTest(){
		Person person = (Person) context.getBean("person_C");
		System.out.println(person);
	}
	@Test
	public void documentTest2(){
		DocumentManager documentManager = (DocumentManager)context.getBean("documentManager");
		documentManager.read();
		documentManager.writer();
	}
}
