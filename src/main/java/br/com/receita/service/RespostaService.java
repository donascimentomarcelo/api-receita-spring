package br.com.receita.service;

import br.com.receita.dto.MensagemDTO;

/**
 * @Author Marcelo Nascimento
 * @Date 17 de nov de 2018
 * @Project receita
 * @Package br.com.receita.service
 * @Desc 
 */
public interface RespostaService {

	/**
	 * @param mensagem
	 * @return
	 * @throws Exception 
	 * @Author Marcelo Nascimento
	 * @Date 17 de nov de 2018
	 * @Project receita
	 * @Package br.com.receita.service
	 * @Desc Vincula a mensagem ao usuario e devolve o objeto informando o usuario o texto para o App.
	 */
	 MensagemDTO salvar(MensagemDTO mensagem) throws Exception;

}
