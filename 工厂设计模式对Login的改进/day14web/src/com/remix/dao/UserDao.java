package com.remix.dao;

import com.remix.domain.User;

public interface UserDao {
	/**
	 * 保存用户信息到xml中
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 根据用户名查询用户
	 * @param username  存在user  不存在 null
	 * @return 
	 */
	User findUserByUsername(String username);
	
	/**
	 * 根据用户名密码查询
	 * @param username
	 * @param password
	 * @return 存在返回true   否则null
	 */
	User findUser(String username,String password);
}
