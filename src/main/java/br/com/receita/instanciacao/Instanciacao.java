package br.com.receita.instanciacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.receita.domain.Avaliacao;
import br.com.receita.domain.Comentario;
import br.com.receita.domain.Endereco;
import br.com.receita.domain.Engrediente;
import br.com.receita.domain.Grupo;
import br.com.receita.domain.ItemReceita;
import br.com.receita.domain.Receita;
import br.com.receita.domain.Resposta;
import br.com.receita.domain.Usuario;
import br.com.receita.domain.enums.Grau;
import br.com.receita.domain.enums.Medida;
import br.com.receita.repository.AvaliacaoRepository;
import br.com.receita.repository.ComentarioRepository;
import br.com.receita.repository.EnderecoRepository;
import br.com.receita.repository.EngredienteRepository;
import br.com.receita.repository.GrupoRepository;
import br.com.receita.repository.ItemReceitaRepository;
import br.com.receita.repository.ReceitaRepository;
import br.com.receita.repository.RespostasRepository;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.service.RespostaService;

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
	
	@Autowired
	private ItemReceitaRepository itemReceitaRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private RespostasRepository respostasRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Usuario usuario = new Usuario(null, "Crane", "crane@gmail.com", "123");
		Usuario usuario1 = new Usuario(null, "Junior", "junior@gmail.com", "123");
		Usuario usuario2 = new Usuario(null, "Sonia", "sonia@gmail.com", "123");
		Usuario usuario3 = new Usuario(null, "Claudia", "claudia@gmail.com", "123");
		Usuario usuario4 = new Usuario(null, "Manuel", "sombra@gmail.com", "123");
		
		usuarioRepository.save(Arrays.asList(
				usuario, usuario1, usuario2, usuario3, usuario4
		));
		
		Endereco endereco =  new Endereco(null, "Braz de pina", "21012409", "Rua Trinta e Seis - Braz de Pina", "Quadra C9", null, "RJ");
		
		endereco.setUsuario(usuario);
		
		enderecoRepository.save(endereco);
		
		Receita receita1 = new Receita(null, "Bolo de Fubá", "Bolo de Fubá desc", usuario);
		Receita receita2 = new Receita(null, "Bolo de Cenoura", "Bolo de Cenoura desc", usuario);
		Receita receita3 = new Receita(null, "Bolo de Morango", "Bolo de Morango desc", usuario);
		Receita receita4 = new Receita(null, "Bolo Doce", "Bolo Doce desc", usuario);
		
		Grupo grupo1 = new Grupo(null, "Doces");
		
		Engrediente engrediente1 =  new Engrediente(null, "Leite moça", Medida.LITROS, grupo1);
		Engrediente engrediente2 =  new Engrediente(null, "Fubá", Medida.GRAMAS, grupo1);
		Engrediente engrediente3 =  new Engrediente(null, "Leite", Medida.GRAMAS, grupo1);
		Engrediente engrediente4 =  new Engrediente(null, "Morango", Medida.GRAMAS, grupo1);
		Engrediente engrediente5 =  new Engrediente(null, "Cenoura", Medida.GRAMAS, grupo1);
		Engrediente engrediente6 =  new Engrediente(null, "Creme de leite", Medida.GRAMAS, grupo1);
		Engrediente engrediente7 =  new Engrediente(null, "Fermento", Medida.GRAMAS, grupo1);
		
		grupo1.getEngrediente().addAll(Arrays.asList(engrediente1, engrediente2, engrediente3, engrediente4, engrediente5, engrediente6, engrediente7));
		
		grupoRepository.save(grupo1);
		
		receitaRepository.save(Arrays.asList(receita1, receita2, receita3, receita4));
		
		engredienteRepository.save(Arrays.asList(engrediente1, engrediente2, engrediente3, engrediente4, engrediente5, engrediente6, engrediente7));
		
		ItemReceita ir1 = new ItemReceita(receita1, engrediente2, 1);
		ItemReceita ir2 = new ItemReceita(receita1, engrediente6, 1);
		ItemReceita ir3 = new ItemReceita(receita1, engrediente3, 2);
		
		ItemReceita ir4 = new ItemReceita(receita2, engrediente1, 1);
		ItemReceita ir5 = new ItemReceita(receita2, engrediente2, 1);
		ItemReceita ir6 = new ItemReceita(receita2, engrediente3, 2);
		ItemReceita ir7 = new ItemReceita(receita2, engrediente4, 1);
		ItemReceita ir8 = new ItemReceita(receita2, engrediente5, 1);
		ItemReceita ir9 = new ItemReceita(receita2, engrediente7, 2);

		ItemReceita ir10 = new ItemReceita(receita3, engrediente1, 1);
		ItemReceita ir11 = new ItemReceita(receita3, engrediente2, 1);
		ItemReceita ir12 = new ItemReceita(receita3, engrediente3, 2);
		ItemReceita ir13 = new ItemReceita(receita3, engrediente4, 1);
		ItemReceita ir14 = new ItemReceita(receita3, engrediente6, 1);
		ItemReceita ir15 = new ItemReceita(receita3, engrediente7, 2);
		
		receita1.getItens().addAll(Arrays.asList(ir1, ir2, ir3));
		receita2.getItens().addAll(Arrays.asList(ir4, ir5, ir6, ir7, ir8, ir9));
		receita3.getItens().addAll(Arrays.asList(ir10, ir11, ir12,ir13, ir14, ir15));
		
		itemReceitaRepository.save(
				Arrays.asList(
						ir1, ir2, ir3, ir4, ir5, ir6, ir7, ir8, ir9, ir10, ir11, ir12, ir13, ir14, ir15
						)
				);
		
		Avaliacao avaliacao = new Avaliacao(null, Grau.EXCELENTE, usuario4, receita1);
		Avaliacao avaliacao1 = new Avaliacao(null, Grau.PESSIMO, usuario3, receita1);
		
		avaliacaoRepository.save(Arrays.asList(avaliacao, avaliacao1));
		
		
		Comentario comentario = new Comentario(null, "Muito bom", avaliacao);
		Comentario comentario1 = new Comentario(null, "Receita bosta", avaliacao1);
		
		comentarioRepository.save(Arrays.asList(comentario, comentario1));
		
		
		Resposta resposta = new Resposta(null, "uahushasuuh", usuario4, comentario1);
		respostasRepository.save(resposta);
	}

	
}
