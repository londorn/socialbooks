package com.template.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.template.socialbooks.domain.DetalhesErro;
import com.template.socialbooks.services.exceptions.AutorExistenteException;
import com.template.socialbooks.services.exceptions.AutorNaoEcontradoException;
import com.template.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlelivroNaoEncontradoException(LivroNaoEncontradoException e,
			HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
	    erro.setStatus(404l);
		erro.setTitulo("O livro nao pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://paginadeerro.com.br/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalhesErro> handleAutorExistenteException(AutorExistenteException e,
			HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
	    erro.setStatus(409l);
		erro.setTitulo("Autor ja existente");
		erro.setMensagemDesenvolvedor("http://paginadeerro.com.br/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(AutorNaoEcontradoException.class)
	public ResponseEntity<DetalhesErro> handleautorNaoEncontradoException(AutorNaoEcontradoException e,
			HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
	    erro.setStatus(404l);
		erro.setTitulo("O Autor nao pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://paginadeerro.com.br/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
	    erro.setStatus(400l);
		erro.setTitulo("Requisicao invalida");
		erro.setMensagemDesenvolvedor("http://paginadeerro.com.br/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
}
