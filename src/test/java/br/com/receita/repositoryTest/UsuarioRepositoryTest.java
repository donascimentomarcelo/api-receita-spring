package br.com.receita.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

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
}
