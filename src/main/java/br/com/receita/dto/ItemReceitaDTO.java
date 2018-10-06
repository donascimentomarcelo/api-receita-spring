package br.com.receita.dto;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.receita.domain.Engrediente;
import br.com.receita.domain.ItemReceitaPK;
import br.com.receita.domain.Receita;

/**
 * @Author Marcelo Nascimento
 * @Date 6 de out de 2018
 * @Project receita
 * @Package br.com.receita.dto
 * @Desc Classe de dto para ItemReceita.
 */
public class ItemReceitaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private ItemReceitaPK id = new ItemReceitaPK();
	
	private Integer quantidade;

	public ItemReceitaDTO() {
		super();
	}
	
	public ItemReceitaDTO(Receita receita, Engrediente engrediente, Integer quantidade) {
		super();
		id.setEngrediente(engrediente);
		id.setReceita(receita);
		this.quantidade = quantidade;
	}
	
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
