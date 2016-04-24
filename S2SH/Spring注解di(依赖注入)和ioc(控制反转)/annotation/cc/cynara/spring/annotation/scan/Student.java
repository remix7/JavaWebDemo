package cc.cynara.spring.annotation.scan;

import org.springframework.stereotype.Component;

@Component("student_SCAN")
public class Student {
	public void show(){
		System.out.println("student_show");
	}
}
