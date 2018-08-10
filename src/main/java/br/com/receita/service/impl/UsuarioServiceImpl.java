package br.com.receita.service.impl;

import java.util.Optional;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.service.UsuarioService;
import br.com.receita.service.exception.UnicidadeEmailException;

public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario salvar(Usuario usuario) throws UnicidadeEmailException {
		Optional<Usuario> optional = usuarioRepository.findByEmail(usuario.getEmail());
		
		if (optional.isPresent()) {
			throw new UnicidadeEmailException();
		}
		
		return usuarioRepository.save(usuario);

	}

}
