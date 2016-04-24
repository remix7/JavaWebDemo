package cc.cynara.spring.jdbc.transaction.service.impl;

import java.util.List;

import cc.cynara.spring.jdbc.transaction.bean.Person;
import cc.cynara.spring.jdbc.transaction.dao.PersonDao;
import cc.cynara.spring.jdbc.transaction.dao.impl.PersonDaoImpl;
import cc.cynara.spring.jdbc.transaction.service.PersonService;

public class PersonServiceImpl implements PersonService{
	private PersonDao dao = new PersonDaoImpl();
	
	public PersonDao getDao() {
		return dao;
	}

	public void setDao(PersonDao dao) {
		this.dao = dao;
	}

	public List<Person> listPerson() {
		
		return this.dao.listPerson();
	}

	public void savePerson() {
		this.dao.savePerson();
	}

}
