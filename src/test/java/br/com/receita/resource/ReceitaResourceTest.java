package br.com.receita.resource;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import br.com.receita.ReceitaApplicationTests;
import br.com.receita.domain.Receita;
import io.restassured.http.ContentType;

/**
 * @Author Marcelo Nascimento
 * @Date 26 de set de 2018
 * @Project receita
 * @Package br.com.receita.resource
 * @Desc Classe para testar metodos do controlador de receita.
 */

@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/insere-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ReceitaResourceTest extends ReceitaApplicationTests{

	private static final String TITULO = "Bolo de cenoura";
	private static final String DESC = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
	
	@Test
	public void deve_salvar_receita () throws Exception {
		Receita receita = new Receita();
		receita.setTitulo(TITULO);
		receita.setDescricao(DESC);
		
		given()
			.request()
			.header("Accept", ContentType.ANY)
			.header("content-type", ContentType.JSON)
			.body(receita)
		.when()
		.post("/api/v1/receitas")
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
}
