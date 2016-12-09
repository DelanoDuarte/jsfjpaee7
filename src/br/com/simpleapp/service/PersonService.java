/**
 * 
 */
package br.com.simpleapp.service;

import java.io.Serializable;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.PersonRepository;

/**
 * @author delan
 *
 */
public class PersonService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PersonRepository personRepository = new PersonRepository();

	private CalculoPersonGratificacoesDescontos gratificacoesDescontos;
	private Calculo13Salario calculo13Salario;

	public void salvarFuncionario(Person person) {
		gratificacoesDescontos = new CalculoPersonGratificacoesDescontos();
		gratificacoesDescontos.calcularSalarioGratificacoesDescontos(person);
		personRepository.update(person);
	}

	public double calcular13Salario(Person person, Integer meses) {
		calculo13Salario = new Calculo13Salario();
		return calculo13Salario.calcular13Salario(person, meses);
	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public CalculoPersonGratificacoesDescontos getGratificacoesDescontos() {
		return gratificacoesDescontos;
	}

	public void setGratificacoesDescontos(CalculoPersonGratificacoesDescontos gratificacoesDescontos) {
		this.gratificacoesDescontos = gratificacoesDescontos;
	}

}
