package com.remix.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.remix.dao.UserDao;
import com.remix.dao.impl.UserDaoImpl;
import com.remix.dao.impl.UserDaoMySQLImol1;
import com.remix.dao.impl.UserDaoMySQLImpl;
import com.remix.domain.User;

public class UserDapImplTest {
	private UserDao dao = new UserDaoMySQLImol1();

	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("lt");
		user.setPassword("123456");
		user.setEmail("lt@remix.com");
		user.setNick("¡ıÃŒ");
		user.setBrithday(new Date());
		dao.addUser(user);
	}

	@Test
	public void testFindUser() {
		User user = dao.findUser("lt", "123456");
		assertNotNull(user);
	}

	@Test
	public void testFindUserByUsername() {
		User user = dao.findUserByUsername("lt");
		assertNotNull(user);
		user = dao.findUserByUsername("lt1");
		assertNull(user);
		
	}

}
