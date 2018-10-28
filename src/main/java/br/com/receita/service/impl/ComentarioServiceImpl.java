package br.com.receita.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.receita.domain.Avaliacao;
import br.com.receita.domain.Comentario;
import br.com.receita.repository.AvaliacaoRepository;
import br.com.receita.repository.ComentarioRepository;
import br.com.receita.service.ComentarioService;

/**
 * @Author Marcelo Nascimento
 * @Date 28 de out de 2018
 * @Project receita
 * @Package br.com.receita.service.impl
 * @Desc Implementacao do servico de comentarios.
 */
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	/* (non-Javadoc)
	 * @see br.com.receita.service.ComentarioService#listarTodos()
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 11:12:05
	 */
	@Override
	public List<Comentario> listarTodos() {
		return comentarioRepository.findAll();
	}
	/* (non-Javadoc)
	 * @see br.com.receita.service.ComentarioService#salvar(br.com.receita.domain.Comentario, java.lang.Integer)
	 * @param comentario
	 * @param avaliacao_id
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 11:21:29
	 */
	@Override
	public Comentario salvar(Comentario comentario, Integer avaliacao_id) {
		Avaliacao avaliacao = avaliacaoRepository.findOne(avaliacao_id);
		comentario.setAvaliacao(avaliacao);
		return comentarioRepository.save(comentario);
	}

}
