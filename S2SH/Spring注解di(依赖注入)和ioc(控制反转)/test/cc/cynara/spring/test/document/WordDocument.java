package cc.cynara.spring.test.document;

import org.springframework.stereotype.Component;

@Component("wordDocument")
public class WordDocument implements Document{

	public void read() {
		System.out.println("read word");
	}

	public void writer() {
		System.out.println("writer word");
	}

}
