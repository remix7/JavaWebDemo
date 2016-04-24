package cc.cynara.spring.aop;

import cc.cynara.spring.aop.annotation.HibernateUtils;
import cc.cynara.spring.aop.annotation.Person;


public class PersonDaoImpl extends HibernateUtils {
	public String savePerson(Person person) {
		sessionFactory.getCurrentSession().save(person);
		return "commitssss";
	}
	
}	
