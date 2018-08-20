package br.com.receita.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping
	ResponseEntity<Void> addEndereco(@RequestBody Endereco endereco) {
		Endereco end = enderecoService.addEndereco(endereco);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(end.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("{id}")
	ResponseEntity<Endereco> pesquisarEndereco(@PathVariable Integer id) {
		Endereco endereco = enderecoService.pesquisarEndereco(id);
		
		return ResponseEntity.ok().body(endereco);
	}
	
	@PutMapping("{id}")
	ResponseEntity<Void> atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco endereco) {
		endereco.setId(id);
		endereco = enderecoService.salvar(endereco);
		return ResponseEntity.noContent().build();
	}
}
