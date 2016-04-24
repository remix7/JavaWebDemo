package cc.cynara.spring.test.document;

import org.springframework.stereotype.Component;

@Component("excelDocument")
public class ExcelDocument implements Document{

	public void read() {
		System.out.println("read excal");
	}

	public void writer() {
		System.out.println("writer excal");
	}

}
