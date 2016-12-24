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
@Table(name = "tb_tabela_calculo_inss")
public class CalculoInss implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private double contribuicaoSalarioMinima;

	@Column
	private double contribuicaoSalarioMedia;

	@Column
	private double contribuicaoSalarioMaxima;

	@Column
	private double contribuicaoAliquotaMinima;

	@Column
	private double contribuicaoAliquotaMedia;

	@Column
	private double contribuicaoAliquotaMaxima;

	public CalculoInss() {
		super();
	}

	public CalculoInss(double contribuicaoSalarioMinima, double contribuicaoSalarioMedia,
			double contribuicaoSalarioMaxima, double contribuicaoAliquotaMinima, double contribuicaoAliquotaMedia,
			double contribuicaoAliquotaMaxima) {
		super();
		this.contribuicaoSalarioMinima = contribuicaoSalarioMinima;
		this.contribuicaoSalarioMedia = contribuicaoSalarioMedia;
		this.contribuicaoSalarioMaxima = contribuicaoSalarioMaxima;
		this.contribuicaoAliquotaMinima = contribuicaoAliquotaMinima;
		this.contribuicaoAliquotaMedia = contribuicaoAliquotaMedia;
		this.contribuicaoAliquotaMaxima = contribuicaoAliquotaMaxima;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getContribuicaoSalarioMinima() {
		return contribuicaoSalarioMinima;
	}

	public void setContribuicaoSalarioMinima(double contribuicaoSalarioMinima) {
		this.contribuicaoSalarioMinima = contribuicaoSalarioMinima;
	}

	public double getContribuicaoSalarioMedia() {
		return contribuicaoSalarioMedia;
	}

	public void setContribuicaoSalarioMedia(double contribuicaoSalarioMedia) {
		this.contribuicaoSalarioMedia = contribuicaoSalarioMedia;
	}

	public double getContribuicaoSalarioMaxima() {
		return contribuicaoSalarioMaxima;
	}

	public void setContribuicaoSalarioMaxima(double contribuicaoSalarioMaxima) {
		this.contribuicaoSalarioMaxima = contribuicaoSalarioMaxima;
	}

	public double getContribuicaoAliquotaMinima() {
		return contribuicaoAliquotaMinima;
	}

	public void setContribuicaoAliquotaMinima(double contribuicaoAliquotaMinima) {
		this.contribuicaoAliquotaMinima = contribuicaoAliquotaMinima;
	}

	public double getContribuicaoAliquotaMedia() {
		return contribuicaoAliquotaMedia;
	}

	public void setContribuicaoAliquotaMedia(double contribuicaoAliquotaMedia) {
		this.contribuicaoAliquotaMedia = contribuicaoAliquotaMedia;
	}

	public double getContribuicaoAliquotaMaxima() {
		return contribuicaoAliquotaMaxima;
	}

	public void setContribuicaoAliquotaMaxima(double contribuicaoAliquotaMaxima) {
		this.contribuicaoAliquotaMaxima = contribuicaoAliquotaMaxima;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(contribuicaoAliquotaMaxima);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(contribuicaoAliquotaMedia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(contribuicaoAliquotaMinima);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(contribuicaoSalarioMaxima);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(contribuicaoSalarioMedia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(contribuicaoSalarioMinima);
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
		CalculoInss other = (CalculoInss) obj;
		if (Double.doubleToLongBits(contribuicaoAliquotaMaxima) != Double
				.doubleToLongBits(other.contribuicaoAliquotaMaxima))
			return false;
		if (Double.doubleToLongBits(contribuicaoAliquotaMedia) != Double
				.doubleToLongBits(other.contribuicaoAliquotaMedia))
			return false;
		if (Double.doubleToLongBits(contribuicaoAliquotaMinima) != Double
				.doubleToLongBits(other.contribuicaoAliquotaMinima))
			return false;
		if (Double.doubleToLongBits(contribuicaoSalarioMaxima) != Double
				.doubleToLongBits(other.contribuicaoSalarioMaxima))
			return false;
		if (Double.doubleToLongBits(contribuicaoSalarioMedia) != Double
				.doubleToLongBits(other.contribuicaoSalarioMedia))
			return false;
		if (Double.doubleToLongBits(contribuicaoSalarioMinima) != Double
				.doubleToLongBits(other.contribuicaoSalarioMinima))
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
		return "CalculoInss [id=" + id + ", contribuicaoSalarioMinima=" + contribuicaoSalarioMinima
				+ ", contribuicaoSalarioMedia=" + contribuicaoSalarioMedia + ", contribuicaoSalarioMaxima="
				+ contribuicaoSalarioMaxima + ", contribuicaoAliquotaMinima=" + contribuicaoAliquotaMinima
				+ ", contribuicaoAliquotaMedia=" + contribuicaoAliquotaMedia + ", contribuicaoAliquotaMaxima="
				+ contribuicaoAliquotaMaxima + "]";
	}

}
