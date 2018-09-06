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

import br.com.receita.domain.Usuario;
import br.com.receita.service.UsuarioService;
import br.com.receita.service.exception.ObjetoNaoEncontradoException;
import br.com.receita.service.exception.UnicidadeEmailException;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> list = usuarioService.listarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Usuario usuario) throws UnicidadeEmailException {
		usuario.setId(null);
		usuario = usuarioService.salvar(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> pesquisar(@PathVariable Integer id) {
		Usuario usuario =  usuarioService.pesquisarPorId(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody Usuario usuario) throws UnicidadeEmailException {
		usuario.setId(id);
		usuario = usuarioService.salvar(usuario);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{email}/email")
	public ResponseEntity<Usuario> pesquisarPorNomeEEmail(
			@PathVariable("email") String email) throws ObjetoNaoEncontradoException{
		Usuario usuario = usuarioService.verificaSeEmailExiste(email);
		return ResponseEntity.ok().body(usuario);
	}
}	
