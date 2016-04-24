package cc.cynara.spring.mvc.exception.service.impl;

import cc.cynara.spring.mvc.exception.dao.PersonDao;
import cc.cynara.spring.mvc.exception.service.PersonService;

public class PersonServiceImpl implements PersonService{
	private PersonDao personDao;
	
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void savePerson() throws Exception {
		this.personDao.savePerson();
//		throw new RuntimeException("personService savePerson Exception");
	}
	
}
