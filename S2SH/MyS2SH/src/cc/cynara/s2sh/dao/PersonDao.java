package cc.cynara.s2sh.dao;

import java.io.Serializable;
import java.util.List;

import cc.cynara.s2sh.domain.Person;

public interface PersonDao {
	public List<Person> listPerson();
	public void savePerson(Person person);
	public Person findPersonById(Serializable id);
}	
