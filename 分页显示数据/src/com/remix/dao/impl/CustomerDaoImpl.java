package com.remix.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.remix.dao.CustomerDao;
import com.remix.domain.Customer;
import com.remix.exception.DaoException;
import com.remix.exception.IdIsNullException;
import com.remix.util.JdbcUtils;
//这里是CustomerDao接口的实现   具体注释请参阅接口
public class CustomerDaoImpl implements CustomerDao {

	public void addCustomer(Customer c) {
		if(c == null)
			throw new IllegalArgumentException();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn
					.prepareStatement("insert into customer(id,name,gender,birthday,cellphone,email,hobby,type,description) values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, c.getId());
			stmt.setString(2, c.getName());
			stmt.setString(3, c.getGender());
			stmt.setDate(4, new java.sql.Date(c.getBirthday().getTime()));
			stmt.setString(5, c.getCellphone());
			stmt.setString(6, c.getEmail());
			stmt.setString(7, c.getHobby());
			stmt.setString(8, c.getType());
			stmt.setString(9, c.getDescription());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
	}

	public void delCustomerById(String customerId) {
		if(customerId == null)
			throw new IllegalArgumentException();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.prepareStatement("delete from customer where id=?");
			stmt.setString(1, customerId);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
	}

	public List<Customer> findAll() {
		throw new AbstractMethodError("你要找的方法还没有实现！");
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		List<Customer> list = new ArrayList<Customer>();
//		try {
//			conn = JdbcUtils.getConnection();
//			stmt = conn.prepareStatement("select * from customer");
//			rs = stmt.executeQuery();
//			while (rs.next()) {
//				Customer c = new Customer();
//				c.setId(rs.getString("id"));
//				c.setName(rs.getString("name"));
//				c.setGender(rs.getString("gender"));
//				c.setBirthday(rs.getDate("birthday"));
//				c.setCellphone(rs.getString("cellphone"));
//				c.setEmail(rs.getString("email"));
//				c.setHobby(rs.getString("hobby"));
//				c.setType(rs.getString("type"));
//				c.setDescription(rs.getString("description"));
//				list.add(c);
//			}
//			return list;
//		} catch (Exception e) {
//			throw new DaoException(e);
//		} finally {
//			JdbcUtils.release(rs, stmt, conn);
//		}
	}

	public Customer findCustomerById(String customerId) {
		if(customerId == null)
			throw new IllegalArgumentException();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.prepareStatement("select * from customer where id = ?");
			stmt.setString(1, customerId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setHobby(rs.getString("hobby"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				return c;
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
		
	}

	public void updateCustomer(Customer c) throws IdIsNullException {
		if(c == null)
			throw new IllegalArgumentException();
		if(c.getId()==null)
			throw new IdIsNullException("The customer's id can not be null!");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn
					.prepareStatement("update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,hobby=?,type=?,description=? where id=?");
			
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getGender());
			stmt.setDate(3, new java.sql.Date(c.getBirthday().getTime()));
			stmt.setString(4, c.getCellphone());
			stmt.setString(5, c.getEmail());
			stmt.setString(6, c.getHobby());
			stmt.setString(7, c.getType());
			stmt.setString(8, c.getDescription());
			stmt.setString(9, c.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
	}

	public List<Customer> findPageRecords(int startIndex, int pagesize) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn.prepareStatement("select * from customer limit ?,?");
			stmt.setInt(1, startIndex);
			stmt.setInt(2, pagesize);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setHobby(rs.getString("hobby"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
	}

	public int getTotalRecords() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			stmt = conn
					.prepareStatement("select count(*) from customer");
			rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return 0;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(rs, stmt, conn);
		}
	}
}
