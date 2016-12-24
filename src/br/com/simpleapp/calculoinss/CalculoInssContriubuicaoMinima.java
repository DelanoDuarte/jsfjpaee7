package br.com.simpleapp.calculoinss;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.PersonRepository;

@RequestScoped
public class CalculoInssContriubuicaoMinima implements CalculoInss {

	@Inject
	private PersonRepository personRepository;

	@Override
	public void calcularContribuicaoInss(Person person) {

		List<Person> personList = personRepository.buscarTodos();

		for (Person personTemp : personList) {

			double salario = personTemp.getSalario();

			if (salario > 0 && salario < person.getCalculoInss().getContribuicaoSalarioMinima()) {

			}

		}

	}
}
