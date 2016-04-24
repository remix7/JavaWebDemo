package cc.cynara.proxy.jdk.hibernate;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyJdkHibernateTest {
	@Test
	public void test(){
		Object target = new PersonDaoImpl();
		MyTransaction myTransaction = new MyTransaction();
		
		PersonDaoInterceptor interceptor = new PersonDaoInterceptor(target, myTransaction);
		
		PersonDao personDao = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);
		Person person = new Person();
		person.setPname("我不知道");
		personDao.savePerson(person);
	}
}
