/**
 * 
 */
package br.com.simpleapp.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.util.JPAUtil;

/**
 * @author delano.junior
 *
 */
@RequestScoped
public class PersonRepository extends AbstractRepository<Person> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonRepository() {
		super(Person.class);
	}

	@SuppressWarnings("unchecked")
	public List<Person> buscarTodos() {
		try {
			EntityManager entityManager = JPAUtil.getEntityManager();
			List<Person> persons = entityManager.createQuery("from Person p").getResultList();
			return persons;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

}
