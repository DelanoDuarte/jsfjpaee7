package br.com.simpleapp.calculoinss;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.simpleapp.domain.CalculoInss;
import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.CalculoInssRepository;

@RequestScoped
public class CalculoInssContriubuicaoMinima implements ICalculoInss {

	@Inject
	private CalculoInssRepository calculoInssRepository = new CalculoInssRepository();

	@Override
	public void calcularContribuicaoInss(Person person) {
		
		
		List<CalculoInss> tabelaValores = calculoInssRepository.buscarContriubuicaCalculoInss();

		for (CalculoInss calculoInss2 : tabelaValores) {

			double salario = person.getSalario();
			double salarioBeneficios = person.getSalarioBeneficios();

			if (salario > 0 && salario < calculoInss2.getContribuicaoSalarioMinima()) {

				System.out.println("Chamou no Minimo ! ");
				double aliquotaMinima = calculoInss2.getContribuicaoAliquotaMinima();
				double valorTotal = aliquotaMinima / 100;
				double valorAbate = salario * valorTotal;
				double valor = salarioBeneficios - valorAbate;

				person.setSalarioBeneficios(valor);
			}
		}
	}
}
