package br.com.receita.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import br.com.receita.ReceitaApplicationTests;
import br.com.receita.domain.Endereco;
import io.restassured.http.ContentType;

/**
 * @Author Marcelo Nascimento
 * @Date 15 de set de 2018
 * @Project receita
 * @Package br.com.receita.resource
 * @Desc 
 */
@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/insere-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class EnderecoResourceTest extends ReceitaApplicationTests{
	
	private static final String BAIRRO = "bairro azul";
	private static final String CEP = "21012409";
	private static final String COMPLEMENTO = "complemento teste";
	private static final String LOCALIDADE = "localidade teste";
	private static final String LOGRADOURO = "logradouro teste";
	private static final String UF = "RJ";
	
	@Test
	public void deve_adicionar_um_endereco_ao_ususario_logado () throws Exception {
		Endereco endereco = new Endereco();
		endereco.setBairro(BAIRRO);
		endereco.setCep(CEP);
		endereco.setComplemento(COMPLEMENTO);
		endereco.setLocalidade(LOCALIDADE);
		endereco.setLogradouro(LOGRADOURO);
		endereco.setUf(UF);
		
		given()
			.request()
			.header("Accept", ContentType.ANY)
			.header("content-type", ContentType.JSON)
			.body(endereco)
		.when()
		.post("/api/v1/enderecos")
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	public void deve_atualizar_um_endereco () throws Exception {
		Endereco endereco = new Endereco();
		endereco.setBairro(BAIRRO);
		endereco.setCep(CEP);
		endereco.setComplemento(COMPLEMENTO);
		endereco.setLocalidade(LOCALIDADE);
		endereco.setLogradouro(LOGRADOURO);
		endereco.setUf(UF);
		
		given()
			.request()
			.header("Accept", ContentType.ANY)
			.header("content-type", ContentType.JSON)
			.body(endereco)
		.when()
		.pathParam("id", 1)
		.put("/api/v1/enderecos/{id}")
		.then()
			.statusCode(HttpStatus.NO_CONTENT.value());
	}
	
	@Test
	public void deve_procurar_endereco_por_id() throws Exception {
		given()
			.pathParam("id", 1)
		.get("/api/v1/enderecos/{id}")
		.then()
			.log().body().and()
			.statusCode(HttpStatus.OK.value())
			.and()
			.body(
					"id", equalTo(1),
					"cep", equalTo("21012409"),
					"uf", equalTo("RJ")
					);
			
	}
}
