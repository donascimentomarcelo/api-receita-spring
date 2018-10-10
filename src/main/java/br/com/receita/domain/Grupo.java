package br.com.receita.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * @Author Marcelo Nascimento
 * @Date 9 de out de 2018
 * @Project receita
 * @Package br.com.receita.domain
 * @Desc Entidade de grupos que contém os ingredientes.
 */
@Entity
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqGrupo")
	@SequenceGenerator(name = "seqGrupo", sequenceName = "seq_id_grupo")
	private Integer id;
	private String descricao;
	
	@OneToMany(mappedBy="grupo", cascade=CascadeType.ALL)
	private List<Engrediente> engrediente = new ArrayList<>();

	public Grupo() {
		super();
	}

	public Grupo(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Engrediente> getEngrediente() {
		return engrediente;
	}

	public void setEngrediente(List<Engrediente> engrediente) {
		this.engrediente = engrediente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}	
