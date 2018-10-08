package br.com.receita.repository.filtro;

import java.io.Serializable;

/**
 * @Author Marcelo Nascimento
 * @Date 7 de out de 2018
 * @Project receita
 * @Package br.com.receita.repository.filtro
 * @Desc Classe responsável por receber os atributos de filtragem para receita.
 */
public class ReceitaFiltro implements Serializable{
	private static final long serialVersionUID = 1L;

	private String titulo;
	private String descricao;
	
	public ReceitaFiltro() {
		super();
	}
	
	public ReceitaFiltro(String titulo, String descricao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
