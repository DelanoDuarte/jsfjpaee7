/**
 * 
 */
package br.com.simpleapp.service;

import java.util.Date;

import javax.enterprise.context.RequestScoped;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.domain.TipoContrato;

/**
 * @author delan
 *
 */
@RequestScoped
public class Calculo13Salario {

	public void calcular13Salario(Person person, Integer meses) {

		try {
			double salario = person.getSalario();
			double total = (salario / 12) * meses;

			if (person.getTipoContrato().toString() == TipoContrato.CLT.toString()) {
				person.setDataCalculoDecimoTerceiroSalario(new Date());
				person.setSalarioDecimoTerceiro(total);

			} else {
				person.setDataCalculoDecimoTerceiroSalario(null);
				person.setSalarioDecimoTerceiro(0);
			}
		} catch (Exception e) {
			System.out.println("Erro na Classe : " + this.getClass().getName() + e.getMessage());
		}

	}

}
