package br.com.receita.service;

import br.com.receita.domain.Usuario;
import br.com.receita.service.exception.UnicidadeEmailException;

public interface UsuarioService {

	Usuario salvar(Usuario usuario) throws UnicidadeEmailException;

}
