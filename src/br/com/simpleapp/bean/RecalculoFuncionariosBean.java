/**
 * 
 */
package br.com.simpleapp.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.simpleapp.domain.Person;
import br.com.simpleapp.service.PersonService;

/**
 * @author delan
 *
 */

@Model
public class RecalculoFuncionariosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Person> persons;

	@Inject
	private PersonService personService;

	public String recalcularFuncionarios() {
		this.persons = null;
		return "/paginas/administrativo/listaFuncionariosCalculados";
	}

	public List<Person> getPersons() {
		if (this.persons == null) {
			this.persons = personService.reCalcularSalarioFuncionarios();
		}
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
