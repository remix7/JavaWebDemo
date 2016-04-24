package cc.cynara.spring.jdbc.transaction.dao;

import java.util.List;

import cc.cynara.spring.jdbc.transaction.bean.Person;

public interface PersonDao {
	public void savePerson();
	public List<Person> listPerson();
}
