package cc.cynara.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mysql.jdbc.ResultSet;

public class DBCPUtils {
	private static DataSource ds;
	static{
		try {
			InputStream in = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties props = new Properties();
			props.load(in);
			ds = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		return ds;
	}
}
