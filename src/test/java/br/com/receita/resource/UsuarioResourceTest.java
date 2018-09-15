package br.com.receita.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import br.com.receita.ReceitaApplicationTests;
import br.com.receita.domain.Usuario;
import io.restassured.http.ContentType;

@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/insere-dados.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/limpar-dados.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UsuarioResourceTest extends ReceitaApplicationTests{

	@Test
	public void deve_procurar_usuario_por_email() throws Exception {
		given()
			.pathParam("email", "crane@gmail.com")
		.get("/api/v1/usuarios/{email}/email")
		.then()
			.log().body().and()
			.statusCode(HttpStatus.OK.value())
			.and()
			.body(
					"id", equalTo(1),
					"nome", equalTo("Crane"),
					"email", equalTo("crane@gmail.com")
					);
			
	}
	
	@Test
	public void deve_retornar_excecao_ao_buscar_por_email_inexistente () throws Exception {
		given()
		.pathParam("email", "crane6@hotmail.com")
		.get("/api/v1/usuarios/{email}/email")
		.then()
			.log().body().and()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.and()
			.body("msg", equalTo("Usuario não encontrado"));
	}
	
	@Test
	public void deve_salvar_usuario () throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNome("Manuel L.");
		usuario.setEmail("manuell@gmail.com");
		usuario.setSenha("123");
		
		given()
			.request()
			.header("Accept", ContentType.ANY)
			.header("content-type", ContentType.JSON)
			.body(usuario)
		.when()
		.post("/api/v1/usuarios/")
		.then()	
				.log().headers()
			.and()
				.log().body()
			.and()
				.statusCode(HttpStatus.CREATED.value())
				.header("Location", equalTo("http://localhost:"+porta+"/api/v1/usuarios/2"));
			
	}
	
	@Test
	public void deve_salvar_usuario_com_email_duplicado () throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNome("Crane 2");
		usuario.setEmail("crane@gmail.com");
		usuario.setSenha("123");
		
		given()
			.request()
			.header("Accept", ContentType.ANY)
			.header("content-type", ContentType.JSON)
			.body(usuario)
		.when()
		.post("/api/v1/usuarios/")
		.then()	
				.log().headers()
			.and()
				.log().body()
			.and()
				.statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.and()
				.body("msg", equalTo("O e-mail crane@gmail.com já está sendo usado."));
			
	}
	
	@Test
	public void deve_atualizar_usuario () throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNome("Crane 2");
		usuario.setEmail("crane@gmail.com");
		usuario.setSenha("123");
		
		given()
			.request()
			.header("Accept", ContentType.ANY)
			.header("content-type", ContentType.JSON)
			.body(usuario)
		.when()
		.pathParam("id", 1)
		.put("/api/v1/usuarios/{id}")
		.then()	
				.log().headers()
			.and()
				.log().body()
			.and()
				.statusCode(HttpStatus.NO_CONTENT.value());
			
	}
	
	@Test
	public void deve_procurar_usuario_por_id() throws Exception {
		given()
			.pathParam("id", 1)
		.get("/api/v1/usuarios/{id}")
		.then()
			.log().body().and()
			.statusCode(HttpStatus.OK.value())
			.and()
			.body(
					"id", equalTo(1),
					"nome", equalTo("Crane"),
					"email", equalTo("crane@gmail.com")
					);
			
	}
	
	@Test
	public void deve_retornar_excecao_ao_buscar_por_id_inexistente() throws Exception {
		given()
			.pathParam("id", 5)
		.get("/api/v1/usuarios/{id}")
		.then()
			.log().body().and()
			.statusCode(HttpStatus.NOT_FOUND.value())
			.and()
			.body("msg", equalTo("Usuário não encontrado"));
			
	}
	
	@Test
	public void deve_listar_todos_os_usuarios_com_seus_enderecos() throws Exception {
		given()
		.get("/api/v1/usuarios")
		.then()
			.log().body().and()
			.statusCode(HttpStatus.OK.value())
			.and()
			.body(
					"id[0]", equalTo(1),
					"nome[0]", equalTo("Crane"),
					"email[0]", equalTo("crane@gmail.com"),
					"endereco[0].id[0]", equalTo(1),
					"endereco[0].bairro[0]", equalTo("Braz de pina"),
					"endereco[0].cep[0]", equalTo("21012409"),
					"endereco[0].complemento[0]", equalTo("Rua Trinta e Seis - Braz de Pina"),
					"endereco[0].localidade[0]", equalTo("Quadra C9"),
					"endereco[0].logradouro[0]", equalTo(null),
					"endereco[0].uf[0]", equalTo("RJ")
					);
			
	}
}
