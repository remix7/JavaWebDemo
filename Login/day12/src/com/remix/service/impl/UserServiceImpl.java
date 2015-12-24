package com.remix.service.impl;

import com.remix.dao.UserDao;
import com.remix.dao.impl.UserDaoImpl;
import com.remix.domain.User;
import com.remix.exception.UsernameExistException;
import com.remix.service.UserService;
import com.remix.util.MD5Util;

public class UserServiceImpl implements UserService {
	private UserDao dao = new UserDaoImpl();
	

	public User login(String username, String password) {
		password = MD5Util.encode(password);
		return dao.findUser(username, password);
	}

	public void regist(User user) throws UsernameExistException {
		//判断是否存在
		User u = dao.findUserByUsername(user.getUsername());
		if(u!=null){
			throw new UsernameExistException("用户名已经存在！");
		}
		//密码要加密
		user.setPassword(MD5Util.encode(user.getPassword()));
		//保存dao
		dao.addUser(user);
	}

}
