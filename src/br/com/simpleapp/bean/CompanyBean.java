/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.simpleapp.domain.Company;
import br.com.simpleapp.repository.CompanyRepository;
import br.com.simpleapp.util.MessageUtil;

/**
 * @author delan
 *
 */
@Model
public class CompanyBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Company company = new Company();
	private List<Company> companies = null;

	@Inject
	private CompanyRepository companyRepository;

	@Inject
	private MessageUtil messageUtil;

	public String salvar() {
		companyRepository.create(company);
		messageUtil.msgInfo("Nova Empresa Cadastrada com Sucesso !");
		return "/paginas/decisoes_tela/decisaoEmpresa";
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
