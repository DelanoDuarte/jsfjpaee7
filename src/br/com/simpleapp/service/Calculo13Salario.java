/**
 * 
 */
package br.com.simpleapp.service;

import br.com.simpleapp.domain.Person;

/**
 * @author delan
 *
 */
public class Calculo13Salario {

	public double calcular13Salario(Person person, Integer meses) {

		try {
			double salario = person.getSalario();
			double total = (salario / 12) * meses;

			return total;

		} catch (Exception e) {

			return 0;
		}

	}

}
