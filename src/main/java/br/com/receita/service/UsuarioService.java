package br.com.receita.service;

import java.util.List;

import br.com.receita.domain.Usuario;
import br.com.receita.service.exception.UnicidadeEmailException;

public interface UsuarioService {

	Usuario salvar(Usuario usuario) throws UnicidadeEmailException;

	Usuario findByEmail(String email) throws UnicidadeEmailException;
	
	List<Usuario> listarTodos();

	Usuario pesquisarPorId(Integer id);
	
	void verificarSeEmailExiste(String email) throws UnicidadeEmailException;

}
