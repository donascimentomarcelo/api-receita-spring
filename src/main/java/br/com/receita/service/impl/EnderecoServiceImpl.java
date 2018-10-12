package br.com.receita.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Endereco;
import br.com.receita.domain.Usuario;
import br.com.receita.repository.EnderecoRepository;
import br.com.receita.service.EnderecoService;
import br.com.receita.service.UsuarioService;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	@Override
	public Endereco addEndereco(Endereco endereco) {
		try {
			Usuario usr = usuarioService.pesquisaUsuarioLogado();
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
	
}
