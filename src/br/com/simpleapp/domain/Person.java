/**
 * 
 */
package br.com.simpleapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author delano.junior
 *
 */
@Entity
@Table(name = "tb_person")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String nome;

	@Column
	private String sobrenome;

	@Column
	private double salario;

	@Column
	private double salarioBeneficios;

	@Column
	private double salarioDecimoTerceiro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCalculoDecimoTerceiroSalario;

	@ManyToOne
	@JoinColumn(name = "id_company")
	private Company company;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_person_beneficios", joinColumns = @JoinColumn(name = "id_person"), inverseJoinColumns = @JoinColumn(name = "id_beneficio"))
	private List<Beneficio> beneficios;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_person_descontos", joinColumns = @JoinColumn(name = "id_person"), inverseJoinColumns = @JoinColumn(name = "id_desconto"))
	private List<Desconto> descontos;

	@Enumerated(EnumType.STRING)
	private TipoContrato tipoContrato;
	
	private CalculoInss calculoInss;
	
	public Person() {
		super();
	}

	public Person(String nome, String sobrenome, double salario, double salarioBeneficios, double salarioDecimoTerceiro,
			Date dataCalculoDecimoTerceiroSalario, Company company, List<Beneficio> beneficios,
			List<Desconto> descontos, TipoContrato tipoContrato) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.salario = salario;
		this.salarioBeneficios = salarioBeneficios;
		this.salarioDecimoTerceiro = salarioDecimoTerceiro;
		this.dataCalculoDecimoTerceiroSalario = dataCalculoDecimoTerceiroSalario;
		this.company = company;
		this.beneficios = beneficios;
		this.descontos = descontos;
		this.tipoContrato = tipoContrato;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getSalarioBeneficios() {
		return salarioBeneficios;
	}

	public void setSalarioBeneficios(double salarioBeneficios) {
		this.salarioBeneficios = salarioBeneficios;
	}

	public double getSalarioDecimoTerceiro() {
		return salarioDecimoTerceiro;
	}

	public void setSalarioDecimoTerceiro(double salarioDecimoTerceiro) {
		this.salarioDecimoTerceiro = salarioDecimoTerceiro;
	}

	public Date getDataCalculoDecimoTerceiroSalario() {
		return dataCalculoDecimoTerceiroSalario;
	}

	public void setDataCalculoDecimoTerceiroSalario(Date dataCalculoDecimoTerceiroSalario) {
		this.dataCalculoDecimoTerceiroSalario = dataCalculoDecimoTerceiroSalario;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Beneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public List<Desconto> getDescontos() {
		return descontos;
	}

	public void setDescontos(List<Desconto> descontos) {
		this.descontos = descontos;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	
	
	
	

	public CalculoInss getCalculoInss() {
		return calculoInss;
	}

	public void setCalculoInss(CalculoInss calculoInss) {
		this.calculoInss = calculoInss;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficios == null) ? 0 : beneficios.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((dataCalculoDecimoTerceiroSalario == null) ? 0 : dataCalculoDecimoTerceiroSalario.hashCode());
		result = prime * result + ((descontos == null) ? 0 : descontos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(salarioBeneficios);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(salarioDecimoTerceiro);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((tipoContrato == null) ? 0 : tipoContrato.hashCode());
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
		Person other = (Person) obj;
		if (beneficios == null) {
			if (other.beneficios != null)
				return false;
		} else if (!beneficios.equals(other.beneficios))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (dataCalculoDecimoTerceiroSalario == null) {
			if (other.dataCalculoDecimoTerceiroSalario != null)
				return false;
		} else if (!dataCalculoDecimoTerceiroSalario.equals(other.dataCalculoDecimoTerceiroSalario))
			return false;
		if (descontos == null) {
			if (other.descontos != null)
				return false;
		} else if (!descontos.equals(other.descontos))
			return false;
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
		if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
			return false;
		if (Double.doubleToLongBits(salarioBeneficios) != Double.doubleToLongBits(other.salarioBeneficios))
			return false;
		if (Double.doubleToLongBits(salarioDecimoTerceiro) != Double.doubleToLongBits(other.salarioDecimoTerceiro))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		if (tipoContrato != other.tipoContrato)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", salario=" + salario
				+ ", salarioBeneficios=" + salarioBeneficios + ", salarioDecimoTerceiro=" + salarioDecimoTerceiro
				+ ", dataCalculoDecimoTerceiroSalario=" + dataCalculoDecimoTerceiroSalario + ", company=" + company
				+ ", beneficios=" + beneficios + ", descontos=" + descontos + ", tipoContrato=" + tipoContrato + "]";
	}

}
