package cc.cynara.spring.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

public class JdbcTemplate {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void update(String sql){
		Connection connection;
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
