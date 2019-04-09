package com.template.socialbooks.services.exceptions;

public class AutorNaoEcontradoException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;

	public AutorNaoEcontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AutorNaoEcontradoException(String mensagem, Throwable causa) {
		super(mensagem);
	}
	
}
