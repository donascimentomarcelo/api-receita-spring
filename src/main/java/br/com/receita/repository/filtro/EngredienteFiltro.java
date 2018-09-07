/**
 * 
 */
package br.com.receita.repository.filtro;

import br.com.receita.domain.enums.Medida;

/**
 * @author Marcelo
 * 7 de set de 2018 
 */
public class EngredienteFiltro {
	
	private Integer id;
	private String descricao;
	private Integer quantidade;
	private Integer medida;
	
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
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Medida getMedida() {
		return Medida.toEnum(medida);
	}
	public void setMedida(Medida medida) {
		this.medida = medida.getCodigo();
	}
	
	
}
