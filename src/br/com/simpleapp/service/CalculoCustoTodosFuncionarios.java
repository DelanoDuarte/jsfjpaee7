/**
 * 
 */
package br.com.simpleapp.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.PersonRepository;

/**
 * @author delano.duarte
 *
 */
@RequestScoped
public class CalculoCustoTodosFuncionarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PersonRepository personRepository;

	public double calculoValorTotalTodosFuncionariosFolha() {

		List<Person> persons = personRepository.buscarTodos();
		double valorTotal = 0.0;
		double valor13Salario = 0.0;

		for (Person person : persons) {
			valor13Salario = person.getSalarioDecimoTerceiro();
			valorTotal += person.getSalarioBeneficios() + valor13Salario;
		}
		return valorTotal;
	}

}
