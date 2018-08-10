package br.com.receita.serviceTest;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.receita.domain.Usuario;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.service.UsuarioService;
import br.com.receita.service.impl.UsuarioServiceImpl;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {
	
	private static final String NOME = "Crane";
	private static final String EMAIL = "crane@gmail.com";
	private static final String SENHA = "123";
	
	@MockBean
	private UsuarioRepository usuarioRepository;
	
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		usuarioService = new UsuarioServiceImpl(usuarioRepository);
		
		usuario = new Usuario();
		usuario.setNome(NOME);
		usuario.setEmail(EMAIL);
		usuario.setSenha(SENHA);
	}
	
	@Test
	public void salvarUsuarioNoRepositorio() throws Exception{
		usuarioService.salvar(usuario);
		
		verify(usuarioRepository).save(usuario);
	}
}
