package br.com.receita.service;

import br.com.receita.domain.Endereco;

public interface EnderecoService {

	Endereco addEndereco(Endereco endereco);

	Endereco pesquisarEndereco(Integer id);

	Endereco salvar(Endereco endereco);

}
