package cc.cynara.spring.hibernate.transaction.dao.impl;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cc.cynara.spring.hibernate.transaction.dao.PersonDao;
import cc.cynara.spring.hibernate.transaction.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	public List<Person> listPerson() {
		
		return this.getHibernateTemplate().getSessionFactory().openSession().createQuery("from Person").list();
	}

	public void savePerson(Person person) {
		this.getHibernateTemplate().save(person);
	}
}
