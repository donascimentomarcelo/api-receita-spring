package br.com.receita.resource;

import java.net.URI;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.receita.domain.Endereco;
import br.com.receita.service.EnderecoService;

@RestController
@RequestMapping("/api/v1/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping("{usuario_id}/usuario")
	ResponseEntity<Void> addEndereco(@PathVariable Integer usuario_id, @RequestBody Endereco endereco) {
		Endereco end = enderecoService.addEndereco(usuario_id, endereco);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(end.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
