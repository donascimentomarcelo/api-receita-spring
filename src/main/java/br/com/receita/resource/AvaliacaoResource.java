package br.com.receita.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.receita.domain.Avaliacao;
import br.com.receita.service.AvaliacaoService;

/**
 * @Author Marcelo Nascimento
 * @Date 27 de out de 2018
 * @Project receita
 * @Package br.com.receita.resource
 * @Desc Controlador que lista as avaliações referentes a uma receita.
 */
@RestController
@RequestMapping("/api/v1/avaliacoes")
public class AvaliacaoResource {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@GetMapping
	ResponseEntity<List<Avaliacao>> listar() {
		List<Avaliacao> list =  avaliacaoService.listarTodos();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/{receita_id}")
	ResponseEntity<Avaliacao> criar(@RequestBody Avaliacao avaliacao, @PathVariable Integer receita_id) throws Exception {
		Avaliacao retorno =  avaliacaoService.salvar(avaliacao, receita_id);
		return ResponseEntity.ok(retorno);
	}
	
	@DeleteMapping
	ResponseEntity<?> deletar(@PathVariable Integer id) {
		avaliacaoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
