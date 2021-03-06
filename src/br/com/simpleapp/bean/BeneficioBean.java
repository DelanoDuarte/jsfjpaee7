/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.simpleapp.domain.Beneficio;
import br.com.simpleapp.repository.BeneficioRepository;
import br.com.simpleapp.util.MessageUtil;

/**
 * @author delan
 *
 */

@Model
public class BeneficioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Beneficio beneficio = new Beneficio();

	private List<Beneficio> beneficios = null;
	private String tipoGratificacao;

	@Inject
	private BeneficioRepository beneficioRepository;

	@Inject
	private MessageUtil messageUtil;

	public String salvar() {
		beneficioRepository.create(beneficio);
		messageUtil.msgInfo("Novo Beneficio Cadastrado com Sucesso !");
		return "/paginas/decisoes_tela/decisaoGratificacaoDesconto";
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

	public String getTipoGratificacao() {
		return tipoGratificacao;
	}

	public void setTipoGratificacao(String tipoGratificacao) {
		this.tipoGratificacao = tipoGratificacao;
	}

}
