/**
 * 
 */
package br.com.simpleapp.service;

import br.com.simpleapp.domain.Person;

/**
 * @author delano.junior
 *
 */
public abstract class CalculosPerson {

	public abstract void calcularGratificacoesDescontos(Person person);

	public final void calcularPerson(Person person) {

		calcularGratificacoesDescontos(person);
	}
}
