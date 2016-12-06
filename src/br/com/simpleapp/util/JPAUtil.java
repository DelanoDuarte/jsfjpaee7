/**
 * 
 */
package br.com.simpleapp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author delano.junior
 *
 */
public class JPAUtil {

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("TesteTomcat");
		return emf;
	}

	public static EntityManager getEntityManager() {
		if (em != null && em.isOpen())
			return em;
		else {
			em = getEntityManagerFactory().createEntityManager();
			return em;
		}
	}

}
