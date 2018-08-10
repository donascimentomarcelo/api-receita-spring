package br.com.receita.instanciacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.UsuarioRepository;

@Configuration
public class Instanciacao implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Usuario usuario = new Usuario(null, "Crane", "crane@gmail.com", "123");
		
		usuarioRepository.save(usuario);
	}

	
}
