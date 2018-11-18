package br.com.receita.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.receita.dto.MensagemDTO;
import br.com.receita.service.RespostaService;

/**
 * @Author Marcelo Nascimento
 * @Date 18 de nov de 2018
 * @Project receita
 * @Package br.com.receita.resource
 * @Desc 
 */
@RequestMapping("/respostas")
@RestController
public class RespostasResource {
	
	@Autowired
	private RespostaService respostaService;
	
	@PostMapping
	ResponseEntity<?> salvar(@RequestBody MensagemDTO mensagem) throws Exception {
		MensagemDTO novaMensagem = respostaService.salvar(mensagem);
		return ResponseEntity.ok().body(novaMensagem);
	}
}
