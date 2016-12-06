/**
 * 
 */
package br.com.simpleapp.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author delan
 *
 */
@Entity
@DiscriminatorValue(value = "Desconto")
public class Desconto extends IncidenciaSalario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
