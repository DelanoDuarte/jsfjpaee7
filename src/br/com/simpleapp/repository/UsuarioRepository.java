/**
 * 
 */
package br.com.simpleapp.repository;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.simpleapp.domain.Usuario;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class UsuarioRepository extends AbstractRepository<Usuario> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioRepository() {
		super(Usuario.class);
	}
}
