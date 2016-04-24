package cc.cynara.spring.mvc.exception.action;

import cc.cynara.spring.mvc.exception.service.PersonService;

public class PersonAction {
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public String savePerson() throws Exception{
		this.personService.savePerson();
		return null;
	}
}
