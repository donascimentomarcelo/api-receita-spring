package br.com.receita.dto;

import java.io.Serializable;

import br.com.receita.domain.Grupo;

/**
 * @Author Marcelo Nascimento
 * @Date 10 de out de 2018
 * @Project receita
 * @Package br.com.receita.dto
 * @Desc 
 */
public class GrupoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	
	public GrupoDTO() {
		super();
	}
	
	public GrupoDTO(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public GrupoDTO(Grupo grupo) {
		id = grupo.getId();
		descricao = grupo.getDescricao();
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
	
}
