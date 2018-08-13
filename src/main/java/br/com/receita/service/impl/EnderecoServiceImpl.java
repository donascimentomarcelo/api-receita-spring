package br.com.receita.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Endereco;
import br.com.receita.domain.Usuario;
import br.com.receita.repository.EnderecoRepository;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Endereco addEndereco(Integer usuario_id, Endereco endereco) {
		Usuario usr = usuarioRepository.findOne(usuario_id);
		endereco.setId(null);
		endereco.setUsuario(usr);
		
		return enderecoRepository.save(endereco);
	}
	
}
