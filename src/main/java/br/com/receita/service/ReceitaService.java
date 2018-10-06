package br.com.receita.service;

import java.util.List;

import br.com.receita.domain.ItemReceita;
import br.com.receita.domain.Receita;
import br.com.receita.dto.ItemReceitaDTO;

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

	/**
	 * @param id
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 26 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc 
	 */
	Receita pesquisar(Integer id);

	/**
	 * @param idIngreceita
	 * @param idReceita
	 * @Author Marcelo Nascimento
	 * @Date 6 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Monta a receita a partir dos ingredientes enviados
	 */
	void montarReceita(ItemReceita itemReceita);

	/**
	 * @param itemReceitaDTO
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 6 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Transforma objeto dto de item receita em objeto real.
	 */
	ItemReceita fromDTO(ItemReceitaDTO itemReceitaDTO);

}
