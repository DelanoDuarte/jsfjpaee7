package br.com.simpleapp.service;

import java.util.List;

/**
 * @author delano.junior
 *
 */

import br.com.simpleapp.domain.Beneficio;
import br.com.simpleapp.domain.Desconto;
import br.com.simpleapp.domain.Person;

public class CalculoPersonValorNumerico extends CalculosPerson {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.simpleapp.service.CalculosPerson#calcularGratificaDesconto(br.com.
	 * simpleapp.domain.Person)
	 */

	@Override
	public double calcularGratificaDesconto(Person person) {
		// person.setSalarioBeneficios(person.getSalario());

		List<Beneficio> beneficios = person.getBeneficios();
		List<Desconto> descontos = person.getDescontos();

		// 2500
		double salarioTemp = 0.0;

		// 1 - 50
		// 2500 + 50 = 2550
		for (Beneficio beneficio : beneficios) {
			salarioTemp += beneficio.getValorNumerico();
		}

		for (Desconto desconto : descontos) {
			salarioTemp += desconto.getValorNumerico();
		}

		/*
		 * if(salarioTemp < 0){ salarioTemp += (salarioTemp * 2); }
		 */

		return salarioTemp;
	}
}
