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

	private CalculosPerson calculosPerson;

	public void salvarFuncionario(Person person) {

		calculosPerson = new CalculoPersonValorNumerico();
		calculosPerson.calcularGratificaDesconto(person);

		calculosPerson = new CalculoPersonValorPorcentagem();
		calculosPerson.calcularGratificaDesconto(person);

		personRepository.update(person);
	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public CalculosPerson getCalculosPerson() {
		return calculosPerson;
	}

	public void setCalculosPerson(CalculosPerson calculosPerson) {
		this.calculosPerson = calculosPerson;
	}

}
