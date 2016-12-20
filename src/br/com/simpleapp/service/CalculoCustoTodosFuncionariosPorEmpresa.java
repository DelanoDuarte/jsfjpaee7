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
public class CalculoCustoTodosFuncionariosPorEmpresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PersonRepository personRepository;

	public double calculoValorTotalTodosFuncionariosPorEmpresaFolha(Long id) {

		List<Person> persons = personRepository.buscarTodosFuncionarioPorIdEmpresa(id);
		double valorTotal = 0.0;

		for (Person person : persons) {
			valorTotal += person.getSalarioBeneficios();
		}
		return valorTotal;
	}
}
