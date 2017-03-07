/**
 * 
 */
package br.com.simpleapp.calculos;

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

	public double calculoValorTotalAnualTodosFuncionariosPorEmpresaFolha(Long id) {

		List<Person> persons = personRepository.buscarTodosFuncionarioPorIdEmpresa(id);
		double valorTotal = 0.0;
		double valor13Salario = 0.0;

		for (Person person : persons) {
			valor13Salario = person.getSalarioDecimoTerceiro();
			valorTotal += person.getSalarioBeneficios();
			valorTotal += valor13Salario;
		}
		return valorTotal * 12;
	}

	public double calculoValorCustoTotalMensalPorEmpresa(Long id) {
		List<Person> persons = personRepository.buscarTodosFuncionarioPorIdEmpresa(id);
		double valorTotal = 0.0;

		for (Person person : persons) {
			valorTotal += person.getSalarioBeneficios();
		}
		return valorTotal;
	}
}
