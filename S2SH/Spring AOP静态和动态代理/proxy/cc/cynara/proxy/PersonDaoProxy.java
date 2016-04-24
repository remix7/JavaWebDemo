package cc.cynara.proxy;

public class PersonDaoProxy implements PersonDao {
	private PersonDao personDao;
	private Transaction transaction;
	
	
	public PersonDaoProxy(PersonDao personDao, Transaction transaction) {
		this.personDao = personDao;
		this.transaction = transaction;
	}

	public void deletePerson() {
		this.transaction.beginTransaction();
		this.personDao.deletePerson();
		this.transaction.commit();
	}

	public void savePerson() {
		this.transaction.beginTransaction();
		this.personDao.savePerson();
		this.transaction.commit();
	}

	public void updatePerson() {
		this.transaction.beginTransaction();
		this.personDao.updatePerson();
		this.transaction.commit();
	}

}
