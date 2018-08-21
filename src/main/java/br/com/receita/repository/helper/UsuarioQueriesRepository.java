package br.com.receita.repository.helper;

import java.util.List;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.filtro.UsuarioFiltro;

public interface UsuarioQueriesRepository {
	
	List<Usuario> filtrar (UsuarioFiltro filtro);
}
