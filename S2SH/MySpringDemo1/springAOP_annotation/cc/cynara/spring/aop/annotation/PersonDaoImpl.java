package cc.cynara.spring.aop.annotation;

import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImpl extends HibernateUtils {
	public String savePerson(Person person) {
		sessionFactory.getCurrentSession().save(person);
		return "commitssss";
	}
	
}	
