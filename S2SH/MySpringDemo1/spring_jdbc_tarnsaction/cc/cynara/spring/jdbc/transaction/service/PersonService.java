package cc.cynara.spring.jdbc.transaction.service;

import java.util.List;

import cc.cynara.spring.jdbc.transaction.bean.Person;

public interface PersonService {
	public void savePerson();
	public List<Person> listPerson();
}
