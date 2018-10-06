package br.com.receita.resource;

import java.net.URI;
import java.util.List;

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

import br.com.receita.domain.ItemReceita;
import br.com.receita.domain.Receita;
import br.com.receita.dto.ItemReceitaDTO;
import br.com.receita.service.ReceitaService;

@RestController
@RequestMapping("/api/v1/receitas")
public class ReceitaResource {
	
	@Autowired
	private ReceitaService receitaService;
	
	@GetMapping
	ResponseEntity<List<Receita>> listar() {
		List<Receita> lista = receitaService.listar();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Receita> pesquisar(@PathVariable Integer id) {
		Receita receita = receitaService.pesquisar(id);
		return ResponseEntity.ok(receita);
	}
	
	@PostMapping
	ResponseEntity<?> salvar(@RequestBody Receita receita) {
		receita = receitaService.salvar(receita);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/montar")
	ResponseEntity<?> montarReceita(
			@RequestBody ItemReceitaDTO itemReceitaDTO) {
		ItemReceita itemReceita = receitaService.fromDTO(itemReceitaDTO);
		
		receitaService.montarReceita(itemReceita);
		
		return ResponseEntity.ok().build();
	}
}
