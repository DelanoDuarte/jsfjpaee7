/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.domain.TipoContrato;
import br.com.simpleapp.repository.PersonRepository;
import br.com.simpleapp.service.PersonService;
import br.com.simpleapp.util.MessageUtil;

/**
 * @author delano.junior
 *
 */
@Model
public class PersonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Person person = new Person();
	private List<Person> persons = null;
	private Integer mesesTrabalhados;
	private double decimo13Salario;

	public PersonBean() {

	}

	@Inject
	private PersonRepository personRepository;

	@Inject
	private PersonService personService;

	@Inject
	private MessageUtil messageUtil;

	public String salvar() {
		personService.salvarFuncionario(person);
		messageUtil.msgInfo("Novo Funcionário Cadastrado com Sucesso !");
		return "/paginas/person/list";
	}

	public void calcular13Salario() {
		buscarPersonPorId();
		decimo13Salario = personService.calcular13Salario(person, mesesTrabalhados);
	}

	public void buscarPersonPorId() {
		this.person = personRepository.findById(this.person.getId());
	}

	public List<Person> getPersons() {
		if (this.persons == null)
			this.persons = personRepository.buscarTodos();
		return persons;
	}

	public TipoContrato[] getTipoContratos() {
		return TipoContrato.values();
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

	public Integer getMesesTrabalhados() {
		return mesesTrabalhados;
	}

	public void setMesesTrabalhados(Integer mesesTrabalhados) {
		this.mesesTrabalhados = mesesTrabalhados;
	}

	public double getDecimo13Salario() {
		return decimo13Salario;
	}

	public void setDecimo13Salario(double decimo13Salario) {
		this.decimo13Salario = decimo13Salario;
	}

}
