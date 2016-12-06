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
@DiscriminatorValue(value = "Gratificacao")
public class Beneficio extends IncidenciaSalario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
