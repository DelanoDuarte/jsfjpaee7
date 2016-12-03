/**
 * 
 */
package br.com.simpleapp.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.simpleapp.domain.Person;

/**
 * @author delano.junior
 *
 */
public class Teste {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		List<Person> all = em.createQuery("from Person p").getResultList();

		for (Person person : all) {
			System.out.println(person.getNome());
		}
	}
}
