/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.simpleapp.domain.Company;
import br.com.simpleapp.repository.CompanyRepository;

/**
 * @author delan
 *
 */
@ManagedBean
@RequestScoped
public class CompanyBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Company company = new Company();
	private List<Company> companies = null;

	private CompanyRepository companyRepository = new CompanyRepository();

	public String salvar() {
		companyRepository.create(company);
		return "/paginas/person/create";
	}

	public void buscarEmpresaPorId() {
		this.company = companyRepository.findById(this.company.getId());
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Company> getCompanies() {
		if (this.companies == null)
			this.companies = companyRepository.buscarTodos();
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public CompanyRepository getCompanyRepository() {
		return companyRepository;
	}

	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

}
