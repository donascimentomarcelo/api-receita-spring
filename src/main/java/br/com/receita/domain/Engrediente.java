package br.com.receita.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.receita.domain.enums.Medida;

@Entity
public class Engrediente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqEngrediente")
	@SequenceGenerator(name = "seqEngrediente", sequenceName = "seq_id_engrediente")
	private Integer id;
	private String descricao;
	private Integer quantidade;
	private Integer medida;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_receita")
	private Receita receita;
	
	public Engrediente() {
		super();
	}

	public Engrediente(Integer id, String descricao, Integer quantidade, Medida medida, Receita receita) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.medida = (medida==null) ? null : medida.getCodigo();
		this.receita = receita;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Medida getMedida() {
		return Medida.toEnum(medida);
	}

	public void setMedida(Medida medida) {
		this.medida = medida.getCodigo();
	}
	
	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
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
		Engrediente other = (Engrediente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
