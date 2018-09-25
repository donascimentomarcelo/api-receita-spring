package br.com.receita.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.receita.domain.Receita;
import br.com.receita.repository.ReceitaRepository;

/**
 * @Author Marcelo Nascimento
 * @Date 24 de set de 2018
 * @Project receita
 * @Package br.com.receita.resource
 * @Desc Classe para testar camada de repositorio de receita.
 */
@Sql(value = "/insere-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestPropertySource("classpath:application-test.properties")
public class ReceitaRepositoryTest {
	
	private static final String TITULO = "Bolo de cenoura";
	private static final String DESC = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	private Receita receita;
	
	@Test
	public void deve_salvar_os_dados_da_receita() throws Exception {
		//cenario
		receita = new Receita();
		receita.setTitulo(TITULO);
		receita.setDescricao(DESC);
		
		//acao
		Receita rec = receitaRepository.save(receita);
		
		//verificacao
		assertThat(rec.getTitulo()).isEqualTo(TITULO);
		assertThat(rec.getDescricao()).isEqualTo(DESC);
	}
}
