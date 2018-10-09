package br.com.receita.repository.helper;

import java.util.List;

import br.com.receita.domain.Receita;
import br.com.receita.repository.filtro.ReceitaFiltro;

/**
 * @Author Marcelo Nascimento
 * @Date 7 de out de 2018
 * @Project receita
 * @Package br.com.receita.repository.helper
 * @Desc Responsavel pelas queries adicionais de receita
 */
public interface ReceitaQueriesRepository {

	List<Receita> filtro(ReceitaFiltro filtro);
}
