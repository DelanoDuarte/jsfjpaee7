/**
 * 
 */
package br.com.simpleapp.service;

import br.com.simpleapp.domain.Beneficio;
import br.com.simpleapp.domain.Desconto;
import br.com.simpleapp.domain.Person;

/**
 * @author delano.junior
 *
 */
public class CalculoPersonValorPorcentagem extends CalculosPerson {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.simpleapp.service.CalculosPerson#calcularGratificaDesconto(br.com.
	 * simpleapp.domain.Person)
	 */
	@Override
	public void calcularGratificacoesDescontos(Person person) {

		// 2000
		double salarioTemp = person.getSalario();

		for (Beneficio beneficio : person.getBeneficios()) {
			// 10
			double valorBeneficio = beneficio.getValorPorcetagem();
			// 0.1
			double valorCalculo = valorBeneficio / 100;
			// 2000 * 0.1 = 200
			double valorTotal = salarioTemp * valorCalculo;
			// 2000 + 200 = 2200
			salarioTemp += valorTotal;
		}

		for (Desconto desconto : person.getDescontos()) {
			// 5
			double valorBeneficio = desconto.getValorPorcetagem();
			// 0.05
			double valorCalculo = valorBeneficio / 100;
			// 2000 * 0,05 = 100
			double valorTotal = salarioTemp * valorCalculo;
			// 2000 - 100 = 1900
			salarioTemp -= valorTotal;
		}

		person.setSalarioBeneficios(salarioTemp);
	}

}
