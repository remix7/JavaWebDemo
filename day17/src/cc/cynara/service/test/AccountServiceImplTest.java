package cc.cynara.service.test;

import cc.cynara.service.impl.AccountServiceImpl;


public class AccountServiceImplTest {
	public static void main(String[] args) {
		AccountServiceImpl s = new AccountServiceImpl();
		s.transfer("aaa", "bbb", 1000);
	}
	
}
