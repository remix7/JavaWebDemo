package cc.cynara.spring.aop.annotation;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;



/**
 * 切面
 * ProceedingJoinPoint joinPoint 通过它可以获取目标方法的一些信息
 * @author liutao-REMIX 
 *@aspect 相当于<aop:config>
 */
@Component("myTransaction")
@Aspect
public class MyTransaction extends HibernateUtils{
	private Transaction transaction;
	
	@Pointcut("execution(* cc.cynara.spring.aop.annotation.PersonDaoImpl.*(..))")
	private void poi(){} //方法签名  返回值必须是void 修饰符最好是private
	//通知
	@Before("poi()")
	public void beginTransaction(){
		this.transaction = sessionFactory.getCurrentSession().beginTransaction();
	}
	//通知
	@AfterReturning(value="poi()",returning="val")
	public void commit(Object val){
		System.out.println(val);
		this.transaction.commit();
	}
}	
