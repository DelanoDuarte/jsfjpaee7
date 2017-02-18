/**
 * 
 */
package br.com.simpleapp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author delan
 *
 */
@Entity
@Table(name = "tb_empresa")
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(name = "nome_empresa")
	private String nome;

	@Column(name = "nome_fantasia_empresa")
	private String nomeFantasia;

	@Column(name = "endereco_empresa")
	private String endereco;

	@Column(name = "numero_endereco_empresa")
	private Integer numero_endereco;

	@Column(name = "cep_empresa")
	private String cep;

	@Column(name = "cnpj_empresa")
	private String cnpj;

	@Column(name = "nome_contato_enmpresa")
	private String nomeContato;

	@Column(name = "numero_contato_empresa")
	private String numeroContato;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
	private List<Person> persons;

	public Company() {
		super();
	}

	public Company(String nome, String nomeFantasia, String endereco, Integer numero_endereco, String cep, String cnpj,
			String nomeContato, String numeroContato, List<Person> persons) {
		super();
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
		this.numero_endereco = numero_endereco;
		this.cep = cep;
		this.cnpj = cnpj;
		this.nomeContato = nomeContato;
		this.numeroContato = numeroContato;
		this.persons = persons;
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

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero_endereco() {
		return numero_endereco;
	}

	public void setNumero_endereco(Integer numero_endereco) {
		this.numero_endereco = numero_endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getNumeroContato() {
		return numeroContato;
	}

	public void setNumeroContato(String numeroContato) {
		this.numeroContato = numeroContato;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeContato == null) ? 0 : nomeContato.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((numeroContato == null) ? 0 : numeroContato.hashCode());
		result = prime * result + ((numero_endereco == null) ? 0 : numero_endereco.hashCode());
		result = prime * result + ((persons == null) ? 0 : persons.hashCode());
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
		Company other = (Company) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
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
		if (nomeContato == null) {
			if (other.nomeContato != null)
				return false;
		} else if (!nomeContato.equals(other.nomeContato))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (numeroContato == null) {
			if (other.numeroContato != null)
				return false;
		} else if (!numeroContato.equals(other.numeroContato))
			return false;
		if (numero_endereco == null) {
			if (other.numero_endereco != null)
				return false;
		} else if (!numero_endereco.equals(other.numero_endereco))
			return false;
		if (persons == null) {
			if (other.persons != null)
				return false;
		} else if (!persons.equals(other.persons))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", nome=" + nome + ", nomeFantasia=" + nomeFantasia + ", endereco=" + endereco
				+ ", numero_endereco=" + numero_endereco + ", cep=" + cep + ", cnpj=" + cnpj + ", nomeContato="
				+ nomeContato + ", numeroContato=" + numeroContato + ", persons=" + persons + "]";
	}

}
