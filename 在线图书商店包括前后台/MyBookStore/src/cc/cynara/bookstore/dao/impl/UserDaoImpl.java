package cc.cynara.bookstore.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cc.cynara.bookstore.dao.UserDao;
import cc.cynara.bookstore.domain.User;
import cc.cynara.bookstore.exception.DaoException;
import cc.cynara.bookstore.util.DBCPUtils;
import cc.cynara.bookstore.util.MD5Utils;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());

	public void addUser(User user) {
		try {
			qr
					.update(
							"insert into user(id,username,password,nick,phone,address,email) values(?,?,?,?,?,?,?)",
							user.getId(), user.getUsername(), 
							MD5Utils.encoding(user.getPassword()), user.getNick(), user
									.getPhone(), user.getAddress(), user
									.getEmail());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public User findUser(String username, String password) {
		try {
			return qr.query("select * from user where username=? and password=?",new BeanHandler<User>(User.class), username,MD5Utils.encoding(password));
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
