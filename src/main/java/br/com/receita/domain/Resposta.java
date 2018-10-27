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

/**
 * @Author Marcelo Nascimento
 * @Date 26 de out de 2018
 * @Project receita
 * @Package br.com.receita.domain
 * @Desc Essa entidade representa as entidades dos comentarios.
 */
@Entity
public class Resposta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqResposta")
	@SequenceGenerator(name = "seqResposta", sequenceName = "seq_id_resposta")
	private Integer id;
	private String resposta;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="comentario_id")
	private Comentario comentario;

	public Resposta() {
		super();
	}

	public Resposta(Integer id, String resposta, Usuario usuario, Comentario comentario) {
		super();
		this.id = id;
		this.resposta = resposta;
		this.usuario = usuario;
		this.comentario = comentario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
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
		Resposta other = (Resposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
