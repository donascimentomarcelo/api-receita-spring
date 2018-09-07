/**
 * 
 */
package br.com.receita.repository.helper;

import java.util.List;

import br.com.receita.domain.Engrediente;
import br.com.receita.repository.filtro.EngredienteFiltro;

/**
 * @author Marcelo
 * 7 de set de 2018 
 */
public interface EngredienteQuerieRepository {
	
	List<Engrediente> filtro(EngredienteFiltro filtro);
}
