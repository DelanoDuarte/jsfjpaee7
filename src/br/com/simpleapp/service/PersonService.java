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

	// Setando o valor do salario com Descontos para que seja igual ao
	// salario.
	// pegando todos os beneficios selecionados para o funcionário
	// atribuindo a um variável temporaria o valor do salario com
	// descontos/beneficios
	// percorrendo a lista de descontos/beneficios para acrescentar ou
	// diminuir no salario
	// atribuindo a coluna salarioBeneficios o valor da váriavel temporária
	public void salvarFuncionario(Person person) {

		person.setSalarioBeneficios(person.getSalario());

		List<Beneficio> beneficios = person.getBeneficios();
		List<Desconto> descontos = person.getDescontos();

		double salarioTemp = person.getSalarioBeneficios();

		for (Beneficio beneficio : beneficios) {
			for (Desconto desconto : descontos) {
				salarioTemp -= desconto.getValor();
			}
			salarioTemp += beneficio.getValor();
		}

		person.setSalarioBeneficios(salarioTemp);
		personRepository.update(person);
	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

}
