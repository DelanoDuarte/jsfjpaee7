/**
 * 
 */
package br.com.simpleapp.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;

import br.com.simpleapp.domain.Cargo;
import br.com.simpleapp.util.JPAUtil;

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

	public List<Cargo> buscarTodosCargos() {
		try {
			EntityManager entityManager = JPAUtil.getEntityManager();
			return entityManager.createQuery("from Cargo c", Cargo.class).getResultList();
		} catch (Exception e) {
			return null;
		}
	}
}
