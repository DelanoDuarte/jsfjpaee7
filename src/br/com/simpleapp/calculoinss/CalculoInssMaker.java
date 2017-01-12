/**
 * 
 */
package br.com.simpleapp.calculoinss;

import javax.enterprise.context.RequestScoped;

import br.com.simpleapp.domain.Person;

/**
 * @author delano.duarte
 *
 */
@RequestScoped
public class CalculoInssMaker {

	private CalculoInssContriubuicaoMinima contriubuicaoMinima;
	private CalculoInssContriubuicaoMedia contriubuicaoMedia;
	private CalculoInssContriubuicaoMaxima contriubuicaoMaxima;

	public CalculoInssMaker() {
		contriubuicaoMinima = new CalculoInssContriubuicaoMinima();
		contriubuicaoMedia = new CalculoInssContriubuicaoMedia();
		contriubuicaoMaxima = new CalculoInssContriubuicaoMaxima();
	}

	public void calcularContribuicaoInss(Person person) {
		if (person.isCalculaINSS() == true) {
			contriubuicaoMinima.calcularContribuicaoInss(person);
			contriubuicaoMedia.calcularContribuicaoInss(person);
			contriubuicaoMaxima.calcularContribuicaoInss(person);
		}
	}

}
