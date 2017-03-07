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
import br.com.simpleapp.service.PersonService;

/**
 * @author delano.duarte
 *
 */
@Model
public class CalculoValorTotalPorEmpresaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Company company = new Company();
	private List<Company> companies = null;
	private double valorTotalCustoAnualPorEmpresa;
	private double valorTotalCustoMensalPorEmpresa;

	@Inject
	private CompanyRepository companyRepository;

	@Inject
	private PersonService personService;

	public void buscarEmpresaPorIdParaCalculo() {
		this.company = companyRepository.findById(this.company.getId());
		valorTotalCustoAnualPorEmpresa = personService
				.calculoValorTotalAnualTodosFuncionariosPorEmpresaFolha(this.company.getId());
		valorTotalCustoMensalPorEmpresa = personService
				.calculoValorTotalMensalTodosFuncionariosPorEmpresaFolha(this.company.getId());
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Company> getCompanies() {
		if (this.companies == null) {
			this.companies = companyRepository.buscarTodos();
		}
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public double getValorTotalCustoAnualPorEmpresa() {
		return valorTotalCustoAnualPorEmpresa;
	}

	public void setValorTotalCustoAnualPorEmpresa(double valorTotalCustoAnualPorEmpresa) {
		this.valorTotalCustoAnualPorEmpresa = valorTotalCustoAnualPorEmpresa;
	}

	public double getValorTotalCustoMensalPorEmpresa() {
		return valorTotalCustoMensalPorEmpresa;
	}

	public void setValorTotalCustoMensalPorEmpresa(double valorTotalCustoMensalPorEmpresa) {
		this.valorTotalCustoMensalPorEmpresa = valorTotalCustoMensalPorEmpresa;
	}

}
