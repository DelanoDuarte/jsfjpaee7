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

/**
 * @author delano.junior
 *
 */
@Entity
@Table(name = "tb_funcionario")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(name = "nome_funcionario")
	private String nome;

	@Column(name = "sobrenome_funcionario")
	private String sobrenome;

	@Column(name = "salario_funcionario")
	private double salario;

	@Column(name = "salarioGratificacoesDescontos_funcionario")
	private double salarioBeneficios;

	@Column(name = "salarioDecimoTerceiro_funcionario")
	private double salarioDecimoTerceiro;

	@Column(name = "cpf_funcionario")
	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCalculoDecimoTerceiroSalario;

	@ManyToOne
	@JoinColumn(name = "id_company")
	private Company company;

	// @JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_person_beneficios", joinColumns = @JoinColumn(name = "id_person"), inverseJoinColumns = @JoinColumn(name = "id_beneficio"))
	private List<Beneficio> beneficios;

	// @JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_person_descontos", joinColumns = @JoinColumn(name = "id_person"), inverseJoinColumns = @JoinColumn(name = "id_desconto"))
	private List<Desconto> descontos;

	@Enumerated(EnumType.STRING)
	private TipoContrato tipoContrato;

	@Column(name = "flag_13_calculado")
	private boolean flag13Calculado;

	@Column(name = "flag_calculaInss")
	private boolean calculaINSS;

	@Column(name = "flag_calculaIrrf")
	private boolean calculaIRRF;

	public String retonarSimOuNao() {
		if (flag13Calculado == true) {
			return "Sim";
		} else {
			return "Não";
		}
	}

	public Person() {
		super();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public boolean isFlag13Calculado() {
		return flag13Calculado;
	}

	public void setFlag13Calculado(boolean flag13Calculado) {
		this.flag13Calculado = flag13Calculado;
	}

	public boolean isCalculaINSS() {
		return calculaINSS;
	}

	public void setCalculaINSS(boolean calculaINSS) {
		this.calculaINSS = calculaINSS;
	}

	public boolean isCalculaIRRF() {
		return calculaIRRF;
	}

	public void setCalculaIRRF(boolean calculaIRRF) {
		this.calculaIRRF = calculaIRRF;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficios == null) ? 0 : beneficios.hashCode());
		result = prime * result + (calculaINSS ? 1231 : 1237);
		result = prime * result + (calculaIRRF ? 1231 : 1237);
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataCalculoDecimoTerceiroSalario == null) ? 0 : dataCalculoDecimoTerceiroSalario.hashCode());
		result = prime * result + ((descontos == null) ? 0 : descontos.hashCode());
		result = prime * result + (flag13Calculado ? 1231 : 1237);
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
		if (calculaINSS != other.calculaINSS)
			return false;
		if (calculaIRRF != other.calculaIRRF)
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
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
		if (flag13Calculado != other.flag13Calculado)
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
				+ ", cpf=" + cpf + ", dataCalculoDecimoTerceiroSalario=" + dataCalculoDecimoTerceiroSalario
				+ ", company=" + company + ", beneficios=" + beneficios + ", descontos=" + descontos + ", tipoContrato="
				+ tipoContrato + ", flag13Calculado=" + flag13Calculado + ", calculaINSS=" + calculaINSS
				+ ", calculaIRRF=" + calculaIRRF + "]";
	}

}
