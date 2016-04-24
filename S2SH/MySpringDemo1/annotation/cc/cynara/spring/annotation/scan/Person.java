package cc.cynara.spring.annotation.scan;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
@Component("person_SCAN")
public class Person {
	
	@Resource(name="student_SCAN")
	private Student students;
	public void show(){
		this.students.show();
	}
}
