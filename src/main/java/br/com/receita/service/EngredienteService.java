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

}
