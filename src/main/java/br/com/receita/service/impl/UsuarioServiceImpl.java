package br.com.receita.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.service.UsuarioService;
import br.com.receita.service.exception.UnicidadeEmailException;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario salvar(Usuario usuario) throws UnicidadeEmailException {

		if (usuario.getId() == null) {
			verificarSeEmailExiste(usuario.getEmail());
		}
		
		usuario = usuarioRepository.save(usuario);
		
		return usuario; 

	}

	@Override
	public Usuario findByEmail(String email) throws UnicidadeEmailException {
		Optional<Usuario> optional = usuarioRepository.findByEmail(email);
		
		return optional.orElseThrow(() -> new UnicidadeEmailException());
	}

	@Override
	public List<Usuario> listarTodos() {
		List<Usuario> list = usuarioRepository.findAll();
		return list;
	}

	@Override
	public Usuario pesquisarPorId(Integer id) {
		Usuario usuario = usuarioRepository.findOne(id);
		return usuario;
	}

	@Override
	public void verificarSeEmailExiste(String email) throws UnicidadeEmailException {
		Optional<Usuario> optional = usuarioRepository.findByEmail(email);
		
		if (optional.isPresent()) {
			throw new UnicidadeEmailException();
		}
	}


}
