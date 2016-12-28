/**
 * 
 */
package br.com.simpleapp.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.simpleapp.calculoinss.CalculoInssMaker;
import br.com.simpleapp.calculos.Calculo13Salario;
import br.com.simpleapp.calculos.CalculoCustoTodosFuncionarios;
import br.com.simpleapp.calculos.CalculoCustoTodosFuncionariosPorEmpresa;
import br.com.simpleapp.calculos.CalculoPersonGratificacoesDescontos;
import br.com.simpleapp.calculos.ReCalculoSalarioFuncionarios;
import br.com.simpleapp.domain.Person;
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
	private CalculoCustoTodosFuncionarios calculoCustoTodosFuncionarios;

	@Inject
	private CalculoCustoTodosFuncionariosPorEmpresa calculoCustoTodosFuncionariosPorEmpresa;

	@Inject
	private ReCalculoSalarioFuncionarios reCalculoSalarioFuncionarios;

	@Inject
	private CalculoInssMaker calculoContribuicaoInss;

	@Inject
	private Calculo13Salario calculo13Salario = new Calculo13Salario();

	public void salvarFuncionario(Person person) {
		gratificacoesDescontos.calcularSalarioGratificacoesDescontos(person);
		calculoContribuicaoInss.calcularContribuicaoInss(person);
		personRepository.update(person);
	}

	public void calcular13Salario(Person person, Integer meses) {
		calculo13Salario.calcular13Salario(person, meses);
		personRepository.update(person);
	}

	public List<Person> reCalcularSalarioFuncionarios() {
		return reCalculoSalarioFuncionarios.reCalcularSalarioFuncionarios();
	}

	public double calculoValorTotalTodosFuncionariosFolha() {
		return calculoCustoTodosFuncionarios.calculoValorTotalTodosFuncionariosFolha();
	}

	public double calculoValorTotalTodosFuncionariosPorEmpresaFolha(Long id) {
		return calculoCustoTodosFuncionariosPorEmpresa.calculoValorTotalTodosFuncionariosPorEmpresaFolha(id);
	}

	public Calculo13Salario getCalculo13Salario() {
		return calculo13Salario;
	}

	public void setCalculo13Salario(Calculo13Salario calculo13Salario) {
		this.calculo13Salario = calculo13Salario;
	}

}
