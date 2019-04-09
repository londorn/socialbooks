package com.template.socialbooks.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.template.socialbooks.domain.Comentario;
import com.template.socialbooks.domain.Livro;
import com.template.socialbooks.repository.ComentariosRepository;
import com.template.socialbooks.repository.LivrosRepository;
import com.template.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	public List<Livro> listar(){
		
		return livrosRepository.findAll();
		
	}
	
	public Livro buscar(Long id) {
		
		Optional<Livro> livroOptional = livrosRepository.findById(id);
		
		if (!livroOptional.isPresent()){
			throw new LivroNaoEncontradoException("O livro nao pode ser encontrado. ");
		}
		
		return livroOptional.get();
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {

		 try {
			 livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro nao pode ser encontrado. ");
			
		}
		
	}
	
	public void atualizar(Livro livro) {
		this.verificarExistencia(livro);
		livrosRepository.save(livro);
	}

	private void verificarExistencia(Livro livro) {
		this.buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
			Livro livro = this.buscar(livroId);
			
			comentario.setLivro(livro);
			comentario.setData(new Date());
			
			return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long livroId){
		Livro livro = this.buscar(livroId);
		
		return livro.getComentarios();
	}
	
	
}
