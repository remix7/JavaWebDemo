package com.remix.service;

import com.remix.domain.User;
import com.remix.exception.UsernameExistException;

public interface UserService {
	/**
	 * 用户名登录
	 * @param username
	 * @param password
	 * @return  成功user  不成功null
	 * 
	 */
	User login(String username,String password);
	
	/**
	 * 注册  先判断是否存在
	 * @param user
	 * @throws UsernameExistException  
	 */
	void regist(User user)throws UsernameExistException;
}
