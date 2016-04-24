package cc.cynara.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper{

	public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		Person person = new Person();
		person.setPid(arg0.getLong("pid"));
		person.setPname(arg0.getString("pname"));
		person.setPsex(arg0.getString("psex"));
		return person;
	}

}
