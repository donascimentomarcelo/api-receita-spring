package br.com.receita.service.impl;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}

}
