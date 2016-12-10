/**
 * 
 */
package br.com.simpleapp.repository;

import javax.enterprise.context.RequestScoped;

import br.com.simpleapp.domain.Beneficio;

/**
 * @author delan
 *
 */
@RequestScoped
public class BeneficioRepository extends AbstractRepository<Beneficio> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BeneficioRepository() {
		super(Beneficio.class);
	}
}
