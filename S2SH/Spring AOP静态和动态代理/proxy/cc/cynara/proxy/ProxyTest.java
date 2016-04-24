package cc.cynara.proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyTest {
	@Test
	public void proxyTest(){
		PersonDao personDao = new PersonDaoImpl();
		Transaction transaction = new Transaction();
		PersonDao daoProxy = new PersonDaoProxy(personDao, transaction);
		daoProxy.deletePerson();
	}
	@Test
	public void proxySpringTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/proxy/applicationContext-proxy.xml");
		PersonDao proxy = (PersonDaoProxy)context.getBean("personDaoProxy");
		proxy.deletePerson();
	}
}
