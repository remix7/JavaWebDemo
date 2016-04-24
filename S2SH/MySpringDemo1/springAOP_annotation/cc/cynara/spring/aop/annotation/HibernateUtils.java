package cc.cynara.spring.aop.annotation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static SessionFactory sessionFactory ;
	static {
		Configuration configuration = new Configuration();
		configuration.configure("cc/cynara/spring/aop/annotation/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}
}
