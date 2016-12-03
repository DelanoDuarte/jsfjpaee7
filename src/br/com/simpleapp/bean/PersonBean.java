/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.PersonRepository;
import br.com.simpleapp.service.PersonService;

/**
 * @author delano.junior
 *
 */
@ManagedBean
@RequestScoped
public class PersonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Person person = new Person();
	private List<Person> persons = null;

	public PersonBean() {

	}

	private PersonRepository personRepository = new PersonRepository();

	private PersonService personService = new PersonService();

	public String salvar() {
		personService.salvarFuncionario(person);
		return "/paginas/company/list";
	}

	public void buscarPersonPorId() {
		this.person = personRepository.findById(this.person.getId());
	}

	public List<Person> getPersons() {
		if (this.persons == null)
			this.persons = personRepository.findAll();
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
