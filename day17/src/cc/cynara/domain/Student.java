package cc.cynara.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 create table teacher(
 	id int primary key,
 	name varchar(100),
 	money float(8,2)
 );
 create table student(
 	id int primary key,
 	name varchar(100),
 	grade varchar(10)
 	
 );
 create table teacher_student(
 	t_id int,
 	s_id int,
 	primary key(t_id,s_id),
 	constraint t_id_fk foreign key(t_id) references teacher(id),
 	constraint s_id_fk foreign key(s_id) references student(id)
 );
 * @author REMIX-7
 *
 */
public class Student implements Serializable {
	private Integer id;
	private String name;
	private String grade;
	private List<Teacher> ts = new ArrayList<Teacher>();
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public List<Teacher> getTs() {
		return ts;
	}
	public void setTs(List<Teacher> ts) {
		this.ts = ts;
	}
	
}
