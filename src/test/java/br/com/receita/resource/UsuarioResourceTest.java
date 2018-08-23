package br.com.receita.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import br.com.receita.ReceitaApplicationTests;

public class UsuarioResourceTest extends ReceitaApplicationTests{

	@Test
	public void procurarUsuarioPorEmail() throws Exception {
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

}
