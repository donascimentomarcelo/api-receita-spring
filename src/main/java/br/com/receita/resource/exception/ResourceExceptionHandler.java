/**
 * This class will handles how the exception will be shown
 */
package br.com.receita.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.receita.service.exception.ObjetoNaoEncontradoException;
import br.com.receita.service.exception.StandardError;
import br.com.receita.service.exception.UnicidadeEmailException;

/**
 * @author Mestre
 * 2 de set de 2018 
 */
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado(
			ObjetoNaoEncontradoException e, 
			HttpServletRequest req) {
		StandardError erro = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(UnicidadeEmailException.class)
	public ResponseEntity<StandardError> unicidadeEmail(
			UnicidadeEmailException e, 
				HttpServletRequest req) {
		StandardError erro =  new StandardError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
	}
}
