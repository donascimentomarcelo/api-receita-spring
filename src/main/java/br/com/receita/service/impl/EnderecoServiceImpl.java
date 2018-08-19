package br.com.receita.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Endereco;
import br.com.receita.domain.Usuario;
import br.com.receita.repository.EnderecoRepository;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.service.EnderecoService;
import br.com.receita.service.exception.UnicidadeEmailException;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	@Override
	public Endereco addEndereco(Endereco endereco) {
		try {
			Usuario usr = pesquisaUsuarioLogado();
			endereco.setId(null);
			endereco.setUsuario(usr);
		} catch (Exception e) {
			e.getMessage();
		}

		
		endereco = enderecoRepository.save(endereco);
		return endereco;
	}

	@Override
	public Endereco pesquisarEndereco(Integer id) {
		Endereco endereco = enderecoRepository.findOne(id);
		return endereco;
	}

	@Override
	public Endereco salvar(Endereco endereco) {
		endereco = enderecoRepository.save(endereco);
		return endereco;
	}
	

	public Usuario pesquisaUsuarioLogado() throws Exception {
		//Criar uma classe generica para retornar usuario logado
		//Apos implementar jwt, retornar id do usuario logado
		Optional<Usuario> optional = usuarioRepository.findById(1);
		
		return optional.orElseThrow(() -> new UnicidadeEmailException());
	}
	
}
