package cc.cynara.service.test;

import java.util.List;

import org.junit.Test;

import cc.cynara.dao.impl.TeacherDaoImpl;
import cc.cynara.domain.Student;
import cc.cynara.domain.Teacher;

public class TeacherDaoImplTest {
	private TeacherDaoImpl dao = new TeacherDaoImpl();
	@Test
	public void testAddTeacher() throws Exception {
		Teacher t1 = new Teacher();
		t1.setId(1);
		t1.setName("aaa");
		t1.setMoney(20000);
		
		Teacher t2 = new Teacher();
		t2.setId(2);
		t2.setName("bbb");
		t2.setMoney(20000);
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("lt");
		s1.setGrade("A");
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("hh");
		s2.setGrade("AA");
		
		t1.getStus().add(s1);
		t1.getStus().add(s2);
		
		t2.getStus().add(s1);
		t2.getStus().add(s2);
		
		dao.addTeacher(t1);
		dao.addTeacher(t2);
		
	}

	@Test
	public void testFindTeacher() throws Exception {
		Teacher t = dao.findTeacher(1);
		System.out.println(t.getName());
		List<Student> stus = t.getStus();
		for(Student s:stus){
			System.out.println(s.getName());
		}
	}

}
