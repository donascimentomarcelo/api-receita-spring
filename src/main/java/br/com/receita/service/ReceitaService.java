package br.com.receita.service;

import java.util.List;

import br.com.receita.domain.Receita;

public interface ReceitaService {

	List<Receita> listar();

	/**
	 * @param receita
	 * @Author Marcelo Nascimento
	 * @Date 25 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Método para salvar receita
	 */
	Receita salvar(Receita receita);

}
