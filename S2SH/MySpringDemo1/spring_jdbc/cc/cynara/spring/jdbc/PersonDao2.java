package cc.cynara.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDao2 extends JdbcTemplate{
	public PersonDao2() {
	}
	public PersonDao2(DataSource dataSource){
		super(dataSource);
	}
	public void update(){
		this.execute("update person set pname='789456' where pid=6");
	}
}
