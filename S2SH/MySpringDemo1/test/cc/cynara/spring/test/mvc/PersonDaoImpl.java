package cc.cynara.spring.test.mvc;

import org.springframework.stereotype.Repository;

@Repository("personDaoImpl") //持久层
public class PersonDaoImpl implements PersonDao{

	public void savePerson() {
		System.out.println("save Person dao");
	}

}
