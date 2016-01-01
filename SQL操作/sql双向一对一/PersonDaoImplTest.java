package cc.cynara.service.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cc.cynara.dao.impl.PersonDaoImpl;
import cc.cynara.domain.IdCard;
import cc.cynara.domain.Person;

public class PersonDaoImplTest {
	private PersonDaoImpl dao = new PersonDaoImpl();
	@Test
	public void testAddPerson() throws Exception {
		Person p = new Person();
		p.setId(1);
		p.setName("nihao");
		
		IdCard idCard = new IdCard();
		idCard.setNum("3111454");
		
		p.setIdcard(idCard);
		
		dao.addPerson(p);
	}

	@Test
	public void testFindPerson() throws Exception {
		Person p = dao.findPerson(1);
		System.out.println(p.getName());
		IdCard idCard = p.getIdcard();
		System.out.println(idCard.getNum());
	}

}
