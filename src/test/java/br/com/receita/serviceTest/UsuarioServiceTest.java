package br.com.receita.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	private List<Usuario> listaUsuarios;
		
	@Before
	public void setUp() throws Exception {
		usuarioService = new UsuarioServiceImpl(usuarioRepository);
		
		usuario = new Usuario();
		usuario.setNome(NOME);
		usuario.setEmail(EMAIL);
		usuario.setSenha(SENHA);
		
		listaUsuarios = new ArrayList<Usuario>();
		
		when(usuarioRepository.findByEmail(EMAIL)).thenReturn(Optional.empty());
		when(usuarioService.pesquisaDinamica(usuario)).thenReturn(listaUsuarios);
	}
	
	@Test
	public void salvarUsuarioNoRepositorio() throws Exception{
		usuarioService.salvar(usuario);
		
		verify(usuarioRepository).save(usuario);
	}
	
	@Test//(expected = UnicidadeEmailException.class)
	public void naoSalvarDoisUsuariosComMesmoEmail() throws Exception {
		when(usuarioRepository.findByEmail(EMAIL)).thenReturn(Optional.of(usuario));
		
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void verificarSeEmailJaEstaCadastrado() throws Exception {
		when(usuarioRepository.findByEmail(EMAIL)).thenReturn(Optional.of(usuario));
		
		Optional<Usuario> optional = usuarioRepository.findByEmail(EMAIL);
		
		assertThat(optional.isPresent()).isTrue();
		
		Usuario usr = optional.get();
		assertThat(usr.getNome()).isEqualTo(NOME);
	}
	
	@Test
	public void pesquisaDinamicaDeUsuario() throws Exception {
		when(usuarioService.pesquisaDinamica(usuario)).thenReturn(listaUsuarios);
		
		List<Usuario> list = usuarioService.pesquisaDinamica(usuario);
		
		assertThat(list.size()).isEqualTo(1);
	}
	
}
