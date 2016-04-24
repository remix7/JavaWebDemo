package cc.cynara.spring.test.mvc;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller("personAction")  //控制层
public class PersonAction {
	@Resource(name="personServiceImpl")
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	 public void savePerson(){
		 this.personService.savePerson();
	 }
}
