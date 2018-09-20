package br.com.receita.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.repository.filtro.UsuarioFiltro;

@Sql(value = "/insere-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestPropertySource("classpath:application-test.properties")
public class UsuarioRepositoryTest {
	private static final String NOMEERRADO = "Manuel";
	private static final String NOME = "Cr";
	private static final String EMAIL = "crane@gmail.com";
	private static final String CEP = "21012409";
	private static final String UF = "RJ";
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void pesquisarUsuarioPorEmail () throws Exception {
		Optional<Usuario> optional = usuarioRepository.findByEmail(EMAIL);
		
		assertThat(optional.isPresent());
		assertThat(optional.get().getEmail()).isEqualTo(EMAIL);
	}
	
	@Test
	public void filtroDinamico () throws Exception {
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setNome(NOME);
		filtro.setEmail(EMAIL);
		
		List<Usuario> lista = usuarioRepository.filtrar(filtro);
		assertThat(lista.size()).isEqualTo(1);
	}
	
	@Test
	public void buscarUsuarioPeloCEP () throws Exception {
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setCep(CEP);
		
		List<Usuario> lista = usuarioRepository.filtrar(filtro);
		assertThat(lista.size()).isEqualTo(1);
	}
	
	@Test
	public void buscarUsuariosDoRj () throws Exception {
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setUf(UF);
		
		List<Usuario> lista = usuarioRepository.filtrar(filtro);
		assertThat(lista.size()).isEqualTo(1);
	}
	
	@Test
	public void buscarUsuariosPorUfECep () throws Exception {
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setCep(CEP);
		filtro.setUf(UF);
		
		List<Usuario> lista = usuarioRepository.filtrar(filtro);
		assertThat(lista.size()).isEqualTo(1);
	}
	
	@Test
	public void buscarUsuariosPorTodosOsDados () throws Exception {
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setNome(NOME);
		filtro.setEmail(EMAIL);
		filtro.setCep(CEP);
		filtro.setUf(UF);
		
		List<Usuario> lista = usuarioRepository.filtrar(filtro);
		assertThat(lista.size()).isEqualTo(1);
	}
	
	@Test
	public void trazerUsuarioNuloPorNome () throws Exception {
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setNome(NOMEERRADO);
		
		List<Usuario> lista = usuarioRepository.filtrar(filtro);
		assertThat(lista.size()).isEqualTo(0);
	}
}
