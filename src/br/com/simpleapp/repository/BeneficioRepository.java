/**
 * 
 */
package br.com.simpleapp.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.simpleapp.domain.Beneficio;
import br.com.simpleapp.util.JPAUtil;

/**
 * @author delan
 *
 */
public class BeneficioRepository extends AbstractRepository<Beneficio> {

	

	@SuppressWarnings("unchecked")
	public List<Beneficio> buscarTodos() {
		try {
			EntityManager entityManager = JPAUtil.getEntityManager();
			List<Beneficio> beneficio = entityManager.createQuery("from Beneficio b").getResultList();
			return beneficio;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Beneficio buscarPorId2(Long id) {
		try {
			EntityManager entityManager = JPAUtil.getEntityManager();
			return entityManager.find(Beneficio.class, id);
		} catch (Exception e) {
			return null;
		}
	}
}
