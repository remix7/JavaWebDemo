package cc.cynara.bookstore.dao;

import cc.cynara.bookstore.domain.User;

public interface UserDao {
	/**
	 * 用户注册
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findUser(String username, String password);

}
