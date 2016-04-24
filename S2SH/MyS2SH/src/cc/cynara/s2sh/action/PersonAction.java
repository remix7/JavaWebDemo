package cc.cynara.s2sh.action;

import java.util.List;

import cc.cynara.s2sh.domain.Person;
import cc.cynara.s2sh.service.PersonService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport{
	private PersonService personService;

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	public String savePerson(){
		Person person = new Person();
		person.setPname("1234567");
		person.setPsex("1");
		this.personService.savePerson(person);
		return null;
	}
	public String listPerson(){
		List<Person> persons = personService.listPerson();
		for (Person person : persons) {
			System.out.println(person.getPname());
		}
		return null;
	}
	public String showPerson(){
		Person person = this.personService.findPersonById(5l);
		ActionContext.getContext().getValueStack().push(person);
		return "index";
	}
}
