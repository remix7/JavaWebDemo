package cc.cynara.spring.test.document;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DocumentTest {
//	@Test
//	public void documentTest(){
//		Document wordDocument = new WordDocument();
//		DocumentManager documentManager = new DocumentManager(wordDocument);
//		documentManager.read();
//		documentManager.writer();
//	}
	
	@Test
	public void documentSCANTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/test/document/applicationContext-document.xml");
		DocumentManager documentManager = (DocumentManager)context.getBean("documentManager");
		documentManager.read();
		documentManager.writer();
	}
}
