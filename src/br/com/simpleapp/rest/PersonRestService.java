/**
 * 
 */
package br.com.simpleapp.rest;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.PersonRepository;
import br.com.simpleapp.service.PersonService;

/**
 * @author delan
 *
 */
@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonRestService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PersonRepository personRepository = new PersonRepository();

	private PersonService personService = new PersonService();

	@Path("/list")
	@GET
	public List<Person> todosFuncionáriosJSON() {
		try {
			return personRepository.buscarTodos();
		} catch (Exception e) {
			return null;
		}
	}

	@Path("/{id}")
	@GET
	public Person funcionarioPorIdJSON(@PathParam(value = "id") Long id) {
		try {
			return personRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	@GET
	@Path("/calculo13Salario/{id}/{meses}")
	public double calcular13SalarioFuncionario(@PathParam(value = "id") Long id,
			@PathParam(value = "meses") Integer meses) {
		try {
			Person person = new Person();
			person = personRepository.findById(id);
			personService.calcular13Salario(person, meses);
			return 0.0; // Adaptar Método Rest
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return 0.0;
		}

	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
