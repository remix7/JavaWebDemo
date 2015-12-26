package com.remix.service;

import com.remix.domain.User;
import com.remix.exception.UsernameExistException;

public interface UserService {
	/**
	 * �û�����¼
	 * @param username
	 * @param password
	 * @return  �ɹ�user  ���ɹ�null
	 * 
	 */
	User login(String username,String password);
	
	/**
	 * ע��  ���ж��Ƿ����
	 * @param user
	 * @throws UsernameExistException  
	 */
	void regist(User user)throws UsernameExistException;
}
