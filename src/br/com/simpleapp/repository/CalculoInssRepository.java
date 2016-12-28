/**
 * 
 */
package br.com.simpleapp.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;

import br.com.simpleapp.domain.CalculoInss;
import br.com.simpleapp.util.JPAUtil;

/**
 * @author delano.duarte
 *
 */
@RequestScoped
public class CalculoInssRepository extends AbstractRepository<CalculoInss> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculoInssRepository() {
		super(CalculoInss.class);
	}

	@SuppressWarnings("unchecked")
	public List<CalculoInss> buscarContriubuicaCalculoInss() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		return entityManager.createQuery("from CalculoInss c").getResultList();
	}

}
