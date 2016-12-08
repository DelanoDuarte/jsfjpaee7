/**
 * 
 */
package br.com.simpleapp.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import br.com.simpleapp.util.JPAUtil;

/**
 * @author delano.junior
 *
 */
public abstract class AbstractRepository<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		} finally {

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
		} finally {

		}
		return entity;

	}

	public void delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			logger.info("Erro ao Deletar" + e.getMessage());
		} finally {
			entityManager.close();
		}

	}

	public T findById(Long id) {
		try {
			if (id != null) {
				return entityManager.find(clazz, id);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.info("Erro ao Buscar por Id " + e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		try {
			return entityManager.createQuery("from " + clazz.getName()).getResultList();
		} catch (Exception e) {
			logger.info("Erro ao Buscar Todos" + e.getMessage());
			return null;
		} finally {
			// entityManager.close();
		}

	}

}
