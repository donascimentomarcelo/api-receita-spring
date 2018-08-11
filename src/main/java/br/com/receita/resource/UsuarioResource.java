package br.com.receita.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.receita.domain.Usuario;
import br.com.receita.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	ResponseEntity<List<Usuario>> listar() {
		List<Usuario> list = usuarioService.listarTodos();
		return ResponseEntity.ok().body(list);
	}
}	
