package cc.cynara.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cc.cynara.domain.Account;
import cc.cynara.util.Transactionutil;

public class AccountDaoImpl {
	private QueryRunner qr = new QueryRunner();
	
	public Account findAccount(String accountName){
		try {
			return qr.query(Transactionutil.getConnection(), "select * from account where name=?", new BeanHandler<Account>(Account.class), accountName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void updateAccount(Account account){
		try {
			qr.update(Transactionutil.getConnection(), "update account set mony=? where name=?",account.getMony(),account.getName() );
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}	
