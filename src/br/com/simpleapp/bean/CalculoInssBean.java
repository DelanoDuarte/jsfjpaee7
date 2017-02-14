/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.simpleapp.domain.CalculoInss;
import br.com.simpleapp.repository.CalculoInssRepository;
import br.com.simpleapp.service.CalculoInssService;

/**
 * @author delan
 *
 */
@Model
public class CalculoInssBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CalculoInssRepository calculoInssRepository;

	@Inject
	private CalculoInssService calculoInssService;

	private CalculoInss calculoInss = new CalculoInss();
	private List<CalculoInss> valoresTabela = null;

	public String salvar() {
		calculoInssRepository.create(calculoInss);
		return "/paginas/administrativo/calculoInss/tabelaInss";
	}

	public boolean verificaTabelaVazia() {
		return calculoInssService.vericaSeTabelaEstaVazia(getValoresTabela());
	}

	public boolean desabilitarNovoCadastro() {
		if (this.valoresTabela.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean desabilitarEditarCadastro() {
		if (this.valoresTabela.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean mostrarEditarCadastro() {
		if (this.valoresTabela.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public void buscarTabelaPorId() {
		this.calculoInss = calculoInssRepository.findById(this.calculoInss.getId());
	}

	public CalculoInss getCalculoInss() {
		return calculoInss;
	}

	public void setCalculoInss(CalculoInss calculoInss) {
		this.calculoInss = calculoInss;
	}

	public List<CalculoInss> getValoresTabela() {
		if (this.valoresTabela == null)
			this.valoresTabela = calculoInssRepository.buscarContriubuicaCalculoInss();
		return valoresTabela;
	}

	public void setValoresTabela(List<CalculoInss> valoresTabela) {
		this.valoresTabela = valoresTabela;
	}

}
