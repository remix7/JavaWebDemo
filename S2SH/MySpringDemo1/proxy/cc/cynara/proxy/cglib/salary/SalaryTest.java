package cc.cynara.proxy.cglib.salary;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class SalaryTest {
	@Test
	public void test(){
		Object manager = new SalaryManagerImpl();
		Logger logger = new Logger();
		Privilege privilege = new Privilege();
		Security security = new Security();
		List<Interceptor> interceptors = new ArrayList<Interceptor>();
		interceptors.add(logger);
		interceptors.add(privilege);
		interceptors.add(security);
		SalaryInterceptor interceptor = new SalaryInterceptor(manager, interceptors);
		SalaryManagerImpl proxy = (SalaryManagerImpl)interceptor.createProxy();
		proxy.showSalary();
	}
}
