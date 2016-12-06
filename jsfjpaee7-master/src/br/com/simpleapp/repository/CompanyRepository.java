/**
 * 
 */
package br.com.simpleapp.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.simpleapp.domain.Company;
import br.com.simpleapp.util.JPAUtil;

/**
 * @author delan
 *
 */
public class CompanyRepository extends AbstractRepository<Company> {

	@SuppressWarnings("unchecked")
	public List<Company> buscarTodos() {
		try {
			EntityManager entityManager = JPAUtil.getEntityManager();
			List<Company> company = entityManager.createQuery("from Company c").getResultList();
			return company;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

}
