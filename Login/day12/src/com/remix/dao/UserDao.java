package com.remix.dao;

import com.remix.domain.User;

public interface UserDao {
	/**
	 * �����û���Ϣ��xml��
	 * @param user
	 */
	void addUser(User user);
	/**
	 * �����û�����ѯ�û�
	 * @param username  ����user  ������ null
	 * @return 
	 */
	User findUserByUsername(String username);
	
	/**
	 * �����û��������ѯ
	 * @param username
	 * @param password
	 * @return ���ڷ���true   ����null
	 */
	User findUser(String username,String password);
}
