package cc.cynara.proxy.jdk.hibernate;

import java.io.Serializable;

public interface PersonDao {
	public void savePerson(Person person);
	public void updatePerson(Person person);
	public void deletePerson(Serializable id);
}
