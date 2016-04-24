package cc.cynara.spring.annotation.di;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class Person {
	private Long pid;
	private String pname;
	
//	@Resource(name="student_A")
	@Autowired
	private Student students;
	
	private Set  sets;
	
	private List lists;
	
	private Map map;
	
	private Properties properties;

	public void show(){
		this.students.show();
	}
}
