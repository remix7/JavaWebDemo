package cc.cynara.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
/**
 * 把得到链接有关的方法写到此类中
 * @author REMIX-7
 *
 */
public class Transactionutil {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static DataSource ds;
	static {
		try {
			InputStream in = DBCPUtil.class.getClassLoader()
					.getResourceAsStream("dbcpconfig.properties");
			Properties props = new Properties();
			props.load(in);

			ds = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDatasource() {
		return ds;
	}
	public static Connection getConnection(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = ds.getConnection();
				tl.set(conn);
			}
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void startTransaction(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = getConnection();
//				tl.set(conn);
			}
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void rollback(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = getConnection();
//				tl.set(conn);
			}
			conn.rollback();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void commit(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = getConnection();
//				tl.set(conn);
			}
			conn.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void release(){
		try {
			Connection conn = tl.get();
			if(conn!=null){
				conn.close();
				tl.remove();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
