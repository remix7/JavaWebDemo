package cc.cynara.spring.aop.aspects;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SalaryTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cc/cynara/spring/aop/aspects/applicationContext.xml");
		SalaryManagerImpl managerImpl = (SalaryManagerImpl)context.getBean("salaryManager");;
		managerImpl.showSalary();
		
	}
}
