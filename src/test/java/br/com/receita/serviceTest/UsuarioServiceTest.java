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
import br.com.receita.repository.filtro.UsuarioFiltro;
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
	
	@MockBean
	private UsuarioServiceImpl usuarioServiceImpl;
	
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
		listaUsuarios.add(0, usuario);
		
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setNome(NOME);
		filtro.setEmail(EMAIL);
		
		when(usuarioRepository.findByEmail(EMAIL)).thenReturn(Optional.empty());
		when(usuarioService.findByEmail(EMAIL)).thenReturn(usuario);
		when(usuarioService.filtro(filtro)).thenReturn(listaUsuarios);
	}
	
	@Test
	public void salvar_usuario_no_repositorio() throws Exception{
		usuarioService.salvar(usuario);
		
		verify(usuarioRepository).save(usuario);
	}
	
	@Test//(expected = UnicidadeEmailException.class)
	public void nao_salvar_dois_usuarios_com_mesmo_email() throws Exception {
		when(usuarioRepository.findByEmail(EMAIL)).thenReturn(Optional.of(usuario));
		
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void filtro_pelo_nome_e_email () {
		//cenario
		UsuarioFiltro filtro = new UsuarioFiltro();
		filtro.setNome(NOME);
		filtro.setEmail(EMAIL);
		
		//acao
		when(usuarioService.filtro(filtro)).thenReturn(listaUsuarios);
		
		//verificacao
		List<Usuario> list = usuarioService.filtro(filtro);
		assertThat(list.get(0).getNome()).isEqualTo(NOME);
	}
	
	
}