package cc.cynara.proxy.jdk.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		configuration.configure("cc/cynara/proxy/jdk/hibernate/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}
}
