/**
 * 
 */
package br.com.simpleapp.repository;

import javax.enterprise.context.RequestScoped;

import br.com.simpleapp.domain.CalculoIRRF;

/**
 * @author delan
 *
 */
@RequestScoped
public class CalculoIRRFRepository extends AbstractRepository<CalculoIRRF> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculoIRRFRepository() {
		super(CalculoIRRF.class);
	}

}
