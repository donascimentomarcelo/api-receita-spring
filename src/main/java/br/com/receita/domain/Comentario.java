package br.com.receita.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Author Marcelo Nascimento
 * @Date 26 de out de 2018
 * @Project receita
 * @Package br.com.receita.domain
 * @Desc 
 */
@Entity
public class Comentario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqComentario")
	@SequenceGenerator(name = "seqComentario", sequenceName = "seq_id_comentario")
	private Integer id;
	private String comentario;
	
	@OneToOne
	@JoinColumn(name="avaliacao_id")
	@JsonIgnore
	private Avaliacao avaliacao;
	
	public Comentario() {
		super();
	}
	
	public Comentario(Integer id, String comentario, Avaliacao avaliacao) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.avaliacao = avaliacao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
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
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
