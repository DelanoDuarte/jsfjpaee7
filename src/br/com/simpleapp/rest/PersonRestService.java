/**
 * 
 */
package br.com.simpleapp.rest;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.repository.PersonRepository;
import br.com.simpleapp.service.PersonService;

/**
 * @author delan
 *
 */
@Stateless
@Path("/funcionario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonRestService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PersonRepository personRepository;

	@Inject
	private PersonService personService;

	@Path("/novoFuncionario")
	@POST
	public Response salvarFuncionario(Person person) {
		try {
			personService.salvarFuncionario(person);

			return Response.ok().entity(person).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@Path("/listaFuncionariosJSON")
	@GET
	public Response todosFuncionariosJSON() {
		try {
			List<Person> persons = personRepository.buscarTodos();
			return Response.ok().entity(persons).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}

	@Path("/{id}")
	@GET
	public Response funcionarioPorIdJSON(@PathParam(value = "id") Long id) {
		try {
			Person person = personRepository.findById(id);
			return Response.ok().entity(person).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/calculo13Salario/{id}/{meses}")
	public Response calcular13SalarioFuncionario(@PathParam(value = "id") Long id,
			@PathParam(value = "meses") Integer meses) {
		try {
			Person person = new Person();
			person = personRepository.findById(id);
			personService.calcular13Salario(person, meses);
			return Response.ok().status(200).build();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());

			return Response.ok().status(500).build();
		}

	}

	@GET
	@Path("/reCalculoFuncionarios")
	public Response recalcularFuncionarios() {
		try {
			List<Person> persons = personService.reCalcularSalarioFuncionarios();
			return Response.ok().entity(persons).build();
		} catch (Exception e) {
			return Response.ok().status(500).build();
		}
	}

	@GET
	@Path("/calculoCustoPorEmpresa/{id}")
	public Response calculoTodosFuncionariosPorEmpresa(@PathParam(value = "id") Long id) {
		try {
			double valorTotalCalculo = personService.calculoValorTotalAnualTodosFuncionariosPorEmpresaFolha(id);
			return Response.ok().entity(valorTotalCalculo).build();
		} catch (Exception e) {
			return Response.ok().status(500).build();
		}
	}

	@GET
	@Path("/calculoCustoTodosFuncionarios")
	public Response calcularCustoTodosFuncionariosCadastrados() {
		try {
			double valorTotalCalculo = personService.calculoValorTotalTodosFuncionariosFolha();
			return Response.ok().entity(valorTotalCalculo).build();
		} catch (Exception e) {
			return Response.ok().status(500).build();
		}
	}

}
