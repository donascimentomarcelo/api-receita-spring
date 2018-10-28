package br.com.receita.service;

import java.util.List;

import br.com.receita.domain.Comentario;

/**
 * @Author Marcelo Nascimento
 * @Date 28 de out de 2018
 * @Project receita
 * @Package br.com.receita.service
 * @Desc 
 */
public interface ComentarioService {

	/**
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 28 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Deve listar todos os comentarios.
	 */
	List<Comentario> listarTodos();

	/**
	 * @param comentario
	 * @param avaliacao_id 
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 28 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Deve salvar um comentario vinculado a uma avaliacao.
	 */
	Comentario salvar(Comentario comentario, Integer avaliacao_id);

	/**
	 * @param comentario
	 * @param id
	 * @Author Marcelo Nascimento
	 * @Date 28 de out de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Deve atualizar um comentario vinculado a uma avaliacao.
	 */
	void atualizar(Comentario comentario, Integer id);

}
