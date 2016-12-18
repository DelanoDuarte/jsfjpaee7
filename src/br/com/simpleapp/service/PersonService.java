/**
 * 
 */
package br.com.simpleapp.service;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.domain.TipoContrato;
import br.com.simpleapp.repository.PersonRepository;

/**
 * @author delan
 *
 */
@RequestScoped
public class PersonService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PersonRepository personRepository;

	@Inject
	private CalculoPersonGratificacoesDescontos gratificacoesDescontos;

	@Inject
	private Calculo13Salario calculo13Salario = new Calculo13Salario();;

	public void salvarFuncionario(Person person) {
		gratificacoesDescontos.calcularSalarioGratificacoesDescontos(person);
		personRepository.update(person);
	}

	public double calcular13Salario(Person person, Integer meses) {
		if (person.getTipoContrato().toString() == TipoContrato.CLT.toString()) {
			return calculo13Salario.calcular13Salario(person, meses);
		} else {
			return 0.0;
		}

	}

	public Calculo13Salario getCalculo13Salario() {
		return calculo13Salario;
	}

	public void setCalculo13Salario(Calculo13Salario calculo13Salario) {
		this.calculo13Salario = calculo13Salario;
	}

}
