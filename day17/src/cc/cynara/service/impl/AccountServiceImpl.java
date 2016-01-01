package cc.cynara.service.impl;

import cc.cynara.dao.impl.AccountDaoImpl;
import cc.cynara.domain.Account;
import cc.cynara.util.Transactionutil;

public class AccountServiceImpl {
	private AccountDaoImpl dao = new AccountDaoImpl();
	public void transfer(String accountAName,String targetAName,float mony){
		try {
			Transactionutil.startTransaction();
			Account aAccount = dao.findAccount(accountAName);
			Account tAccount = dao.findAccount(targetAName);
			aAccount.setMony(aAccount.getMony()-mony);
			tAccount.setMony(tAccount.getMony()+mony);
			
			dao.updateAccount(aAccount);
			dao.updateAccount(tAccount);
		} catch (Exception e) {
			Transactionutil.rollback();
			e.printStackTrace();
		}finally{
			Transactionutil.commit();
			Transactionutil.release();
		}
		
	}
}
