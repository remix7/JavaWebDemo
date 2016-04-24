package cc.cynara.spring.jdbc.transaction.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cc.cynara.spring.jdbc.transaction.bean.Person;
import cc.cynara.spring.jdbc.transaction.dao.PersonDao;

public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao{

	public List<Person> listPerson() {
		return this.getJdbcTemplate().query("select * from person", new RowMapper() {
			
			public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
				Person person = new Person();
				person.setPid(arg0.getLong("pid"));
				person.setPname(arg0.getString("pname"));
				person.setPsex(arg0.getString("psex"));
				return person;
			}
		});
	}
	public void savePerson() {
		this.getJdbcTemplate().update("insert into person(pid,pname,psex) values(12,'ahdsfh','ss')");
		int i = 1/0;
	}

}
