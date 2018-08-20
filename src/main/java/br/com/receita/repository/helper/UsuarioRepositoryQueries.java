package br.com.receita.repository.helper;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.filtro.UsuarioFiltro;

public interface UsuarioRepositoryQueries {
	
	List<Usuario> filtrar (UsuarioFiltro filtro);
}
