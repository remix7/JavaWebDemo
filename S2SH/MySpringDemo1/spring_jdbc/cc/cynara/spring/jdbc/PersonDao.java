package cc.cynara.spring.jdbc;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDao extends JdbcDaoSupport{
	public void update(){
//		this.update("update person set pname='123456789' where pid=1");
		this.getJdbcTemplate().execute("update person set pname='123456' where pid=5");
	}
	public void qurey(){
		List<Person> list = this.getJdbcTemplate().query("select * from person", new PersonRowMapper());
		for (Person person : list) {
			System.out.println(person.getPname());
		}
	}
}
