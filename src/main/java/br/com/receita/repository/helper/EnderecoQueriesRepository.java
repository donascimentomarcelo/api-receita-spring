/**
 * 
 */
package br.com.receita.repository.helper;

import java.util.List;

import br.com.receita.domain.Endereco;
import br.com.receita.repository.filtro.EnderecoFiltro;

/**
 * @author Marcelo
 * 2 de set de 2018 
 */
public interface EnderecoQueriesRepository {
	List<Endereco> filtrar(EnderecoFiltro filtro);
}
