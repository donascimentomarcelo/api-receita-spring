package br.com.receita.instanciacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.receita.domain.Endereco;
import br.com.receita.domain.Engrediente;
import br.com.receita.domain.Receita;
import br.com.receita.domain.Usuario;
import br.com.receita.domain.enums.Medida;
import br.com.receita.repository.EnderecoRepository;
import br.com.receita.repository.EngredienteRepository;
import br.com.receita.repository.ReceitaRepository;
import br.com.receita.repository.UsuarioRepository;

@Configuration
public class Instanciacao implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EngredienteRepository engredienteRepository;
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Usuario usuario = new Usuario(null, "Crane", "crane@gmail.com", "123");
		
		usuarioRepository.save(usuario);
		
		Endereco endereco =  new Endereco(null, "Braz de pina", "21012409", "Rua Trinta e Seis - Braz de Pina", "Quadra C9", null, "RJ");
		
		endereco.setUsuario(usuario);
		
		enderecoRepository.save(endereco);
		
		Receita receita = new Receita(null, "Bolo de Fubá", "Bolo de Fubá desc");
		
		Engrediente engrediente1 =  new Engrediente(null, "Leite moça", 2, Medida.LITROS, receita);
		Engrediente engrediente2 =  new Engrediente(null, "Fubá", 2, Medida.GRAMAS, receita);
		Engrediente engrediente3 =  new Engrediente(null, "Creme de leite", 2, Medida.GRAMAS, receita);
		
		receita.getEngredientes().addAll(Arrays.asList(engrediente1, engrediente2, engrediente3));
	
		receitaRepository.save(receita);
		
		engredienteRepository.save(Arrays.asList(engrediente1, engrediente2, engrediente3));
		
	}

	
}
