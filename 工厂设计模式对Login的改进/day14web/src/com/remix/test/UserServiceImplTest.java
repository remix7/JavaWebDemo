package com.remix.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.remix.domain.User;
import com.remix.exception.UsernameExistException;
import com.remix.service.UserService;
import com.remix.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	private UserService s = new UserServiceImpl();

	@Test
	public void testLogin() {
		User u = s.login("HH", "123456");
		assertNotNull(u);
	}

	@Test(expected=com.remix.exception.UsernameExistException.class)
	public void testRegist()throws UsernameExistException {
		User user = new User();
		user.setUsername("lt");
		user.setPassword("123456");
		user.setEmail("lt@remix.com");
		user.setNick("ÁõÌÎ");
		user.setBrithday(new Date());
		s.regist(user);
	}
	@Test
	public void testRegist1()throws UsernameExistException {
		User user = new User();
		user.setUsername("HH");
		user.setPassword("123456");
		user.setEmail("lt@remix.com");
		user.setNick("»ª»ª");
		user.setBrithday(new Date());
		s.regist(user);
	}

}
