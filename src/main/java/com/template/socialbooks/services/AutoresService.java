package com.template.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.socialbooks.domain.Autor;
import com.template.socialbooks.repository.AutoresRepository;
import com.template.socialbooks.services.exceptions.AutorExistenteException;
import com.template.socialbooks.services.exceptions.AutorNaoEcontradoException;

@Service
public class AutoresService {

	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		
		if(autor.getId() != null) {
			Optional<Autor> a = autoresRepository.findById(autor.getId());

			if (a.isPresent()){
				throw new AutorExistenteException("O autor ja exite. ");
			}
		}
		
		return autoresRepository.save(autor);
	
	}
	
	public Autor buscar(Long id) {
		
		Optional<Autor> a = autoresRepository.findById(id);
		
		if (!a.isPresent()){
			throw new AutorNaoEcontradoException("O autor nao pode ser encontrado ");
		}
		
		return a.get();
		
	}
}
