/**
 * 
 */
package br.com.simpleapp.rest;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.PersonRepository;

/**
 * @author delan
 *
 */
@Path("/person")
public class PersonRestService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PersonRepository personRepository = new PersonRepository();

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> todosFuncionáriosJSON() {
		try {
			return personRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Person funcionarioPorIdJSON(@PathParam(value = "id") Long id) {
		try {
			return personRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

}
