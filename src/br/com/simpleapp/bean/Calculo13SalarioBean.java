/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.PersonRepository;
import br.com.simpleapp.service.PersonService;

/**
 * @author delan
 *
 */
@Model
public class Calculo13SalarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer mesesTrabalhados;
	private Person person = new Person();
	private List<Person> persons = null;

	@Inject
	private PersonService personService;

	@Inject
	private PersonRepository personRepository;

	public void buscarPersonPorId() {
		this.person = personRepository.findById(this.person.getId());
	}

	public String calcular13Salario() {
		buscarPersonPorId();
		personService.calcular13Salario(person, mesesTrabalhados);
		return "/paginas/calculo13Salario/primeiroCalculo13/detalhesFuncionario13Calculado";
	}

	public Integer getMesesTrabalhados() {
		return mesesTrabalhados;
	}

	public List<Person> getPersons() {
		if (this.persons == null)
			this.persons = personRepository.buscarTodosFuncionarioCom13SalarioNaoCalculado();
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public void setMesesTrabalhados(Integer mesesTrabalhados) {
		this.mesesTrabalhados = mesesTrabalhados;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
