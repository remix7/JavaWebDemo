package cc.cynara.spring.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInit {
	public static  ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
