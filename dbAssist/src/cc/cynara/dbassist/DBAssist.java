package cc.cynara.dbassist;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import cc.cynara.dbassist.handler.ResultSetHandler;
import cc.cynara.exception.DBAssistException;
/**
 *  数据库增删改集成框架
 * @author REMIX-7
 *
 */
public class DBAssist {
	private DataSource ds;
	public DBAssist(DataSource ds){
		this.ds = ds;
	}
	public void update(String sql,Object[] params){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			
			ParameterMetaData pmd = stmt.getParameterMetaData();
			int count = pmd.getParameterCount();//得到占位符的个数
			if(count>0){//有参数
				if(params==null||params.length<1){
					throw new IllegalArgumentException("参数设置错误！");
				}
				if(params.length!=count){
					throw new IllegalArgumentException("参数与占位符不匹配~");
				}
				for(int i=0;i<count;i++){
					stmt.setObject(i+1, params[i]);
				}
			}
			
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DBAssistException(e);
		}finally{
			release(rs, stmt, conn);
		}
	}
	public Object query(String sql,Object[] params,ResultSetHandler rsh){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			
			ParameterMetaData pmd = stmt.getParameterMetaData();
			int count = pmd.getParameterCount();//得到占位符的个数
			if(count>0){//有参数
				if(params==null||params.length<1){
					throw new IllegalArgumentException("参数设置错误！");
				}
				if(params.length!=count){
					throw new IllegalArgumentException("参数与占位符不匹配~");
				}
				for(int i=0;i<count;i++){
					stmt.setObject(i+1, params[i]);
				}
			}
			
			rs = stmt.executeQuery();
			//封装到对象中  有结果集
			return rsh.handler(rs);
		} catch (Exception e) {
			throw new DBAssistException(e);
		}finally{
			release(rs, stmt, conn);
		}
	}
	private static void release(ResultSet rs,PreparedStatement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
