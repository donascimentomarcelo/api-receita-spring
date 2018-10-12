package br.com.receita.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Integer medida;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.receita")
	private Set<ItemReceita> itens = new HashSet<>();
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="grupo_id")
	private Grupo grupo;
	
	public Engrediente() {
		super();
	}

	public Engrediente(Integer id, String descricao, Medida medida, Grupo grupo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.medida = (medida==null) ? null : medida.getCodigo();
		this.grupo = grupo;
	}
	
	@JsonIgnore
	public List<Receita> getReceitas()
	{
		List<Receita> lista = new ArrayList<>();
		for(ItemReceita x: itens)
		{
			lista.add(x.getReceita());
		}
		return lista;
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
	
	public Medida getMedida() {
		return Medida.toEnum(medida);
	}

	public void setMedida(Medida medida) {
		this.medida = medida.getCodigo();
	}
	
	public Set<ItemReceita> getItens() {
		return itens;
	}

	public void setItens(Set<ItemReceita> itens) {
		this.itens = itens;
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
