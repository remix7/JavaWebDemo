package cc.cynara.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 create table department(
 	id int primary key,
 	name varchar(100)
 );
 create table employee(
 	id int primary key,
 	name varchar(100),
 	salary float(8,2),
 	dept_id int,
 	constraint dept_id _fk foreign key(dept_id) references department(id)
 	
 );
 * @author REMIX-7
 *Department Employee DepartmentDaoimpl DapartmentDaoImplTest 都是测试一对多的关系
 *
 */
public class Department implements Serializable {
	private Integer id;
	private String name;
	private List<Employee> emps = new ArrayList<Employee>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
}
