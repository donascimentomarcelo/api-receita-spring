package br.com.receita.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.receita.domain.Engrediente;
import br.com.receita.domain.enums.Medida;
import br.com.receita.repository.EngredienteRepository;
import br.com.receita.repository.filtro.EngredienteFiltro;

/**
 * @Author Marcelo Nascimento
 * @Date 7 de set de 2018
 * @Project receita
 * @Package br.com.receita.repositoryTest
 * @Desc Teste para testar os metodos de repositorio de engrediente.
 */
@Sql(value = "/insere-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestPropertySource("classpath:application-test.properties")
public class EngredienteRepositoryTest {
	
	private static final String DESCRICAO = "Leite";
	private static final Medida MEDIDA = Medida.LITROS;
	private static final Integer ID = 3;
	
	private EngredienteFiltro filtro;
	private Engrediente engrediente;
	@Autowired
	private EngredienteRepository engredienteRepository;
	
	/**
	 * 
	 * @Author Marcelo Nascimento
	 * @Date 7 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.repositoryTest
	 * @Desc Teste para ver se engrediente está sendo persistido corretamente
	 */
	@Test
	public void deve_salvar_engrediente_no_repositorio() throws Exception{
		//cenario
		engrediente = new Engrediente();
		engrediente.setDescricao(DESCRICAO);
		engrediente.setMedida(MEDIDA);
		
		//acao
		Engrediente eng = engredienteRepository.save(engrediente);
		
		//verificacao
		assertThat(eng.getDescricao()).isEqualTo(engrediente.getDescricao());
		assertThat(eng.getMedida()).isEqualTo(engrediente.getMedida());
	}
	
	/**
	 * 
	 * @Author Marcelo Nascimento
	 * @Date 7 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.repositoryTest
	 * @Desc Pesquisar um engrediente pela descricao e retornar de acordo com os parametros
	 */
	@Test
	public void deve_pesquisar_por_descricao() {
		// cenario
		filtro = new EngredienteFiltro();
		filtro.setDescricao(DESCRICAO);

		// acao
		List<Engrediente> lista =  engredienteRepository.filtro(filtro);
		
		// verificacao
		assertThat(lista.get(0).getId()).isEqualTo(ID);
		assertThat(lista.get(0).getDescricao()).isEqualTo(DESCRICAO);
		assertThat(lista.get(0).getMedida()).isEqualTo(MEDIDA);

	}

		
	/**
	 * 
	 * @Author Marcelo Nascimento
	 * @Date 7 de set de 2018
	 * @Project receita
	 * @Package br.com.receita.repositoryTest
	 * @Desc Pesquisar um engrediente pela medida e retornar de acordo com os parametros
	 */
	@Test
	public void deve_pesquisar_engrediente_por_medida() {
		// cenario
		filtro = new EngredienteFiltro();
		filtro.setMedida(MEDIDA);

		// acao
		List<Engrediente> lista =  engredienteRepository.filtro(filtro);
		
		// verificacao
		assertThat(lista.get(0).getId()).isEqualTo(ID);
		assertThat(lista.get(0).getDescricao()).isEqualTo(DESCRICAO);
		assertThat(lista.get(0).getMedida()).isEqualTo(MEDIDA);

	}
}
