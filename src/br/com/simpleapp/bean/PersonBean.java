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
import br.com.simpleapp.service.CalculoDecimoTerceiroService;
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

	public PersonBean() {

	}

	@Inject
	private PersonRepository personRepository;

	@Inject
	private PersonService personService;

	@Inject
	private MessageUtil messageUtil;

	@Inject
	private CalculoDecimoTerceiroService calculoDecimoTerceiroService;

	public String salvar() {
		personService.salvarFuncionario(person);
		messageUtil.msgInfo("Novo Funcionário Cadastrado com Sucesso !");
		return "/paginas/person/list";
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

	public boolean desabilitaBotaoCalcular13Terceiro() {
		// buscarPersonPorId();
		return calculoDecimoTerceiroService.verificaFuncionario13CalculoETipoContratoCLT(person);
	}

	public boolean desabilitaAreaExibicao13Salario() {
		return calculoDecimoTerceiroService.mostrarAreaFuncionario13CalculadoETipoContratoCLT(this.person);
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
