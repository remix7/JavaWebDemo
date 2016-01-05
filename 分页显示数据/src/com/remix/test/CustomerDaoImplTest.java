package com.remix.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.remix.dao.CustomerDao;
import com.remix.dao.impl.CustomerDaoImpl;
import com.remix.domain.Customer;
import com.remix.exception.IdIsNullException;

public class CustomerDaoImplTest {
	private CustomerDao cdi = new CustomerDaoImpl();
	@Test
	public void testAddCustomer() {
		
		Customer c = new Customer();
		c.setId(UUID.randomUUID().toString());
		c.setName("李四");
		c.setGender("1");
		c.setBirthday(new Date());
		c.setEmail("123@123.123");
		c.setCellphone("132456789");
		c.setHobby("足球，篮球");
		c.setType("vip");
		c.setDescription("我不知道！");
		cdi.addCustomer(c);
	}

	@Test
	public void testDelCustomerById() {
		cdi.delCustomerById("002");
	}

	@Test
	public void testFindAll() {
		List<Customer> list = cdi.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
	}

	@Test
	public void testFindCustomerById() {
		System.out.println(cdi.findCustomerById("001"));
	}

	@Test
	public void testUpdateCustomer() {
		Customer c = new Customer();
		c.setId("002");
		c.setName("李四");
		c.setGender("1");
		c.setBirthday(new Date());
		c.setEmail("123@123.123");
		c.setCellphone("132456789");
		c.setHobby("足球，篮球");
		c.setType("CEO");
		c.setDescription("我不知道！");
		try {
			cdi.updateCustomer(c);
		} catch (IdIsNullException e) {
			e.printStackTrace();
		}
	}

}
