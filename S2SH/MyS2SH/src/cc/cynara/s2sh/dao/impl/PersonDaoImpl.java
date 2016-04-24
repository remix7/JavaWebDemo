package cc.cynara.s2sh.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cc.cynara.s2sh.dao.PersonDao;
import cc.cynara.s2sh.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	public List<Person> listPerson() {
		return this.getHibernateTemplate().getSessionFactory().openSession().createQuery("from Person").list();
	}

	public void savePerson(Person person) {
		this.getHibernateTemplate().save(person);
	}

	@Override
	public Person findPersonById(Serializable id) {
		return (Person) this.getHibernateTemplate().load(Person.class, id);
	}

}
