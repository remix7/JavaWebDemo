package cc.cynara.proxy.jdk.salary;

import java.lang.reflect.Proxy;

import org.junit.Test;


public class SalaryTest {
	@Test
	public void test(){
		Object manager = new SalaryManagerImpl();
		Logger logger = new Logger();
		Privilege privilege = new Privilege();
		privilege.setPri("admin");
		Security security = new Security();
		
		SalaryInterceptor interceptor = new SalaryInterceptor(manager, logger, privilege, security);
		
		SalaryManager salaryManager = (SalaryManager)Proxy.newProxyInstance(manager.getClass().getClassLoader(), manager.getClass().getInterfaces(), interceptor);
		salaryManager.showSalary();
		
	}
}
