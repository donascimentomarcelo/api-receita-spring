package br.com.receita.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.receita.domain.Comentario;
import br.com.receita.domain.Resposta;
import br.com.receita.domain.Usuario;
import br.com.receita.dto.MensagemDTO;
import br.com.receita.repository.ComentarioRepository;
import br.com.receita.repository.RespostasRepository;
import br.com.receita.service.RespostaService;
import br.com.receita.service.UsuarioService;

/**
 * @Author Marcelo Nascimento
 * @Date 17 de nov de 2018
 * @Project receita
 * @Package br.com.receita.service.impl
 * @Desc 
 */
@Service
public class RespostaServiceImpl implements RespostaService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RespostasRepository respostasRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;

	/* (non-Javadoc)
	 * @see br.com.receita.service.RespostaService#salvar(br.com.receita.dto.MensagemDTO)
	 * @param mensagem
	 * @return
	 * @Project receita
	 * @Author Marcelo Nascimento
	 * @Date 20:34:14
	 */
	@Override
	public MensagemDTO salvar(MensagemDTO mensagem) throws Exception {
		Usuario usuario = usuarioService.pesquisaUsuarioLogado();
		
		Comentario comentario = comentarioRepository.findOne(mensagem.getComentario_id());
		mensagem.setUsuario_id(usuario.getId());
		mensagem.setNome(usuario.getNome());
		
		Resposta resposta = new Resposta(null, mensagem.getResposta(), usuario, comentario);
		
		respostasRepository.save(resposta);
		
		return mensagem;
	}

}
