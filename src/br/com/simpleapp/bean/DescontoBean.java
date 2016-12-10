/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.simpleapp.domain.Desconto;
import br.com.simpleapp.repository.DescontoRepository;

/**
 * @author delan
 *
 */
@Model
public class DescontoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Desconto desconto = new Desconto();
	private List<Desconto> descontos = null;
	private String tipoDesconto;

	@Inject
	private DescontoRepository descontoRepository;

	public String salvar() {
		descontoRepository.create(desconto);
		return "/paginas/company/create";
	}

	public Desconto getDesconto() {
		return desconto;
	}

	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}

	public DescontoRepository getDescontoRepository() {
		return descontoRepository;
	}

	public void setDescontoRepository(DescontoRepository descontoRepository) {
		this.descontoRepository = descontoRepository;
	}

	public List<Desconto> getDescontos() {
		if (this.descontos == null)
			this.descontos = descontoRepository.findAll();
		return descontos;
	}

	public void setDescontos(List<Desconto> descontos) {
		this.descontos = descontos;
	}

	public String getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

}
