package cc.cynara.spring.test.mvc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("personServiceImpl") //业务层
public class PersonServiceImpl implements PersonService{
	@Resource(name="personDaoImpl")
	private PersonDao personDao;
	
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void savePerson() {
		this.personDao.savePerson();
	}

}
