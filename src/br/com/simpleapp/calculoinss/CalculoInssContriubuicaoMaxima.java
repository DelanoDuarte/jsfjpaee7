package br.com.simpleapp.calculoinss;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.simpleapp.domain.CalculoInss;
import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.CalculoInssRepository;

@RequestScoped
public class CalculoInssContriubuicaoMaxima implements ICalculoInss {

	@Inject
	private CalculoInssRepository calculoInssRepository = new CalculoInssRepository();

	@Override
	public double calcularContribuicaoInss(Person person) {

		double valorAbate = 0;
		List<CalculoInss> tabelaValores = calculoInssRepository.buscarContriubuicaCalculoInss();

		for (CalculoInss calculoInss2 : tabelaValores) {

			double salario = person.getSalario();

			if (salario > calculoInss2.getContribuicaoSalarioMedia()
					&& salario <= calculoInss2.getContribuicaoSalarioMaxima()) {

				System.out.println("Chamou no Maxima ! ");
				double aliquotaMaxima = calculoInss2.getContribuicaoAliquotaMaxima();
				double valorTotal = aliquotaMaxima / 100;
				valorAbate = salario * valorTotal;
			} else {
				return 0;
			}
		}

		return valorAbate;
	}
}
