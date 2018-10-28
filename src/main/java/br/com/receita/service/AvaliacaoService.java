package br.com.receita.service;

import java.util.List;

import br.com.receita.domain.Avaliacao;

/**
 * @Author Marcelo Nascimento
 * @Date 27 de out de 2018
 * @Project receita
 * @Package br.com.receita.service
 * @Desc 
 */
public interface AvaliacaoService {

	/**
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 27 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Lista todas as avaliaceos.
	 */
	List<Avaliacao> listarTodos();

	/**
	 * @param avaliacao
	 * @return
	 * @throws Exception 
	 * @Author Marcelo Nascimento
	 * @Date 27 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Cria uma avaliacao.
	 */
	Avaliacao salvar(Avaliacao avaliacao) throws Exception;

	/**
	 * @param id
	 * @Author Marcelo Nascimento
	 * @Date 28 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Deleta uma avaliacao e consequentemente comentario, caso exista.
	 */
	void deletar(Integer id);

}
