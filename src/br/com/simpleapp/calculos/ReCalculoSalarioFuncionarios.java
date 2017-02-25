/**
 * 
 */
package br.com.simpleapp.calculos;

import java.io.Serializable;
import java.util.ArrayList;
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
public class ReCalculoSalarioFuncionarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PersonRepository personRepository;

	@Inject
	private CalculoPersonGratificacoesDescontos calculoPersonGratificacoesDescontos;

	public List<Person> reCalcularSalarioFuncionarios() {

		List<Person> funcionarios = new ArrayList<>();
		List<Person> persons = personRepository.buscarTodos();

		for (Person personTemp : persons) {
			calculoPersonGratificacoesDescontos.calcularSalarioGratificacoesDescontos(personTemp);
			// calculoInssMaker.calcularContribuicaoInss(personTemp);
			funcionarios.add(personTemp);
		}

		return funcionarios;
	}

}
