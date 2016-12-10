/**
 * 
 */
package br.com.simpleapp.rest;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.simpleapp.domain.Company;
import br.com.simpleapp.repository.CompanyRepository;

/**
 * @author delan
 *
 */
@Path("/company")
public class CompanyRestService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CompanyRepository companyRepository;

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Company> todasEmpresasJSON() {
		return companyRepository.buscarTodos();
	}

}
