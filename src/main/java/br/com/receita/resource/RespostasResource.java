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
public class RespostasResource {
	
	private final SimpMessagingTemplate template;
	
	@Autowired
	RespostasResource(SimpMessagingTemplate template){
		this.template = template;
	}
	
	@MessageMapping("/send/message")
	public void onReciveMessage(MensagemDTO message) {
		System.out.println(message.getResposta());
		this.template.convertAndSend("/chat", message);
	}
}
