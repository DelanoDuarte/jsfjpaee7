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
 * @author delano.duarte
 *
 */
@Model
public class CalculoValorTotalTodosFuncionariosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Person> persons = null;
	private double valorTotalTodosFuncionarios;

	@Inject
	private PersonRepository personRepository;

	@Inject
	private PersonService personService;

	public String calcularCustoTodosFuncionarios() {
		valorTotalTodosFuncionarios = personService.calculoValorTotalTodosFuncionariosFolha();
		return "/paginas/administrativo/calculoCustoTodosFuncionarios/detalhesCalculoTodosFuncionarios";
	}

	public List<Person> getPersons() {
		if (this.persons == null) {
			this.persons = personRepository.buscarTodos();
		}
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public double getValorTotalTodosFuncionarios() {
		return valorTotalTodosFuncionarios;
	}

	public void setValorTotalTodosFuncionarios(double valorTotalTodosFuncionarios) {
		this.valorTotalTodosFuncionarios = valorTotalTodosFuncionarios;
	}
}
