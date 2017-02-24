package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.PersonRepository;
import br.com.simpleapp.service.PersonService;

@Model
public class Recalculo13Salario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Person> persons = null;
	private Person person = new Person();
	private Integer mesesTrabalhados;

	@Inject
	private PersonRepository personRepository;

	@Inject
	private PersonService personService;

	public void buscarPersonPorId() {
		this.person = personRepository.findById(this.person.getId());
	}

	public void buscarPersonPorIdParaCalcular() {
		this.person = personRepository.findById(this.person.getId());
		personService.calcular13Salario(person, mesesTrabalhados);
	}

	public String reCalcular13SalarioFuncionario() {
		return "/paginas/administrativo/calculo13Salario/recalculo13Salario/detalhesFuncionario13ReCalculado";
	}

	public List<Person> getPersons() {
		if (this.persons == null)
			this.persons = personRepository.buscarTodosFuncionarioCom13SalarioCalculado();
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

	public Integer getMesesTrabalhados() {
		return mesesTrabalhados;
	}

	public void setMesesTrabalhados(Integer mesesTrabalhados) {
		this.mesesTrabalhados = mesesTrabalhados;
	}

}
