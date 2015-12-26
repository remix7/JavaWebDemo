package com.remix.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.remix.dao.UserDao;

//����dao����ʵ���Ĺ��� ������ʽ  ������
public class DaoFactory {
	private static DaoFactory instance = new DaoFactory();
	private DaoFactory(){}
	public static DaoFactory getInstance(){
		return instance;
	}
//	
//	public UserDao getUserDaoXml(){
//		return new UserDaoImpl();
//	}
//	public UserDao getUserDaoMySQl0(){
//		
//		return new UserDaoMySQLImpl();
//	}
//	public UserDao getUserDaoMySQL1(){
//		return new UserDaoMySQLImol1();
//	}
	
	private static String userDaoImplClassName;
	static{
		try {
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			Properties props = new Properties();
			props.load(in);
			userDaoImplClassName = props.getProperty("userDao");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static UserDao getUserDao(){
		try {
			return (UserDao)Class.forName(userDaoImplClassName).newInstance();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		
	}
	
}
