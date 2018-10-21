package br.com.receita.dto;

import java.io.Serializable;

/**
 * @Author Marcelo Nascimento
 * @Date 20 de out de 2018
 * @Project receita
 * @Package br.com.receita.dto
 * @Desc Essa classe represeta o objeto de pesquisa de receitas através dos
 * seus respectivos ingredientes.
 */
public class TagDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String valor;

	public TagDTO() {
		super();
	}

	public TagDTO(String valor) {
		super();
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
