package cc.cynara.spring.hibernate.transaction.service.impl;

import java.util.List;

import cc.cynara.spring.hibernate.transaction.dao.PersonDao;
import cc.cynara.spring.hibernate.transaction.dao.impl.PersonDaoImpl;
import cc.cynara.spring.hibernate.transaction.domain.Person;
import cc.cynara.spring.hibernate.transaction.service.PersonService;

public class PersonServiceImpl implements PersonService{
	private PersonDao personDao = new PersonDaoImpl();
	
	
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public List<Person> listPerson() {
		return this.personDao.listPerson();
	}

	public void savePerson(Person person) {
		this.personDao.savePerson(person);
	}

}
