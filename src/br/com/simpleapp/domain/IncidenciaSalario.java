/**
 * 
 */
package br.com.simpleapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

/**
 * @author delan
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_incidencia_salario", discriminatorType = DiscriminatorType.STRING)
public abstract class IncidenciaSalario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(name = "nome_incidencia_salarial")
	@NotNull
	private String nome;

	@Column(name = "valor_numero_incidencia")
	private double valorNumerico;

	@Column(name = "valor_porcentagem_incidencia")
	private double valorPorcetagem;

	public IncidenciaSalario() {
		super();
	}

	public IncidenciaSalario(String nome, double valorNumerico, double valorPorcetagem) {
		super();
		this.nome = nome;
		this.valorNumerico = valorNumerico;
		this.valorPorcetagem = valorPorcetagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorNumerico() {
		return valorNumerico;
	}

	public void setValorNumerico(double valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public double getValorPorcetagem() {
		return valorPorcetagem;
	}

	public void setValorPorcetagem(double valorPorcetagem) {
		this.valorPorcetagem = valorPorcetagem;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorNumerico);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorPorcetagem);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		IncidenciaSalario other = (IncidenciaSalario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(valorNumerico) != Double.doubleToLongBits(other.valorNumerico))
			return false;
		if (Double.doubleToLongBits(valorPorcetagem) != Double.doubleToLongBits(other.valorPorcetagem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IncidenciaSalario [id=" + id + ", nome=" + nome + ", valorNumerico=" + valorNumerico
				+ ", valorPorcetagem=" + valorPorcetagem + "]";
	}

}
