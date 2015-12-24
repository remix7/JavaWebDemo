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
		//�ж��Ƿ����
		User u = dao.findUserByUsername(user.getUsername());
		if(u!=null){
			throw new UsernameExistException("�û����Ѿ����ڣ�");
		}
		//����Ҫ����
		user.setPassword(MD5Util.encode(user.getPassword()));
		//����dao
		dao.addUser(user);
	}

}
