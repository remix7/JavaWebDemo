package cc.cynara.s2sh.service.impl;

import java.io.Serializable;
import java.util.List;

import cc.cynara.s2sh.dao.PersonDao;
import cc.cynara.s2sh.domain.Person;
import cc.cynara.s2sh.service.PersonService;

public class PersonServiceImpl implements PersonService{
	private PersonDao personDao ;
	
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

	@Override
	public Person findPersonById(Serializable id) {
		return personDao.findPersonById(id);
	}
	
}
