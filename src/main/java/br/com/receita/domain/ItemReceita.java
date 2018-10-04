package br.com.receita.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Author Marcelo Nascimento
 * @Date 1 de out de 2018
 * @Project receita
 * @Package br.com.receita.domain
 * @Desc Classe de associação que irá relacionar a receita aos engredientes.
 */
@Entity
public class ItemReceita implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemReceitaPK id = new ItemReceitaPK();
	
	private Integer quantidade;

	public ItemReceita() {
		super();
	}
	
	public ItemReceita(Receita receita, Engrediente engrediente, Integer quantidade) {
		super();
		id.setEngrediente(engrediente);
		id.setReceita(receita);
		this.quantidade = quantidade;
	}
	
	@JsonIgnore
	public Receita getReceita() {
		return id.getReceita();
	}
	
	public void setReceita(Receita receita) {
		id.setReceita(receita);
	}
	
	public Engrediente getEngrediente() {
		return id.getEngrediente();
	}
	
	public void setEngrediente(Engrediente engrediente) {
		id.setEngrediente(engrediente);
	}
	
	public ItemReceitaPK getId() {
		return id;
	}
	
	public void setId(ItemReceitaPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
