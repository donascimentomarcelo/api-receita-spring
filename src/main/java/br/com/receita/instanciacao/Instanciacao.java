package br.com.receita.instanciacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.receita.domain.Endereco;
import br.com.receita.domain.Engrediente;
import br.com.receita.domain.Usuario;
import br.com.receita.domain.enums.Medida;
import br.com.receita.repository.EnderecoRepository;
import br.com.receita.repository.EngredienteRepository;
import br.com.receita.repository.UsuarioRepository;

@Configuration
public class Instanciacao implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EngredienteRepository engredienteRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Usuario usuario = new Usuario(null, "Crane", "crane@gmail.com", "123");
		
		usuarioRepository.save(usuario);
		
		Endereco endereco =  new Endereco(null, "Braz de pina", "21012409", "Rua Trinta e Seis - Braz de Pina", "Quadra C9", null, "RJ");
		
		endereco.setUsuario(usuario);
		
		enderecoRepository.save(endereco);
		
		Engrediente engrediente =  new Engrediente(null, "Alho", 2, Medida.GRAMAS);
		
		engredienteRepository.save(engrediente);
	}

	
}
