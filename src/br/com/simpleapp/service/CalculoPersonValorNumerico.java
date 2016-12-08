package br.com.simpleapp.service;

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
	public void calcularGratificacoesDescontos(Person person) {

		double salarioTemp = person.getSalario();

		for (Beneficio beneficio : person.getBeneficios()) {
			double valorBeneficioNumerico = beneficio.getValorNumerico();
			double valorBeneficioPorcentagem = beneficio.getValorPorcetagem();
			double valorCalculo = valorBeneficioPorcentagem / 100;
			double valorTotal = valorBeneficioNumerico + (salarioTemp * valorCalculo);
			salarioTemp += valorTotal;
		}

		for (Desconto desconto : person.getDescontos()) {
			double valorDescontoNumerico = desconto.getValorNumerico();
			double valorDescontoPorcentagem = desconto.getValorPorcetagem();
			double valorCalculo = valorDescontoPorcentagem / 100;
			double valorTotal = valorDescontoNumerico - (salarioTemp * valorCalculo);
			salarioTemp -= valorTotal;
		}

		person.setSalarioBeneficios(salarioTemp);

	}

}
