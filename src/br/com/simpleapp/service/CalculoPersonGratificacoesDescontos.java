package br.com.simpleapp.service;

import javax.enterprise.context.RequestScoped;

/**
 * @author delano.junior
 *
 */

import br.com.simpleapp.domain.Beneficio;
import br.com.simpleapp.domain.Desconto;
import br.com.simpleapp.domain.Person;

@RequestScoped
public class CalculoPersonGratificacoesDescontos {

	public void calcularSalarioGratificacoesDescontos(Person person) {

		try {
			double salarioTemp = person.getSalario();

			for (Beneficio beneficio : person.getBeneficios()) {
				double valorBeneficioNumerico = beneficio.getValorNumerico();
				double valorBeneficioPorcentagem = beneficio.getValorPorcetagem();
				double valorCalculo = valorBeneficioPorcentagem / 100;
				double valorTotal = valorBeneficioNumerico + (person.getSalario() * valorCalculo);
				salarioTemp += valorTotal;
			}

			for (Desconto desconto : person.getDescontos()) {
				double valorDescontoNumerico = desconto.getValorNumerico();
				double valorDescontoPorcentagem = desconto.getValorPorcetagem();
				double valorCalculo = valorDescontoPorcentagem / 100;
				double valorTotal = valorDescontoNumerico - (person.getSalario() * valorCalculo);
				salarioTemp -= Math.abs(valorTotal);
			}

			person.setSalarioBeneficios(salarioTemp);

		} catch (Exception e) {

		}

	}

}
