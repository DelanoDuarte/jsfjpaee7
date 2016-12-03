/**
 * 
 */
package br.com.simpleapp.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.simpleapp.util.JPAUtil;

/**
 * @author delano.junior
 *
 */
public abstract class AbstractRepository<T> {

	private Logger logger = Logger.getLogger("Abstract Repository");

	protected EntityManager entityManager = JPAUtil.getEntityManager();
	protected Class<T> clazz = null;

	@SuppressWarnings("unchecked")
	protected AbstractRepository() {
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.clazz = clazz;
	}

	public void create(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			logger.info("Erro ao Salvar" + e.getMessage());
		}

	}

	public T update(T entity) {

		try {
			entityManager.getTransaction().begin();
			entity = entityManager.merge(entity);
			entityManager.getTransaction().commit();
			entityManager.close();

		} catch (Exception e) {
			logger.info("Erro ao Atualizar" + e.getMessage());
		}

		return entity;
	}

	public void delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			logger.info("Erro ao Deletar" + e.getMessage());
		}

	}

	public T findById(Long id) {
		try {
			return entityManager.find(clazz, id);
		} catch (Exception e) {
			logger.info("Erro ao Buscaro por Id" + e.getMessage());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		try {
			Query query = entityManager.createQuery("from " + clazz.getName());
			List<T> resultList = query.getResultList();
			return resultList;
		} catch (Exception e) {
			logger.info("Erro ao Buscar Todos" + e.getMessage());

			return null;
		}

	}

}
