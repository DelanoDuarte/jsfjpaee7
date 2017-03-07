/**
 * 
 */
package br.com.simpleapp.repository;

import javax.enterprise.context.RequestScoped;

import br.com.simpleapp.domain.Desconto;

/**
 * @author delan
 *
 */
@RequestScoped
public class DescontoRepository extends AbstractRepository<Desconto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DescontoRepository() {
		super(Desconto.class);
	}

}
