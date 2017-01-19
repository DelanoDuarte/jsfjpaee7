/**
 * 
 */
package br.com.simpleapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author delan
 *
 */
@Entity
@Table(name = "tb_imposto_renda")
public class CalculoIRRF implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_imposto_renda")
	private Long id;

	@Column(name = "contribuicao_minima")
	private double contribuicaoMinima;

	@Column(name = "contribuicao_media")
	private double contribuicaoMedia;

	@Column(name = "contribuicao_maxima")
	private double contribuicaoMaxima;

	@Column(name = "contribuicao_teto")
	private double contribuicaoTeto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getContribuicaoMinima() {
		return contribuicaoMinima;
	}

	public void setContribuicaoMinima(double contribuicaoMinima) {
		this.contribuicaoMinima = contribuicaoMinima;
	}

	public double getContribuicaoMedia() {
		return contribuicaoMedia;
	}

	public void setContribuicaoMedia(double contribuicaoMedia) {
		this.contribuicaoMedia = contribuicaoMedia;
	}

	public double getContribuicaoMaxima() {
		return contribuicaoMaxima;
	}

	public void setContribuicaoMaxima(double contribuicaoMaxima) {
		this.contribuicaoMaxima = contribuicaoMaxima;
	}

	public double getContribuicaoTeto() {
		return contribuicaoTeto;
	}

	public void setContribuicaoTeto(double contribuicaoTeto) {
		this.contribuicaoTeto = contribuicaoTeto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(contribuicaoMaxima);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(contribuicaoMedia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(contribuicaoMinima);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(contribuicaoTeto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CalculoIRRF other = (CalculoIRRF) obj;
		if (Double.doubleToLongBits(contribuicaoMaxima) != Double.doubleToLongBits(other.contribuicaoMaxima))
			return false;
		if (Double.doubleToLongBits(contribuicaoMedia) != Double.doubleToLongBits(other.contribuicaoMedia))
			return false;
		if (Double.doubleToLongBits(contribuicaoMinima) != Double.doubleToLongBits(other.contribuicaoMinima))
			return false;
		if (Double.doubleToLongBits(contribuicaoTeto) != Double.doubleToLongBits(other.contribuicaoTeto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CalculoIRRF [id=" + id + ", contribuicaoMinima=" + contribuicaoMinima + ", contribuicaoMedia="
				+ contribuicaoMedia + ", contribuicaoMaxima=" + contribuicaoMaxima + ", contribuicaoTeto="
				+ contribuicaoTeto + "]";
	}

}
