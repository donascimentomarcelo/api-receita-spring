package br.com.receita.service;

import java.util.List;

import br.com.receita.domain.Engrediente;
import br.com.receita.repository.filtro.EngredienteFiltro;

public interface EngredienteService {

	Engrediente salvar(Engrediente engrediente);

	/**
	 * @param filtro
	 * @return
	 */
	List<Engrediente> filtrar(EngredienteFiltro filtro);

	/**
	 * @param engrediente
	 * @Author Marcelo Nascimento
	 * @Date 12 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc 
	 */
	void atualizar(Engrediente engrediente);

	/**
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 13 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc 
	 */
	List<Engrediente> listar();

	/**
	 * @param id
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 15 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc 
	 */
	Engrediente pesquisar(Integer id);

	/**
	 * @param id_grupo
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 16 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Retorna uma lista de ingredientes filtrados pelo grupo;
	 */
	List<Engrediente> listarIngredientePorGrupo(Integer id_grupo);

}
