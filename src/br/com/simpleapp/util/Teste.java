/**
 * 
 */
package br.com.simpleapp.util;

import br.com.simpleapp.calculoinss.CalculoInssMaker;
import br.com.simpleapp.domain.CalculoInss;
import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.CalculoInssRepository;

/**
 * @author delano.duarte
 *
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		salvarCalculoInss();

		Person person = new Person();
		person.setSalario(2594.93);
		person.setSalarioBeneficios(2000.00);

		CalculoInssMaker calculoInssMaker = new CalculoInssMaker();
		calculoInssMaker.calcularContribuicaoInss(person);

		System.out.println(person.getSalarioBeneficios());

	}

	private static void salvarCalculoInss() {
		CalculoInssRepository calculoInssReposiroty = new CalculoInssRepository();
		CalculoInss caInss = new CalculoInss();
		caInss.setContribuicaoSalarioMinima(1556.94);
		caInss.setContribuicaoAliquotaMinima(8);
		caInss.setContribuicaoSalarioMedia(2594.92);
		caInss.setContribuicaoAliquotaMedia(9);
		caInss.setContribuicaoSalarioMaxima(5189.82);
		caInss.setContribuicaoAliquotaMaxima(11);

		calculoInssReposiroty.create(caInss);
	}

}
