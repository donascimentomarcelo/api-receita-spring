package br.com.receita.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

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
	
	@Test
	public void deve_listar_todas_as_receitas () throws Exception {
		given()
			.request()
			.header("Accept", ContentType.ANY)
			.header("content-type", ContentType.JSON)
		.get("/api/v1/engredientes")
		.then()
			.log().headers()
		.and()
			.log().body()
		.and()
			.statusCode(HttpStatus.OK.value())
			.body("id[0]", equalTo(1))
			.body("descricao[0]", equalTo("Leite moça"))
			.body("quantidade[0]", equalTo(2))
			.body("medida[0]", equalTo("GRAMAS"))
			
			.body("id[1]", equalTo(2))
			.body("descricao[1]", equalTo("Fubá"))
			.body("quantidade[1]", equalTo(3))
			.body("medida[1]", equalTo("QUILOS"))
			
			.body("id[2]", equalTo(3))
			.body("descricao[2]", equalTo("Leite"))
			.body("quantidade[2]", equalTo(8))
			.body("medida[2]", equalTo("LITROS"));
	}
}
