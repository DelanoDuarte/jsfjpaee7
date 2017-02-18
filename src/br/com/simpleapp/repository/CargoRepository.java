/**
 * 
 */
package br.com.simpleapp.repository;

import javax.enterprise.context.RequestScoped;

import br.com.simpleapp.domain.Cargo;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class CargoRepository extends AbstractRepository<Cargo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CargoRepository() {
		super(Cargo.class);
	}
}
