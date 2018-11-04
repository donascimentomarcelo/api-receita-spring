package br.com.receita.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.receita.domain.enums.Grau;

/**
 * @Author Marcelo Nascimento
 * @Date 25 de out de 2018
 * @Project receita
 * @Package br.com.receita.domain
 * @Desc Entidade que define os níveis de aprovação da receita pelo usuário.
 */
@Entity
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqAvaliacao")
	@SequenceGenerator(name = "seqAvaliacao", sequenceName = "seq_id_avaliacao")
	private Integer id;
	private Integer grau;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="avaliacao")
	private Comentario comentario;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="receita_id")
	private Receita receita;
	
	public Avaliacao() {
		super();
	}

	public Avaliacao(Integer id, Grau grau, Usuario usuario, Receita receita) {
		super();
		this.id = id;
		this.grau = grau != null ? grau.getCodigo() : null;
		this.usuario = usuario;
		this.receita = receita;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Grau getGrau() {
		return Grau.toEnum(grau);
	}
	public void setGrau(Grau grau) {
		this.grau = grau.getCodigo();
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
		Avaliacao other = (Avaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
