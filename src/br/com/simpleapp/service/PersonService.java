/**
 * 
 */
package br.com.simpleapp.service;

import java.io.Serializable;
import java.util.List;

import br.com.simpleapp.domain.Beneficio;
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

	public void salvarFuncionario(Person person) {

		// Setando o valor do salario com Descontos para que seja igual ao
		// salario.
		person.setSalarioBeneficios(person.getSalario());

		// pegando todos os beneficios selecionados para o funcionário
		List<Beneficio> beneficios = person.getBeneficios();

		// atribuindo a um variável temporaria o valor do salario com
		// descontos/beneficios
		double salarioTemp = person.getSalarioBeneficios();

		// percorrendo a lista de descontos/beneficios para acrescentar ou
		// diminuir no salario
		for (Beneficio beneficio : beneficios) {
			salarioTemp -= beneficio.getValor();
		}

		// atribuindo a coluna salarioBeneficios o valor da váriavel temporária
		person.setSalarioBeneficios(salarioTemp);

		// salvando o valor final
		personRepository.update(person);
	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

}
