package cc.cynara.proxy.jdk.hibernate;

import java.io.Serializable;

public class PersonDaoImpl extends HibernateUtils implements PersonDao{

	public void deletePerson(Serializable id) {
		Person person = (Person)sessionFactory.getCurrentSession().get(Person.class, Long.parseLong(id+""));
		sessionFactory.getCurrentSession().delete(person);
	}

	public void savePerson(Person person) {
		sessionFactory.getCurrentSession().save(person);
	}

	public void updatePerson(Person person) {
		sessionFactory.getCurrentSession().update(person);
	}
	
}	
