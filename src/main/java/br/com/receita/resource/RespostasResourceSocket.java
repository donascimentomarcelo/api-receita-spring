package br.com.receita.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import br.com.receita.dto.MensagemDTO;

/**
 * @Author Marcelo Nascimento
 * @Date 31 de out de 2018
 * @Project receita
 * @Package br.com.receita.resource
 * @Desc 
 */
@Controller
public class RespostasResourceSocket {
	
	private final SimpMessagingTemplate template;
		
	@Autowired
	RespostasResourceSocket(SimpMessagingTemplate template){
		this.template = template;
	}
	
	@MessageMapping("/send/message")
	public void onReciveMessage(MensagemDTO mensagem) throws Exception {
		System.out.println(mensagem.getResposta());
		this.template.convertAndSend("/chat", mensagem);
	}
}
