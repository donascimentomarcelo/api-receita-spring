package br.com.receita.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

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

	private static final String TITULO = "Bolo de Maracuja";
	private static final String DESC = "Lorem ipsum dolor sit amet, consectetur adipisicing elit";
	
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
	
	@Test
	public void deve_pesquisar_receita_por_id () throws Exception {
		given()
			.request()
			.header("Accept", ContentType.ANY)
			.header("content-type", ContentType.JSON)
		.get("/api/v1/receitas/1")
		.then()
			.log().headers()
		.and()
			.log().body()
		.and()
		.statusCode(HttpStatus.OK.value())
		.body("id", equalTo(1))
		.body("titulo", equalTo(TITULO))
		.body("descricao", equalTo(DESC));
	}
}
