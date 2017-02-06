/**
 * 
 */
package br.com.simpleapp.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.simpleapp.domain.CalculoInss;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class CalculoInssService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean vericaSeTabelaEstaVazia(List<CalculoInss> listaTabela) {
		try {
			if (listaTabela.isEmpty()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}
