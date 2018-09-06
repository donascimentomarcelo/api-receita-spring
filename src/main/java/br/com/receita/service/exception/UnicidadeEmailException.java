package br.com.receita.service.exception;

public class UnicidadeEmailException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UnicidadeEmailException(String mensagem) {
		super(mensagem);
	}

	public UnicidadeEmailException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
