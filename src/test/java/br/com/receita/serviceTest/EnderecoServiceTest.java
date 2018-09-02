package br.com.receita.serviceTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.receita.domain.Endereco;
import br.com.receita.domain.Usuario;
import br.com.receita.repository.EnderecoRepository;
import br.com.receita.repository.UsuarioRepository;
import br.com.receita.service.EnderecoService;
import br.com.receita.service.impl.EnderecoServiceImpl;

@RunWith(SpringRunner.class)
public class EnderecoServiceTest {
	
	private static final String BAIRRO = "Braz de pina";
	private static final String CEP = "21012409";
	private static final String COMPLEMENTO = "Rua Trinta e Seis - Braz de Pina";
	private static final String LOCALIDADE = "Quadra C9";
	private static final String LOGRADOURO = null;
	private static final String UF = "RJ";
	
	@MockBean
	private EnderecoRepository enderecoRepository;
	private EnderecoService enderecoService;
	@Mock
	private EnderecoServiceImpl enderecoServiceImpl;
	
	@Mock
	private UsuarioRepository usuarioRepository;
	
	private Endereco endereco;
	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		enderecoService = new EnderecoServiceImpl(enderecoRepository);
		
		usuario = new Usuario();
		
		endereco = new Endereco();
		endereco.setBairro(BAIRRO);
		endereco.setCep(CEP);
		endereco.setComplemento(COMPLEMENTO);
		endereco.setLocalidade(LOCALIDADE);
		endereco.setLogradouro(LOGRADOURO);
		endereco.setUf(UF);		
		endereco.setUsuario(usuario);
		
		when(usuarioRepository.findById(1)).thenReturn(Optional.empty());
	}
	
	@Test
	public void testarSeEnderecoEstaSendoSalvoNoRepositorio() throws Exception{
		when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
		enderecoService.addEndereco(endereco);
		verify(enderecoRepository).save(endereco);
	}

}
