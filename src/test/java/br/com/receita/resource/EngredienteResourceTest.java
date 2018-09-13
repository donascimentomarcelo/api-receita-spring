package br.com.receita.resource;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import br.com.receita.ReceitaApplicationTests;
import br.com.receita.domain.Engrediente;
import br.com.receita.domain.enums.Medida;
import io.restassured.http.ContentType;

/**
 * @Author Marcelo Nascimento
 * @Date 12 de set de 2018
 * @Project receita
 * @Package br.com.receita.resource
 * @Desc 
 */
@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/insere-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class EngredienteResourceTest extends ReceitaApplicationTests{
	
	@Test
	public void deve_salvar_receita () throws Exception {
		Engrediente engrediente = new Engrediente();
		engrediente.setDescricao("Leite 2");
		engrediente.setMedida(Medida.LITROS);
		engrediente.setQuantidade(2);
		
		given()
			.request()
			.header("Accept", ContentType.ANY)
			.header("content-type", ContentType.JSON)
			.body(engrediente)
		.when()
		.post("/api/v1/engredientes")
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	public void deve_atualizar_receita () throws Exception {
		Engrediente engrediente = new Engrediente();
		engrediente.setDescricao("Leite 2");
		engrediente.setMedida(Medida.MILILITROS);
		engrediente.setQuantidade(2);
		
		given()
			.request()
			.header("Accept", ContentType.ANY)
			.header("content-type", ContentType.JSON)
			.body(engrediente)
		.when()
		.put("/api/v1/engredientes/3")
		.then()
			.statusCode(HttpStatus.NO_CONTENT.value());
	}
}
