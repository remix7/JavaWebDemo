package cc.cynara.spring.hibernate.transaction.dao;

import java.util.List;

import cc.cynara.spring.hibernate.transaction.domain.Person;

public interface PersonDao {
	public List<Person> listPerson();
	public void savePerson(Person person);
	
}
