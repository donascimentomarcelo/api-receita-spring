package br.com.receita.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.receita.domain.Endereco;
import br.com.receita.domain.Receita;
import br.com.receita.repository.ReceitaRepository;
import br.com.receita.service.ReceitaService;
import br.com.receita.service.impl.ReceitaServiceImpl;

/**
 * @Author Marcelo Nascimento
 * @Date 25 de set de 2018
 * @Project receita
 * @Package br.com.receita.serviceTest
 * @Desc Classe para testar servicos de receita
 */
@RunWith(SpringRunner.class)
public class ReceitaServiceTest {
	
	private static final String TITULO = "Bolo de cenoura";
	private static final String DESC = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
	
	@MockBean
	private ReceitaRepository receitaRepository;
	private ReceitaService receitaService;
	@Mock
	private ReceitaServiceImpl receitaServiceImpl;
	
	private Receita receita;
	
	@Before
	public void setUp() throws Exception {
		receitaService = new ReceitaServiceImpl(receitaRepository);
		
		receita = new Receita();
		
		receita.setTitulo(TITULO);
		receita.setDescricao(DESC);
	}
	
	@Test
	public void testar_se_receita_esta_sendo_salva_no_repositorio() throws Exception {
		receitaService.salvar(receita);
		
		verify(receitaRepository).save(receita);
	}
	
	@Test
	public void deve_testar_hashcode() {
		Receita r1 = new Receita(1, TITULO, DESC);
		Receita r2 = new Receita(1, TITULO, DESC);
		
		assertNotSame(r1, r2);
		assertEquals(r1, r2);
		assertEquals(r1.hashCode(), r2.hashCode());
	}
}
