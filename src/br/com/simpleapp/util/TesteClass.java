/**
 * 
 */
package br.com.simpleapp.util;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.service.Calculo13Salario;

/**
 * @author delan
 *
 */
public class TesteClass {

	public static void main(String[] args) {
		Person person = new Person();
		person.setSalario(6512.56);

		System.out.println(calculo(person, 12));

	}

	private static double calculo(Person person, Integer meses) {

		Calculo13Salario calculo13Salario = new Calculo13Salario();

		return calculo13Salario.calcular13Salario(person, meses);
	}
}
