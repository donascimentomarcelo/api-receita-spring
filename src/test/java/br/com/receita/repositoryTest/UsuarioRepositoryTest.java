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
import org.springframework.test.context.junit4.SpringRunner;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.repository.filtro.UsuarioFiltro;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestPropertySource("classpath:application-test.properties")
public class UsuarioRepositoryTest {
	
	private static final String EMAIL = "crane@gmail.com";
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void pesquisarUsuarioPorEmail () throws Exception {
		Optional<Usuario> optional = usuarioRepository.findByEmail(EMAIL);
		
		assertThat(optional.isPresent());
		assertThat(optional.get().getEmail()).isEqualTo(EMAIL);
	}
	
	@Test
	public void filtro_dinamico () throws Exception {
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setNome("Cr");
		
		List<Usuario> lista = usuarioRepository.filtrar(filtro);
		assertThat(lista.size()).isEqualTo(1);
	}
}
