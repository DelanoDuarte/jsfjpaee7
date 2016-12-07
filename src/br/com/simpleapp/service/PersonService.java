/**
 * 
 */
package br.com.simpleapp.service;

import java.io.Serializable;
import java.util.List;

import br.com.simpleapp.domain.Beneficio;
import br.com.simpleapp.domain.Desconto;
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
		double valorTotalCalculoNumerico = calculosPerson.calcularGratificaDesconto(person);

		calculosPerson = new CalculoPersonValorPorcentagem();
		double valorTotalCalculoPorcentagem = calculosPerson.calcularGratificaDesconto(person);

		double salarioPerson = person.getSalario();
		person.setSalarioBeneficios(
				verificaCalculoSalario(person, salarioPerson, valorTotalCalculoNumerico, valorTotalCalculoPorcentagem));
		personRepository.update(person);
	}

	public double verificaCalculoSalario(Person person, double salario, double valor1, double valor2) {

		try {
			List<Beneficio> beneficios = person.getBeneficios();
			List<Desconto> descontos = person.getDescontos();

			if (!beneficios.isEmpty()) {
				salario = ((salario + valor1) + valor2);
			}

			if (!descontos.isEmpty()) {
				salario = ((salario - valor1) - valor2);
			}

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
		return salario;

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
