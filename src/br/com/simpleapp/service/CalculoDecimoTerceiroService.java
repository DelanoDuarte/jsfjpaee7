/**
 * 
 */
package br.com.simpleapp.service;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.domain.TipoContrato;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class CalculoDecimoTerceiroService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean verificaFuncionario13CalculoETipoContratoCLT(Person person) {
		try {

			if (person.isFlag13Calculado() == false
					&& person.getTipoContrato().toString() == TipoContrato.CLT.toString())
				return false;
			else
				return true;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean mostrarAreaFuncionario13CalculadoETipoContratoCLT(Person person) {
		try {
			if (person.isFlag13Calculado() == false
					&& person.getTipoContrato().toString() == TipoContrato.CLT.toString())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
}
