package cc.cynara.spring.hibernate.transaction.service;

import java.util.List;

import cc.cynara.spring.hibernate.transaction.domain.Person;

public interface PersonService {
	public List<Person> listPerson();
	public void savePerson(Person person);
}
