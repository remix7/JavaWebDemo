package cc.cynara.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.Transaction;

import cc.cynara.spring.aop.annotation.HibernateUtils;

/**
 * 切面
 * ProceedingJoinPoint joinPoint 通过它可以获取目标方法的一些信息
 * @author liutao-REMIX 
 *
 */
public class MyTransaction extends HibernateUtils{
	private Transaction transaction;
	//通知
	public void beginTransaction(){
		System.out.println("beginTransaction");
		this.transaction = sessionFactory.getCurrentSession().beginTransaction();
	}
	//通知
	public void commit(Object var){
		System.out.println(var);
		this.transaction.commit();
	}
	
	public void finallyMethod(){
		System.out.println("finally method");
	}
	
	/**
	 * 异常通知
	 * @param ex
	 */
	public void throwMethod(Exception ex){
		System.out.println(ex.getMessage());
	}
	public void arroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println(joinPoint.getSignature().getName());
		joinPoint.proceed();  //调用目标方法
		System.out.println("arroundMethod");
	}
}	
