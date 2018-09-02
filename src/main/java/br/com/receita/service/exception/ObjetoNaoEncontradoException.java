/**
 * This exception handles when occours an error 404 / object not found
 */
package br.com.receita.service.exception;

/**
 * @author Marcelo
 * 2 de set de 2018 
 */
public class ObjetoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ObjetoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
