package br.com.receita.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * @Author Marcelo Nascimento
 * @Date 2 de out de 2018
 * @Project receita
 * @Package br.com.receita.domain
 * @Desc classe que com chave composta com os ids de receita e ingrediente.
 */
@Embeddable
public class ItemReceitaPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="receita_id")
	private Receita receita;
	
	@ManyToOne
	@JoinColumn(name="engrediente_id")
	private Engrediente engrediente;

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Engrediente getEngrediente() {
		return engrediente;
	}

	public void setEngrediente(Engrediente engrediente) {
		this.engrediente = engrediente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((engrediente == null) ? 0 : engrediente.hashCode());
		result = prime * result + ((receita == null) ? 0 : receita.hashCode());
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
		ItemReceitaPK other = (ItemReceitaPK) obj;
		if (engrediente == null) {
			if (other.engrediente != null)
				return false;
		} else if (!engrediente.equals(other.engrediente))
			return false;
		if (receita == null) {
			if (other.receita != null)
				return false;
		} else if (!receita.equals(other.receita))
			return false;
		return true;
	}

	
}
