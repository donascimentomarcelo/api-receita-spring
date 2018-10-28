package br.com.receita.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.receita.domain.Avaliacao;
import br.com.receita.domain.Comentario;
import br.com.receita.service.ComentarioService;

/**
 * @Author Marcelo Nascimento
 * @Date 28 de out de 2018
 * @Project receita
 * @Package br.com.receita.resource
 * @Desc 
 */
@RestController
@RequestMapping("/comentarios")
public class ComentariosResource {
	@Autowired
	private ComentarioService comentarioService;
	
	@GetMapping
	ResponseEntity<List<Comentario>> listar() {
		List<Comentario> list = comentarioService.listarTodos();
		return ResponseEntity.ok(list);
	}
	
	ResponseEntity<Comentario> criar(@RequestBody Comentario comentario, @PathVariable Integer avaliacao_id) {
		Comentario retorno = comentarioService.salvar(comentario, avaliacao_id);
		return ResponseEntity.ok(retorno);
	}
	
	@PutMapping
	ResponseEntity<?> atualizar(@RequestBody Comentario comentario, @PathVariable Integer id) {
		comentarioService.atualizar(comentario, id);
		return ResponseEntity.noContent().build();
	}
}
