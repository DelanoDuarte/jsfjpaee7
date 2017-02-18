/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.simpleapp.domain.Cargo;
import br.com.simpleapp.repository.CargoRepository;

/**
 * @author Delano Jr
 *
 */
@Model
public class CargoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cargo cargo = new Cargo();
	private List<Cargo> cargos = null;

	@Inject
	private CargoRepository cargoRepository;

	public String salvarCargo() {
		cargoRepository.update(cargo);

		return "";
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		if (this.cargos == null)
			this.cargos = cargoRepository.findAll();
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}
