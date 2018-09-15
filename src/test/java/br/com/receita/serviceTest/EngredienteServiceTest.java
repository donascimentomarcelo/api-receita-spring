package br.com.receita.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.receita.domain.Engrediente;
import br.com.receita.domain.enums.Medida;
import br.com.receita.repository.EngredienteRepository;
import br.com.receita.repository.filtro.EngredienteFiltro;
import br.com.receita.service.EngredienteService;
import br.com.receita.service.impl.EngredienteServiceImpl;

@RunWith(SpringRunner.class)
public class EngredienteServiceTest {
	
	private static final String DESCRICAO = "Leite";
	private static final Integer QUANTIDADE = 1;
	private static final Medida MEDIDA = Medida.LITROS;

	
	@MockBean
	private EngredienteRepository engredienteRepository;
	private EngredienteService engredienteService;
	@Mock
	private Engrediente engrediente;
	private List<Engrediente> listaDeEngredientes;
	@Mock
	private EngredienteFiltro filtro;
	
	@Before
	public void setUp() throws Exception {
		engredienteService = new EngredienteServiceImpl(engredienteRepository);
		
		engrediente = new Engrediente();
		engrediente.setDescricao(DESCRICAO);
		engrediente.setMedida(Medida.LITROS);
		engrediente.setQuantidade(QUANTIDADE);
		
		filtro = new EngredienteFiltro();
		filtro.setDescricao(DESCRICAO);
		
		listaDeEngredientes = new ArrayList<Engrediente>();
		listaDeEngredientes.add(0, engrediente);
		
		when(engredienteRepository.findByDescricaoIgnoreCase(DESCRICAO)).thenReturn(listaDeEngredientes);
		when(engredienteService.filtrar(filtro)).thenReturn(listaDeEngredientes);
	}
	
	@Test
	public void deve_salvar_engrediente_no_repositorio() throws Exception {
		engredienteService.salvar(engrediente);
		verify(engredienteRepository).save(engrediente);
	}
	
	@Test
	public void deve_pesquisar_por_descricao() throws Exception {
		when(engredienteRepository.findByDescricaoIgnoreCase(DESCRICAO)).thenReturn(listaDeEngredientes);
		List<Engrediente> lista = engredienteRepository.findByDescricaoIgnoreCase(DESCRICAO);
		assertThat(lista.get(0).getDescricao()).isEqualTo(DESCRICAO);
	}
	
	@Test
	public void deve_pesquisar_engrediente_por_descricao_usando_filtro() throws Exception {
		//cenario
		filtro = new EngredienteFiltro();
		filtro.setDescricao(DESCRICAO);
		
		//acao
		when(engredienteService.filtrar(filtro)).thenReturn(listaDeEngredientes);
		
		//verificacao
		List<Engrediente> list = engredienteService.filtrar(filtro);
		assertThat(list.get(0).getDescricao()).isEqualTo(DESCRICAO);
		
	}
	
	/**
	 * 
	 * @Author Marcelo Nascimento
	 * @Date 7 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.serviceTest
	 * @Desc Testa deve retornar um engrediente filtrado por descricao e quantidade
	 */
	@Test
	public void deve_pesquisar_engrediente_por_descricao_e_quantidade_usando_filtro() throws Exception{
		//cenario
		filtro = new EngredienteFiltro();
		filtro.setDescricao(DESCRICAO);
		filtro.setQuantidade(QUANTIDADE);
		
		//acao
		when(engredienteService.filtrar(filtro)).thenReturn(listaDeEngredientes);
		
		//verificacao
		List<Engrediente> list = engredienteService.filtrar(filtro);
		assertThat(list.get(0).getDescricao()).isEqualTo(DESCRICAO);
		assertThat(list.get(0).getQuantidade()).isEqualTo(QUANTIDADE);
	}
	
	/**
	 * 
	 * @Author Marcelo Nascimento
	 * @Date 7 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.serviceTest
	 * @Desc Testa deve retornar um engrediente filtrado por quantidade
	 */
	@Test
	public void deve_pesquisar_engrediente_por_quantidade_usando_filtro() {
		//cenario
		filtro = new EngredienteFiltro();
		filtro.setQuantidade(QUANTIDADE);
		
		//acao
		when(engredienteService.filtrar(filtro)).thenReturn(listaDeEngredientes);
		
		//verificacao
		List<Engrediente> list = engredienteService.filtrar(filtro);
		assertThat(list.get(0).getDescricao()).isEqualTo(DESCRICAO);
		assertThat(list.get(0).getQuantidade()).isEqualTo(QUANTIDADE);

	}
	
	/**
	 * 
	 * @Author Marcelo Nascimento
	 * @Date 7 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.serviceTest
	 * @Desc Testa deve retornar um engrediente filtrado por descricao e quantidade 
	 */
	@Test
	public void deve_pesquisar_engrediente_por_medida() throws Exception {
		//cenario
		filtro = new EngredienteFiltro();
		filtro.setMedida(MEDIDA);
		
		//acao
		when(engredienteService.filtrar(filtro)).thenReturn(listaDeEngredientes);
		
		//verificacao
		List<Engrediente> list = engredienteService.filtrar(filtro);
		assertThat(list.get(0).getDescricao()).isEqualTo(DESCRICAO);
		assertThat(list.get(0).getQuantidade()).isEqualTo(QUANTIDADE);
		assertThat(list.get(0).getMedida()).isEqualTo(MEDIDA);

	}
	
	@Test
	public void deve_testar_hashcode() {
		Engrediente e1 = new Engrediente(1, DESCRICAO, QUANTIDADE, MEDIDA, null);
		Engrediente e2 = new Engrediente(1, DESCRICAO, QUANTIDADE, MEDIDA, null);
		
		assertNotSame(e1, e2);
		assertEquals(e1, e2);
		assertEquals(e1.hashCode(), e2.hashCode());
	}
}
