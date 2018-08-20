package br.com.receita.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.receita.domain.Engrediente;
import br.com.receita.domain.enums.Medida;
import br.com.receita.repository.EngredienteRepository;
import br.com.receita.service.EngredienteService;
import br.com.receita.service.impl.EngredienteServiceImpl;

@RunWith(SpringRunner.class)
public class EngredienteServiceTest {
	
	private static final String DESCRICAO = "Leite";
	private static final Integer QUANTIDADE = 1;

	
	@MockBean
	private EngredienteRepository engredienteRepository;
	private EngredienteService engredienteService;
	
	private Engrediente engrediente;
	private List<Engrediente> listaDeEngredientes;
	
	@Before
	public void setUp() throws Exception {
		engredienteService = new EngredienteServiceImpl(engredienteRepository);
		
		engrediente = new Engrediente();
		engrediente.setDescricao(DESCRICAO);
		engrediente.setMedida(Medida.LITROS);
		engrediente.setQuantidade(QUANTIDADE);
		
		listaDeEngredientes = new ArrayList<Engrediente>();
		listaDeEngredientes.add(0, engrediente);
		
		when(engredienteRepository.findByDescricaoIgnoreCase(DESCRICAO)).thenReturn(listaDeEngredientes);
	}
	
	@Test
	public void salvarEngredienteNoRepositorio() throws Exception {
		engredienteService.salvar(engrediente);
		verify(engredienteRepository).save(engrediente);
	}
	
	@Test
	public void pesquisarPorNomeOuMedida() throws Exception {
		when(engredienteRepository.findByDescricaoIgnoreCase(DESCRICAO)).thenReturn(listaDeEngredientes);
		List<Engrediente> lista = engredienteRepository.findByDescricaoIgnoreCase(DESCRICAO);
		assertThat(lista.get(0).getDescricao()).isEqualTo(DESCRICAO);
	}

}
