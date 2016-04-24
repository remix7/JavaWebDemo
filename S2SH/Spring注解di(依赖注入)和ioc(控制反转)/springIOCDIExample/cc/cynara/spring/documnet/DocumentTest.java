package cc.cynara.spring.documnet;

import org.junit.Test;

public class DocumentTest {
	@Test
	public void documentTest(){
		Document wordDocument = new WordDocument();
		DocumentManager documentManager = new DocumentManager(wordDocument);
		documentManager.read();
		documentManager.writer();
	}
}
