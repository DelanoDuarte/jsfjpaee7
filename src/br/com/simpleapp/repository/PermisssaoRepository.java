/**
 * 
 */
package br.com.simpleapp.repository;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import br.com.simpleapp.domain.Permissao;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class PermisssaoRepository extends AbstractRepository<Permissao> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PermisssaoRepository() {
		super(Permissao.class);
	}
}
