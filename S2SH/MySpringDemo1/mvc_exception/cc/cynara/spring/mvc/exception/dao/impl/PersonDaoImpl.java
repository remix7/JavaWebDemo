package cc.cynara.spring.mvc.exception.dao.impl;

import cc.cynara.spring.mvc.exception.dao.PersonDao;

public class PersonDaoImpl implements PersonDao {

	public void savePerson() throws Exception {
		System.out.println("savePerson");
//		throw new RuntimeException("personDao savePerson Exception");
	}
	
}
