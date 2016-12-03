/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.simpleapp.domain.Beneficio;
import br.com.simpleapp.repository.BeneficioRepository;

/**
 * @author delan
 *
 */

@ManagedBean
@RequestScoped
public class BeneficioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Beneficio beneficio = new Beneficio();

	private List<Beneficio> beneficios = null;

	private BeneficioRepository beneficioRepository = new BeneficioRepository();

	public String salvar() {
		beneficioRepository.update(beneficio);
		return "/paginas/company/create";
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public List<Beneficio> getBeneficios() {
		if (this.beneficios == null)
			this.beneficios = beneficioRepository.findAll();
		return beneficios;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public BeneficioRepository getBeneficioRepository() {
		return beneficioRepository;
	}

	public void setBeneficioRepository(BeneficioRepository beneficioRepository) {
		this.beneficioRepository = beneficioRepository;
	}

}
