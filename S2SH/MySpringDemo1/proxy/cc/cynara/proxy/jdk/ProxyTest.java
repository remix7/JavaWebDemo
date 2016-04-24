package cc.cynara.proxy.jdk;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyTest {
	@Test
	public void test(){
		Object target = new PersonDaoImpl();
		Transaction transaction = new Transaction();
		PersonInterceptor interceptor = new PersonInterceptor(target, transaction);
		/**
		 * loader 目标类的类加载器
		 * interfaces 目标类实现的所有接口
		 * h 拦截器
		 */
		PersonDao dao = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),interceptor);
		dao.deletePerson();
	}
}
