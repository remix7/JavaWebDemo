package cc.cynara.proxy.jdk.hibernate;

import org.hibernate.Transaction;

public class MyTransaction extends HibernateUtils{
	public Transaction transaction;
	
	public void beginTransaction(){
		this.transaction = sessionFactory.getCurrentSession().beginTransaction();
	}
	public void commit(){
		this.transaction.commit();
	}
}
