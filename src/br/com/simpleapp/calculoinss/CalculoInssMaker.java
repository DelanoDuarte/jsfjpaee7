/**
 * 
 */
package br.com.simpleapp.calculoinss;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.simpleapp.domain.Person;

/**
 * @author delano.duarte
 *
 */
@RequestScoped
public class CalculoInssMaker {

	@Inject
	private CalculoInssContriubuicaoMinima calculoInssContriubuicaoMinima;

	@Inject
	private CalculoInssContriubuicaoMedia calculoInssContriubuicaoMedia;

	@Inject
	private CalculoInssContriubuicaoMaxima calculoInssContriubuicaoMaxima;

	public CalculoInssMaker() {

	}

	public double calcularContribuicaoInss(Person person) {

		if (person.isCalculaINSS() == true) {
			double a = calculoInssContriubuicaoMinima.calcularContribuicaoInss(person);
			double b = calculoInssContriubuicaoMedia.calcularContribuicaoInss(person);
			double c = calculoInssContriubuicaoMaxima.calcularContribuicaoInss(person);

			return a + b + c;
		}
		return 0;
	}

}
