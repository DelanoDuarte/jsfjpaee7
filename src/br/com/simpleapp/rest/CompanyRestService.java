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

import br.com.simpleapp.domain.Company;
import br.com.simpleapp.repository.CompanyRepository;

/**
 * @author delan
 *
 */
@Stateless
@Path("/empresa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyRestService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CompanyRepository companyRepository;

	@Path("/listaEmpresasJSON")
	@GET
	public Response todasEmpresasJSON() {
		try {
			List<Company> companies = companyRepository.buscarTodos();
			return Response.ok().entity(companies).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}

	}

	@Path("/novaEmpresa")
	@POST
	public Response salvarEmpresa(Company company) {
		try {
			companyRepository.update(company);

			return Response.ok().entity(company).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@Path("/{idEmpresa}")
	@GET
	public Response buscaEmpresPorId(@PathParam("idEmpresa") Long id) {
		try {
			Company empresa = companyRepository.findById(id);

			return Response.ok().entity(empresa).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

}
