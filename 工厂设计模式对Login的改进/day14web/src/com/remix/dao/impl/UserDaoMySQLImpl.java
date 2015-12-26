package com.remix.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.remix.dao.UserDao;
import com.remix.domain.User;
import com.remix.exception.DaoException;
import com.remix.util.JdbcUtils;

public class UserDaoMySQLImpl implements UserDao {
	
	
	public void addUser(User user) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into user(username,nick,password,email,brithday) values('"+user.getUsername()+"','"+user.getNick()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getBrithday().toLocaleString()+"')");
			
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			
			JdbcUtils.release(null, stmt, conn);
		}
	}

	public User findUser(String username, String password) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user where username='"+username+"' and password='"+password+"'");
			if(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setNick(rs.getString("nick"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBrithday(rs.getDate("brithday"));
				return user;
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			
			JdbcUtils.release(rs, stmt, conn);
		}
	}

	public User findUserByUsername(String username) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user where username='"+username+"'");
			if(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setNick(rs.getString("nick"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBrithday(rs.getDate("brithday"));
				return user;
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			
			JdbcUtils.release(rs, stmt, conn);
		}
	}

}
