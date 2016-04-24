package cc.cynara.spring.aop;

import java.io.Serializable;

import cc.cynara.spring.aop.annotation.Person;

public interface PersonDao {
	public void savePerson(Person person);
}
