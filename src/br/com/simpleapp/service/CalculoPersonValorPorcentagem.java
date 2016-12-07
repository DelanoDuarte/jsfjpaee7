/**
 * 
 */
package br.com.simpleapp.service;

import java.util.List;

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
	public double calcularGratificaDesconto(Person person) {
		// person.setSalarioBeneficios(person.getSalario());

		List<Beneficio> beneficios = person.getBeneficios();
		List<Desconto> descontos = person.getDescontos();

		double salarioTemp = 0.0;

		for (Beneficio beneficio : beneficios) {
			double valorBeneficio = beneficio.getValorPorcetagem();
			double valorCalculo = valorBeneficio / 100;
			double valorTotal = person.getSalario() * valorCalculo;
			salarioTemp = valorTotal;
		}

		for (Desconto desconto : descontos) {
			double valorBeneficio = desconto.getValorPorcetagem();
			double valorCalculo = valorBeneficio / 100;
			double valorTotal = person.getSalario() * valorCalculo;
			salarioTemp = valorTotal;
		}

		// person.setSalarioBeneficios(salarioTemp);

		return salarioTemp;
	}

}
