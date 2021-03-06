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

	@SuppressWarnings("unchecked")
	public List<Person> buscarTodosFuncionarioPorIdEmpresa(Long id) {
		try {
			EntityManager entityManager = JPAUtil.getEntityManager();
			List<Person> persons = entityManager.createQuery("from Person p where p.company.id = " + id)
					.getResultList();
			return persons;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Person> buscarTodosFuncionarioCom13SalarioNaoCalculado() {
		try {
			EntityManager entityManager = JPAUtil.getEntityManager();
			List<Person> persons = entityManager
					.createQuery("from Person p where p.dataCalculoDecimoTerceiroSalario = null").getResultList();
			return persons;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Person> buscarTodosFuncionarioCom13SalarioCalculado() {
		try {
			EntityManager entityManager = JPAUtil.getEntityManager();
			List<Person> persons = entityManager
					.createQuery("from Person p where p.dataCalculoDecimoTerceiroSalario != null").getResultList();
			return persons;
		} catch (Exception e) {
			return null;
		}
	}

}
