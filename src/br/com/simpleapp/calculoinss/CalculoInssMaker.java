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
			double valorMinimo = calculoInssContriubuicaoMinima.calcularContribuicaoInss(person);
			double valorMedio = calculoInssContriubuicaoMedia.calcularContribuicaoInss(person);
			double valoMaximo = calculoInssContriubuicaoMaxima.calcularContribuicaoInss(person);

			return valorMinimo + valorMedio + valoMaximo;
		}
		return 0;
	}

}
