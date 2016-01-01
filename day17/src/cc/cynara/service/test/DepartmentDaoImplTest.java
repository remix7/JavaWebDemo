package cc.cynara.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cc.cynara.dao.impl.DepartmentDaoImpl;
import cc.cynara.domain.Department;
import cc.cynara.domain.Employee;

public class DepartmentDaoImplTest {
	private DepartmentDaoImpl dao = new DepartmentDaoImpl();
	@Test
	public void testAddDepartment() throws Exception {
		Department d = new Department();
		d.setId(1);
		d.setName("±à¼­²¿");
		
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("aaa");
		e1.setSalary(20000.0f);
		
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("bbb");
		e2.setSalary(20000.0f);
		
		d.getEmps().add(e1);
		d.getEmps().add(e2);
		
		dao.addDepartment(d);
	}

	@Test
	public void testFindDepartment() throws Exception {
		Department d = dao.findDepartment(1);
		System.out.println(d.getName());
		
		List<Employee> emps = d.getEmps();
		for(Employee e:emps){
			System.out.println(e.getName());
		}
	}

}
