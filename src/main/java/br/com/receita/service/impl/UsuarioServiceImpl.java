package br.com.receita.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.repository.filtro.UsuarioFiltro;
import br.com.receita.service.UsuarioService;
import br.com.receita.service.exception.ObjetoNaoEncontradoException;
import br.com.receita.service.exception.UnicidadeEmailException;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

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
		
		return optional.orElseThrow(() -> new UnicidadeEmailException("O e-mail "+ email +" já está sendo usado."));
	}

	@Override
	public List<Usuario> listarTodos() {
		List<Usuario> list = usuarioRepository.findAll();
		return list;
	}

	@Override
	public Usuario pesquisarPorId(Integer id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		return optional.orElseThrow(() -> new ObjetoNaoEncontradoException("Usuário não encontrado"));
	}

	@Override
	public void verificarSeEmailExiste(String email) throws UnicidadeEmailException {
		Optional<Usuario> optional = usuarioRepository.findByEmail(email);
		
		if (optional.isPresent()) {
			throw new UnicidadeEmailException("O e-mail "+ email +" já está sendo usado.");
		}
	}
	
	@Override
	public List<Usuario> filtro(UsuarioFiltro filtro) {
		List<Usuario> usuarios = usuarioRepository.filtrar(filtro);
		System.out.println(usuarios);
		return usuarios;
	}

	/* (non-Javadoc)
	 * @see br.com.receita.service.UsuarioService#verificaSeEmailExiste(java.lang.String)
	 */
	@Override
	public Usuario verificaSeEmailExiste(String email) throws ObjetoNaoEncontradoException {
		Optional<Usuario> optional = usuarioRepository.findByEmail(email);
		
		return optional.orElseThrow(() -> new ObjetoNaoEncontradoException("Usuario não encontrado"));
	}

	@Override
	public Usuario pesquisaUsuarioLogado() throws Exception {
		//Criar uma classe generica para retornar usuario logado
		//Apos implementar jwt, retornar id do usuario logado
		Optional<Usuario> optional = usuarioRepository.findById(50);
		
		return optional.orElseThrow(() -> new ObjetoNaoEncontradoException("Usuario não encontrado"));
	}

}
