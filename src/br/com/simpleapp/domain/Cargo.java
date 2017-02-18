/**
 * 
 */
package br.com.simpleapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Delano Jr
 *
 */
@Entity
@Table(name = "tb_cargo")
public class Cargo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cargo")
	private Long id;

	@Column(name = "nome_cargo")
	private String nome_cargo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_cargo() {
		return nome_cargo;
	}

	public void setNome_cargo(String nome_cargo) {
		this.nome_cargo = nome_cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome_cargo == null) ? 0 : nome_cargo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome_cargo == null) {
			if (other.nome_cargo != null)
				return false;
		} else if (!nome_cargo.equals(other.nome_cargo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome_cargo=" + nome_cargo + "]";
	}

}
