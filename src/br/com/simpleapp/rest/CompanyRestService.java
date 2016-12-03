/**
 * 
 */
package br.com.simpleapp.rest;

import java.util.List;

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
public class CompanyRestService {

	private CompanyRepository companyRepository = new CompanyRepository();

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Company> todasEmpresasJSON() {
		return companyRepository.findAll();
	}

	public CompanyRepository getCompanyRepository() {
		return companyRepository;
	}

	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

}
