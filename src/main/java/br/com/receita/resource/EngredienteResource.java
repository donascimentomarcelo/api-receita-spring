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

import br.com.receita.domain.Engrediente;
import br.com.receita.service.EngredienteService;

@RestController
@RequestMapping("/api/v1/engredientes")
public class EngredienteResource {
	
	@Autowired
	private EngredienteService engredienteService;
	
	@PostMapping
	ResponseEntity<Void> salvar(@RequestBody Engrediente engrediente) {
		engrediente.setId(null);
		engrediente = engredienteService.salvar(engrediente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(engrediente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("{id}")
	ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody Engrediente engrediente) {
		engrediente.setId(id);
		engredienteService.atualizar(engrediente);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	ResponseEntity<List<Engrediente>> listar() {
		List<Engrediente> lista = engredienteService.listar();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("{id}")
	ResponseEntity<Engrediente> pesquisar(@PathVariable Integer id) {
		Engrediente engrediente = engredienteService.pesquisar(id);
		return ResponseEntity.ok(engrediente);
	}
	
	@GetMapping("{grupo_id}/grupo")
	ResponseEntity<List<Engrediente>> listarIngredientePorGrupo(@PathVariable Integer grupo_id) {
		List<Engrediente> lista = engredienteService.listarIngredientePorGrupo(grupo_id);
		return ResponseEntity.ok(lista);
	}
}
