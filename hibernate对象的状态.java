package cn.itcast.hibernate.sh.state;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.hibernate.sh.domain.Person;
import cn.itcast.hibernate.sh.utils.HiberanteUtils;

public class StateTest extends HiberanteUtils{
	/**
	 * session.save方法把一个临时状态的对象转化成持久化状态的对象
	 */
	@Test
	public void testSavePerson(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();
		person.setPname("afds");
		person.setPsex("af");
		session.save(person);
		transaction.commit();
		session.close();
	}
	
	/**
	 * session.update方法可以把一个对象的状态变成持久化状态
	 */
	@Test
	public void testUpdate(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person2 = new Person();//临时状态
		person2.setPid(1L);//临时状态
		session.update(person2);//持久化状态
		transaction.commit();
		session.close();
	}
	
	/**
	 * 当session.get方法得到一个对象的时候，是不需要再执行 update语句，因为已经是持久化状态
	 * 当一个对象是一个持久化对象的时候,当进行提交的时候,hibernate内部会让该对象和快照进行对比,如果一样,则不发出update语句
	 * 如果不一样，则发出update语句
	 */
	@Test
	public void testGet(){
		Session session = sessionFactory.openSession();
		//Transaction transaction = session.beginTransaction();
		Person person = (Person)session.get(Person.class, 1L);//持久化
		person.setPname("tt");
		//session.update(person);
		//transaction.commit();
		session.close();
	}
	
	/**
	 * session.clear方法把所有的对象从session中清空
	 */
	@Test
	public void testClear(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person)session.get(Person.class, 1L);
		person.setPname("asd");
		session.clear();//把session中所有的对象清空
		session.update(person);//把对象从脱管状态转化成持久化状态
		transaction.commit();
		session.close();
	}
	
	/**
	 * session.evict把一个对象从session中清空
	 */
	@Test
	public void testEvict(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person)session.get(Person.class, 1L);
		person.setPname("asdsss");
		session.evict(person);//脱管状态
		session.update(person);//把对象的状态转化成持久化状态
		transaction.commit();
		session.close();
	}
	
	
	/**
	 * 一个对象是否是持久化对象是针对某一个session而言的
	 */
	@Test
	public void testSession(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person)session.get(Person.class, 1L);
		person.setPname("asfd");
		transaction.commit();
		session.close();
		session =  sessionFactory.openSession();
		transaction =  session.beginTransaction();
		person.setPname("aaaaaaa");//person对象对于94的session来说是一个临时状态的对象
		//session.update(person);
		transaction.commit();
		session.close();
	}
	
	/**
	 * 当执行transaction.commit的时候，hibernate内部会检查session
	 *    1、如果一个对象为临时状态的对象，则session不会管
	 *    2、如果一个对象是持久化状态的对象，如果有ID值，并且和数据库对应，那么先把该对象与快照进行对比，如果一致，则什么都不做，如果不一致，则发出update语句
	 *    3、如果一个对象是持久化状态的对象，如果没有ID值，则会发出save语句
	 */
	@Test
	public void testMuplyOption(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();
		person.setPname("rrr");
		person.setPsex("asdfasdf");
		
		Person person3 = new Person();
		person3.setPname("rrr");
		person3.setPsex("asdfasdf");
		
		
		session.save(person);
		Person person2 = (Person)session.get(Person.class, 1L);
		person2.setPname("afds45");
		transaction.commit();
		session.close();
	}
	
	
	@Test
	public void testMutiplyOption2(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();
		person.setPname("asdfads");
		person.setPsex("er");
		session.save(person);
		transaction.commit();
		session.evict(person);
		session.close();
		
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.update(person);
		session.clear();
		transaction.commit();
		session.close();
	}
}
