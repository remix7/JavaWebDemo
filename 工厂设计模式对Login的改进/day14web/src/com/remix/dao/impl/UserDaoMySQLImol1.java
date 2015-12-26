package com.remix.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.remix.dao.UserDao;
import com.remix.domain.User;
import com.remix.util.JdbcUtils;

public class UserDaoMySQLImol1 implements UserDao {

	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.prepareStatement("insert into user(username,nick,password,email,brithday) values(?,?,?,?,?)");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getNick());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setDate(5, new java.sql.Date(user.getBrithday().getTime()));
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(null, stmt, conn);
		}
	}
	public User findUser(String username, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.prepareStatement("select * from user where username=? and password=?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
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
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(rs, stmt, conn);
		}
	}
	public User findUserByUsername(String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.prepareStatement("select * from user where username=?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
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
			throw new RuntimeException(e);
		}finally{
			JdbcUtils.release(rs, stmt, conn);
		}
	}

}
